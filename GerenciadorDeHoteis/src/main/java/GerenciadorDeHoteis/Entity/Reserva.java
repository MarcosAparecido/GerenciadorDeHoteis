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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Marcos
 */
@Entity
@Table(name = "tb_reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "quarto_id")
    private Quarto quarto;
 
    @ManyToMany
    @JoinTable(name = "tb_reserva_hospede", joinColumns = @JoinColumn(name = "reserva_id"), inverseJoinColumns = @JoinColumn(name = "hospede_id"))
    private Set<Hospede> hospede = new HashSet<>();
    
    @Column(name = "nome", nullable = false, unique = false)
    private String nome;
    
    @Column(name = "numeroHospedes", nullable = false, unique = false)
    private byte numeroHospedes;
    
    @Column(name = "nomeQuarto", nullable = false, unique = false)
    private String nomeQuarto;
    
    @Column(name = "status", nullable = false, unique = false)
    private boolean status;
    
    @Column(name = "checkIn", nullable = false, unique = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkIn;
    
    @Column(name = "checkOut", nullable = true, unique = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkOut;
    
    public Reserva(Funcionario funcionario, Quarto quarto, String nome, byte numeroHospedes, String nomeQuarto, boolean status, Date checkIn, Date checkOut) {
        this.funcionario = funcionario;
        this.quarto = quarto;
        this.nome = nome;
        this.numeroHospedes = numeroHospedes;
        this.nomeQuarto = nomeQuarto;
        this.status = status;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }
   
    public Set<Hospede> getHospede() {
        return hospede;
    }

    public void setHospede(Set<Hospede> hospede) {
        this.hospede = hospede;
    }
    
    public Reserva() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public byte getNumeroHospedes() {
        return numeroHospedes;
    }

    public void setNumeroHospedes(byte numeroHospedes) {
        this.numeroHospedes = numeroHospedes;
    }

    public String getNomeQuarto() {
        return nomeQuarto;
    }

    public void setNomeQuarto(String nomeQuarto) {
        this.nomeQuarto = nomeQuarto;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }
}