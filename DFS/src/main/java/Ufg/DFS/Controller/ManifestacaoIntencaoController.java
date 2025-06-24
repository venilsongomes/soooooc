package Ufg.DFS.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Ufg.DFS.Model.ManifestacaoIntencao;
import Ufg.DFS.Service.ManifestacaoIntecaoService;


@RestController
@RequestMapping("/manifestacao")
public class ManifestacaoIntencaoController{
    @Autowired
    private final ManifestacaoIntecaoService service;

    public ManifestacaoIntencaoController (ManifestacaoIntecaoService service){
        this.service = service;
    }

    @GetMapping
    public List<ManifestacaoIntencao> getIntencaos() {
        return service.getIntencaos();
    }

     @GetMapping("/{id}")
    public ResponseEntity<ManifestacaoIntencao> getById(@PathVariable Integer id) {
        ManifestacaoIntencao manifestacao = service.getById(id);
        if (manifestacao != null) {
            return ResponseEntity.ok(manifestacao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/docente/{docenteId}")
    public ResponseEntity<List<ManifestacaoIntencao>> getByDocenteId(@PathVariable Integer docenteId) {
        List<ManifestacaoIntencao> manifestacoes = service.getByDocenteId(docenteId);
        if (manifestacoes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(manifestacoes);
    }

    @PostMapping
    public ResponseEntity<ManifestacaoIntencao> criar(@RequestBody ManifestacaoIntencao manifestacao) {
        ManifestacaoIntencao nova = service.saveIntecoes(manifestacao);
        return ResponseEntity.ok(nova);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
    

