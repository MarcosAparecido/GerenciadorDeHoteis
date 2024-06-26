
import GerenciadorDeHoteis.Entity.Funcionario;
import GerenciadorDeHoteis.Entity.Hospede;
import GerenciadorDeHoteis.Repository.TipoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class TesteConexaoMySQL {

    private EntityManager em;

    public TesteConexaoMySQL() {
        EntityManagerFactory fm = Persistence.createEntityManagerFactory("bd-gerenciador");
        this.em = fm.createEntityManager();
    }

    public static void main(String[] args) {
        TesteConexaoMySQL teste = new TesteConexaoMySQL();
        teste.listar();
        teste.cpf();
        String url = "jdbc:mysql://localhost:3306/dbgerenciadordehoteis";
        String usuario = "root";
        String senha = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conexao = DriverManager.getConnection(url, usuario, senha);

            System.out.println("Conexão bem-sucedida!");

            conexao.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC não encontrado.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados.");
            e.printStackTrace();
        }

    }

    public List<Funcionario> listarTodos() {
        String query = "SELECT t FROM Funcionario t";
        return (List<Funcionario>) em.createQuery(query).getResultList();
    }

    public void listar() {
        List<Funcionario> f = listarTodos();
        for (Funcionario funcionario : f) {
            System.out.println(funcionario.getNome() + funcionario.getSobrenome());
        }
    }

    public void cpf() {
        TipoRepository repository = new TipoRepository();
        String cpf = "123.456.789-00"; // CPF válido para simulação
        String passaporte = null; // Passaporte nulo para simulação

        Hospede resultado = repository.buscarPorCpfEPassaporte(cpf, passaporte);

        if (resultado == null) {
            System.out.println("Nenhum hóspede encontrado com o CPF fornecido e passaporte nulo.");
        } else {
            System.out.println("Hóspede encontrado: " + resultado.getNome());
        }
    }
}
