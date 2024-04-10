/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GerenciadorDeHoteis.Views;

import GerenciadorDeHoteis.Service.TipoService;
import GerenciadorDeHoteis.Types.Quarto;
import GreneciadorDeHoteis.Repository.TipoRepository;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marcos
 */
public class GerenciamentoDeQuarto extends javax.swing.JFrame {
    TipoService tipoService = new TipoService();
    TipoRepository tipoRepository = new TipoRepository();
    
    /**
     * Creates new form GerenciamentoDeQuarto
     */
    public GerenciamentoDeQuarto() {
        initComponents();
        preencherAtualizarTabela();
        telaPesquisa.setSize(445, 450);
        cbxCampoPesquisa = getComboBoxColunas(cbxCampoPesquisa);
        telaPesquisa.setLocationRelativeTo(null);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        telaPesquisa = new javax.swing.JFrame();
        lblPesquisa = new javax.swing.JLabel();
        lblCampoPesquisa = new javax.swing.JLabel();
        lblValorPesquisa = new javax.swing.JLabel();
        cbxCampoPesquisa = new javax.swing.JComboBox<>();
        txtCampoPesquisa = new javax.swing.JTextField();
        btnPesquisa = new javax.swing.JButton();
        btnFecharPesquisar = new javax.swing.JToggleButton();
        lblFundoPesquisa = new javax.swing.JLabel();
        lblGerenciamentoDeQuatos = new javax.swing.JLabel();
        lblNomeQuarto = new javax.swing.JLabel();
        lblTipoQuarto = new javax.swing.JLabel();
        lblNumeroCamas = new javax.swing.JLabel();
        txtNomeQuarto = new javax.swing.JTextField();
        cmbTipoQuarto = new javax.swing.JComboBox<>();
        txtNumeroCamas = new javax.swing.JTextField();
        cbxQuartoOcupado = new javax.swing.JCheckBox();
        scpQuartos = new javax.swing.JScrollPane();
        tbQuartos = new javax.swing.JTable();
        bntRegistarQuarto = new javax.swing.JButton();
        bntPesquisar = new javax.swing.JToggleButton();
        bntSelecionarQuarto = new javax.swing.JToggleButton();
        bntEditarQuarto = new javax.swing.JToggleButton();
        btnRefersh = new javax.swing.JToggleButton();
        btnSair = new javax.swing.JToggleButton();
        lblFundo = new javax.swing.JLabel();

        telaPesquisa.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPesquisa.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblPesquisa.setText("Campo De Pesquisa");
        telaPesquisa.getContentPane().add(lblPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, 30));

        lblCampoPesquisa.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblCampoPesquisa.setText("Campo a Pesquisar :");
        telaPesquisa.getContentPane().add(lblCampoPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        lblValorPesquisa.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblValorPesquisa.setText("Valor da Pesquisar :");
        telaPesquisa.getContentPane().add(lblValorPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 180, 30));

