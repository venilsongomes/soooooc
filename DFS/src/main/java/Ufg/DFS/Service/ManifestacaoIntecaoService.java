package Ufg.DFS.Service;
import java.util.List;
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
 
     public ManifestacaoIntencao saveIntecoes(ManifestacaoIntencao manifestacao) {
        return repository.save(manifestacao);
    }

  
}
