/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GerenciadorDeHoteis.Service;

import GerenciadorDeHoteis.Entity.Funcionario;
import GerenciadorDeHoteis.Entity.Hospede;
import GerenciadorDeHoteis.Entity.Quarto;
import GerenciadorDeHoteis.Repository.TipoRepository;
import GerenciadorDeHoteis.Entity.ProdutoEServico;
import GerenciadorDeHoteis.Entity.Reserva;
import GerenciadorDeHoteis.Entity.ReservaDespesa;
import GerenciadorDeHoteis.Entity.ReservaHospede;
import GerenciadorDeHoteis.Utils.DatasUtil;
import GerenciadorDeHoteis.Utils.PaisesUtil;
import GerenciadorDeHoteis.Utils.PopUpUtil;
import GerenciadorDeHoteis.Utils.ValidacaoUtil;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marcos
 */
public class TipoService {

    private TipoRepository tipoRepository;
    private PopUpUtil deletePopUpUtil = new PopUpUtil();
    private ValidacaoUtil validacaoUtil = new ValidacaoUtil();
    private PaisesUtil paisesUtil = new PaisesUtil();

    public TipoService() {
        this.tipoRepository = new TipoRepository();
    }

    //Service Funcionario
    public void salvarFuncionario(Funcionario funcionario) {
        System.out.println("Cadastrando o tipo...");
        if (validacaoUtil.validaDadosFuncionario(funcionario)) {
            System.out.println("Dados validados com sucesso");
            if (funcionario.getId() == null) {
                System.out.println("Inserindo os dados");
                JOptionPane.showInternalMessageDialog(null, "Funcionário cadastrado com sucesso!");
                tipoRepository.inserirFuncionario(funcionario);
            }
        }
    }

    public int buscarIdFuncionario(String cpfFuncionario) {
        List<Funcionario> funcionario = tipoRepository.listarTodosFuncionarios();
        if (funcionario != null) {
            for (Funcionario funcionarios : funcionario) {
                if (cpfFuncionario.equals(funcionarios.getCpf())) {
                    return funcionarios.getId();
                }
            }
        } else {
            System.out.println("ID de funcionario não existente.");
            return -1;
        }
        return -1;
    }

    public Funcionario buscarFuncionarioPorId(String cpf) {
        List<Funcionario> funcionario = tipoRepository.listarTodosFuncionarios();
        if (funcionario != null) {
            for (Funcionario funcionarios : funcionario) {
                if (cpf.equals(funcionarios.getCpf())) {
                    return funcionarios;
                }
            }
        } else {
            System.out.println("ID de funcionario não existente.");
            return null;
        }
        return null;
    }

    //Service Quartos
    public void deletarQuartoService(int id) {
        Quarto quarto = tipoRepository.buscarPorIdQuarto(id);
        System.out.println("quarto " + quarto.getNome());
        if (deletePopUpUtil.confirmacaoPopUp(quarto.getNome())) {
            JOptionPane.showInternalMessageDialog(null, "Quarto deletado com sucesso");
            System.out.println("O quarto foi deletado.");
            tipoRepository.deletarQuartoPorId(id);
        } else {
            System.out.println("Operação cancelada.");
        }
    }

    public void preencherTabelaQuarto(JTable tbQuartos) {
        DefaultTableModel tabela = (DefaultTableModel) tbQuartos.getModel();
        tabela.setRowCount(0);
        List<Quarto> quartos = tipoRepository.listarTodosQuartos();
        List<Object[]> objeto = new ArrayList<>();
        for (Quarto quarto : quartos) {
            Object[] linha = {quarto.getId(), quarto.getNome(), quarto.getTipoQuarto(), quarto.getNumeroCamas()};
            objeto.add(linha);
        }
        if (tabela == null) {
            System.out.println("Erro ao retornar tabela, tabela esta nula");

        } else {
            for (Object[] linha : objeto) {
                tabela.addRow(linha);
            }
            System.out.println("tabela retornada com sucesso");
        }
    }

