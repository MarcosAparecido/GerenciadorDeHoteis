/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GerenciadorDeHoteis.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

/**
 *
 * @author Marcos
 */
@Embeddable
public class ReservaDespesaId implements Serializable {

    @Column(name = "reserva_id")
    private Integer reservaId;

    @Column(name = "despesa_id")
    private Integer despesaId;

    public ReservaDespesaId(Integer reservaId, Integer despesaId) {
        this.reservaId = reservaId;
        this.despesaId = despesaId;
    }
    
    public ReservaDespesaId() {
    }

    public int getReservaId() {
        return reservaId;
    }

    public void setReservaId(int reservaId) {
        this.reservaId = reservaId;
    }

    public int getDespesaId() {
        return despesaId;
    }

    public void setDespesaId(int despesaId) {
        this.despesaId = despesaId;
    }

}