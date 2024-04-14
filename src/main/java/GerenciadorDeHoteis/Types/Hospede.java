/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GerenciadorDeHoteis.Types;

import java.util.Date;

/**
 *
 * @author Marcos
 */
public class Hospede {

    private Integer id;
    private String nome;
    private String cpf;
    private String passaporte;
    private String email;
    private String telefone;
    private String pais;
    private Date data;

    public Hospede(String nome, String cpf, String passaporte, String email, String telefone, String pais, Date data) {
        this.nome = nome;
        this.cpf = cpf;
        this.passaporte = passaporte;
        this.email = email;
        this.telefone = telefone;
        this.pais = pais;
        this.data = data;
    }

    public Hospede() {
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPassaporte() {
        return passaporte;
    }

    public void setPassaporte(String passaporte) {
        this.passaporte = passaporte;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

}
