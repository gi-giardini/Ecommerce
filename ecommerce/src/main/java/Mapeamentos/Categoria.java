package Mapeamentos;
// Generated 15/10/2018 14:46:52 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Categoria generated by hbm2java
 */
@Entity
@Table(name="categoria"
    ,schema="public"
)
public class Categoria  implements java.io.Serializable {


     private int id;
     private String nome;
     private Set <Produto> produtos = new HashSet(0);

    public Categoria() {
    }

	
    public Categoria(int id) {
        this.id = id;
    }
    public Categoria(int id, String nome, Set produtos) {
       this.id = id;
       this.nome = nome;
       this.produtos = produtos;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    
    @Column(name="nome", length=25)
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="categoria")
    public Set <Produto> getProdutos() {
        return this.produtos;
    }
    
    public void setProdutos(Set <Produto> produtos) {
        this.produtos = produtos;
    }
}