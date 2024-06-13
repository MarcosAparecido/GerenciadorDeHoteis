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
public class GerenciamentoDeQuarto extends javax.swing.JFrame {
    private int idSelecionado = -1;
    private TipoService tipoService = new TipoService();

    /**
     * Creates new form GerenciamentoDeQuarto
     */
    public GerenciamentoDeQuarto() {
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
        jPanel2 = new javax.swing.JPanel();
        lblValorPesquisa = new javax.swing.JLabel();
        txtCampoPesquisa = new javax.swing.JTextField();
        btnPesquisa = new javax.swing.JButton();
        cbmCampoPesquisa = new javax.swing.JComboBox<>();
        lblCampoPesquisa = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblTipoQuarto = new javax.swing.JLabel();
        btnRefersh = new javax.swing.JToggleButton();
        lblNomeQuarto = new javax.swing.JLabel();
        lblQuartoSelecionado = new javax.swing.JLabel();
        lblQuarto = new javax.swing.JLabel();
        lblNumeroCamas = new javax.swing.JLabel();
        txtNomeQuarto = new javax.swing.JTextField();
        cmbTipoQuarto = new javax.swing.JComboBox<>();
        txtNumeroCamas = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnPesquisarQuarto = new javax.swing.JToggleButton();
        btnDesselecionarQuarto = new javax.swing.JToggleButton();
        btnLimparCampos = new javax.swing.JToggleButton();
        btnDeletar = new javax.swing.JToggleButton();
        scpQuartos = new javax.swing.JScrollPane();
        tbQuartos = new javax.swing.JTable();
        lblMargem = new javax.swing.JLabel();
        lblImagem = new javax.swing.JLabel();
        lblDadosGerais = new javax.swing.JLabel();
        lblMargensBotoes = new javax.swing.JLabel();

        telaPesquisa.setTitle("PESQUISA DE QUARTO");
        telaPesquisa.setResizable(false);
        telaPesquisa.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setForeground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblValorPesquisa.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        lblValorPesquisa.setText("Valor da Pesquisa:");
        jPanel2.add(lblValorPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 100, 30));

