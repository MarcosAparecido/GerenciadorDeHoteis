/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GerenciadorDeHoteis.Utils;

import GerenciadorDeHoteis.Entity.Funcionario;
import GerenciadorDeHoteis.Entity.Hospede;
import GerenciadorDeHoteis.Entity.ProdutoEServico;
import GerenciadorDeHoteis.Entity.Quarto;
import GerenciadorDeHoteis.Entity.Reserva;
import GerenciadorDeHoteis.Entity.ReservaDespesa;
import GerenciadorDeHoteis.Repository.TipoRepository;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

/**
 *
 * @author Marcos
 */
public class ValidacaoUtil {

    private TipoRepository tipoRepository = new TipoRepository();
    private FormatoStringUtil numeroEmStringUtil = new FormatoStringUtil();
    private SenhaUtil senhaUtil = new SenhaUtil();
    private DatasUtil datasUtil = new DatasUtil();

    //Validação Funcionarios
    public boolean validaDadosFuncionario(Funcionario funcionario) {
        if (funcionario.getNome() == null) {
            JOptionPane.showInternalMessageDialog(null, "O campo NOME esta nulo.");
            return false;

        } else if (funcionario.getSobrenome() == null) {
            JOptionPane.showInternalMessageDialog(null, "O campo SOBRENOME esta nulo.");
            return false;

        } else if (funcionario.getSenha() == null) {
            JOptionPane.showInternalMessageDialog(null, "O campo SENHA esta nulo.");
            return false;

        } else if (funcionario.getTelefone() == null) {
            JOptionPane.showInternalMessageDialog(null, "O campo TELEFONE esta nulo.");
            return false;

        } else if (funcionario.getCpf() == null) {
            JOptionPane.showInternalMessageDialog(null, "O campo CPF esta nulo.");
            return false;

        } else if (funcionario.getNome().trim().isBlank()) {
            JOptionPane.showInternalMessageDialog(null, "O campo NOME esta em branco.");
            return false;

        } else if (funcionario.getSobrenome().trim().isBlank()) {
            JOptionPane.showInternalMessageDialog(null, "O campo SOBRENOME esta em branco.");
            return false;

        } else if (funcionario.getSenha().trim().isBlank()) {
            JOptionPane.showInternalMessageDialog(null, "O campo SENHA esta em branco.");
            return false;

        } else if (funcionario.getTelefone().trim().isBlank()) {
            JOptionPane.showInternalMessageDialog(null, "O campo TELEFONE esta em branco.");
            return false;

        } else if (funcionario.getCpf().trim().isBlank()) {
            JOptionPane.showInternalMessageDialog(null, "O campo CPF esta em branco.");
            return false;

        } else if (funcionario.getNome().length() > 50) {
            JOptionPane.showInternalMessageDialog(null, "O campo NOME não pode conter mais de 50 caracteres.");
            return false;

        } else if (funcionario.getSobrenome().length() > 50) {
            JOptionPane.showInternalMessageDialog(null, "O campo SOBRENOME não pode conter mais de 50 caracteres.");
            return false;

        } else if (funcionario.getTelefone().length() > 14) {
            JOptionPane.showInternalMessageDialog(null, "O campo TELEFONE não pode conter mais de 11 caracteres.");
            return false;

        } else if (funcionario.getCpf().length() > 14 || funcionario.getCpf().length() < 14) {
            JOptionPane.showInternalMessageDialog(null, "O campo CPF tem que conter 11 caracteres.");
            return false;
        }

        if (!validaFormatoCampoTextoFuncionario(funcionario)) {
            System.out.println("um dos campos de formato de texto está errado.");
            return false;

        }

        if (!validaDuplicidadeDadosFuncionario(funcionario)) {
            System.out.println("Já existe um funcionário com o mesmo CPF!");
            JOptionPane.showInternalMessageDialog(null, "Já existe um funcionário com o mesmo CPF.");
            return false;

        }
        return true;
    }

    public boolean validaTamanhoSenhaFuncionario(JPasswordField txtSenha) {
        if (txtSenha.getText().length() > 50) {
            JOptionPane.showInternalMessageDialog(null, "O campo SENHA não pode conter mais de 50 caracteres.");
            return false;
        }
        return true;
    }

