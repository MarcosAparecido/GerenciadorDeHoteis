/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GerenciadorDeHoteis.Service;

import GerenciadorDeHoteis.Types.Funcionario;
import GerenciadorDeHoteis.Types.Quarto;
import GerenciadorDeHoteis.Repository.TipoRepository;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcos
 */
public class TipoService {

    private TipoRepository tipoRepository;

    public TipoService() {
        this.tipoRepository = new TipoRepository();
    }

    //Service Funcionario
    private boolean validaDadosFuncionario(Funcionario funcionario) {
        if (funcionario.getNome() == null || funcionario.getSobrenome() == null || funcionario.getSenha() == null || funcionario.getTelefone() == null || funcionario.getCpf() == null) {
            JOptionPane.showInternalMessageDialog(null, "Um dos campos esta nulo.");
            return false;

        } else if (funcionario.getNome().trim().isBlank() || funcionario.getSobrenome().trim().isBlank() || funcionario.getSenha().trim().isBlank()
                || funcionario.getTelefone().trim().isBlank() || funcionario.getCpf().trim().isBlank()) {
            JOptionPane.showInternalMessageDialog(null, "Um dos campos esta em branco.");
            return false;

        } else if (funcionario.getNome().length() > 50 || funcionario.getSobrenome().length() > 50) {
            JOptionPane.showInternalMessageDialog(null, "O nome ou sobrenome não pode conter mais de 50 caracteres");
            return false;

        } else if (funcionario.getTelefone().length() > 14) {
            JOptionPane.showInternalMessageDialog(null, "O telefone não pode conter mais de 11 caracteres");
            return false;

        } else if (funcionario.getCpf().length() > 14) {
            JOptionPane.showInternalMessageDialog(null, "A senha não pode ter mais de 11 caracteres");
            return false;
        }

        if (!validaFormatoCampoTextoFuncionario(funcionario)) {
            System.out.println("um dos campos de formato de texto esta errado");
            return false;
        }

        if (!validaDuplicidadeDadosFuncionario(funcionario)) {
            JOptionPane.showInternalMessageDialog(null, "Ja existe um funcionário com o mesmo CPF");
            return false;
        }

        return true;
    }

    private boolean validaFormatoCampoTextoFuncionario(Funcionario funcionario) {
        boolean nomeValido = funcionario.getNome().matches("[a-zA-Z]+");
        boolean sobreNomeValido = funcionario.getSobrenome().matches("[a-zA-Z]+");
        boolean cpfValido = funcionario.getCpf().trim().matches("^(?!\\d+$)(?!\\d+-\\d+$)\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$");
        boolean telefoneValido = funcionario.getTelefone().matches("\\(\\d{2}\\)\\d{4,5}-\\d{4}");

        if (!nomeValido || !sobreNomeValido) {
            JOptionPane.showInternalMessageDialog(null, "Nome ou Sobrenome contem caracteres invalidos");
            return false;
        }

        if (!cpfValido) {
            JOptionPane.showInternalMessageDialog(null, "CPF contem caracteres invalidos");
            return false;
        }

        if (!telefoneValido) {
            JOptionPane.showInternalMessageDialog(null, "Telefone contem caracteres invalidos");
            return false;
        }
        return true;
    }

    private boolean validaDuplicidadeDadosFuncionario(Funcionario funcionario) {
        Funcionario funcionarioExistente = tipoRepository.buscarPorCPFFuncionario(funcionario.getCpf());
        if (funcionarioExistente != null) {
            System.out.println("Ja existe um funcionário com o mesmo CPF");
            return false;
        }
        return true;
    }

    public void salvarFuncionario(Funcionario funcionario) {
        System.out.println("Cadastrando o tipo...");
        if (validaDadosFuncionario(funcionario)) {
            System.out.println("Dados validados com sucesso");
            if (funcionario.getId() == null) {
                System.out.println("Inserindo os dados");
                JOptionPane.showInternalMessageDialog(null, "Funcionario cadastrado com sucesso");
                tipoRepository.inserirFuncionario(funcionario);
            }
        }
    }

