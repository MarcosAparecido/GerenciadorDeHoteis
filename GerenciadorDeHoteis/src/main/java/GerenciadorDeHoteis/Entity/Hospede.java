/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GerenciadorDeHoteis.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
/**
 *
 * @author Marcos
 */
@Entity
@Table(name = "tb_hospede")
public class Hospede implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;
    @ManyToMany(mappedBy = "hospede")
    private Set<Reserva> reserva = new HashSet<>();
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "cpf", unique = true)
    private String cpf;
    @Column(name = "passaporte", unique = true)
    private String passaporte;
    private String email;
    private String telefone;
    private String pais;
    @Temporal(TemporalType.DATE)
    @Column(name = "dataNascimento")
    private Date dataNascimento;

    public Hospede(String nome, String cpf, String passaporte, String email, String telefone, String pais, Date dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.passaporte = passaporte;
        this.email = email;
        this.telefone = telefone;
        this.pais = pais;
        this.dataNascimento = dataNascimento;
    }

    public Hospede() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Reserva> getReserva() {
        return reserva;
    }

    public void setReserva(Set<Reserva> reserva) {
        this.reserva = reserva;
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}