    public Quarto retornaIdQuarto(int id) {
        Quarto quarto = tipoRepository.buscarPorIdQuarto(id);
        return quarto;
    }

    public void pesquisaQuarto(String campo, String valor, JTable tbQuartos) {
        DefaultTableModel tabela = (DefaultTableModel) tbQuartos.getModel();
        tabela.setRowCount(0);
        List<Quarto> quartos = tipoRepository.pesquisaCampoQuarto(campo, valor);
        List<Object[]> objeto = new ArrayList<>();
        for (Quarto quarto : quartos) {
            Object[] linha = {quarto.getId(), quarto.getNome(), quarto.getTipoQuarto(), quarto.getNumeroCamas()};
            objeto.add(linha);
        }
        if (validacaoUtil.validarCampoPesquisaQuarto(valor)) {
            System.out.println("Dados validados com sucesso");
            for (Object[] linha : objeto) {
                tabela.addRow(linha);
            }
        } else {
            System.out.println("erro ao preencher tabela");
        }
    }

    public void salvarQuarto(int id, Quarto quarto) {
        if (validacaoUtil.validaDadosQuarto(quarto) && validacaoUtil.validaDuplicidadeDadosQuarto(quarto) && id == -1) {
            if (quarto.getId() == null) {
                System.out.println("Inserindo os dados");
                tipoRepository.inserirQuarto(quarto);
                JOptionPane.showInternalMessageDialog(null, "Quarto cadastrado com sucesso");
            }

        } else if (validacaoUtil.validaDadosQuarto(quarto) && validacaoUtil.validaDuplicidadeDadosQuartoAtualizar(id, quarto)) {
            System.out.println("Dados validados com sucesso");
            System.out.println("id encontrato com sucesso");
            System.out.println("atualizando dados");
            tipoRepository.atualizarQuarto(id, quarto);
            JOptionPane.showInternalMessageDialog(null, "Quarto atualizado com sucesso");
        }
    }

    public int buscarIdQuarto(String numeroQuarto) {
        List<Quarto> quarto = tipoRepository.listarTodosQuartos();
        if (quarto != null) {
            for (Quarto quartos : quarto) {
                if (numeroQuarto != null && numeroQuarto.equals(quartos.getNome())) {
                    return quartos.getId();
                }
            }
        } else {
            System.out.println("Numero de quarto não existente.");
            return -1;
        }
        return -1;
    }

    public void mudarStatusQuarto(String numeroQuarto, boolean status) {
        Quarto quarto = tipoRepository.buscarPorNomeQuarto(numeroQuarto);
        if (quarto != null) {
            tipoRepository.atualizarStatusQuarto(quarto.getId(), status);

        } else {
            System.out.println("Numero de quarto não existente.");

        }
    }

    //Service Produto e Serviço
    public int buscarIdProduto(String nomeProduto) {
        ProdutoEServico produto = tipoRepository.buscarPorNomeProduto(nomeProduto);
        if (produto != null) {
            return produto.getId();

        } else if (produto == null) {
            System.out.println("produto nulo, retorna -1");
            return -1;
        }
        System.out.println("produto nulo, retorna -1");
        return -1;
    }

    public int buscarQuantidadeProduto(String nomeProduto) {
        List<ProdutoEServico> produto = tipoRepository.listarTodosProdutos();
        for (ProdutoEServico produtos : produto) {
            if (produtos.getNome().equals(nomeProduto)) {
                return produtos.getEstoque();
            }
        }
        return -1;
    }

    public double buscarValorProduto(String nomeProduto) {
        ProdutoEServico produto = tipoRepository.buscarPorNomeProduto(nomeProduto);
        if (produto != null) {
            return produto.getValor();

        } else if (produto == null) {
            System.out.println("produto nulo, retorna -1");
            return -1;
        }
        System.out.println("produto nulo, retorna -1");
        return -1;
    }

