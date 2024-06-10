/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GerenciadorDeHoteis.Entity;

/**
 *
 * @author Marcos
 */
public class ReservaHospede {

    private Reserva reserva;
    private Hospede hospede;

    public ReservaHospede(Reserva reserva, Hospede hospede) {
        this.reserva = reserva;
        this.hospede = hospede;
    }

    public ReservaHospede() {
    }
    
    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }  
}