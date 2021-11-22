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
import javax.persistence.UniqueConstraint;

/**
 * Cliente generated by hbm2java
 */
@Entity
@Table(name = "cliente",
         schema = "public",
         uniqueConstraints = @UniqueConstraint(columnNames = "email")
)
public class Cliente implements java.io.Serializable {

    private String cpf;
    private String email;
    private String nome;
    private String senha;
    private String rua;
    private Integer num;
    private String bairro;
    private String cidade;
    private String estado;
    private Boolean isAdmin;
    private Set <Compra> compras = new HashSet(0);

    public Cliente() {
    }

    public Cliente(String cpf) {
        this.cpf = cpf;
    }

    public Cliente(String cpf, String email, String nome, String senha, String rua, Integer num, String bairro, String cidade, String estado, Boolean isAdmin, Set compras) {
        this.cpf = cpf;
        this.email = email;
        this.nome = nome;
        this.senha = senha;
        this.rua = rua;
        this.num = num;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.isAdmin = isAdmin;
        this.compras = compras;
    }

    @Id

    @Column(name = "cpf", unique = true, nullable = false, length = 14)
    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Column(name = "email", unique = true, length = 150)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "nome", length = 150)
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name = "senha", length = 20)
    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Column(name = "rua", length = 100)
    public String getRua() {
        return this.rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    @Column(name = "num")
    public Integer getNum() {
        return this.num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Column(name = "bairro", length = 100)
    public String getBairro() {
        return this.bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    @Column(name = "cidade", length = 300)
    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Column(name = "estado", length = 50)
    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Column(name = "is_admin")
    public Boolean getIsAdmin() {
        return this.isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
    public Set <Compra> getCompras() {
        return this.compras;
    }

    public void setCompras(Set <Compra> compras) {
        this.compras = compras;
    }

}