    public void preencherTabelaProduto(JTable tbProdutos) {
        DefaultTableModel tabela = (DefaultTableModel) tbProdutos.getModel();
        tabela.setRowCount(0);
        List<ProdutoEServico> produtosEServico = tipoRepository.listarTodosProdutos();
        List<Object[]> objeto = new ArrayList<>();
        for (ProdutoEServico produtos : produtosEServico) {
            Object[] linha = {produtos.getId(), produtos.getNome(), produtos.getEstoque(), produtos.getValor()};
            objeto.add(linha);
        }
        if (objeto == null) {
            System.out.println("Erro ao retornar tabela, tabela esta nula");
        } else {
            System.out.println("tabela retornada com sucesso");
            for (Object[] linha : objeto) {
                tabela.addRow(linha);
            }
        }
    }

    public void preencherTabelaProdutoConta(JTable tbProdutos) {
        DefaultTableModel tabela = (DefaultTableModel) tbProdutos.getModel();
        tabela.setRowCount(0);
        List<ProdutoEServico> produtosEServico = tipoRepository.listarTodosProdutos();
        List<Object[]> objeto = new ArrayList<>();
        for (ProdutoEServico produtos : produtosEServico) {
            if (produtos.getId() > 6 && produtos.getEstoque() >= 0) {
                Object[] linha = {produtos.getId(), produtos.getNome(), produtos.getValor()};
                objeto.add(linha);
            }
        }
        if (objeto == null) {
            System.out.println("Erro ao retornar tabela, tabela esta nula");
        } else {
            System.out.println("tabela retornada com sucesso");
            for (Object[] linha : objeto) {
                tabela.addRow(linha);
            }
        }
    }

    public void pesquisaProduto(String campo, String valor, JTable tbProdutos) {
        DefaultTableModel tabela = (DefaultTableModel) tbProdutos.getModel();
        tabela.setRowCount(0);
        List<ProdutoEServico> produtos = tipoRepository.pesquisaCampoProduto(campo, valor);
        List<Object[]> objeto = new ArrayList<>();

        for (ProdutoEServico produto : produtos) {
            Object[] linha = {produto.getId(), produto.getNome(), produto.getEstoque(), produto.getValor()};
            objeto.add(linha);
        }
        if (validacaoUtil.validarCampoPesquisaProduto(valor)) {
            System.out.println("Dados validados com sucesso");
            for (Object[] linha : objeto) {
                tabela.addRow(linha);
            }
        } else {
            System.out.println("erro ao preencher tabela");
        }
    }

    public ProdutoEServico retornaIdProdutoEServico(int id) {
        ProdutoEServico produto = tipoRepository.buscarPorIdProduto(id);
        return produto;
    }

    public void atualizarQuantidadeEstoque(int id, int novaQuantidade) {
        ProdutoEServico produto = tipoRepository.buscarPorIdProduto(id);

        if (produto != null) {
            produto.setEstoque(novaQuantidade);
            tipoRepository.atualizarProduto(id, produto);
            System.out.println("Quantidade em estoque atualizada com sucesso para o produto: " + produto.getNome());
        } else {
            System.out.println("Produto não encontrado para atualização de estoque.");
        }
    }

    public void deletarProdutoService(int id) {
        ProdutoEServico produto = tipoRepository.buscarPorIdProduto(id);
        System.out.println("produto: " + produto.getNome());
        if (deletePopUpUtil.confirmacaoPopUp(produto.getNome())) {
            JOptionPane.showInternalMessageDialog(null, "Produto deletado com sucesso");
            System.out.println("O Produto foi deletado.");
            tipoRepository.deletarProdutoPorId(id);

        } else {
            System.out.println("Operação cancelada.");
        }
    }

