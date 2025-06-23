package Ufg.DFS.Model;
import java.util.Date;
import jakarta.persistence.Entity;

@Entity
public class Admin extends Docente {

    private String senha;

    public Admin() {
        super();
    }

    public Admin(Integer id, String nome, String email, String senha,  String telefone, Date ultimoAcesso) {
        super(nome, email,  telefone, ultimoAcesso);
        this.senha = senha;
        
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
   
    
    
}
