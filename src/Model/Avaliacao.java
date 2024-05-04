package Model;
// Generated May 4, 2024 4:11:17 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Avaliacao generated by hbm2java
 */
public class Avaliacao  implements java.io.Serializable {


     private Integer id;
     private String descricao;
     private BigDecimal peso;
     private Set disciplinas = new HashSet(0);
     private Set realizas = new HashSet(0);

    public Avaliacao() {
    }

    public Avaliacao(String descricao, BigDecimal peso, Set disciplinas, Set realizas) {
       this.descricao = descricao;
       this.peso = peso;
       this.disciplinas = disciplinas;
       this.realizas = realizas;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public BigDecimal getPeso() {
        return this.peso;
    }
    
    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }
    public Set getDisciplinas() {
        return this.disciplinas;
    }
    
    public void setDisciplinas(Set disciplinas) {
        this.disciplinas = disciplinas;
    }
    public Set getRealizas() {
        return this.realizas;
    }
    
    public void setRealizas(Set realizas) {
        this.realizas = realizas;
    }

   




}