        txtCampoPesquisa.setBackground(new java.awt.Color(153, 153, 153));
        txtCampoPesquisa.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtCampoPesquisa.setToolTipText("valor do campo que quer pesquisar");
        txtCampoPesquisa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtCampoPesquisa.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.add(txtCampoPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 270, 30));

        btnPesquisa.setBackground(new java.awt.Color(153, 153, 153));
        btnPesquisa.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        btnPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/Icone_Pesquisar.png"))); // NOI18N
        btnPesquisa.setText("Pesquisar");
        btnPesquisa.setToolTipText("efetua a pesquisa");
        btnPesquisa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPesquisa.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaActionPerformed(evt);
            }
        });
        jPanel2.add(btnPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 120, -1));

        cbmCampoPesquisa.setBackground(new java.awt.Color(102, 102, 102));
        cbmCampoPesquisa.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        cbmCampoPesquisa.setForeground(new java.awt.Color(102, 102, 102));
        cbmCampoPesquisa.setToolTipText("campo que deseja pesquisar");
        cbmCampoPesquisa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cbmCampoPesquisa.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.add(cbmCampoPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 270, 30));

        lblCampoPesquisa.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        lblCampoPesquisa.setText("Campo a Pesquisar :");
        jPanel2.add(lblCampoPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 110, -1));

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Pesquisar Quarto");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 420, -1));

        jLabel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Narrow", 0, 12))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 370, 250));

        telaPesquisa.getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 410));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GERENCIAMENTO DE QUARTO");
        setMaximumSize(new java.awt.Dimension(1060, 850));
        setMinimumSize(new java.awt.Dimension(1060, 850));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTipoQuarto.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        lblTipoQuarto.setText("Tipo de Quarto :");
        jPanel1.add(lblTipoQuarto, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 250, 110, 30));

        btnRefersh.setBackground(new java.awt.Color(153, 153, 153));
        btnRefersh.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        btnRefersh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/Icone_Atualizar_1.png"))); // NOI18N
        btnRefersh.setToolTipText("Recarrega a tabela");
        btnRefersh.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRefersh.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRefersh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefershActionPerformed(evt);
            }
        });
        jPanel1.add(btnRefersh, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 50, 40));

        lblNomeQuarto.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        lblNomeQuarto.setText("Nome do Quarto :");
        jPanel1.add(lblNomeQuarto, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 120, 30));

        lblQuartoSelecionado.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        lblQuartoSelecionado.setText("Quarto Selecionado :");
        jPanel1.add(lblQuartoSelecionado, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 140, -1));

        lblQuarto.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jPanel1.add(lblQuarto, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 110, 250, 30));

        lblNumeroCamas.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        lblNumeroCamas.setText("Nº de Camas :");
        jPanel1.add(lblNumeroCamas, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, 110, 30));

        txtNomeQuarto.setBackground(new java.awt.Color(153, 153, 153));
        txtNomeQuarto.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtNomeQuarto.setToolTipText("numero do quarto");
        txtNomeQuarto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtNomeQuarto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(txtNomeQuarto, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 190, 270, 30));

        cmbTipoQuarto.setBackground(new java.awt.Color(102, 102, 102));
        cmbTipoQuarto.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        cmbTipoQuarto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Solteiro", "Solteiro Duplo", "Quarto Casal", "Apartamento", "Suite" }));
        cmbTipoQuarto.setToolTipText("Tipo do quarto");
        cmbTipoQuarto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cmbTipoQuarto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cmbTipoQuarto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoQuartoActionPerformed(evt);
            }
        });
        jPanel1.add(cmbTipoQuarto, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 250, 200, 30));

        txtNumeroCamas.setBackground(new java.awt.Color(153, 153, 153));
        txtNumeroCamas.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtNumeroCamas.setToolTipText("Número de camas no quarto");
        txtNumeroCamas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtNumeroCamas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(txtNumeroCamas, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 320, 140, 30));

        btnSalvar.setBackground(new java.awt.Color(153, 153, 153));
        btnSalvar.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/Icone_Salvar_1.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setToolTipText("efetua o registro de um quarto");
        btnSalvar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 120, 40));

        btnPesquisarQuarto.setBackground(new java.awt.Color(153, 153, 153));
        btnPesquisarQuarto.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        btnPesquisarQuarto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/Icone_Pesquisar.png"))); // NOI18N
        btnPesquisarQuarto.setText("Pesquisar ");
        btnPesquisarQuarto.setToolTipText("Abre Tela de Pesquisa de Quarto");
        btnPesquisarQuarto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPesquisarQuarto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnPesquisarQuarto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarQuartoActionPerformed(evt);
            }
        });
        jPanel1.add(btnPesquisarQuarto, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 350, 120, 40));

        btnDesselecionarQuarto.setBackground(new java.awt.Color(153, 153, 153));
        btnDesselecionarQuarto.setFont(new java.awt.Font("Arial Narrow", 0, 12)); // NOI18N
        btnDesselecionarQuarto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/Icone_Desmarcar.png"))); // NOI18N
        btnDesselecionarQuarto.setText("Desscelecionar");
        btnDesselecionarQuarto.setToolTipText("Dessceleciona Quarto");
        btnDesselecionarQuarto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDesselecionarQuarto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesselecionarQuarto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesselecionarQuartoActionPerformed(evt);
            }
        });
        jPanel1.add(btnDesselecionarQuarto, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, 120, 40));

        btnLimparCampos.setBackground(new java.awt.Color(153, 153, 153));
        btnLimparCampos.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        btnLimparCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/Icone_LimparTela.png"))); // NOI18N
        btnLimparCampos.setText("Limpar ");
        btnLimparCampos.setToolTipText("Limpa Campos");
        btnLimparCampos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLimparCampos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLimparCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparCamposActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimparCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 120, 40));

        btnDeletar.setBackground(new java.awt.Color(153, 153, 153));
        btnDeletar.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        btnDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/excluir.png"))); // NOI18N
        btnDeletar.setText("Excluir");
        btnDeletar.setToolTipText("Exclui Quarto");
        btnDeletar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDeletar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });
        jPanel1.add(btnDeletar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 120, 40));

        scpQuartos.setBackground(new java.awt.Color(204, 204, 204));

        tbQuartos.setBackground(new java.awt.Color(204, 204, 204));
        tbQuartos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbQuartos.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        tbQuartos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome Quarto", "Tipo Do Quarto", "Nº De Camas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbQuartos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        scpQuartos.setViewportView(tbQuartos);
        if (tbQuartos.getColumnModel().getColumnCount() > 0) {
            tbQuartos.getColumnModel().getColumn(0).setResizable(false);
            tbQuartos.getColumnModel().getColumn(1).setResizable(false);
            tbQuartos.getColumnModel().getColumn(2).setResizable(false);
            tbQuartos.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel1.add(scpQuartos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 1040, 280));

        lblMargem.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        lblMargem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMargem.setText("Gerenciamento de Quarto");
        lblMargem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lblMargem, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 40));

        lblImagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/Icone_Quarto.png"))); // NOI18N
        lblImagem.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.add(lblImagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 140, 120));

        lblDadosGerais.setBackground(new java.awt.Color(204, 204, 204));
        lblDadosGerais.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados Quarto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Narrow", 0, 14))); // NOI18N
        jPanel1.add(lblDadosGerais, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 660, 370));

        lblMargensBotoes.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.add(lblMargensBotoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 140, 260));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 760));

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

    private void btnDesselecionarQuartoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesselecionarQuartoActionPerformed
        // TODO add your handling code here:
        limparQuarto();
    }//GEN-LAST:event_btnDesselecionarQuartoActionPerformed

    private void btnLimparCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparCamposActionPerformed
        // TODO add your handling code here:
        limparCampos();
    }//GEN-LAST:event_btnLimparCamposActionPerformed

    private void cmbTipoQuartoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoQuartoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTipoQuartoActionPerformed

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
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
    private javax.swing.JToggleButton btnDeletar;
    private javax.swing.JToggleButton btnDesselecionarQuarto;
    private javax.swing.JToggleButton btnLimparCampos;
    private javax.swing.JButton btnPesquisa;
    private javax.swing.JToggleButton btnPesquisarQuarto;
    private javax.swing.JToggleButton btnRefersh;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbmCampoPesquisa;
    private javax.swing.JComboBox<String> cmbTipoQuarto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblCampoPesquisa;
    private javax.swing.JLabel lblDadosGerais;
    private javax.swing.JLabel lblImagem;
    private javax.swing.JLabel lblMargem;
    private javax.swing.JLabel lblMargensBotoes;
    private javax.swing.JLabel lblNomeQuarto;
    private javax.swing.JLabel lblNumeroCamas;
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
            JOptionPane.showInternalMessageDialog(null, "O campo Nº DE CAMAS deve ser um número válido.");
            System.out.println("O campo Nº DE CAMAS deve ser um número válido." + e.getMessage());
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