    //Service Quartos
    private boolean validaDadosQuarto(Quarto quarto) {

        if (quarto.getNome().trim().isEmpty() || String.valueOf(quarto.getNumeroCamas()).trim().isEmpty()) {
            JOptionPane.showInternalMessageDialog(null, "Um dos campos esta nulo.");
            return false;

        } else if (quarto.getNome().trim().isBlank() || String.valueOf(quarto.getNumeroCamas()).trim().isBlank()) {
            JOptionPane.showInternalMessageDialog(null, "O campo Nome de Quarto esta em branco.");
            return false;

        } else if (quarto.getNome().length() > 50) {
            JOptionPane.showInternalMessageDialog(null, "O nome ou sobrenome não pode conter mais de 50 caracteres");
            return false;

        } else if (quarto.getNumeroCamas() > 10 || quarto.getNumeroCamas() < 1) {
            JOptionPane.showInternalMessageDialog(null, "O numero de camas não pode ser maior que 10 e menor que 1");
            return false;
        }

        if (!validaFormatoCampoTextoQuarto(quarto)) {
            System.out.println("um dos campos de formato de texto esta errado");
            return false;
        }

        if (!validaDuplicidadeDadosQuarto(quarto)) {
            JOptionPane.showInternalMessageDialog(null, "Ja existe um quarto com o mesmo nome");
            return false;
        }

        if (!validaNumeroEmString(quarto.getNome())) {
            JOptionPane.showInternalMessageDialog(null, "Nenhum numero encontrado, o quarto precisa ter um numero");
            return false;
        }
        return true;
    }

    private boolean validarCampoPesquisaQuarto(String valor) {
        if (valor == null) {
            JOptionPane.showInternalMessageDialog(null, "Campo valor esta nulo.");
            return false;

        } else if (valor.trim().isBlank()) {
            JOptionPane.showInternalMessageDialog(null, "Campo valor esta em branco.");
            return false;

        } else if (valor.length() > 50) {
            JOptionPane.showInternalMessageDialog(null, "Campo valor não deve possoir mais de 50 characteres");
            return false;
        }
        return true;
    }

    private boolean validaDuplicidadeDadosQuarto(Quarto quarto) {
        Quarto quartoExistente = tipoRepository.buscarPorNomeQuarto(quarto.getNome());
        if (quartoExistente != null) {
            System.out.println("Ja existe um quarto com o mesmo nome");
            return false;
        }
        return true;
    }

    private boolean validaFormatoCampoTextoQuarto(Quarto quarto) {
        String numeroCamasValidoString = String.valueOf(quarto.getNumeroCamas());
        boolean nomeValido = quarto.getNome().matches("[a-zA-Z0-9 ]+");
        boolean numeroCamasValido = numeroCamasValidoString.matches("[0-9]+");

        if (!nomeValido) {
            JOptionPane.showInternalMessageDialog(null, "Nome contem caracteres invalidos");
            return false;
        }

        if (!numeroCamasValido) {
            JOptionPane.showInternalMessageDialog(null, "Numero de camas contem caracteres invalidos");
            return false;
        }

        return true;
    }

    public List<Object[]> preencherTabelaQuarto() {
        List<Object[]> linha = tipoRepository.preencherTabelaQuarto();
        if (linha == null) {
            System.out.println("Erro ao retornar tabela, tabela esta nula");
            return null;

        } else {
            System.out.println("tabela retornada com sucesso");
            return linha;
        }
    }

    public void deletarQuartoService(int id) {
        Quarto quarto = tipoRepository.buscarPorIdQuarto(id);
        System.out.println("quarto " + quarto.getNome());
        if (confirmacaoPopUp(quarto.getNome())) {
            JOptionPane.showInternalMessageDialog(null, "Quarto deletado com sucesso");
            System.out.println("O quarto foi deletado.");
            tipoRepository.deletarQuartoPorId(id);
        } else {
            System.out.println("Operação cancelada.");
        }
    }