    private boolean validaFormatoCampoTextoFuncionario(Funcionario funcionario) {
        boolean nomeValido = funcionario.getNome().matches("[\\p{L}0-9\\p{Punct} ]+");
        boolean sobreNomeValido = funcionario.getSobrenome().matches("\\p{L}+");
        boolean cpfValido = funcionario.getCpf().trim().matches("^(?!\\d+$)(?!\\d+-\\d+$)\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$");
        boolean telefoneValido = funcionario.getTelefone().matches("\\(\\d{2}\\)\\d{4,5}-\\d{4}");

        if (!nomeValido) {
            JOptionPane.showInternalMessageDialog(null, "o campo NOME contem caracteres invalidos.");
            return false;
        }

        if (!sobreNomeValido) {
            JOptionPane.showInternalMessageDialog(null, "o campo SOBRENOME contem caracteres invalidos.");
            return false;
        }

        if (!cpfValido) {
            JOptionPane.showInternalMessageDialog(null, "o campo CPF contem caracteres invalidos.");
            return false;
        }

        if (!telefoneValido) {
            JOptionPane.showInternalMessageDialog(null, "o campo TELEFONE contem caracteres invalidos.");
            return false;
        }
        return true;
    }

    private boolean validaDuplicidadeDadosFuncionario(Funcionario funcionario) {
        Funcionario funcionarioExistente = tipoRepository.buscarPorCPFFuncionario(funcionario.getCpf());
        if (funcionarioExistente != null) {
            JOptionPane.showInternalMessageDialog(null, "Já existe um funcionário com o mesmo CPF.");
            return false;
        }
        return true;
    }

    public boolean validarLogin(String cpf, String senha) {
        Funcionario funcionario = tipoRepository.buscarIformacaoLogin(cpf, senha);
        if (funcionario.getSenha().equals(senhaUtil.criptografarSenha(senha))) {
            System.out.println("Funcionario autenticado com sucesso.");
            return true;
        } else {
            System.out.println("Falha ao autenticar ao autenticar funcionario.");
            return false;
        }
    }

    public boolean validaConfirmacaoSenha(String senha, String confirmacao, JPasswordField txtConfirmacao) {
        if (!confirmacao.equals(senha)) {
            System.out.println("As senhas não coincidem");
            txtConfirmacao.setText("");
            return false;
        }
        return true;
    }

    //Validação Login
    public boolean validacaoDadosLogin(JPasswordField txtSenha, JFormattedTextField txtCpf) {
        if (txtCpf.getText().trim().isEmpty()) {
            JOptionPane.showInternalMessageDialog(null, "O campo CPF esta nulo.");
            return false;

        } else if (txtSenha.getText().trim().isEmpty()) {
            JOptionPane.showInternalMessageDialog(null, "O campo SENHA esta nulo.");
            return false;

        } else if (txtSenha.getText().trim().isEmpty()) {
            JOptionPane.showInternalMessageDialog(null, "O campo CPF esta em branco.");
            return false;

        } else if (txtSenha.getText().trim().isEmpty()) {
            JOptionPane.showInternalMessageDialog(null, "O campo SENHA esta em branco.");
            return false;

        } else if (txtCpf.getText().length() > 14 || txtCpf.getText().length() < 14) {
            JOptionPane.showInternalMessageDialog(null, "O campo CPF tem que conter 11 caracteres.");
            return false;

        } else if (txtSenha.getText().length() > 50) {
            JOptionPane.showInternalMessageDialog(null, "O campo SENHA não pode conter  mias de 50 caracteres.");
            return false;
        }

        if (!validaFormatoCampoTextoLogin(txtCpf)) {
            System.out.print("Login possui um campo de texto invalido.");
            return false;
        }
        return true;
    }

    private boolean validaFormatoCampoTextoLogin(JFormattedTextField txtCpf) {
        boolean cpfValido = txtCpf.getText().trim().matches("^(?!\\d+$)(?!\\d+-\\d+$)\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$");
        if (!cpfValido) {
            JOptionPane.showInternalMessageDialog(null, "o campo CPF contem caracteres invalidos.");
            return false;
        }
        return true;
    }