        telaPesquisa.getContentPane().add(cbxCampoPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 180, 40));

        txtCampoPesquisa.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtCampoPesquisa.setToolTipText("valor do campo que quer pesquisar");
        telaPesquisa.getContentPane().add(txtCampoPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 370, 40));

        btnPesquisa.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnPesquisa.setText("Pesquisar");
        btnPesquisa.setToolTipText("efetua a pesquisa");
        btnPesquisa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaActionPerformed(evt);
            }
        });
        telaPesquisa.getContentPane().add(btnPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 130, 30));

        btnFecharPesquisar.setText("Fechar");
        btnFecharPesquisar.setToolTipText("fecha essa tela");
        btnFecharPesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        telaPesquisa.getContentPane().add(btnFecharPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, 130, 30));

        lblFundoPesquisa.setText("Fundo Pesquisa");
        telaPesquisa.getContentPane().add(lblFundoPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, 680, 410));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblGerenciamentoDeQuatos.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblGerenciamentoDeQuatos.setText("Gerenciamento de Quartos");
        getContentPane().add(lblGerenciamentoDeQuatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 320, 40));

        lblNomeQuarto.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblNomeQuarto.setText("Nome do Quarto :");
        getContentPane().add(lblNomeQuarto, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 160, 30));

        lblTipoQuarto.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblTipoQuarto.setText("Tipo de Quarto :");
        getContentPane().add(lblTipoQuarto, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 150, 30));

        lblNumeroCamas.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblNumeroCamas.setText("Nº de Camas :");
        getContentPane().add(lblNumeroCamas, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 130, 30));

        txtNomeQuarto.setToolTipText("numero do quarto");
        getContentPane().add(txtNomeQuarto, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 270, 30));

        cmbTipoQuarto.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cmbTipoQuarto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Solteiro", "Solteiro Duplo", "Quarto Casal", "Apartamento", "Suite" }));
        getContentPane().add(cmbTipoQuarto, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 150, 30));

        txtNumeroCamas.setToolTipText("numero de camas no quarto");
        getContentPane().add(txtNumeroCamas, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 270, 30));

        cbxQuartoOcupado.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        cbxQuartoOcupado.setText("Quarto Ocupado");
        getContentPane().add(cbxQuartoOcupado, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 170, 40));

        tbQuartos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome Quarto", "Tipo Do Quarto", "Nº De Camas", "Status Ocupação"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scpQuartos.setViewportView(tbQuartos);
        if (tbQuartos.getColumnModel().getColumnCount() > 0) {
            tbQuartos.getColumnModel().getColumn(0).setResizable(false);
            tbQuartos.getColumnModel().getColumn(1).setResizable(false);
            tbQuartos.getColumnModel().getColumn(2).setResizable(false);
            tbQuartos.getColumnModel().getColumn(3).setResizable(false);
            tbQuartos.getColumnModel().getColumn(4).setResizable(false);
        }

        getContentPane().add(scpQuartos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 990, 210));

        bntRegistarQuarto.setText("Registrar Quarto");
        bntRegistarQuarto.setToolTipText("efetua o registro de um quarto");
        bntRegistarQuarto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntRegistarQuartoActionPerformed(evt);
            }
        });
        getContentPane().add(bntRegistarQuarto, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, 140, -1));

        bntPesquisar.setText("Pesquisar");
        bntPesquisar.setToolTipText("abre a tela de pesquisa");
        bntPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntPesquisarActionPerformed(evt);
            }
        });
        getContentPane().add(bntPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 230, 140, -1));

        bntSelecionarQuarto.setText("Selecionar Quarto");
        bntSelecionarQuarto.setToolTipText("seleciona um quarto para editar");
        bntSelecionarQuarto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntSelecionarQuartoActionPerformed(evt);
            }
        });
        getContentPane().add(bntSelecionarQuarto, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 240, 140, -1));

        bntEditarQuarto.setText("Editar Quarto");
        bntEditarQuarto.setToolTipText("efetua a edição");
        bntEditarQuarto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntEditarQuartoActionPerformed(evt);
            }
        });
        getContentPane().add(bntEditarQuarto, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 300, 140, -1));

        btnRefersh.setText("Recarregar/Julinha Mude S2");
        btnRefersh.setToolTipText("recarrega a tabela");
        btnRefersh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefershActionPerformed(evt);
            }
        });
        getContentPane().add(btnRefersh, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 330, 170, -1));

        btnSair.setText("Sair/Julinha Mude S2");
        btnSair.setToolTipText("fecha essa tela");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        getContentPane().add(btnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, 170, -1));

        lblFundo.setText("Fundo");
        getContentPane().add(lblFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntRegistarQuartoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntRegistarQuartoActionPerformed
        // TODO add your handling code here:
        criarQuarto(quarto);
        atualizarTabela();
    }//GEN-LAST:event_bntRegistarQuartoActionPerformed

    private void bntEditarQuartoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntEditarQuartoActionPerformed
        atualizarQuarto();
        atualizarTabela();
    }//GEN-LAST:event_bntEditarQuartoActionPerformed

    private void bntSelecionarQuartoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntSelecionarQuartoActionPerformed
        // TODO add your handling code here:
        selecionarQuarto();
    }//GEN-LAST:event_bntSelecionarQuartoActionPerformed

    private void bntPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntPesquisarActionPerformed
        // TODO add your handling code here:
        telaPesquisa.setVisible(true);        
    }//GEN-LAST:event_bntPesquisarActionPerformed

    private void btnRefershActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefershActionPerformed
        // TODO add your handling code here:
        atualizarTabela();
    }//GEN-LAST:event_btnRefershActionPerformed

    private void btnPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaActionPerformed
        // TODO add your handling code here:
        pesquisar();
    }//GEN-LAST:event_btnPesquisaActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnSairActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GerenciamentoDeQuarto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GerenciamentoDeQuarto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GerenciamentoDeQuarto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GerenciamentoDeQuarto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GerenciamentoDeQuarto().setVisible(true);
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton bntEditarQuarto;
    private javax.swing.JToggleButton bntPesquisar;
    private javax.swing.JButton bntRegistarQuarto;
    private javax.swing.JToggleButton bntSelecionarQuarto;
    private javax.swing.JToggleButton btnFecharPesquisar;
    private javax.swing.JButton btnPesquisa;
    private javax.swing.JToggleButton btnRefersh;
    private javax.swing.JToggleButton btnSair;
    private javax.swing.JComboBox<String> cbxCampoPesquisa;
    private javax.swing.JCheckBox cbxQuartoOcupado;
    private javax.swing.JComboBox<String> cmbTipoQuarto;
    private javax.swing.JLabel lblCampoPesquisa;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JLabel lblFundoPesquisa;
    private javax.swing.JLabel lblGerenciamentoDeQuatos;
    private javax.swing.JLabel lblNomeQuarto;
    private javax.swing.JLabel lblNumeroCamas;
    private javax.swing.JLabel lblPesquisa;
    private javax.swing.JLabel lblTipoQuarto;
    private javax.swing.JLabel lblValorPesquisa;
    private javax.swing.JScrollPane scpQuartos;
    private javax.swing.JTable tbQuartos;
    private javax.swing.JFrame telaPesquisa;
    private javax.swing.JTextField txtCampoPesquisa;
    private javax.swing.JTextField txtNomeQuarto;
    private javax.swing.JTextField txtNumeroCamas;
    // End of variables declaration//GEN-END:variables

    private void criarQuarto(){
        String nome = txtNomeQuarto.getText();
        String tipoQuarto = (String) cmbTipoQuarto.getSelectedItem();
        byte numeroCamas = Byte.parseByte(txtNumeroCamas.getText());
        boolean quartoOcupado = cbxQuartoOcupado.isSelected();
        
        Quarto quarto = new Quarto(nome, tipoQuarto, numeroCamas, quartoOcupado);
        tipoService.salvarQuarto(quarto);
    }
  
   /* private void preencherTabela(){
        DefaultTableModel tabela = (DefaultTableModel) tbQuartos.getModel();
        tabela.setRowCount(0);
        List<Quarto> quartos = tipoRepository.listarTodosQuartos();
     
        for (Quarto quarto : quartos){
            Object[] linha = {quarto.getId(), quarto.getNumeroquarto(), quarto.getTipoQuarto(), quarto.getNumeroCamas(), diariaFormatada};
            tabela.addRow(linha);
        }
    }*/
    
    private void preencherAtualizarTabela(){
        DefaultTableModel tabela = (DefaultTableModel) tbQuartos.getModel();
        tabela.setRowCount(0);
        tabela.addRow(tipoRepository.preencherTabelaQuarto());   
    }
    
    /*public void atualizarTabela(){
        DefaultTableModel tabela = (DefaultTableModel) tbQuartos.getModel();
        tabela.setRowCount(0);
        NumberFormat dinheiro = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        try{
            List<Quarto> quartos = quartoDAO.listarQuartos();
            for (Quarto quarto : quartos) {
                String diariaFormatada = dinheiro.format(quarto.getDiaria());
                Object[] row = {quarto.getId(), quarto.getNumeroquarto(), quarto.getTipoQuarto(), quarto.getNumeroCamas(), diariaFormatada};
                tabela.addRow(row);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, "Erro ao atualizar tabela: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }*/
    
    public void selecionarQuarto(){
        int index = tbQuartos.getSelectedRow();
        int roomId = (int) tbQuartos.getValueAt(index, 0);
        System.out.println("index selecionado: " + index);       
        Quarto quarto = tipoRepository.buscarPorIdQuarto(roomId);
        txtNomeQuarto.setText(quarto.getNome());
        cmbTipoQuarto.setSelectedItem(quarto.getTipoQuarto());
        txtNumeroCamas.setText(String.valueOf(quarto.getNumeroCamas()));
        cbxQuartoOcupado.setSelected(quarto.isStatus());
    }
    
    private void atualizarQuarto(){
        byte numeroQuarto = Byte.parseByte(txtNomeQuarto.getText());
        byte numeroCamas = Byte.parseByte(txtNumeroCamas.getText());
        double diaria = Double.parseDouble(txtDiaria.getText());
        
        if(validaCamposTexto()){
            
        }else if(!validaLetraNumero(txtNomeQuarto.getText(), txtTipoQuarto.getText(), txtNumeroCamas.getText(), txtDiaria.getText())){
            
        }else if(!validaTamanhoString(numeroQuarto, numeroCamas, diaria)){
            
        }else{
             
            Quarto quartoParaAtualizar = new Quarto();   
            quartoParaAtualizar.setNumeroquarto((byte) numeroQuarto);
            quartoParaAtualizar.setTipoQuarto(txtTipoQuarto.getText());
            quartoParaAtualizar.setNumeroCamas((byte) numeroCamas);
            quartoParaAtualizar.setDiaria(diaria);

            QuartoDAO quartoDAO = new QuartoDAO();
            try{

                quartoDAO.atualizarQuarto(quartoParaAtualizar);
            }catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar o quarto." + e.getMessage());
            }
        }
    }
    
    public void pesquisar(){
        DefaultTableModel tabela = (DefaultTableModel) tbQuartos.getModel();
        tabela.setRowCount(0);
        String pesquisa = (String) cbxCampoPesquisa.getSelectedItem();
        String valor = txtCampoPesquisa.getText();
        NumberFormat dinheiro = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        
        if(valor.isBlank()){
            JOptionPane.showMessageDialog(null, "O campo esta em branco.");
            
        }else if(!valor.matches("[a-zA-Z\\d\\s.]+")){
             JOptionPane.showMessageDialog(null, "O campo possui caracteres invalidos");
             
        }else if(!limiteTamanhoString(valor, 100)){ 
             JOptionPane.showMessageDialog(null, "O numeros de caracteres foi ultrapassado.");
             
        }else{
            if(pesquisa.equalsIgnoreCase("id".trim())){
                pesquisa = "id";     
                                  
            }else if(pesquisa.equalsIgnoreCase("Nº Quarto".trim())){ 
                pesquisa = "n_quarto";
               
            }else if(pesquisa.equalsIgnoreCase("Tipo Do Quarto".trim())){ 
                pesquisa = "tipo_quarto";
                           
            }else if(pesquisa.equalsIgnoreCase("Nº De Camas".trim())){
                pesquisa = "n_camas";
                
            }else if(pesquisa.equalsIgnoreCase("Valor Da Diaria".trim())){ 
                pesquisa = "valor_diaria";
                
            }else{
                JOptionPane.showMessageDialog(null, "Nemnhuma das colunas foi encontrada, pesquise novamente");
                return;
            }
        try{
            ArrayList<Quarto> quartos = quartoDAO.buscar(pesquisa,valor);

            for(Quarto quarto : quartos){
                String diariaFormatada = dinheiro.format(quarto.getDiaria());
                Object[] row = {quarto.getId(), quarto.getNumeroquarto(), quarto.getTipoQuarto(), quarto.getNumeroCamas(), diariaFormatada};
                tabela.addRow(row);
            }

        }catch(SQLException e){
            System.out.println("erro ao pesquisar " + e.getMessage());
        }
        }
    }
  
    public JComboBox<String> getComboBoxColunas(JComboBox<String> comboBox){
        comboBox.removeAllItems();
         
        for (int i = 0; i < getTbQuatos().getColumnCount(); i++) {
            String nomeColuna = getTbQuatos().getColumnName(i);
            comboBox.addItem(nomeColuna);
        }  
        return comboBox;
    }

    public JTable getTbQuatos() {
        return tbQuartos;
    }   
}