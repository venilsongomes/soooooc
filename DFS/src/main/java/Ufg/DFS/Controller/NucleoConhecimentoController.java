package Ufg.DFS.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Ufg.DFS.Model.NucleoConhecimento;
import Ufg.DFS.Service.NucleoConhecimentoService;


@RestController
@RequestMapping("/nucleo")
public class NucleoConhecimentoController {
     @Autowired
    private final NucleoConhecimentoService nucleoConhecimentoService;

    public NucleoConhecimentoController(NucleoConhecimentoService nucleoConhecimentoService) {
        this.nucleoConhecimentoService = nucleoConhecimentoService;
    }

     @GetMapping
     public List<NucleoConhecimento> Listar(){
        return nucleoConhecimentoService.listarTodos();
     }
     @PostMapping
     public NucleoConhecimento creaNucleoConhecimento(@RequestBody NucleoConhecimento NucleoConhecimento){
        return nucleoConhecimentoService.salvar(NucleoConhecimento);
     }

    


}