    //Validação Quartos
    public boolean validaDadosQuarto(Quarto quarto) {
        if (quarto.getNome().trim().isEmpty()) {
            JOptionPane.showInternalMessageDialog(null, "O campo NOME DO QUARTO está nulo.");
            return false;

        } else if (String.valueOf(quarto.getNumeroCamas()).trim().isEmpty()) {
            JOptionPane.showInternalMessageDialog(null, "O campo Nº DE CAMAS está nulo.");
            return false;

        } else if (quarto.getNome().trim().isBlank()) {
            JOptionPane.showInternalMessageDialog(null, "O campo NOME DO QUARTO está em branco.");
            return false;

        } else if (String.valueOf(quarto.getNumeroCamas()).trim().isBlank()) {
            JOptionPane.showInternalMessageDialog(null, "O campo Nº DE CAMAS está em barnco.");
            return false;

        } else if (quarto.getNome().length() > 50) {
            JOptionPane.showInternalMessageDialog(null, "O campo NOME DO QUARTO não pode conter mais de 50 caracteres.");
            return false;

        } else if (quarto.getNumeroCamas() > 10 || quarto.getNumeroCamas() < 1) {
            JOptionPane.showInternalMessageDialog(null, "O campo Nº DE CAMAS não pode ser menor que 1 maior que 10.");
            return false;
        }

        if (!validaFormatoCampoTextoQuarto(quarto)) {
            System.out.println("um dos campos de formato de texto esta errado.");
            return false;
        }

        if (!numeroEmStringUtil.validaNumeroEmString(quarto.getNome())) {
            JOptionPane.showInternalMessageDialog(null, "Nenhum numero encontrado, o QUARTO precisa ter um numero.");
            return false;
        }
        return true;
    }

    public boolean validarCampoPesquisaQuarto(String valor) {
        if (valor == null) {
            JOptionPane.showInternalMessageDialog(null, "O campo VALOR DA PESQUISA esta nulo.");
            return false;

        } else if (valor.trim().isBlank()) {
            JOptionPane.showInternalMessageDialog(null, "O campo VALOR DA PESQUISA esta em branco.");
            return false;

        } else if (valor.length() > 50) {
            JOptionPane.showInternalMessageDialog(null, "O campo VALOR DA PESQUISA não deve possuir mais de 50 characteres.");
            return false;
        }
        return true;
    }

    public boolean validaDuplicidadeDadosQuarto(Quarto quarto) {
        Quarto quartoExistente = tipoRepository.buscarPorNomeQuarto(quarto.getNome());
        if (quartoExistente != null) {
            if (quartoExistente.getNome().equalsIgnoreCase(quarto.getNome())) {
                JOptionPane.showInternalMessageDialog(null, "Já existe um QUARTO com o mesmo nome.");
                return false;
            }
            JOptionPane.showInternalMessageDialog(null, "Já existe um QUARTO com o mesmo nome.");
            return false;
        }
        return true;
    }

    public boolean validaDuplicidadeDadosQuartoAtualizar(int id, Quarto quarto) {
        Quarto quartoExistente = tipoRepository.buscarPorNomeQuarto(quarto.getNome());
        if (quartoExistente == null) {
            return true;
        }
        if (quartoExistente.getNome().equals(quarto.getNome())) {
            if (id == quartoExistente.getId()) {
                return true;
            }
            JOptionPane.showInternalMessageDialog(null, "Já existe um QUARTO com o mesmo nome.");
            return false;
        }
        return true;
    }

    private boolean validaFormatoCampoTextoQuarto(Quarto quarto) {
        String numeroCamasValidoString = String.valueOf(quarto.getNumeroCamas());
        boolean nomeValido = quarto.getNome().matches("[a-zA-Z0-9 ]+");
        boolean numeroCamasValido = numeroCamasValidoString.matches("[0-9]+");

        if (!nomeValido) {
            JOptionPane.showInternalMessageDialog(null, "o campo NOME DO QUARTO contem caracteres invalidos.");
            return false;
        }

        if (!numeroCamasValido) {
            JOptionPane.showInternalMessageDialog(null, "o campo Nº DE CAMAS contem caracteres invalidos.");
            return false;
        }

        return true;
    }

