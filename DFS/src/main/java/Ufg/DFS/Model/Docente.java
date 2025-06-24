package Ufg.DFS.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    private String email;
    private String telefone;
    private Date ultimoAcesso;
    
    @OneToMany(mappedBy = "docente")
    @JsonBackReference
    private  List<ManifestacaoIntencao> manifestacaoIntencaos;


    @JoinColumn(name = "Nucleo")
    @ManyToOne
    @JsonBackReference
    private NucleoConhecimento nucleoConhecimento;


    public NucleoConhecimento getNucleoConhecimento() {
        return nucleoConhecimento;
    }

    public void setNucleoConhecimento(NucleoConhecimento nucleoConhecimento) {
       this.nucleoConhecimento = nucleoConhecimento;
    }

    public List<ManifestacaoIntencao> getManifestacaoIntencaos() {
        return manifestacaoIntencaos;
    }

    public void setManifestacaoIntencaos(List<ManifestacaoIntencao> manifestacaoIntencaos) {
        this.manifestacaoIntencaos = manifestacaoIntencaos;
    }


    public Docente() { }

    public Docente(String nome, String email, String telefone, Date ultimoAcesso) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.ultimoAcesso = ultimoAcesso;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public Date getUltimoAcesso() { return ultimoAcesso; }
    public void setUltimoAcesso(Date ultimoAcesso) { this.ultimoAcesso = ultimoAcesso; }

    
}
