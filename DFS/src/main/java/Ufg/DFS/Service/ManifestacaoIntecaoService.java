package Ufg.DFS.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Ufg.DFS.Model.ManifestacaoIntencao;
import Ufg.DFS.Repository.DocenteRepository;
import Ufg.DFS.Repository.NucleoConhecimentoRepsitory;
import Ufg.DFS.Repository.StatusRepository;

@Service
public class ManifestacaoIntecaoService {
    
    private final Ufg.DFS.Repository.ManifetacaoIntecaoRepository repository;
    @Autowired
    private DocenteRepository docenteRepository;
    @Autowired
    private NucleoConhecimentoRepsitory nucleoConhecimentoRepository;

    @Autowired
    private StatusRepository statusRepository;

  public ManifestacaoIntecaoService(Ufg.DFS.Repository.ManifetacaoIntecaoRepository repository){
    this.repository = repository;
  }

   public List<ManifestacaoIntencao> getIntencaos() {
        return repository.findAll();
    }

    public ManifestacaoIntencao getById(Integer id) {
        Optional<ManifestacaoIntencao> result = repository.findById(id);
        return result.orElse(null);
    }

    public List<ManifestacaoIntencao> getByDocenteId(Integer docenteId) {
        return repository.findByDocenteId(docenteId);
    }

 
public ManifestacaoIntencao saveIntecoes(ManifestacaoIntencao manifestacao) {
   
    if (manifestacao.getStatus() != null && manifestacao.getStatus().getId() != null) {
        manifestacao.setStatus(
            statusRepository.findById(manifestacao.getStatus().getId())
                .orElseThrow(() -> new RuntimeException("Status não encontrado!"))
        );
    }
    
    if (manifestacao.getDocente() != null && manifestacao.getDocente().getId() != null) {
        manifestacao.setDocente(
            docenteRepository.findById(manifestacao.getDocente().getId())
                .orElseThrow(() -> new RuntimeException("Docente não encontrado!"))
        );
    }
   
       if (manifestacao.getNucleoConhecimento() != null && manifestacao.getNucleoConhecimento().getId() != null) {
        var nucleo = nucleoConhecimentoRepository.findById(manifestacao.getNucleoConhecimento().getId())
            .orElseThrow(() -> new RuntimeException("Núcleo não encontrado!"));
        manifestacao.setNucleoConhecimento(nucleo);

        // Sempre pega o facilitador do núcleo
        if (nucleo.getFacilitador() != null) {
            manifestacao.setFacilitador(nucleo.getFacilitador());
        } else {
            throw new RuntimeException("Núcleo não possui facilitador!");
        }
    }

    return repository.save(manifestacao);
}

     public void deleteById(Integer id) {
        repository.deleteById(id);
    }


  
}
