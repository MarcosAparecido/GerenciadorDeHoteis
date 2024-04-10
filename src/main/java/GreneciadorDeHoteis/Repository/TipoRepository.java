/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GreneciadorDeHoteis.Repository;

import GerenciadorDeHoteis.Types.Funcionario;
import GerenciadorDeHoteis.Types.Quarto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcos
 */
public class TipoRepository {
    private EntityManager em;
    
    public TipoRepository(){
        EntityManagerFactory fm = Persistence.createEntityManagerFactory("bd-gerenciador");
        this.em = fm.createEntityManager();
    }
    
    //Funcionario Repository
    public Funcionario buscarPorCPFFuncionario(String cpf) {
        try {
            TypedQuery<Funcionario> query = em.createQuery("SELECT f FROM Funcionario f WHERE f.cpf = :cpf", Funcionario.class);
            query.setParameter("cpf", cpf);
            List<Funcionario> resultados = query.getResultList();

            if (resultados.size() == 1) {
                return resultados.get(0); // Retorna o único funcionário encontrado

            } else if (resultados.isEmpty()) {
                return null; // Retorna null se nenhum funcionário for encontrado com o CPF fornecido

            } else {
                throw new IllegalStateException("Mais de um funcionário encontrado com o mesmo CPF!"); // Lança uma exceção se mais de um funcionário for encontrado com o mesmo CPF
            }
        } catch (NoResultException e) {
            return null; // Se nenhum funcionário for encontrado com o CPF fornecido
        }
    }   
    
    public void inserirFuncionario(Funcionario funcionario){
        em.getTransaction().begin();
        em.persist(funcionario);
        em.getTransaction().commit();
    }
    
    //Quarto Repository   
    public Quarto buscarPorNomeQuarto(String quarto) {
        try {
            TypedQuery<Quarto> query = em.createQuery("SELECT f FROM Quarto f WHERE f.nome= :nome", Quarto.class);
            query.setParameter("nome", quarto);
            List<Quarto> resultados = query.getResultList();

            if (resultados.size() == 1) {
                return resultados.get(0); // Retorna o único funcionário encontrado

            } else if (resultados.isEmpty()) {
                return null; // Retorna null se nenhum funcionário for encontrado com o CPF fornecido

            } else {
                throw new IllegalStateException("Mais de um quarto encontrado com o mesmo nome!"); // Lança uma exceção se mais de um funcionário for encontrado com o mesmo CPF
            }
        } catch (NoResultException e) {
            return null; // Se nenhum funcionário for encontrado com o CPF fornecido
        }
    }
    
    public Quarto buscarPorIdQuarto(int id) {
        try {
            TypedQuery<Quarto> query = em.createQuery("SELECT q FROM Quarto q WHERE q.id = :id", Quarto.class);
            query.setParameter("id", id);
            List<Quarto> resultados = query.getResultList();

            if (resultados.size() == 1) {
                return resultados.get(0); // Retorna o único funcionário encontrado

            } else if (resultados.isEmpty()) {
                return null; // Retorna null se nenhum funcionário for encontrado com o CPF fornecido

            } else {
                throw new IllegalStateException("Mais de um funcionário encontrado com o mesmo CPF!"); // Lança uma exceção se mais de um funcionário for encontrado com o mesmo CPF
            }
        } catch (NoResultException e) {
            return null; // Se nenhum funcionário for encontrado com o CPF fornecido
        }
    }
    
    public List<Quarto> listarTodosQuartos(){
        TypedQuery<Quarto> query = em.createQuery("SELECT q FROM Quarto q", Quarto.class);
        return query.getResultList();
    }
    
    public Object[][] preencherTabelaQuarto(){
        List<Quarto> quartos = listarTodosQuartos();
        List<Object[]> tabela = new ArrayList<>();
        
        for (Quarto quarto : quartos){
            Object[] linha = {quarto.getId(), quarto.getNome(), quarto.getTipoQuarto(), quarto.getNumeroCamas(), quarto.isStatus()};  
            tabela.add(linha);
        }
        return tabela.toArray(new Object[0][]);
    }
    
    public void inserirQuarto(Quarto quarto){
        em.getTransaction().begin();
        em.persist(quarto);
        em.getTransaction().commit();
    }
}
