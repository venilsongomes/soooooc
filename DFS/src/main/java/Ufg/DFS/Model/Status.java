package Ufg.DFS.Model;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;


@Entity

public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id; 
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String situacao;

   // @OneToOne
    //@JsonIgnore
    //private List <ManifestacaoIntencao> manifestacaoIntencao;
    

    public Status(){}
    
    public Status(String situcao) {  
        this.situacao = situcao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String aberto) {
        this.situacao = aberto;
    }
}
