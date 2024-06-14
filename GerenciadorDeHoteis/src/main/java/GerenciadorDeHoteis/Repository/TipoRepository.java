/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GerenciadorDeHoteis.Repository;

import GerenciadorDeHoteis.Entity.Funcionario;
import GerenciadorDeHoteis.Entity.Hospede;
import GerenciadorDeHoteis.Entity.ProdutoEServico;
import GerenciadorDeHoteis.Entity.Quarto;
import GerenciadorDeHoteis.Entity.Reserva;
import GerenciadorDeHoteis.Entity.ReservaDespesa;
import GerenciadorDeHoteis.Entity.ReservaHospede;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
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

    public Funcionario buscarIformacaoLogin(String cpf, String senha) {
        TypedQuery<Funcionario> query = em.createQuery("SELECT f FROM Funcionario f WHERE f.cpf = :cpf", Funcionario.class);
        query.setParameter("cpf", cpf);

        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException e) {
            throw new IllegalStateException("Mais de um funcionário encontrado com o mesmo CPF!");
        }
    }

    public List<Funcionario> listarTodosFuncionarios() {
        TypedQuery<Funcionario> query = em.createQuery("SELECT q FROM Funcionario q", Funcionario.class);
        return query.getResultList();
    }

    public void inserirFuncionario(Funcionario funcionario) {
        if (em.getTransaction().isActive()) {
            System.out.println("transmição acontecendo em atualizar, fechendo transmição");
            em.getTransaction().rollback();
            em.close();
        }
        em.getTransaction().begin();
        em.persist(funcionario);
        em.getTransaction().commit();
    }
      public Funcionario buscarPorIdFuncionario(int id) {
        TypedQuery<Funcionario> query = em.createQuery("SELECT q FROM Funcionario q WHERE q.id = :id", Funcionario.class);
        query.setParameter("id", id);
        List<Funcionario> resultados = query.getResultList();

        if (resultados.size() == 1) {
            return resultados.get(0);

        } else if (resultados.isEmpty()) {
            return null;

        } else {
            throw new IllegalStateException("Mais de um Funcionario encontrado com o mesmo nome!");
        }
    }
      
    //Quarto Repository   
    public Quarto buscarPorNomeQuarto(String quarto) {
        TypedQuery<Quarto> query = em.createQuery("SELECT q FROM Quarto q WHERE q.nome= :nome", Quarto.class);
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

    public List<Quarto> buscarPorNomeEspecificoQuarto(String quarto) {
        TypedQuery<Quarto> query = em.createQuery("SELECT q FROM Quarto q WHERE q.tipoQuarto = :tipoQuarto", Quarto.class);
        query.setParameter("tipoQuarto", quarto);
        List<Quarto> lista = query.getResultList();
        return lista;
    }

    public Quarto buscarPorIdQuarto(int id) {
        TypedQuery<Quarto> query = em.createQuery("SELECT q FROM Quarto q WHERE q.id = :id", Quarto.class);
        query.setParameter("id", id);
        List<Quarto> resultados = query.getResultList();

        if (resultados.size() == 1) {
            return resultados.get(0);

        } else if (resultados.isEmpty()) {
            return null;

        } else {
            throw new IllegalStateException("Mais de um Quarto encontrado com o mesmo nome!");
        }
    }

    public List<Quarto> listarTodosQuartos() {
        TypedQuery<Quarto> query = em.createQuery("SELECT q FROM Quarto q", Quarto.class);
        return query.getResultList();
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
        if (em.getTransaction().isActive()) {
            System.out.println("transmição acontecendo em atualizar, fechendo transmição");
            em.getTransaction().rollback();
            em.close();
        }
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

    public void atualizarStatusQuarto(int id, boolean status) {
        if (em.getTransaction().isActive()) {
            System.out.println("Transação acontecendo em atualizar, fechando transação");
            em.getTransaction().rollback();
            em.close();
        }
        em.getTransaction().begin();
        Quarto quarto = em.find(Quarto.class, id);

        if (quarto == null) {
            System.out.println("Quarto não encontrado para atualização de status");
            return;
        }

        quarto.setStatus(status);
        em.merge(quarto);
        em.getTransaction().commit();
        System.out.println("Status do quarto atualizado com sucesso!");
    }

    public void deletarQuartoPorId(int id) {
        if (em.getTransaction().isActive()) {
            System.out.println("transmição acontecendo em atualizar, fechendo transmição");
            em.getTransaction().rollback();
            em.close();
        }
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
        if (em.getTransaction().isActive()) {
            System.out.println("transmição acontecendo em atualizar, fechendo transmição");
            em.getTransaction().rollback();
            em.close();
        }
        em.getTransaction().begin();
        em.persist(quarto);
        em.getTransaction().commit();
    }

    //Repository Produto e Serviço
    public ProdutoEServico buscarPorNomeProduto(String produto) {
        TypedQuery<ProdutoEServico> query = em.createQuery("SELECT p FROM ProdutoEServico p WHERE p.nome= :nome", ProdutoEServico.class);
        query.setParameter("nome", produto);
        List<ProdutoEServico> resultados = query.getResultList();

        if (resultados.size() == 1) {
            return resultados.get(0);

        } else if (resultados.isEmpty()) {
            return null;

        } else {
            throw new IllegalStateException("Mais de um produto encontrado com o mesmo nome!");
        }
    }

    public ProdutoEServico buscarPorIdProduto(int id) {
        TypedQuery<ProdutoEServico> query = em.createQuery("SELECT p FROM ProdutoEServico p WHERE p.id = :id", ProdutoEServico.class);
        query.setParameter("id", id);
        List<ProdutoEServico> resultados = query.getResultList();

        if (resultados.size() == 1) {
            return resultados.get(0);

        } else if (resultados.isEmpty()) {
            return null;

        } else {
            throw new IllegalStateException("Mais de um funcionário encontrado com o mesmo CPF!");
        }
    }

    public Integer buscarIdPorNomeProduto(String nomeProduto) {
        TypedQuery<Integer> query = em.createQuery("SELECT p.id FROM ProdutoEServico p WHERE p.nome = :nome", Integer.class);
        query.setParameter("nome", nomeProduto);
        List<Integer> resultados = query.getResultList();

        if (!resultados.isEmpty()) {
            return resultados.get(0);
        } else {
            return null;
        }
    }

    public List<ProdutoEServico> pesquisaCampoProduto(String campo, Object valor) {
        String pesquisa = "SELECT p FROM ProdutoEServico p WHERE ";
        if ("Id".equals(campo)) {
            pesquisa += "p.id = :valor";

        } else if ("Produto ou Serviço".equals(campo)) {
            pesquisa += "p.nome = :valor";

        } else if ("Estoque".equals(campo)) {
            pesquisa += "p.estoque = :valor";

        } else if ("Valor".equals(campo)) {
            pesquisa += "p.valor = :valor";

        } else {
            throw new IllegalArgumentException("Campo de busca inválido: " + campo);
        }
        TypedQuery<ProdutoEServico> query = em.createQuery(pesquisa, ProdutoEServico.class);
        query.setParameter("valor", valor);
        return query.getResultList();
    }

    public List<ProdutoEServico> listarTodosProdutos() {
        TypedQuery<ProdutoEServico> query = em.createQuery("SELECT p FROM ProdutoEServico p", ProdutoEServico.class);
        return query.getResultList();
    }

    public void deletarProdutoPorId(int id) {
        if (em.getTransaction().isActive()) {
            System.out.println("transmição acontecendo em atualizar, fechendo transmição");
            em.getTransaction().rollback();
            em.close();
        }

        em.getTransaction().begin();
        ProdutoEServico produto = em.find(ProdutoEServico.class, id);
        if (produto == null) {
            System.out.println("Produtonão encontrado");

        } else {
            em.remove(produto);
            em.getTransaction().commit();
            System.out.println("Prudto deletado com sucesso!");
            System.out.println("Produto não encontrado");
        }
    }

    public void atualizarProduto(int id, ProdutoEServico produtoEServico) {
        if (em.getTransaction().isActive()) {
            System.out.println("transmição acontecendo em atualizar, fechendo transmição");
            em.getTransaction().rollback();
            em.close();
        }

        em.getTransaction().begin();
        ProdutoEServico produtoExistente = em.find(ProdutoEServico.class, id);
        if (produtoExistente == null) {
            System.out.println("Produto não encontrado para atualização");
            return;
        }
        produtoExistente.setNome(produtoEServico.getNome());
        produtoExistente.setEstoque(produtoEServico.getEstoque());
        produtoExistente.setValor(produtoEServico.getValor());
        em.merge(produtoExistente);
        em.getTransaction().commit();
        System.out.println("produto atualizado");
    }

    public void inserirProduto(ProdutoEServico produtoEServico) {
        if (em.getTransaction().isActive()) {
            System.out.println("transmição acontecendo em atualizar, fechendo transmição");
            em.getTransaction().rollback();
            em.close();
        }
        em.getTransaction().begin();
        em.persist(produtoEServico);
        em.getTransaction().commit();
    }

    //Hospede Repository
    public Hospede buscarPorCPFHosde(String cpf) {
        TypedQuery<Hospede> query = em.createQuery("SELECT h FROM Hospede h WHERE h.cpf = :cpf", Hospede.class);
        query.setParameter("cpf", cpf);
        List<Hospede> resultados = query.getResultList();

        if (resultados.size() == 1) {
            return resultados.get(0);

        } else if (resultados.isEmpty()) {
            return null;

        } else {
            throw new IllegalStateException("Mais de um Hospede encontrado com o mesmo CPF!");
        }
    }

    public Hospede buscarPorIdPorCpfHospede(String cpf) {
        TypedQuery<Hospede> query = em.createQuery("SELECT h FROM Hospede h WHERE h.cpf = :nome", Hospede.class);
        query.setParameter("nome", cpf);
        List<Hospede> resultados = query.getResultList();

        if (resultados.size() == 1) {
            return resultados.get(0);
        } else if (resultados.isEmpty()) {
            return null;
        } else {
            throw new IllegalStateException("Mais de um Hospede encontrado com o mesmo nome!");
        }
    }

    public Hospede buscarPorCpfEPassaporte(String cpf, String passaporte) {
        if (cpf == null && passaporte == null) {
            throw new IllegalArgumentException("CPF e passaporte não podem ser ambos nulos!");
        }
        TypedQuery<Hospede> query;

        if (cpf != null && passaporte != null) {
            query = em.createQuery("SELECT h FROM Hospede h WHERE h.cpf = :cpf AND h.passaporte = :passaporte", Hospede.class);
            query.setParameter("cpf", cpf);
            query.setParameter("passaporte", passaporte);
        } else if (cpf != null) {
            query = em.createQuery("SELECT h FROM Hospede h WHERE h.cpf = :cpf", Hospede.class);
            query.setParameter("cpf", cpf);
        } else {
            query = em.createQuery("SELECT h FROM Hospede h WHERE h.passaporte = :passaporte", Hospede.class);
            query.setParameter("passaporte", passaporte);
        }
        List<Hospede> resultados = query.getResultList();

        if (!resultados.isEmpty()) {
            return resultados.get(0);
        } else {
            return null;
        }
    }

    public Hospede buscarPorIdHospede(int id) {
        TypedQuery<Hospede> query = em.createQuery("SELECT h FROM Hospede h WHERE h.id = :id", Hospede.class);
        query.setParameter("id", id);
        List<Hospede> resultados = query.getResultList();

        if (resultados.size() == 1) {
            return resultados.get(0);

        } else if (resultados.isEmpty()) {
            return null;

        } else {
            throw new IllegalStateException("Mais de um Hospede encontrado com o mesmo nome!");
        }
    }

    public List<Hospede> listarTodosHospede() {
        TypedQuery<Hospede> query = em.createQuery("SELECT h FROM Hospede h", Hospede.class);
        return query.getResultList();
    }

    public List<Hospede> pesquisaCampoHospede(String campo, Object valor) {
        String pesquisa = "SELECT h FROM Hospede h WHERE ";
        if ("Id".equals(campo)) {
            pesquisa += "h.id = :valor";

        } else if ("Nome Hospede".equals(campo)) {
            pesquisa += "h.nome = :valor";

        } else if ("CPF".equals(campo)) {
            pesquisa += "h.cpf = :valor";

        } else if ("Passaporte".equals(campo)) {
            pesquisa += "h.passaporte = :valor";

        } else if ("Email".equals(campo)) {
            pesquisa += "h.email = :valor";

        } else if ("Telefone".equals(campo)) {
            pesquisa += "h.telefone = :valor";

        } else if ("Pais".equals(campo)) {
            pesquisa += "h.pais = :valor";

        } else if ("Data de Nascimento".equals(campo)) {
            pesquisa += "h.dataNascimento = :valor";

        } else {
            throw new IllegalArgumentException("Campo de busca inválido: " + campo);
        }
        TypedQuery<Hospede> query = em.createQuery(pesquisa, Hospede.class);
        query.setParameter("valor", valor);
        return query.getResultList();
    }

    public void inserirHospede(Hospede hospede) {
        if (em.getTransaction().isActive()) {
            System.out.println("transmição acontecendo em atualizar, fechendo transmição");
            em.getTransaction().rollback();
            em.close();
        }
        em.getTransaction().begin();
        em.persist(hospede);
        em.getTransaction().commit();
    }

    //Reserva Repository
    public Reserva buscarReservaPorId(int id) {
        TypedQuery<Reserva> query = em.createQuery("SELECT p FROM Reserva p WHERE p.id = :id", Reserva.class);
        query.setParameter("id", id);
        List<Reserva> resultados = query.getResultList();

        if (resultados.size() == 1) {
            return resultados.get(0);

        } else if (resultados.isEmpty()) {
            return null;

        } else {
            throw new IllegalStateException("Mais de um funcionário encontrado com o mesmo CPF!");
        }
    }

    public Reserva buscarPorNomeQuartoPorIdHospede(int id) {
        TypedQuery<Reserva> query = em.createQuery("SELECT h FROM Reserva h WHERE h.hospede_id = :nomeQuarto", Reserva.class);
        query.setParameter("nomeQuarto", id);
        List<Reserva> resultados = query.getResultList();

        if (resultados.size() >= 1) {
            return resultados.get(0);

        } else if (resultados.isEmpty()) {
            return null;

        } else {
            throw new IllegalStateException("Mais de um Reserva encontrado com o mesmo nome!");
        }
    }

    public Reserva buscarPorCheckInPorCpfePassaporteHospede(String cpf, String passaporte) {
        Hospede hospede = buscarPorCpfEPassaporte(cpf, passaporte);
        if (hospede == null) {
            return null;
        }
        TypedQuery<Reserva> query = em.createQuery("SELECT h FROM ReservaHospede h WHERE h.reseva = :checkIn", Reserva.class);
        query.setParameter("checkIn", hospede.getId());
        List<Reserva> resultados = query.getResultList();

        if (resultados.size() >= 1) {
            return resultados.get(0);

        } else if (resultados.isEmpty()) {
            return null;

        } else {
            throw new IllegalStateException("Mais de um Reserva encontrado com o mesmo nome!");
        }
    }

    public List<Reserva> listarTodosReservas() {
        TypedQuery<Reserva> query = em.createQuery("SELECT r FROM Reserva r", Reserva.class);
        return query.getResultList();
    }

    public List<Reserva> listarTodosReservasStatus() {
        TypedQuery<Reserva> query = em.createQuery("SELECT r FROM Reserva r WHERE r.status = true", Reserva.class);
        return query.getResultList();
    }

    public void inserirReserva(Reserva reserva) {
        if (em.getTransaction().isActive()) {
            System.out.println("transmição acontecendo em atualizar, fechendo transmição");
            em.getTransaction().rollback();
            em.close();
        }
        em.getTransaction().begin();
        em.persist(reserva);
        em.getTransaction().commit();
    }

    public void atualizarStatusReserva(int id, boolean status) {
        if (em.getTransaction().isActive()) {
            System.out.println("Transação acontecendo em atualizar, fechando transação");
            em.getTransaction().rollback();
            em.close();
        }
        em.getTransaction().begin();
        Reserva reserva = em.find(Reserva.class, id);

        if (reserva == null) {
            System.out.println("Quarto não encontrado para atualização de status");
            return;
        }

        reserva.setStatus(status);
        em.merge(reserva);
        em.getTransaction().commit();
        System.out.println("Status do quarto atualizado com sucesso!");
    }

    //ReservaDespesa Repoditory
    public ReservaDespesa buscaUltimaEntradaPorIdReserva(int idReserva) {
        String consultaSql = "SELECT r FROM ReservaDespesa r WHERE r.reserva.id = :reserva_id ORDER BY r.dataConsumo DESC";

        TypedQuery<ReservaDespesa> query = em.createQuery(consultaSql, ReservaDespesa.class);
        query.setParameter("reserva_id", idReserva);
        query.setMaxResults(1);

        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("retorna null");
            return null;
        }
    }

    public void inserirReservaDespesa(ReservaDespesa ReservaDespesa) {
        if (em.getTransaction().isActive()) {
            System.out.println("transmição acontecendo em atualizar, fechendo transmição");
            em.getTransaction().rollback();
            em.close();
        }
        em.getTransaction().begin();
        em.persist(ReservaDespesa);
        em.getTransaction().commit();
    }

    //ReservaHospede Repository
    public ReservaHospede buscarPorIdReservaPorCpfEPassaporteHospede(String cpf, String passaporte) {
        Hospede hospede = buscarPorCpfEPassaporte(cpf, passaporte);
        if (hospede == null) {
            return null;
        }
        TypedQuery<Object[]> query = em.createQuery("SELECT r, h FROM Reserva r JOIN r.hospede h WHERE h.id = :id", Object[].class);
        query.setParameter("id", hospede.getId());
        List<Object[]> resultados = query.getResultList();

        if (!resultados.isEmpty()) {
            Object[] resultado = resultados.get(0);
            return new ReservaHospede((Reserva) resultado[0], (Hospede) resultado[1]);

        } else {
            return null;
        }
    }

    public List<ReservaHospede> litarReservaHospede() {
        TypedQuery<Object[]> query = em.createQuery("SELECT r, h FROM Reserva r JOIN r.hospede h", Object[].class);
        List<Object[]> resultados = query.getResultList();
        List<ReservaHospede> reservaHospedeList = new ArrayList<>();
        for (Object[] resultado : resultados) {
            Reserva reserva = (Reserva) resultado[0];
            Hospede hospede = (Hospede) resultado[1];
            reservaHospedeList.add(new ReservaHospede(reserva, hospede));
        }
        return reservaHospedeList;
    }
}