    public void salvarProduto(int id, ProdutoEServico produtoEServico) {
        if (validacaoUtil.validaDadosProduto(produtoEServico) && validacaoUtil.validaDuplicidadeDadosProduto(produtoEServico) && id == -1) {
            if (produtoEServico.getId() == null) {
                System.out.println("Inserindo os dados");
                tipoRepository.inserirProduto(produtoEServico);
                JOptionPane.showInternalMessageDialog(null, "Produto cadastrado com sucesso");
            }

        } else if (validacaoUtil.validaDadosProduto(produtoEServico) && validacaoUtil.validaDuplicidadeDadosProdutoAtualizar(id, produtoEServico)) {
            System.out.println("Dados validados com sucesso");
            System.out.println("id encontrato com sucesso");
            System.out.println("atualizando dados");
            tipoRepository.atualizarProduto(id, produtoEServico);
            JOptionPane.showInternalMessageDialog(null, "Produto atualizado com sucesso");
        }
    }

    // Service Hospede
    public void preencherComboBoxPaises(JComboBox<String> cmbPais) {
        String[] paises = paisesUtil.listaPaises();
        for (String pais : paises) {
            cmbPais.addItem(pais);
        }
    }

    public void preencherTabelaHospede(JTable tbHospede) {
        DatasUtil datasUtil = new DatasUtil();
        DefaultTableModel tabela = (DefaultTableModel) tbHospede.getModel();
        tabela.setRowCount(0);
        List<Hospede> hospede = tipoRepository.listarTodosHospede();
        List<ReservaHospede> reservaHospedes = tipoRepository.litarReservaHospede();
        List<Reserva> reserva = tipoRepository.listarTodosReservasStatus();
        List<Object[]> objeto = new ArrayList<>();

        for (Hospede hospedes : hospede) {
            ReservaHospede reservaHospede = tipoRepository.buscarPorIdReservaPorCpfEPassaporteHospede(hospedes.getCpf(), hospedes.getPassaporte());
            if (reservaHospede != null) {
                if (reservaHospede.getReserva().isStatus()) {
                    String data = datasUtil.converterDataParaString(reservaHospede.getReserva().getCheckIn(), "dd/MM/yyyy");
                    Object[] linha = {reservaHospede.getHospede().getId(), hospedes.getNome(), reservaHospede.getHospede().getCpf(), reservaHospede.getHospede().getPassaporte(), reservaHospede.getReserva().getNumeroHospedes(), reservaHospede.getReserva().getNomeQuarto(), data, reservaHospede.getReserva().isStatus()};
                    objeto.add(linha);
                }
            }
        }
        if (tabela == null) {
            System.out.println("Erro ao retornar tabela, tabela esta nula");

        } else {
            for (Object[] linha : objeto) {
                tabela.addRow(linha);
            }
            System.out.println("tabela retornada com sucesso");
        }
    
    }

    public void preencherTabelaHospedeCheckIn(JTable tbHospede) {
        DefaultTableModel tabela = (DefaultTableModel) tbHospede.getModel();
        tabela.setRowCount(0);
        List<Hospede> hospede = tipoRepository.listarTodosHospede();
        List<ReservaHospede> reservaHospeder = tipoRepository.litarReservaHospede();
        List<Object[]> objeto = new ArrayList<>();
        List<Integer> hospedesId = new ArrayList<>();

//        for (ReservaHospede reservaHospeders : reservaHospeder) {
//            if (reservaHospeders.getReserva().isStatus()) {
//                hospedesId.add(reservaHospeders.getHospede().getId());
//            }
//        }
        for (Hospede hospedes : hospede) {
            if (!hospedesId.contains(hospedes.getId())) {
                Object[] linha = {hospedes.getId(), hospedes.getNome(), hospedes.getCpf(), hospedes.getPassaporte()};
                objeto.add(linha);
//                hospedesId.add(hospedes.getId());
            }
        }
        if (tabela == null) {
            System.out.println("Erro ao retornar tabela, tabela esta nula");

        } else {
            for (Object[] linha : objeto) {
                tabela.addRow(linha);
            }
            System.out.println("tabela retornada com sucesso");
        }
    }

