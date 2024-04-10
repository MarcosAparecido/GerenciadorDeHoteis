package GerenciadorDeHoteis.Types;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author Marcos
 */
@Entity
@Table(name = "tb_funcionario")
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;
    private String nome;
    private String sobrenome;
    private String telefone;
    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;
    @Column(name = "senha", nullable = false)
    private String senha;
    
    public Funcionario(String nome, String sobrenome, String telefone, String cpf, String senha) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.senha = senha;
    }

    public Funcionario() {
    }
     
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}