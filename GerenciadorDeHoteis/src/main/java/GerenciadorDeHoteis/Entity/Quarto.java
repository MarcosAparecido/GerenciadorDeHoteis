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
import jakarta.persistence.Table;

/**
 *
 * @author Marcos
 */
@Entity
@Table(name = "tb_quarto")
public class Quarto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id", nullable = false, unique = true)
    private Integer id;
    @Column(name = "nome", nullable = false)
    private String nome;
    private String tipoQuarto;
    private byte numeroCamas;
    private boolean status;

    public Quarto(String nome, String tipoQuarto, byte numeroCamas, boolean status) {
        this.nome = nome;
        this.tipoQuarto = tipoQuarto;
        this.numeroCamas = numeroCamas;
        this.status = status;
    }

    public Quarto() {
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

    public String getTipoQuarto() {
        return tipoQuarto;
    }

    public void setTipoQuarto(String tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }

    public byte getNumeroCamas() {
        return numeroCamas;
    }

    public void setNumeroCamas(byte numeroCamas) {
        this.numeroCamas = numeroCamas;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }  
}