    //Validação Produto e Serviço
    public boolean validaDadosProduto(ProdutoEServico produtoEServico) {
        if (produtoEServico.getNome().trim().isEmpty()) {
            JOptionPane.showInternalMessageDialog(null, "O campo NOME DO PRODUTO/ SERVIÇO esta vazio.");
            return false;

        } else if (String.valueOf(produtoEServico.getValor()).trim().isEmpty()) {
            JOptionPane.showInternalMessageDialog(null, "O campo VALOR PRODUTO esta vazio.");
            return false;

        } else if (String.valueOf(produtoEServico.getEstoque()).trim().isEmpty()) {
            JOptionPane.showInternalMessageDialog(null, "O campo QUANTIDADE PRODUTO esta vazio.");
            return false;

        } else if (produtoEServico.getNome().trim().isBlank() || String.valueOf(produtoEServico.getValor()).trim().isBlank() || String.valueOf(produtoEServico.getValor()).trim().isBlank()) {
            JOptionPane.showInternalMessageDialog(null, "O campo NOME DO PRODUTO/ SERVIÇO esta em branco.");
            return false;

        } else if (String.valueOf(produtoEServico.getValor()).trim().isBlank()) {
            JOptionPane.showInternalMessageDialog(null, "O campo VALOR PRODUTO esta em branco.");
            return false;

        } else if (String.valueOf(produtoEServico.getEstoque()).trim().isBlank()) {
            JOptionPane.showInternalMessageDialog(null, "O campo QUANTIDADE PRODUTO esta em branco.");
            return false;

        } else if (produtoEServico.getNome().length() > 50) {
            JOptionPane.showInternalMessageDialog(null, "O campo NOME DO PRODUTO/ SERVIÇO não pode conter mais de 50 caracteres.");
            return false;

        } else if (produtoEServico.getEstoque() < 0 || produtoEServico.getEstoque() > 100000) {
            JOptionPane.showInternalMessageDialog(null, "A quantidade em QUANTIDADE PRODUTO não pode ser menor que 0 e maior que 100,000.");
            return false;

        } else if (produtoEServico.getValor() < 0 || produtoEServico.getValor() > 1000000) {
            JOptionPane.showInternalMessageDialog(null, "A quantidade em VALOR PRODUTO não pode não pode ser menor que 0 e maior que 1,000,000.");
            return false;
        }

        if (!validaFormatoCampoTextoProduto(produtoEServico)) {
            System.out.println("um dos campos de formato de texto esta errado.");
            return false;
        }
        return true;
    }

    public boolean validaDuplicidadeDadosProduto(ProdutoEServico produtoEServico) {
        ProdutoEServico produtoExistente = tipoRepository.buscarPorNomeProduto(produtoEServico.getNome());
        if (produtoExistente != null) {
            JOptionPane.showInternalMessageDialog(null, "Ja existe um PRODUTO com o mesmo nome.");
            return false;
        }
        return true;
    }

    public boolean validaDuplicidadeDadosProdutoAtualizar(int id, ProdutoEServico produto) {
        ProdutoEServico produtoExistente = tipoRepository.buscarPorNomeProduto(produto.getNome());
        if (produtoExistente == null) {
            return true;
        }
        if (produtoExistente.getNome().equals(produto.getNome())) {
            if (id == produtoExistente.getId()) {
                return true;
            }
            JOptionPane.showInternalMessageDialog(null, "Ja existe um PRODUTO com o mesmo nome.");
            return false;
        }
        return true;
    }

    private boolean validaFormatoCampoTextoProduto(ProdutoEServico produtoEServico) {
        boolean nomeValido = produtoEServico.getNome().matches("[\\p{L}0-9\\p{Punct} ]+");
        boolean estoqueValido = String.valueOf(produtoEServico.getEstoque()).matches("[0-9]+");
        boolean valorValido = String.valueOf(produtoEServico.getValor()).matches("[0-9\\p{Punct}]+");

        if (!nomeValido) {
            JOptionPane.showInternalMessageDialog(null, "O campo NOME DO PRODUTO/ SERVIÇO contem caracteres invalidos.");
            return false;
        }

        if (!estoqueValido) {
            JOptionPane.showInternalMessageDialog(null, "O campo QUANTIDADE PRODUTO contem caracteres invalidos.");
            return false;
        }

        if (!valorValido) {
            JOptionPane.showInternalMessageDialog(null, "O campo VALOR PRODUTO contem caracteres invalidos.");
            return false;
        }
        return true;
    }

    public boolean validarCampoPesquisaProduto(String valor) {
        if (valor == null) {
            JOptionPane.showInternalMessageDialog(null, "o campo VALOR DA PESQUISA esta nulo.");
            return false;

        } else if (valor.trim().isBlank()) {
            JOptionPane.showInternalMessageDialog(null, "o campo VALOR DA PESQUISA esta em branco.");
            return false;

        } else if (valor.length() > 50) {
            JOptionPane.showInternalMessageDialog(null, "O campo VALOR DA PESQUISA não deve possuir mais de 50 characteres.");
            return false;
        }
        return true;
    }