    public List<Object[]> pesquisaQuarto(String campo, String valor) {
        if (validarCampoPesquisaQuarto(valor)) {
            System.out.println("Dados validados com sucesso");
            return tipoRepository.preencherTabelaPesquisaQuarto(campo, valor);
        }
        System.out.println("erro ao preencher tabela");
        return null;
    }

    public void atulizarQuartoService(int id, Quarto quarto) {
        if (validaDadosQuarto(quarto)) {
            System.out.println("Dados validados com sucesso");
            System.out.println("id encontrato com sucesso");
            System.out.println("atualizando dados");
            tipoRepository.atualizarQuarto(id, quarto);
        }
    }

    public void salvarQuarto(Quarto quarto) {
        System.out.println("Cadastrando o tipo...");
        if (validaDadosQuarto(quarto)) {
            System.out.println("Dados validados com sucesso");
            if (quarto.getId() == null) {
                System.out.println("Inserindo os dados");
                tipoRepository.inserirQuarto(quarto);
                JOptionPane.showInternalMessageDialog(null, "Quarto cadastrado com sucesso");
            }
        }
    }

    //Pega numero da String
    public String pegaNumeroDaString(String nome) {
        Pattern padrao = Pattern.compile("\\d+");
        Matcher match = padrao.matcher(nome);
        String numero = "";
        if (match.find()) {
            numero = match.group();
            System.out.println("Número encontrado: " + numero);
            return numero;
        } else {
            System.out.println("Nenhum número encontrado na string.");
            return null;
        }
    }

    //Delet PopUp Confirmação
    public static boolean confirmacaoPopUp(String nome) {
        int opcao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar o quarto " + nome + " ?", "Confirmar Deleção", JOptionPane.YES_NO_OPTION);
        return opcao == JOptionPane.YES_OPTION;
    }

    //valida numero da string
    public boolean validaNumeroEmString(String nome) {
        String numero = pegaNumeroDaString(nome);
        if (numero == null || numero.isBlank() || numero.isEmpty()) {
            System.out.println("Nenhum número encontrado na string da validação.");
            return false;
        }
        return true;
    }

