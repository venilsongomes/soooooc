package Ufg.DFS.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import Ufg.DFS.Model.Docente;
import Ufg.DFS.Repository.DocenteRepository;

@Service
public class DocentesService {


private final DocenteRepository docenteRepository;

public DocentesService(DocenteRepository docenteRepository){
    this.docenteRepository = docenteRepository;
}

public List<Docente> getAllDocentes() {
        return docenteRepository.findAll();
    }
     public Optional<Docente> getDocenteById(Integer id) {
        return docenteRepository.findById(id);
    }

    public Docente createDocente(Docente docente) {
        return docenteRepository.save(docente);
    }

 
}
