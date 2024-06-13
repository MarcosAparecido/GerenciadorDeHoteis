/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GerenciadorDeHoteis.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
/**
 *
 * @author Marcos
 */
@Entity
@Table(name = "tb_reserva_produtoeservico")
public class ReservaDespesa {
    
    @EmbeddedId
    private ReservaDespesaId id;
    
    @ManyToOne
    @MapsId("reservaId")
    @JoinColumn(name = "reserva_id")
    private Reserva reserva;
    
    @ManyToOne
    @MapsId("despesaId")
    @JoinColumn(name = "despesa_id")
    private ProdutoEServico produtoEServico;
    
    @Column(name = "nome", nullable = false, unique = false)
    String nome;

    @Column(name = "produtoServico", nullable = false, unique = false)
    private String produtoServico;
    
    @Column(name = "dataConsumo", nullable = false, unique = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataConsumo;
    
    @Column(name = "quantidade", nullable = true, unique = false)
    private int quantidade;
    
    @Column(name = "valor", nullable = true, unique = false)
    private double valor;
    
    @Column(name = "total", nullable = true, unique = false)
    private double total;

    public ReservaDespesa(ReservaDespesaId id, Reserva reserva, ProdutoEServico produtoEServico, String nome, String produtoServico, Date dataConsumo, int quantidade, double valor, double total) {
        this.id = id;
        this.reserva = reserva;
        this.produtoEServico = produtoEServico;
        this.nome = nome;
        this.produtoServico = produtoServico;
        this.dataConsumo = dataConsumo;
        this.quantidade = quantidade;
        this.valor = valor;
        this.total = total;
    }

    public ReservaDespesaId getId() {
        return id;
    }

    public void setId(ReservaDespesaId id) {
        this.id = id;
    }
    
    public ReservaDespesa() {
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public ProdutoEServico getProdutoEServico() {
        return produtoEServico;
    }

    public void setProdutoEServico(ProdutoEServico produtoEServico) {
        this.produtoEServico = produtoEServico;
    }
 
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProdutoServico() {
        return produtoServico;
    }

    public void setProdutoServico(String produtoServico) {
        this.produtoServico = produtoServico;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getProduto() {
        return produtoServico;
    }

    public void setProduto(String produtoServico) {
        this.produtoServico = produtoServico;
    }

    public Date getDataConsumo() {
        return dataConsumo;
    }

    public void setDataConsumo(Date dataConsumo) {
        this.dataConsumo = dataConsumo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}