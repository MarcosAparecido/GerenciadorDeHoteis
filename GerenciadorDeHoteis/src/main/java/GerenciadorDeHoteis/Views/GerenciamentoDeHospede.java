/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GerenciadorDeHoteis.Views;

import GerenciadorDeHoteis.Service.TipoService;
import GerenciadorDeHoteis.Entity.Quarto;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Marcos
 */
public class GerenciamentoDeHospede extends javax.swing.JFrame {
    private int idSelecionado = -1;
    private TipoService tipoService = new TipoService();

    /**
     * Creates new form GerenciamentoDeQuarto
     */
    public GerenciamentoDeHospede() {
        initComponents();
        preencherAtualizarTabela();
        selecionarQuarto();
        telaPesquisa.setSize(445, 450);
        cbmCampoPesquisa = getComboBoxColunas(cbmCampoPesquisa);
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
        cbmCampoPesquisa = new javax.swing.JComboBox<>();
        txtCampoPesquisa = new javax.swing.JTextField();
        btnPesquisa = new javax.swing.JButton();
        btnFecharPesquisar = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();
        lblFundoPesquisa = new javax.swing.JLabel();
        lblGerenciamentoDeQuatos = new javax.swing.JLabel();
        lblNomeQuarto = new javax.swing.JLabel();
        lblTipoQuarto = new javax.swing.JLabel();
        lblNumeroCamas = new javax.swing.JLabel();
        lblQuartoSelecionado = new javax.swing.JLabel();
        lblQuarto = new javax.swing.JLabel();
        txtNomeQuarto = new javax.swing.JTextField();
        cmbTipoQuarto = new javax.swing.JComboBox<>();
        txtNumeroCamas = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnPesquisarQuarto = new javax.swing.JToggleButton();
        btnDeletar = new javax.swing.JToggleButton();
        btnRefersh = new javax.swing.JToggleButton();
        btnSair = new javax.swing.JToggleButton();
        scpQuartos = new javax.swing.JScrollPane();
        tbQuartos = new javax.swing.JTable();
        btnDesselecionarQuarto = new javax.swing.JToggleButton();
        btnLimparCampos = new javax.swing.JToggleButton();
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

        cbmCampoPesquisa.setToolTipText("campo que deseja pesquisar");
        telaPesquisa.getContentPane().add(cbmCampoPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 180, 40));