    //Validação Hospede
    public boolean validaDadosHospede(Hospede hospede) {
        if (hospede.getNome().trim().isEmpty()) {
            JOptionPane.showInternalMessageDialog(null, "O campo NOME DO QUARTO está nulo.");
            return false;

        } else if (hospede.getDataNascimento() == null) {
            JOptionPane.showInternalMessageDialog(null, "O campo DATA DE NASCIMENTO esta nulo");
            return false;
        }
        if (!validarPassaporteCpf(hospede)) {
            System.out.println("Erro na verificação cpf/passaporte");
            return false;
        }
        if (!validarTelefoneEmail(hospede)) {
            System.out.println("Erro na verificação email/telefone");
            return false;
        }
        if (!validaFormatoCampoTextoHospede(hospede)) {
            System.out.println("Erro de formato");
            return false;
        }
        if (!datasUtil.validaIdade(datasUtil.converterDataParaString((hospede.getDataNascimento()), "dd/MM/yyyy"))) {
            JOptionPane.showInternalMessageDialog(null, "O Hospede não possui mais de 18 anos.");
            return false;
        }
        if (!validaDuplicidadeDadosHospede(hospede.getCpf(), hospede.getPassaporte())) {
            System.out.println("Erro duplicidade.");
            return false;
        }
        return true;
    }

    public boolean validaDuplicidadeDadosHospede(String cpf, String passaporte) {
        Hospede hospede = tipoRepository.buscarPorCpfEPassaporte(cpf, passaporte);
        if (hospede != null) {
            JOptionPane.showInternalMessageDialog(null, "Ja existe um Hospede com esse CPF ou PASSAPORTE.");
            return false;
        }
        return true;
    }

    private boolean validarPassaporteCpf(Hospede hospede) {
        boolean cpfValido = hospede.getCpf().trim().matches("^(?!\\d+$)(?!\\d+-\\d+$)\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$");
        boolean passaporteValido = hospede.getPassaporte().trim().matches("[A-Z0-9]+");

        if (hospede.getPassaporte().trim().isEmpty() && hospede.getCpf().trim().isEmpty()) {
            JOptionPane.showInternalMessageDialog(null, "O campo CPF e PASSAPORTE não podem ser nulos ao mesmo tempo");
            return false;

        } else if (hospede.getEmail().trim().isBlank() && hospede.getCpf().trim().isBlank()) {
            JOptionPane.showInternalMessageDialog(null, "O campo CPF e PASSAPORTE não podem estar em branco ao mesmo tempo");
            return false;

        } else if (!hospede.getCpf().trim().isEmpty()) {
            if (cpfValido) {
                if (hospede.getCpf().length() > 14 || hospede.getCpf().length() < 14) {
                    JOptionPane.showInternalMessageDialog(null, "O campo CPF deve possuir 11 caracteres.");
                    return false;

                } else {
                    return true;
                }

            } else {
                JOptionPane.showInternalMessageDialog(null, "O campo CPF possui caracteres invalidos.");
                return false;
            }

        } else if (!hospede.getPassaporte().trim().isEmpty()) {
            if (passaporteValido) {
                if (hospede.getPassaporte().length() > 8 || hospede.getPassaporte().length() < 8) {
                    JOptionPane.showInternalMessageDialog(null, "O campo PASSAPORTE deve possuir 8 caracteres.");
                    return false;

                } else {
                    return true;
                }
            } else {
                JOptionPane.showInternalMessageDialog(null, "O campo PASSAPORTE possui caracteres invalidos.");
                return false;
            }

        } else {
            System.out.println("Deu erro na verificacão de cpf");
            return false;
        }
    }