    public void pesquisaHospede(String campo, String valor, JTable tbHospede) {
        DefaultTableModel tabela = (DefaultTableModel) tbHospede.getModel();
        tabela.setRowCount(0);
        List<Hospede> hospede = tipoRepository.pesquisaCampoHospede(campo, valor);
        List<Object[]> objeto = new ArrayList<>();
        for (Hospede hospedes : hospede) {
            Object[] linha = {hospedes.getId(), hospedes.getNome(), hospedes.getCpf(), hospedes.getPassaporte()};
            objeto.add(linha);
        }
        if (validacaoUtil.validarCampoPesquisaQuarto(valor)) {
            System.out.println("Dados validados com sucesso");
            for (Object[] linha : objeto) {
                tabela.addRow(linha);
            }
        } else {
            System.out.println("erro ao preencher tabela");
        }
    }

    public Hospede retornaIdHospede(int id) {
        Hospede hospede = tipoRepository.buscarPorIdHospede(id);
        return hospede;
    }

    public void buscarPrecoPorTipoDeQuarto(JComboBox cmbNumeroQuarto, JLabel lblValor) {
        cmbNumeroQuarto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numeroSelecionado = (String) cmbNumeroQuarto.getSelectedItem();
                Quarto quarto = tipoRepository.buscarPorNomeQuarto(numeroSelecionado);
                if (quarto != null) {
                    String tipoSelecionado = quarto.getTipoQuarto();

                    ProdutoEServico produto = tipoRepository.buscarPorNomeProduto(obterNomeProdutoPorTipo(tipoSelecionado));

                    if (produto != null) {
                        lblValor.setText(String.valueOf(produto.getValor()));

                    } else {
                        lblValor.setText("Produto não encontrado");
                    }
                }
            }
        });
    }

    public String obterNomeProdutoPorTipo(String tipoQuarto) {
        switch (tipoQuarto) {
            case "Solteiro":
                return "Diaria Quarto Solteiro";
            case "Solteiro Duplo":
                return "Diaria Quarto Solteiro Duplo";
            case "Quarto Casal":
                return "Diaria Quarto Casal";
            case "Apartamento":
                return "Diaria Quarto Apartamento";
            case "Suite":
                return "Diaria Quarto Suite";
            default:
                return null;
        }
    }

    public void preencherComboBoxTipoQuarto(JComboBox cmbNomeQuarto, JComboBox cmbTipoQuarto) {
        cmbTipoQuarto.removeAllItems();
        String tp = "";
        List<Quarto> quartos = tipoRepository.listarTodosQuartos();
        for (Quarto quarto : quartos) {
            if (!tp.equalsIgnoreCase(quarto.getTipoQuarto())) {
                cmbTipoQuarto.addItem(quarto.getTipoQuarto());
                tp = quarto.getTipoQuarto();
            }
        }

        cmbTipoQuarto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipoSelecionado = (String) cmbTipoQuarto.getSelectedItem();
                preencherComboBoxNomeQuarto(cmbNomeQuarto, tipoSelecionado);
            }
        });
    }

    private void preencherComboBoxNomeQuarto(JComboBox cmbNomeQuarto, String tipoSelecionado) {
        cmbNomeQuarto.removeAllItems();
        List<Quarto> quartos = tipoRepository.buscarPorNomeEspecificoQuarto(tipoSelecionado);
        for (Quarto quarto : quartos) {
            if (!quarto.isStatus()) {
                cmbNomeQuarto.addItem(quarto.getNome());
            }
        }
    }

    public void salvarHospede(Hospede hospede) {
        if (validacaoUtil.validaDadosHospede(hospede)) {
            if (hospede.getId() == null) {
                System.out.println("Inserindo os dados");
                tipoRepository.inserirHospede(hospede);
                JOptionPane.showInternalMessageDialog(null, "Hospede cadastrado com sucesso");
            }
        }
    }

    //Service Reserva
    public int buscarIdReserva(String cpf, String passaporte) {
        ReservaHospede reserva = tipoRepository.buscarPorIdReservaPorCpfEPassaporteHospede(cpf, passaporte);
        if (reserva != null) {
            return reserva.getReserva().getId();

        } else if (reserva == null) {
            System.out.println("hospede nulo, retorna -11");
            return -1;
        }
        System.out.println("hospede nulo, retorna -1");
        return - 1;
    }

    public Date buscarPorCheckIn(String cpf, String passaporte) {
        ReservaHospede reserva = tipoRepository.buscarPorIdReservaPorCpfEPassaporteHospede(cpf, passaporte);
        if (reserva != null) {
            return reserva.getReserva().getCheckIn();

        } else if (reserva == null) {
            System.out.println("hospede nulo, retorna -11");
            return null;
        }
        System.out.println("hospede nulo, retorna -1");
        return null;
    }

    public String buscarNomeQuartoPorHospedeId(String cpf, String passaporte) {
        ReservaHospede reserva = tipoRepository.buscarPorIdReservaPorCpfEPassaporteHospede(cpf, passaporte);
        if (reserva != null) {
            return reserva.getReserva().getNomeQuarto();

        } else if (reserva == null) {
            System.out.println("hospede nulo, retorna nulo");
            return null;
        }
        System.out.println("hospede nulo, retorna null");
        return null;
    }

    public String buscarNomeQuartoPorTipo(String cpf, String passaporte) {
        ReservaHospede reserva = tipoRepository.buscarPorIdReservaPorCpfEPassaporteHospede(cpf, passaporte);
        if (reserva == null) {
            System.out.println("reserva nulo, retorna nula");
            return null;

        } else {
            Quarto quarto = tipoRepository.buscarPorNomeQuarto(reserva.getReserva().getNomeQuarto());
            if (quarto != null) {
                return quarto.getTipoQuarto();

            } else if (reserva == null) {
                System.out.println("quarto nulo, retorna nulo");
                return null;
            }
        }
        System.out.println("reserva nulo, retorna null");
        return null;
    }

    public void preencherTabelaReserva(JTable tbReserva) {
        DatasUtil datasUtil = new DatasUtil();
        DefaultTableModel tabela = (DefaultTableModel) tbReserva.getModel();
        tabela.setRowCount(0);
        List<Hospede> hospede = tipoRepository.listarTodosHospede();
        List<ReservaHospede> reservaHospedes = tipoRepository.litarReservaHospede();
        List<Reserva> reserva = tipoRepository.listarTodosReservasStatus();
        List<Object[]> objeto = new ArrayList<>();

        for (Hospede hospedes : hospede) {
            ReservaHospede reservaHospede = tipoRepository.buscarPorIdReservaPorCpfEPassaporteHospede(hospedes.getCpf(), hospedes.getPassaporte());
            if (reservaHospede != null) {
                if (reservaHospede.getReserva().isStatus()) {
                    String data = datasUtil.converterDataParaString(reservaHospede.getReserva().getCheckIn(), "dd/MM/yyyy");
                    Object[] linha = {reservaHospede.getHospede().getId(), hospedes.getNome(), reservaHospede.getHospede().getCpf(), reservaHospede.getHospede().getPassaporte(), reservaHospede.getReserva().getNumeroHospedes(), reservaHospede.getReserva().getNomeQuarto(), data, reservaHospede.getReserva().isStatus()};
                    objeto.add(linha);
                }
            }
        }
        if (tabela == null) {
            System.out.println("Erro ao retornar tabela, tabela esta nula");

        } else {
            for (Object[] linha : objeto) {
                tabela.addRow(linha);
            }
            System.out.println("tabela retornada com sucesso");
        }
    }

    public void mudarStatusReserva(String cpf, String Passaporte) {
        ReservaHospede reserva = tipoRepository.buscarPorIdReservaPorCpfEPassaporteHospede(cpf, Passaporte);
        if (reserva != null) {
            tipoRepository.atualizarStatusReserva(reserva.getReserva().getId(), false);

        } else {
            System.out.println("Numero de quarto não existente.");

        }
    }

    public void salvarReserva(Reserva reserva) {
        //if (validacaoUtil.validaDadosReserva(reserva)) {
        if (reserva.getId() == null) {
            System.out.println("Inserindo os dados");
            tipoRepository.inserirReserva(reserva);
            JOptionPane.showInternalMessageDialog(null, "Reserva feita com sucesso");
        }
        // }
    }

    //Service ReservaDespesa
    public double ultimoTotal(int idReserva) {
        ReservaDespesa reservaDespesa = tipoRepository.buscaUltimaEntradaPorIdReserva(idReserva);
        if (reservaDespesa == null) {
            JOptionPane.showInternalMessageDialog(null, "Não existe essa reserva.");

        } else {
            if (reservaDespesa.getTotal() <= 0) {
                JOptionPane.showInternalMessageDialog(null, "O total não pode ser menor que 0.");
            }
            return reservaDespesa.getTotal();
        }
        System.out.println("reserva nulo, retorna -1");
        return -1;
    }

    public void salvarReservaDespesa(ReservaDespesa reservaDespesa, Reserva reserva, boolean gasto) {
        //if (validacaoUtil.validaDadosReservaDespesa(reservaDespesa, reserva)) {
        System.out.println("Inserindo os dados");
        tipoRepository.inserirReservaDespesa(reservaDespesa);
        if (!gasto) {
            JOptionPane.showInternalMessageDialog(null, "Despesa registrada com sucesso");
        }
        //}
    }

    //Service ReseravaHospede
    public void preencherTabelaHospedeTelaCheckIn(JTable tbHospedeCheckIn) {
        DefaultTableModel tabela = (DefaultTableModel) tbHospedeCheckIn.getModel();
        tabela.setRowCount(0);
        List<Hospede> hospede = tipoRepository.listarTodosHospede();
        List<Reserva> reserva = tipoRepository.listarTodosReservasStatus();
        List<Object[]> objeto = new ArrayList<>();
        for (Hospede hospedes : hospede) {
            for (Reserva reservas : reserva) {
                //if (Objects.equals(reservas.getHospede().getId(), hospedes.getId()) && !reservas.isStatus()) {
                Object[] linha = {hospedes.getId(), hospedes.getNome(), hospedes.getCpf(), hospedes.getPassaporte()};
                objeto.add(linha);
                // }
            }
        }
        if (tabela == null) {
            System.out.println("Erro ao retornar tabela, tabela esta nula");

        } else {
            for (Object[] linha : objeto) {
                tabela.addRow(linha);
            }
            System.out.println("tabela retornada com sucesso");
        }
    }

    public void preencherTabelaHospedeListaTelaCheckIn(JTable tbAcompanhanteCheckIn, int id) {
        DefaultTableModel tabela = (DefaultTableModel) tbAcompanhanteCheckIn.getModel();
        List<Hospede> hospedeLista = new ArrayList<>();
        Hospede hospede = tipoRepository.buscarPorIdHospede(id);
        hospedeLista.add(hospede);
        List<Object[]> objeto = new ArrayList<>();
        for (Hospede hospedes : hospedeLista) {
            Object[] linha = {hospedes.getId(), hospedes.getNome(), hospedes.getCpf(), hospedes.getPassaporte()};
            objeto.add(linha);
        }
        if (tabela == null) {
            System.out.println("Erro ao retornar tabela, tabela esta nula");

        } else {
            for (Object[] linha : objeto) {
                tabela.addRow(linha);
            }
            System.out.println("tabela retornada com sucesso");
        }
    }
}
