package Ufg.DFS.Service;

import java.util.List;


import org.springframework.stereotype.Service;

import Ufg.DFS.Model.NucleoConhecimento;
import Ufg.DFS.Repository.NucleoConhecimentoRepsitory;

@Service
public class NucleoConhecimentoService {
    
    private final NucleoConhecimentoRepsitory nucleoConhecimentoRepsitory;

    public NucleoConhecimentoService(NucleoConhecimentoRepsitory nucleoConhecimentoRepsitory) {
        this.nucleoConhecimentoRepsitory = nucleoConhecimentoRepsitory;
    }
    public List<NucleoConhecimento> listarTodos(){
        return nucleoConhecimentoRepsitory.findAll();
    }
    
    public NucleoConhecimento salvar( NucleoConhecimento nucleoConhecimento){
        return nucleoConhecimentoRepsitory.save(nucleoConhecimento);
    }
}
