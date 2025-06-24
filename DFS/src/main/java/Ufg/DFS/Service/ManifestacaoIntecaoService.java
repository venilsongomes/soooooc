package Ufg.DFS.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import Ufg.DFS.Model.ManifestacaoIntencao;

@Service
public class ManifestacaoIntecaoService {
    
    private final Ufg.DFS.Repository.ManifetacaoIntecaoRepository repository;

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
        return repository.save(manifestacao);
    }

     public void deleteById(Integer id) {
        repository.deleteById(id);
    }


  
}