    private boolean validarTelefoneEmail(Hospede hospede) {
        boolean telefoneValido = hospede.getCpf().trim().matches("^(?!\\d+$)(?!\\d+-\\d+$)\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$");
        boolean emailValido = hospede.getEmail().trim().matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$");

        if (hospede.getTelefone().trim().isEmpty() && hospede.getEmail().trim().isEmpty()) {
            JOptionPane.showInternalMessageDialog(null, "O campo TELEFONE e EMAIL não podem ser nulos ao mesmo tempo");
            return false;

        } else if (hospede.getEmail().trim().isBlank() && hospede.getTelefone().trim().isBlank()) {
            JOptionPane.showInternalMessageDialog(null, "O campo TELEFONE e EMAIL não podem estar em branco ao mesmo tempo");
            return false;

        } else if (!hospede.getEmail().trim().isEmpty()) {
            if (emailValido) {
                if (hospede.getEmail().length() > 100) {
                    JOptionPane.showInternalMessageDialog(null, "O campo EMAIL não deve possuir mais de 100 caracteres.");
                    return false;

                } else {
                    return true;
                }
            } else {
                JOptionPane.showInternalMessageDialog(null, "O campo EMAIL possui caracteres invalidos.");
                return false;
            }

        } else if (!hospede.getTelefone().trim().isEmpty()) {
            if (telefoneValido) {
                if (hospede.getTelefone().length() > 14) {
                    JOptionPane.showInternalMessageDialog(null, "O campo TELEFONE não deve possuir mais de 12 caracteres.");
                    return false;

                } else {
                    return true;
                }

            } else {
                JOptionPane.showInternalMessageDialog(null, "O campo TELEFONE possui caracteres invalidos.");
                return false;
            }

        } else {
            System.out.println("Deu erro na verificacão de cpf");
            return false;
        }
    }

    private boolean validaFormatoCampoTextoHospede(Hospede hospede) {
        boolean nomeValido = hospede.getNome().matches("[\\p{L}0-9\\p{Punct} ]+");
        boolean dataNascimentoValido = datasUtil.converterDataParaString((hospede.getDataNascimento()), "dd/MM/yyyy").matches("\\d{2}/\\d{2}/\\d{4}");

        if (!nomeValido) {
            JOptionPane.showInternalMessageDialog(null, "o campo NOME contem caracteres invalidos.");
            return false;
        }

        if (!dataNascimentoValido) {
            JOptionPane.showInternalMessageDialog(null, "o campo DATA DE NASCIMENTO contem caracteres invalidos.");
            return false;
        }

        return true;
    }

    //Validação Reserva
    /*public boolean validaDadosReserva(Reserva reserva) {
        if (reserva.getHospede_id() == null) {
            JOptionPane.showInternalMessageDialog(null, "O Id de funcionario esta nulo.");
            return false;

        } else if (reserva.getFuncionario_id() == null) {
            JOptionPane.showInternalMessageDialog(null, "O Id de hospede esta nulo.");
            return false;

        } else if (reserva.getQuarto_id() == null) {
            JOptionPane.showInternalMessageDialog(null, "O Id de quarto esta nulo.");
            return false;

        } else if (String.valueOf(reserva.getNumeroHospedes()) == null) {
            JOptionPane.showInternalMessageDialog(null, "O campo QUANTIDADE DE HOSPEDE esta nulo.");
            return false;

        } else if (reserva.getNome() == null) {
            JOptionPane.showInternalMessageDialog(null, "O campo NOME esta nulo.");
            return false;

        } else if (String.valueOf(reserva.getNumeroHospedes()).isEmpty()) {
            JOptionPane.showInternalMessageDialog(null, "O campo QUANTIDADE HOSPEDE esta nulo.");
            return false;

        } else if (String.valueOf(reserva.getNumeroHospedes()).isBlank()) {
            JOptionPane.showInternalMessageDialog(null, "O campo QUANTIDADE HOSPEDE esta em branco.");
            return false;

        } else if (reserva.getNumeroHospedes() < 1 || reserva.getNumeroHospedes() > 6) {
            JOptionPane.showInternalMessageDialog(null, "O NUMERO DE QUARTO deve estar entre 1 e 6 por quarto.");
            return false;

        }
        if (!validaFormatoCampoTextoReserva(reserva)) {
            System.out.println("um dos campos de formato de texto está errado.");
            return false;

        }
        return true;
    }*/

    private boolean validaFormatoCampoTextoReserva(Reserva reserva) {
        boolean nomeValido = reserva.getNome().matches("[\\p{L}0-9\\p{Punct} ]+");
        boolean numeroHospedesValido = String.valueOf(reserva.getNumeroHospedes()).matches("[0-9]+");

        if (!nomeValido) {
            JOptionPane.showInternalMessageDialog(null, "o campo NOME contem caracteres invalidos.");
            return false;
        }

        if (!numeroHospedesValido) {
            JOptionPane.showInternalMessageDialog(null, "o campo QUANTIDADE DE HOSPEDES contem caracteres invalidos.");
            return false;
        }
        return true;
    }

