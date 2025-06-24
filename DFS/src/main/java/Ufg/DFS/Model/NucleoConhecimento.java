
package Ufg.DFS.Model;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;


@Entity
public class NucleoConhecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    private String descricao;

   @OneToMany(mappedBy = "nucleoConhecimento")
   @JsonManagedReference
   private List<Docente> docentes;


   @OneToMany(mappedBy = "nucleoConhecimento")
   @JsonBackReference
   private List<ManifestacaoIntencao> manifestacaoIntencaos;



   public List<ManifestacaoIntencao> getManifestacaoIntencaos() {
    return manifestacaoIntencaos;
}
   public void setManifestacaoIntencaos(List<ManifestacaoIntencao> manifestacaoIntencaos) {
    this.manifestacaoIntencaos = manifestacaoIntencaos;
   }
    // public List<Docente> getDocentes() {
   // return docentes;
//}
  // public void setDocentes(List<Docente> docentes) {
  //  this.docentes = docentes;
   //}
    public NucleoConhecimento() {
        super();
    }
    public NucleoConhecimento(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
}
