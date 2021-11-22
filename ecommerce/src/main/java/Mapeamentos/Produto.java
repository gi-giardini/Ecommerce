package Mapeamentos;
// Generated 15/10/2018 14:46:52 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Produto generated by hbm2java
 */
@Entity
@Table(name="produto"
    ,schema="public"
)
public class Produto  implements java.io.Serializable {


     private int cod;
     private Categoria categoria;
     private String nome;
     private Double valor;
     private String descricao;
     private byte[] imagem;
     private Date modificacao;
     private Integer quantEstoque;
     private Set <Compra> compras = new HashSet(0);

    public Produto() {
    }

	
    public Produto(int cod) {
        this.cod = cod;
    }
    public Produto(int cod, Categoria categoria, String nome, Double valor, String descricao, byte[] imagem, Date modificacao, Integer quantEstoque, Set compras) {
       this.cod = cod;
       this.categoria = categoria;
       this.nome = nome;
       this.valor = valor;
       this.descricao = descricao;
       this.imagem = imagem;
       this.modificacao = modificacao;
       this.quantEstoque = quantEstoque;
       this.compras = compras;
    }
   
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    @Column(name="cod", unique=true, nullable=false)
    public int getCod() {
        return this.cod;
    }
    
    public void setCod(int cod) {
        this.cod = cod;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="categoria")
    public Categoria getCategoria() {
        return this.categoria;
    }
    
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    
    @Column(name="nome", length=100)
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    
    @Column(name="valor", precision=17, scale=17)
    public Double getValor() {
        return this.valor;
    }
    
    public void setValor(Double valor) {
        this.valor = valor;
    }

    
    @Column(name="descricao", length=1000)
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
    @Column(name="imagem")
    public byte[] getImagem() {
        return this.imagem;
    }
    
    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="modificacao", length=13)
    public Date getModificacao() {
        return this.modificacao;
    }
    
    public void setModificacao(Date modificacao) {
        this.modificacao = modificacao;
    }

    
    @Column(name="quant_estoque")
    public Integer getQuantEstoque() {
        return this.quantEstoque;
    }
    
    public void setQuantEstoque(Integer quantEstoque) {
        this.quantEstoque = quantEstoque;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="produto")
    public Set <Compra> getCompras() {
        return this.compras;
    }
    
    public void setCompras(Set <Compra> compras) {
        this.compras = compras;
    }
}

