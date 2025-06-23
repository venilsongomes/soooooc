package Ufg.DFS.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Ufg.DFS.Model.Status;
import Ufg.DFS.Service.StatusService;
import java.util.List;



@RestController
@RequestMapping("/status")
public class StatusController {
     @Autowired
    private final StatusService services;

    public StatusController (StatusService services){
        this.services = services;
    }
    @GetMapping
    public List<Status> Listar(){
        return services.listarTodos();
    }
    
    @PostMapping
    public Status createStatus(@RequestBody Status status){
        return services.salvarr(status);
    }


    
}
