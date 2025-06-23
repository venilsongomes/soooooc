package Ufg.DFS.Controller;
import Ufg.DFS.Model.Docente;
import Ufg.DFS.Service.DocentesService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/docentes")
public class DocenteController {

   
    private final DocentesService docenteService;

    public DocenteController(DocentesService docenteService) {
        this.docenteService = docenteService;
    }

    @GetMapping
    public List <Docente> listarTodosDocentes() {
        return docenteService.getAllDocentes();
    }

    @PostMapping
    public ResponseEntity<Docente> PostDocente(@RequestBody Docente docente){
        Docente novDocente = docenteService.createDocente(docente);
        return ResponseEntity.ok(novDocente);
    }
}
