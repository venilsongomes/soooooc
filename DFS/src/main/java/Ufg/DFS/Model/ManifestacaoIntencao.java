package Ufg.DFS.Model;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class ManifestacaoIntencao {
      @Id
      @GeneratedValue(strategy = GenerationType.AUTO)
      private Integer id; 
      

      @JoinColumn(name = "docente_id")
      @ManyToOne 
      private Docente docente;
      
      @OneToOne
      private Docente facilitador;

      public Docente getFacilitador() {
        return facilitador;
     }
      public void setFacilitador(Docente facilitador) {
          this.facilitador = facilitador;
      }

        @ManyToOne
        @JoinColumn(name = "nucleo_id")
        @JsonBackReference("nucleo-manifestacao")
        private NucleoConhecimento nucleoConhecimento;

     public NucleoConhecimento getNucleoConhecimento() {
        return nucleoConhecimento;
    }
      public void setNucleoConhecimento(NucleoConhecimento nucleoConhecimento) {
          this.nucleoConhecimento = nucleoConhecimento;
      }
     public Docente getDocente() {
        return docente;
       }
    public void setDocente(Docente docente) {
         this.docente = docente;
      }
     
      private Date dataManifestacaoIntencao;
      private Date dataIngresso;

      @ManyToOne
     @JoinColumn(name = "status_id")
     private Status status;

     
        public Status getStatus() {
        return status;
    }
      public void setStatus(Status status) {
          this.status = status;
      }
        public ManifestacaoIntencao() { }

        public ManifestacaoIntencao( Date dataManifestacaoIntencao, Date dataIngresso, Status status) {
            
            this.dataManifestacaoIntencao = dataManifestacaoIntencao;
            this.dataIngresso = dataIngresso;
           
            this.status = status;
      
        }
        public Date getDataManifestacaoIntencao() {
            return dataManifestacaoIntencao;
        }
        public void setDataManifestacaoIntencao(Date dataManifestacaoIntencao) {
            this.dataManifestacaoIntencao = dataManifestacaoIntencao;
        }
        public Date getDataIngresso() {
            return dataIngresso;
        }
        public void setDataIngresso(Date dataIngresso) {
            this.dataIngresso = dataIngresso;
        }
        
       

}