   // Valida DespesaReserva
//    public boolean validaDadosReservaDespesa(ReservaDespesa reservaDespesa, Reserva reserva) {
//        if (reservaDespesa.getReserva().getId() == null) {
//            JOptionPane.showInternalMessageDialog(null, "O Id de reserva esta nulo.");
//            return false;
//
//        } else if (reservaDespesa.getProdutoEServico().getId() == null) {
//            JOptionPane.showInternalMessageDialog(null, "O Id de depesa esta nulo.");
//            return false;
//
//        } else if (reservaDespesa.getProduto().isEmpty()) {
//            JOptionPane.showInternalMessageDialog(null, "O campo de PRODUTO esta nulo.");
//            return false;
//
//        } else if (String.valueOf(reservaDespesa.getQuantidade()).trim().isEmpty()) {
//            JOptionPane.showInternalMessageDialog(null, "O campo QUANTIDADE esta nulo.");
//            return false;
//
//        } else if (String.valueOf(reservaDespesa.getNome()).trim().isEmpty()) {
//            JOptionPane.showInternalMessageDialog(null, "O campo HOSPEDE esta nulo.");
//            return false;
//
//        } else if (String.valueOf(reservaDespesa.getValor()).trim().isEmpty()) {
//            JOptionPane.showInternalMessageDialog(null, "O campo VALOR esta nulo.");
//            return false;
//
//        } else if (String.valueOf(reservaDespesa.getReserva().getId()).trim().isBlank()) {
//            JOptionPane.showInternalMessageDialog(null, "O campo Id de despesa esta em branco.");
//            return false;
//
//        } else if (String.valueOf(reservaDespesa.getProdutoEServico().getId()).trim().isBlank()) {
//            JOptionPane.showInternalMessageDialog(null, "O Id de reserva esta em branco.");;
//            return false;
//
//        } else if (reservaDespesa.getProduto().trim().isBlank()) {
//            JOptionPane.showInternalMessageDialog(null, "O campo PRODUTO esta em branco.");
//            return false;
//
//        } else if (String.valueOf(reservaDespesa.getQuantidade()).trim().isBlank()) {
//            JOptionPane.showInternalMessageDialog(null, "O campo QUANTIDADE esta em branco.");
//            return false;
//
//        } else if (String.valueOf(reservaDespesa.getValor()).trim().isBlank()) {
//            JOptionPane.showInternalMessageDialog(null, "O campo DESPESA esta em branco.");
//            return false;
//
//        } else if (reservaDespesa.getProduto().length() > 50) {
//            JOptionPane.showInternalMessageDialog(null, "O campo PRODUTO não pode conter mais de 50 caracteres.");
//            return false;
//
//        } else if (reservaDespesa.getQuantidade() < 1 && !reserva.isAcompanhante()) {
//            JOptionPane.showInternalMessageDialog(null, "A quantidade não pode ser menor que 1.");
//            return false;
//
//        } else if (reservaDespesa.getValor() < 0 && !reserva.isAcompanhante()) {
//            JOptionPane.showInternalMessageDialog(null, "O VALOR não pode ser menor que 0.");
//            return false;
//
//        }
//        if (!validaFormatoCampoTextoReservaDespesa(reservaDespesa)) {
//            System.out.println("um dos campos de formato de texto está errado.");
//            return false;
//
//        }
//        return true;
//    }

    private boolean validaFormatoCampoTextoReservaDespesa(ReservaDespesa reservaDespesa) {
        boolean produtoValido = reservaDespesa.getProduto().matches("[\\p{L}0-9\\p{Punct} ]+");
        boolean quantidadeNomeValido = String.valueOf(reservaDespesa.getQuantidade()).matches("[0-9]+");
        boolean valorValido = String.valueOf(reservaDespesa.getValor()).matches("\\d+(\\.\\d{1,2})?");

        if (!produtoValido) {
            JOptionPane.showInternalMessageDialog(null, "o campo PRODUTO contem caracteres invalidos.");
            return false;
        }

        if (!quantidadeNomeValido) {
            JOptionPane.showInternalMessageDialog(null, "o campo QUANTIDADE contem caracteres invalidos.");
            return false;
        }

        if (!valorValido) {
            JOptionPane.showInternalMessageDialog(null, "o campo DESPESA contem caracteres invalidos.");
            return false;
        }

        return true;
    }
}
