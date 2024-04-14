/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GerenciadorDeHoteis.Repository;

import GerenciadorDeHoteis.Types.Funcionario;
import GerenciadorDeHoteis.Types.Quarto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
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

    public TipoRepository() {
        EntityManagerFactory fm = Persistence.createEntityManagerFactory("bd-gerenciador");
        this.em = fm.createEntityManager();
    }

    //Funcionario Repository
    public Funcionario buscarPorCPFFuncionario(String cpf) {
        TypedQuery<Funcionario> query = em.createQuery("SELECT f FROM Funcionario f WHERE f.cpf = :cpf", Funcionario.class);
        query.setParameter("cpf", cpf);
        List<Funcionario> resultados = query.getResultList();

        if (resultados.size() == 1) {
            return resultados.get(0);

        } else if (resultados.isEmpty()) {
            return null;

        } else {
            throw new IllegalStateException("Mais de um funcionário encontrado com o mesmo CPF!");
        }
    }

    public void inserirFuncionario(Funcionario funcionario) {
        em.getTransaction().begin();
        em.persist(funcionario);
        em.getTransaction().commit();
    }

    //Quarto Repository   
    public Quarto buscarPorNomeQuarto(String quarto) {
        TypedQuery<Quarto> query = em.createQuery("SELECT f FROM Quarto f WHERE f.nome= :nome", Quarto.class);
        query.setParameter("nome", quarto);
        List<Quarto> resultados = query.getResultList();

        if (resultados.size() == 1) {
            return resultados.get(0);

        } else if (resultados.isEmpty()) {
            return null;

        } else {
            throw new IllegalStateException("Mais de um quarto encontrado com o mesmo nome!");
        }
    }
    
    /*public Quarto buscarPorNomeQuarto(String quarto) {
        Quarto quartoEncontrado = em.find(Quarto.class, quarto);
        if (quartoEncontrado != null) {
            return quartoEncontrado;
        } else {
            return null;
        }
    }*/

    public Quarto buscarPorIdQuarto(int id) {
        TypedQuery<Quarto> query = em.createQuery("SELECT q FROM Quarto q WHERE q.id = :id", Quarto.class);
        query.setParameter("id", id);
        List<Quarto> resultados = query.getResultList();

        if (resultados.size() == 1) {
            return resultados.get(0);

        } else if (resultados.isEmpty()) {
            return null;

        } else {
            throw new IllegalStateException("Mais de um funcionário encontrado com o mesmo CPF!");
        }
    }

    public List<Quarto> listarTodosQuartos() {
        TypedQuery<Quarto> query = em.createQuery("SELECT q FROM Quarto q", Quarto.class);
        return query.getResultList();
    }

    public List<Object[]> preencherTabelaQuarto() {
        List<Quarto> quartos = listarTodosQuartos();
        List<Object[]> tabela = new ArrayList<>();

        for (Quarto quarto : quartos) {
            Object[] linha = {quarto.getId(), quarto.getNome(), quarto.getTipoQuarto(), quarto.getNumeroCamas(), quarto.isStatus()};
            tabela.add(linha);
        }
        return tabela;
    }

    public List<Object[]> preencherTabelaPesquisaQuarto(String campo, Object valor) {
        List<Quarto> quartos = pesquisaCampoQuarto(campo, valor);
        List<Object[]> tabela = new ArrayList<>();

        for (Quarto quarto : quartos) {
            Object[] linha = {quarto.getId(), quarto.getNome(), quarto.getTipoQuarto(), quarto.getNumeroCamas(), quarto.isStatus()};
            tabela.add(linha);
        }
        return tabela;
    }

    public List<Quarto> pesquisaCampoQuarto(String campo, Object valor) {
        String pesquisa = "SELECT q FROM Quarto q WHERE ";
        if ("Id".equals(campo)) {
            pesquisa += "q.id = :valor";

        } else if ("Nome Quarto".equals(campo)) {
            pesquisa += "q.nome = :valor";

        } else if ("Tipo Do Quarto".equals(campo)) {
            pesquisa += "q.tipoQuarto = :valor";

        } else if ("Nº De Camas".equals(campo)) {
            pesquisa += "q.numeroCamas = :valor";

        } else if ("Status Ocupação".equals(campo)) {
            pesquisa += "q.status = :valor";

        } else {
            throw new IllegalArgumentException("Campo de busca inválido: " + campo);
        }
        TypedQuery<Quarto> query = em.createQuery(pesquisa, Quarto.class);
        query.setParameter("valor", valor);
        return query.getResultList();
    }

    public void atualizarQuarto(int id, Quarto quarto) {
        em.getTransaction().begin();
        Quarto quartoExistente = em.find(Quarto.class, id);

        if (quartoExistente == null) {
            System.out.println("Quarto não encontrado para atualização");
            return;
        }

        quartoExistente.setNome(quarto.getNome());
        quartoExistente.setTipoQuarto(quarto.getTipoQuarto());
        quartoExistente.setNumeroCamas(quarto.getNumeroCamas());
        quartoExistente.setStatus(quarto.isStatus());
        em.merge(quartoExistente);
        em.getTransaction().commit();
    }

    public void deletarQuartoPorId(int id) {
        em.getTransaction().begin();
        Quarto quarto = em.find(Quarto.class, id);
        if (quarto == null) {
            System.out.println("Quarto não encontrado");
        } else {
            em.remove(quarto);
            em.getTransaction().commit();
            System.out.println("Quarto deletado com sucesso!");
            System.out.println("Quarto não encontrado");
        }
    }

    public void inserirQuarto(Quarto quarto) {
        em.getTransaction().begin();
        em.persist(quarto);
        em.getTransaction().commit();
    }
}