    // Criptografa senha
    public String criptografarSenha(String senha) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(senha.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Erro ao criptografar senha: " + e.getMessage());
            return null;
        }
    }
    
    //Lista de Paises
    public String[] listaPaises() {
        String[] paises = {
            "Afeganistão", "Albânia", "Argélia", "Andorra", "Angola", "Antígua e Barbuda", "Argentina", "Armênia", "Austrália", "Áustria",
            "Azerbaijão", "Bahamas", "Bahrein", "Bangladesh", "Barbados", "Belarus", "Bélgica", "Belize", "Benin", "Butão", "Bolívia",
            "Bósnia e Herzegovina", "Botswana", "Brasil", "Brunei", "Bulgária", "Burkina Faso", "Burundi", "Cabo Verde", "Camboja",
            "Camarões", "Canadá", "República Centro-Africana", "Chade", "Chile", "China", "Colômbia", "Comores", "Congo", "Costa Rica",
            "Croácia", "Cuba", "Chipre", "República Tcheca", "República Democrática do Congo", "Dinamarca", "Djibouti", "Dominica",
            "República Dominicana", "Timor-Leste", "Equador", "Egito", "El Salvador", "Guiné Equatorial", "Eritreia", "Estônia",
            "Eswatini", "Etiópia", "Fiji", "Finlândia", "França", "Gabão", "Gâmbia", "Geórgia", "Alemanha", "Gana", "Grécia",
            "Granada", "Guatemala", "Guiné", "Guiné-Bissau", "Guiana", "Haiti", "Honduras", "Hungria", "Islândia", "Índia", "Indonésia",
            "Irã", "Iraque", "Irlanda", "Israel", "Itália", "Costa do Marfim", "Jamaica", "Japão", "Jordânia", "Cazaquistão", "Quênia",
            "Kiribati", "Kuwait", "Quirguistão", "Laos", "Letônia", "Líbano", "Lesoto", "Libéria", "Líbia", "Liechtenstein", "Lituânia",
            "Luxemburgo", "Madagascar", "Malawi", "Malásia", "Maldivas", "Mali", "Malta", "Ilhas Marshall", "Mauritânia", "Maurício",
            "México", "Micronésia", "Moldávia", "Mônaco", "Mongólia", "Montenegro", "Marrocos", "Moçambique", "Myanmar", "Namíbia",
            "Nauru", "Nepal", "Países Baixos", "Nova Zelândia", "Nicarágua", "Níger", "Nigéria", "Coreia do Norte", "Macedônia do Norte",
            "Noruega", "Omã", "Paquistão", "Palau", "Palestina", "Panamá", "Papua Nova Guiné", "Paraguai", "Peru", "Filipinas", "Polônia",
            "Portugal", "Catar", "Romênia", "Rússia", "Ruanda", "São Cristóvão e Nevis", "Santa Lúcia", "Samoa", "San Marino",
            "São Tomé e Príncipe", "Arábia Saudita", "Senegal", "Sérvia", "Seychelles", "Serra Leoa", "Singapura", "Eslováquia", "Eslovênia",
            "Ilhas Salomão", "Somália", "África do Sul", "Coreia do Sul", "Sudão do Sul", "Espanha", "Sri Lanka", "Sudão", "Suriname",
            "Suécia", "Suíça", "Síria", "Tajiquistão", "Tanzânia", "Tailândia", "Togo", "Tonga", "Trinidad e Tobago", "Tunísia",
            "Turquia", "Turcomenistão", "Tuvalu", "Uganda", "Ucrânia", "Emirados Árabes Unidos", "Reino Unido", "Estados Unidos",
            "Uruguai", "Uzbequistão", "Vanuatu", "Cidade do Vaticano", "Venezuela", "Vietnã", "Iêmen", "Zâmbia", "Zimbábue", "Outro"
        };
        return paises;
    }
    
    private Date obtemDataHoje(JLabel lblDataCheckIn){
        LocalDateTime dataAtual = LocalDateTime.now();
        Date dataConvertida = Date.from(dataAtual.atZone(ZoneId.systemDefault()).toInstant());
        SimpleDateFormat formatoData = new SimpleDateFormat("ddMMyyyy", new Locale("pt", "BR"));
        String dataString = formatoData.format(dataConvertida);
        lblDataCheckIn.setText(dataString);
        return dataConvertida;
    }
    
    private  Date obtemDataNascimento(String dataNascimento){
        Date data = null;
        String dataString = dataNascimento;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        
        try {
            data = formato.parse(dataString);

        } catch (ParseException e) {
            System.out.println("Erro ao convrter string da data: " + e.getMessage());
        }
        return data;
    }
    
    private boolean validaIdade(String dataNascimento){
        LocalDate nascimento = LocalDate.parse(dataNascimento);
        LocalDate hoje = LocalDate.now();
        Period periodo = Period.between(nascimento, hoje);
        int idade = periodo.getYears();
        
        if (idade >= 18) {
            return true;
            
        }else{
            System.out.println("O Hospede não possui mais de 18 anos.");
            return false;
        }         
    }
    
   /* private void preencherComboBoxTipoQuarto(){
        cmbTipoQuarto.removeAllItems();
        String tp = "";
        
        try {
            List<Quarto> quartos = quartoDAO.buscarTipoQuarto();
            Set<String> tiposQuarto = new HashSet<>();
            
            for (Quarto quarto : quartos){
                if(!tp.equalsIgnoreCase(quarto.getTipoQuarto())){
                    cmbTipoQuarto.addItem(quarto.getTipoQuarto());
                    tp = quarto.getTipoQuarto();
                }
            }
            
        } catch (SQLException e){
            System.out.println("Erro ao preencher tabela");
        }
    }*/
}
