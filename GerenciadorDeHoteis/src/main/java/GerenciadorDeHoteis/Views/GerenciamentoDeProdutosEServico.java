/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GerenciadorDeHoteis.Views;

import GerenciadorDeHoteis.Service.TipoService;
import GerenciadorDeHoteis.Entity.ProdutoEServico;
import GerenciadorDeHoteis.Utils.FormatoStringUtil;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Marcos
 */
public class GerenciamentoDeProdutosEServico extends javax.swing.JFrame {
    private int idSelecionado = -1;
    private TipoService tipoService = new TipoService();
    private FormatoStringUtil numeroEmString = new FormatoStringUtil();

    /**
     * Creates new form GerenciamentoDeQuarto
     */
    public GerenciamentoDeProdutosEServico() {
        initComponents();
        selecionarProduto();
        preencherAtualizarTabela();
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
        lblCampoPesquisa = new javax.swing.JLabel();
        lblValorPesquisa = new javax.swing.JLabel();
        cbmCampoPesquisa = new javax.swing.JComboBox<>();
        txtCampoPesquisa = new javax.swing.JTextField();
        btnPesquisa = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        lblNomeProduto = new javax.swing.JLabel();
        lblQuantidadeProduto = new javax.swing.JLabel();
        lblValorProduto = new javax.swing.JLabel();
        lblProdutoSelecionado = new javax.swing.JLabel();
        lblProduto = new javax.swing.JLabel();
        txtNomeProduto = new javax.swing.JTextField();
        txtQuantidadeProduto = new javax.swing.JTextField();
        txtValorProduto = new javax.swing.JFormattedTextField();
        btnRegistarProduto = new javax.swing.JButton();
        btnDesselecionarProduto = new javax.swing.JToggleButton();
        btnPesquisarProduto = new javax.swing.JToggleButton();
        btnLimparCampos = new javax.swing.JToggleButton();
        btnDeletarProduto = new javax.swing.JToggleButton();
        btnRefersh = new javax.swing.JToggleButton();
        btnSair = new javax.swing.JToggleButton();
        scpProdutos = new javax.swing.JScrollPane();
        tbProdutos = new javax.swing.JTable();

        telaPesquisa.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCampoPesquisa.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblCampoPesquisa.setText("Campo a Pesquisar :");
        telaPesquisa.getContentPane().add(lblCampoPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        lblValorPesquisa.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblValorPesquisa.setText("Valor da Pesquisar :");
        telaPesquisa.getContentPane().add(lblValorPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 180, 30));

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

        jButton1.setText("SAIR, Julinha ALTERAR S2");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        telaPesquisa.getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 0, 170, 40));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GERENCIAMENTO DE PRODUTO E SERVIÇO");
        setIconImages(null);
        setMaximumSize(new java.awt.Dimension(1060, 850));
        setMinimumSize(new java.awt.Dimension(1060, 850));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNomeProduto.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        lblNomeProduto.setText("Produto / Serviço :");
        getContentPane().add(lblNomeProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 220, 30));

        lblQuantidadeProduto.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        lblQuantidadeProduto.setText("Quantidade Produto :");
        getContentPane().add(lblQuantidadeProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 240, 30));

        lblValorProduto.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        lblValorProduto.setText("Valor Produto R$:");
        getContentPane().add(lblValorProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 200, 30));

        lblProdutoSelecionado.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        lblProdutoSelecionado.setText("Produto Selecionado : ");
        getContentPane().add(lblProdutoSelecionado, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, -1, -1));

        lblProduto.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        getContentPane().add(lblProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 220, 330, 20));

        txtNomeProduto.setBackground(new java.awt.Color(153, 153, 153));
        txtNomeProduto.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        txtNomeProduto.setToolTipText("Nome do Produto");
        txtNomeProduto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtNomeProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(txtNomeProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 260, 30));

        txtQuantidadeProduto.setBackground(new java.awt.Color(153, 153, 153));
        txtQuantidadeProduto.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        txtQuantidadeProduto.setToolTipText("Quatidade de intens para o estoque");
        txtQuantidadeProduto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtQuantidadeProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtQuantidadeProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantidadeProdutoActionPerformed(evt);
            }
        });
        getContentPane().add(txtQuantidadeProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 320, 140, 30));

        txtValorProduto.setBackground(new java.awt.Color(153, 153, 153));
        txtValorProduto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtValorProduto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        txtValorProduto.setToolTipText("Preço dos itens");
        txtValorProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtValorProduto.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        txtValorProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorProdutoActionPerformed(evt);
            }
        });
        getContentPane().add(txtValorProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 370, 210, 30));

        btnRegistarProduto.setBackground(new java.awt.Color(153, 153, 153));
        btnRegistarProduto.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        btnRegistarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/Icone_Salvar.png"))); // NOI18N
        btnRegistarProduto.setText("Salvar");
        btnRegistarProduto.setToolTipText("efetua o registro de um quarto");
        btnRegistarProduto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRegistarProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegistarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistarProdutoActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistarProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 420, 120, 40));

        btnDesselecionarProduto.setBackground(new java.awt.Color(153, 153, 153));
        btnDesselecionarProduto.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        btnDesselecionarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/Icone_Desmarcar.png"))); // NOI18N
        btnDesselecionarProduto.setText("Desselecionar ");
        btnDesselecionarProduto.setToolTipText("Desseleciona Produto");
        btnDesselecionarProduto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDesselecionarProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesselecionarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesselecionarProdutoActionPerformed(evt);
            }
        });
        getContentPane().add(btnDesselecionarProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 360, 170, -1));

        btnPesquisarProduto.setBackground(new java.awt.Color(153, 153, 153));
        btnPesquisarProduto.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        btnPesquisarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/Icone_Pesquisar.png"))); // NOI18N
        btnPesquisarProduto.setText("Pesquisar");
        btnPesquisarProduto.setToolTipText("Abre a tela de pesquisa de produto ou Quarto");
        btnPesquisarProduto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPesquisarProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnPesquisarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarProdutoActionPerformed(evt);
            }
        });
        getContentPane().add(btnPesquisarProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 250, 170, -1));

        btnLimparCampos.setBackground(new java.awt.Color(153, 153, 153));
        btnLimparCampos.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        btnLimparCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/Icone_LimparTela.png"))); // NOI18N
        btnLimparCampos.setText("Limpar Campos");
        btnLimparCampos.setToolTipText("Limpa Campos");
        btnLimparCampos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLimparCampos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLimparCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparCamposActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimparCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 420, 170, -1));

        btnDeletarProduto.setBackground(new java.awt.Color(153, 153, 153));
        btnDeletarProduto.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        btnDeletarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/excluir.png"))); // NOI18N
        btnDeletarProduto.setText("Excluir");
        btnDeletarProduto.setToolTipText("Exclui Produto ou Serviço");
        btnDeletarProduto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDeletarProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDeletarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarProdutoActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeletarProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 310, 170, 40));

        btnRefersh.setBackground(new java.awt.Color(153, 153, 153));
        btnRefersh.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        btnRefersh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/Icone_Atualizar.png"))); // NOI18N
        btnRefersh.setToolTipText("Recarregar a tabela");
        btnRefersh.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRefersh.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRefersh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefershActionPerformed(evt);
            }
        });
        getContentPane().add(btnRefersh, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 450, 60, -1));

        btnSair.setBackground(new java.awt.Color(153, 153, 153));
        btnSair.setForeground(new java.awt.Color(153, 153, 153));
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/Icone_Sair.png"))); // NOI18N
        btnSair.setToolTipText("fecha essa tela");
        btnSair.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSair.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        getContentPane().add(btnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 0, 50, 50));

        tbProdutos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbProdutos.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        tbProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Produto ou Serviço", "Estoque", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbProdutos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tbProdutos.setSelectionForeground(new java.awt.Color(153, 153, 153));
        scpProdutos.setViewportView(tbProdutos);
        if (tbProdutos.getColumnModel().getColumnCount() > 0) {
            tbProdutos.getColumnModel().getColumn(0).setResizable(false);
            tbProdutos.getColumnModel().getColumn(1).setResizable(false);
            tbProdutos.getColumnModel().getColumn(2).setResizable(false);
            tbProdutos.getColumnModel().getColumn(3).setResizable(false);
        }

        getContentPane().add(scpProdutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 1040, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistarProdutoActionPerformed
        // TODO add your handling code here:
        criarProduto();
        preencherAtualizarTabela();
    }//GEN-LAST:event_btnRegistarProdutoActionPerformed

    private void btnDeletarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarProdutoActionPerformed
        deletar();
        preencherAtualizarTabela();
    }//GEN-LAST:event_btnDeletarProdutoActionPerformed

    private void btnPesquisarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarProdutoActionPerformed
        // TODO add your handling code here:
        telaPesquisa.setVisible(true);
    }//GEN-LAST:event_btnPesquisarProdutoActionPerformed

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

    private void txtQuantidadeProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantidadeProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantidadeProdutoActionPerformed

    private void txtValorProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorProdutoActionPerformed

    private void btnDesselecionarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesselecionarProdutoActionPerformed
        // TODO add your handling code here:
        limparProduto();
    }//GEN-LAST:event_btnDesselecionarProdutoActionPerformed

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
            java.util.logging.Logger.getLogger(GerenciamentoDeProdutosEServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GerenciamentoDeProdutosEServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GerenciamentoDeProdutosEServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GerenciamentoDeProdutosEServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new GerenciamentoDeProdutosEServico().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnDeletarProduto;
    private javax.swing.JToggleButton btnDesselecionarProduto;
    private javax.swing.JToggleButton btnLimparCampos;
    private javax.swing.JButton btnPesquisa;
    private javax.swing.JToggleButton btnPesquisarProduto;
    private javax.swing.JToggleButton btnRefersh;
    private javax.swing.JButton btnRegistarProduto;
    private javax.swing.JToggleButton btnSair;
    private javax.swing.JComboBox<String> cbmCampoPesquisa;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblCampoPesquisa;
    private javax.swing.JLabel lblNomeProduto;
    private javax.swing.JLabel lblProduto;
    private javax.swing.JLabel lblProdutoSelecionado;
    private javax.swing.JLabel lblQuantidadeProduto;
    private javax.swing.JLabel lblValorPesquisa;
    private javax.swing.JLabel lblValorProduto;
    private javax.swing.JScrollPane scpProdutos;
    private javax.swing.JTable tbProdutos;
    private javax.swing.JFrame telaPesquisa;
    private javax.swing.JTextField txtCampoPesquisa;
    private javax.swing.JTextField txtNomeProduto;
    private javax.swing.JTextField txtQuantidadeProduto;
    private javax.swing.JFormattedTextField txtValorProduto;
    // End of variables declaration//GEN-END:variables
    private void criarProduto() {
        int numeroEstoqueNumero;
        float numeroValorNumero;
        String nome = txtNomeProduto.getText().trim();
        String estoque = txtQuantidadeProduto.getText().trim();
        String valorNumero = numeroEmString.pegaNumeroDaString(txtValorProduto.getText().trim());
        try {
            numeroEstoqueNumero = Integer.parseInt(estoque);
            numeroValorNumero = Float.parseFloat(valorNumero);

        } catch (NumberFormatException e) {
            if (!estoque.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "O campo QUANTIDADE PRODUTO contem caractere invalido.");

            } else if (!valorNumero.matches("\\d+(\\.\\d+)?")) {
                JOptionPane.showMessageDialog(null, "O campo QUANTIDADE PRODUTO contem caractere invalido.");
            }
            System.out.println("O campo valor e quantidade devem ser um número válido." + e.getMessage());
            return;
        }
        ProdutoEServico produtoEServico = new ProdutoEServico(nome, numeroEstoqueNumero, numeroValorNumero);
        tipoService.salvarProduto(getIdSelecionado(), produtoEServico);
        limparProduto();
    }

    private void preencherAtualizarTabela() {
        tipoService.preencherTabelaProduto(tbProdutos);
    }

    private void deletar() {
        if (validaDelecao()) {
            tipoService.deletarProdutoService(getIdSelecionado());
        }
    }

    private void pesquisar() {
        String campo = (String) cbmCampoPesquisa.getSelectedItem();
        String valor = numeroEmString.pegaNumeroDaString(txtCampoPesquisa.getText());
        if (campo.equals("Id") || campo.equals("Estoque") || campo.equals("Valor")) {
            try {
                int id = Integer.parseInt(valor);
                int estoque = Integer.parseInt(valor);
                float valorDinheiro = Float.parseFloat(valor);
            } catch (NumberFormatException e) {
                if (campo.equals("Id")) {
                    JOptionPane.showMessageDialog(null, "O campo ID possui um caractere invalido.");

                } else if (campo.equals("Estoque")) {
                    JOptionPane.showMessageDialog(null, "O campo QUANTIDADE PRODUTO possui um caractere invalido.");

                } else if (campo.equals("Valor")) {
                    JOptionPane.showMessageDialog(null, "O campo VALOR PRODUTO possui um caractere invalido.");
                }
                System.out.println("um dos campos de pesquisa possui erro." + e.getMessage());
                return;
            }
        }
        tipoService.pesquisaProduto(campo, valor, tbProdutos);
    }

    private void selecionarProduto() {
        tbProdutos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int index = tbProdutos.getSelectedRow();
                    if (index != -1) {
                        idSelecionado = (int) tbProdutos.getValueAt(index, 0);
                        ProdutoEServico produto = tipoService.retornaIdProdutoEServico(getIdSelecionado());
                        lblProduto.setText(produto.getNome());
                        txtNomeProduto.setText(produto.getNome());
                        txtQuantidadeProduto.setText(String.valueOf(produto.getEstoque()));
                        txtValorProduto.setText(String.valueOf(produto.getValor()));
                    }
                }
            }
        });
    }

    private boolean validaDelecao() {
        if (getIdSelecionado() < 0) {
            JOptionPane.showInternalMessageDialog(null, "Selecione um PRODUTO/ SERVIÇO antes de ser excluido");
            return false;
        }
        return true;
    }

    private void limparProduto() {
        lblProduto.setText("");
        txtNomeProduto.setText("");
        txtQuantidadeProduto.setText("");
        txtValorProduto.setText("");
        idSelecionado = -1;
    }

    private void limparCampos() {
        txtNomeProduto.setText("");
        txtQuantidadeProduto.setText("");
        txtValorProduto.setText("");
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
        return tbProdutos;
    }

    public int getIdSelecionado() {
        return idSelecionado;
    }
}