package Ufg.DFS.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AreaConhecimento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id; // Id será gerado automaticamente pelo banco de dados
    private String nome;
    private String descricao;
    
    public AreaConhecimento() {
        super();
    }
    
    public AreaConhecimento(String nome, String descricao) {
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
}
