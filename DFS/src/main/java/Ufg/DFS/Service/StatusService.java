package Ufg.DFS.Service;
import java.util.List;
import Ufg.DFS.Model.Status;
import org.springframework.stereotype.Service;




@Service
public class StatusService {
    
    private final Ufg.DFS.Repository.StatusRepository statusRepository;

  
    public StatusService(Ufg.DFS.Repository.StatusRepository statusRepository){
        this.statusRepository = statusRepository;
    }

   public List<Status> listarTodos() {
        return statusRepository.findAll();
    }


   public Status salvarr(Ufg.DFS.Model.Status status){
    return statusRepository.save(status);
   }
   
    

    
}