        txtCampoPesquisa.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtCampoPesquisa.setToolTipText("valor do campo que quer pesquisar");
        telaPesquisa.getContentPane().add(txtCampoPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 370, 40));

        btnPesquisa.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnPesquisa.setText("Pesquisar");
        btnPesquisa.setToolTipText("efetua a pesquisa");
        btnPesquisa.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaActionPerformed(evt);
            }
        });
        telaPesquisa.getContentPane().add(btnPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 130, 30));

        btnFecharPesquisar.setText("Fechar");
        btnFecharPesquisar.setToolTipText("fecha essa tela");
        btnFecharPesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        telaPesquisa.getContentPane().add(btnFecharPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, 130, 30));

        jButton1.setText("Sair/ Julinha Alterar S2");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        telaPesquisa.getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 0, 160, 40));

        lblFundoPesquisa.setText("Fundo Pesquisa");
        telaPesquisa.getContentPane().add(lblFundoPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, 680, 410));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1060, 850));
        setMinimumSize(new java.awt.Dimension(1060, 850));
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

        lblQuartoSelecionado.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblQuartoSelecionado.setText("Quarto Selecionado :");
        getContentPane().add(lblQuartoSelecionado, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 70, 150, -1));

        lblQuarto.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        getContentPane().add(lblQuarto, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 70, 250, 20));

        txtNomeQuarto.setToolTipText("numero do quarto");
        getContentPane().add(txtNomeQuarto, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 270, 30));

        cmbTipoQuarto.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cmbTipoQuarto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Solteiro", "Solteiro Duplo", "Quarto Casal", "Apartamento", "Suite" }));
        cmbTipoQuarto.setToolTipText("Tipo do quarto");
        getContentPane().add(cmbTipoQuarto, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 150, 30));

        txtNumeroCamas.setToolTipText("numero de camas no quarto");
        getContentPane().add(txtNumeroCamas, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 270, 30));

        btnSalvar.setText("Salvar");
        btnSalvar.setToolTipText("efetua o registro de um quarto");
        btnSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 290, 120, 40));

        btnPesquisarQuarto.setText("Pesquisar Quarto");
        btnPesquisarQuarto.setToolTipText("abre a tela de pesquisa");
        btnPesquisarQuarto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnPesquisarQuarto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarQuartoActionPerformed(evt);
            }
        });
        getContentPane().add(btnPesquisarQuarto, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 130, 150, 30));

        btnDeletar.setText("Excluir Quarto");
        btnDeletar.setToolTipText("efetua a edição");
        btnDeletar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeletar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 290, 150, 30));

        btnRefersh.setText("Recarregar/Julinha Mude S2");
        btnRefersh.setToolTipText("recarrega a tabela");
        btnRefersh.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRefersh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefershActionPerformed(evt);
            }
        });
        getContentPane().add(btnRefersh, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 313, 80, 40));

        btnSair.setText("Sair/Julinha Mude S2");
        btnSair.setToolTipText("fecha essa tela");
        btnSair.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        getContentPane().add(btnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 0, 40, 50));

        tbQuartos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome Hospede", "Tipo Do Quarto", "Nº De Camas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

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
        }

        getContentPane().add(scpQuartos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 990, 210));

        btnDesselecionarQuarto.setText("Desscelecionar Quarto");
        btnDesselecionarQuarto.setToolTipText("abre a tela de pesquisa");
        btnDesselecionarQuarto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesselecionarQuarto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesselecionarQuartoActionPerformed(evt);
            }
        });
        getContentPane().add(btnDesselecionarQuarto, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 230, 150, 30));

        btnLimparCampos.setText("Limpar Campos");
        btnLimparCampos.setToolTipText("abre a tela de pesquisa");
        btnLimparCampos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLimparCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparCamposActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimparCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 180, 150, 30));

        lblFundo.setText("Fundo");
        getContentPane().add(lblFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, 990, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        criarQuarto();
        preencherAtualizarTabela();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        deletar();
        preencherAtualizarTabela();
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void btnPesquisarQuartoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarQuartoActionPerformed
        // TODO add your handling code here:
        telaPesquisa.setVisible(true);
    }//GEN-LAST:event_btnPesquisarQuartoActionPerformed

    private void btnRefershActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefershActionPerformed
        // TODO add your handling code here:
        preencherAtualizarTabela();
    }//GEN-LAST:event_btnRefershActionPerformed

    private void btnPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaActionPerformed
        // TODO add your handling code here:       
        pesquisar();
    }//GEN-LAST:event_btnPesquisaActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnDesselecionarQuartoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesselecionarQuartoActionPerformed
        // TODO add your handling code here:
        limparQuarto();
    }//GEN-LAST:event_btnDesselecionarQuartoActionPerformed

    private void btnLimparCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparCamposActionPerformed
        // TODO add your handling code here:
        limparCampos();
    }//GEN-LAST:event_btnLimparCamposActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        telaPesquisa.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GerenciamentoDeHospede.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GerenciamentoDeHospede.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GerenciamentoDeHospede.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GerenciamentoDeHospede.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GerenciamentoDeHospede().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnDeletar;
    private javax.swing.JToggleButton btnDesselecionarQuarto;
    private javax.swing.JToggleButton btnFecharPesquisar;
    private javax.swing.JToggleButton btnLimparCampos;
    private javax.swing.JButton btnPesquisa;
    private javax.swing.JToggleButton btnPesquisarQuarto;
    private javax.swing.JToggleButton btnRefersh;
    private javax.swing.JToggleButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbmCampoPesquisa;
    private javax.swing.JComboBox<String> cmbTipoQuarto;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblCampoPesquisa;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JLabel lblFundoPesquisa;
    private javax.swing.JLabel lblGerenciamentoDeQuatos;
    private javax.swing.JLabel lblNomeQuarto;
    private javax.swing.JLabel lblNumeroCamas;
    private javax.swing.JLabel lblPesquisa;
    private javax.swing.JLabel lblQuarto;
    private javax.swing.JLabel lblQuartoSelecionado;
    private javax.swing.JLabel lblTipoQuarto;
    private javax.swing.JLabel lblValorPesquisa;
    private javax.swing.JScrollPane scpQuartos;
    private javax.swing.JTable tbQuartos;
    private javax.swing.JFrame telaPesquisa;
    private javax.swing.JTextField txtCampoPesquisa;
    private javax.swing.JTextField txtNomeQuarto;
    private javax.swing.JTextField txtNumeroCamas;
    // End of variables declaration//GEN-END:variables
    private void criarQuarto() {
        byte numeroCamasNumero;
        String nome = txtNomeQuarto.getText().trim();
        String tipoQuarto = (String) cmbTipoQuarto.getSelectedItem();
        String numeroCamas = txtNumeroCamas.getText().trim();

        try {
            numeroCamasNumero = Byte.parseByte(numeroCamas);
        } catch (NumberFormatException e) {
            JOptionPane.showInternalMessageDialog(null, "O campo Nº DE CAMAS deve ser um número válido." + e.getMessage());
            return;
        }
        Quarto quarto = new Quarto(nome, tipoQuarto, numeroCamasNumero, false);
        tipoService.salvarQuarto(getIdSelecionado(), quarto);
        limparQuarto();
    }

    private void preencherAtualizarTabela() {
        tipoService.preencherTabelaQuarto(tbQuartos);
    }

    private void deletar() {
        if (validaDelecao()) {
            tipoService.deletarQuartoService(getIdSelecionado());
        }
    }

    private void pesquisar() {
        String campo = (String) cbmCampoPesquisa.getSelectedItem();
        String valor = txtCampoPesquisa.getText();
        if (campo.equals("Id") || campo.equals("Nº De Camas")) {
            try {
                int id = Integer.parseInt(valor);
                byte numeroCamas = Byte.parseByte(valor);
            } catch (NumberFormatException e) {
                if (campo.equals("Id")) {
                    JOptionPane.showMessageDialog(null, "O campo ID possui um caractere invalido.");

                } else if (campo.equals("Nº De Camas")) {
                    JOptionPane.showMessageDialog(null, "O campo Nº DE CAMAS possui um caractere invalido, ou possui um valor maior que 128.");

                }
                System.out.println("O campo Id não aceita Letra e o Campo Numero de camas não aceita numero maior que 128" + e.getMessage());
                return;
            }
        }
        tipoService.pesquisaQuarto(campo, valor, tbQuartos);
    }

    private void selecionarQuarto() {
        tbQuartos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int index = tbQuartos.getSelectedRow();
                    if (index != -1) {
                        idSelecionado = (int) tbQuartos.getValueAt(index, 0);
                        Quarto quarto = tipoService.retornaIdQuarto(getIdSelecionado());
                        lblQuarto.setText(quarto.getNome());
                        txtNomeQuarto.setText(quarto.getNome());
                        cmbTipoQuarto.setSelectedItem(quarto.getTipoQuarto());
                        txtNumeroCamas.setText(String.valueOf(quarto.getNumeroCamas()));
                    }
                }
            }
        });
    }

    private boolean validaDelecao() {
        if (getIdSelecionado() < 0) {
            JOptionPane.showInternalMessageDialog(null, "Selecione um QUARTO antes de ser excluido");
            return false;
        }
        return true;
    }

    private void limparQuarto() {
        lblQuarto.setText("");
        txtNomeQuarto.setText("");
        cmbTipoQuarto.setSelectedItem(0);
        txtNumeroCamas.setText("");
        idSelecionado = -1;
    }

    private void limparCampos() {
        txtNomeQuarto.setText("");
        cmbTipoQuarto.setSelectedItem(0);
        txtNumeroCamas.setText("");
    }

    public JComboBox<String> getComboBoxColunas(JComboBox<String> comboBox) {
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

    public int getIdSelecionado() {
        return idSelecionado;
    }
}
