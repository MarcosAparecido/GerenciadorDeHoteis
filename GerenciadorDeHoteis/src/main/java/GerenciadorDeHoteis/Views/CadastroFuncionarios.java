/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GerenciadorDeHoteis.Views;

import GerenciadorDeHoteis.Service.TipoService;
import GerenciadorDeHoteis.Entity.Funcionario;
import GerenciadorDeHoteis.Utils.SenhaUtil;
import GerenciadorDeHoteis.Utils.ValidacaoUtil;
import static GerenciadorDeHoteis.Views.GerenciamentoCheckInCheckOut.setCpfFuncionario;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcos
 */
public class CadastroFuncionarios extends javax.swing.JFrame {

    private TipoService tipoService = new TipoService();
    private int idSelecionado = -1;

    /**
     * Creates new form CadastroFuncionarios
     */
    public CadastroFuncionarios() {
        initComponents();
        this.setLocationRelativeTo(null);
        selecionarFuncionario();
        preencherAtualizarTabela();
        getIdSelecionado();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtNome = new javax.swing.JTextField();
        txtSobrenome = new javax.swing.JTextField();
        txtCpf = new javax.swing.JFormattedTextField();
        txtTelefone = new javax.swing.JFormattedTextField();
        txtSenha = new javax.swing.JPasswordField();
        txtSalario = new javax.swing.JFormattedTextField();
        txtEmail = new javax.swing.JTextField();
        txtConfirmacao = new javax.swing.JPasswordField();
        lblNome = new javax.swing.JLabel();
        lbSelecionado = new javax.swing.JLabel();
        lblCpf = new javax.swing.JLabel();
        lblTelefone = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        lblConfimacao = new javax.swing.JLabel();
        lblSenha1 = new javax.swing.JLabel();
        lbFuncionarioSelecionado1 = new javax.swing.JLabel();
        lblMargem = new javax.swing.JLabel();
        btnPesquisar = new javax.swing.JButton();
        lblImagem = new javax.swing.JLabel();
        lblSobrenome1 = new javax.swing.JLabel();
        lblSalario = new javax.swing.JLabel();
        btnDesselecionar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        lblDadosGerais = new javax.swing.JLabel();
        lblMargensBotoes = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbFuncionarios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CADASTRO DE FUNCIONÁRIO");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNome.setBackground(new java.awt.Color(153, 153, 153));
        txtNome.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtNome.setToolTipText("Nome do Funcionario");
        txtNome.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, 220, 30));

        txtSobrenome.setBackground(new java.awt.Color(153, 153, 153));
        txtSobrenome.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtSobrenome.setToolTipText("Sobrenome do Funcionario");
        txtSobrenome.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtSobrenome.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(txtSobrenome, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 150, 220, 30));

        txtCpf.setBackground(new java.awt.Color(153, 153, 153));
        txtCpf.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCpf.setToolTipText("CPF do Funcionario");
        txtCpf.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtCpf.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCpfActionPerformed(evt);
            }
        });
        jPanel1.add(txtCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 220, 30));

        txtTelefone.setBackground(new java.awt.Color(153, 153, 153));
        txtTelefone.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefone.setToolTipText("Telefone do Funcionario");
        txtTelefone.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtTelefone.setFont(new java.awt.Font("Arial Narrow", 0, 12)); // NOI18N
        txtTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefoneActionPerformed(evt);
            }
        });
        jPanel1.add(txtTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 220, 220, 30));

        txtSenha.setBackground(new java.awt.Color(153, 153, 153));
        txtSenha.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtSenha.setToolTipText("Digite Senha Desejada");
        txtSenha.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtSenha.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaActionPerformed(evt);
            }
        });
        jPanel1.add(txtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 360, 220, 30));

        txtSalario.setBackground(new java.awt.Color(153, 153, 153));
        txtSalario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtSalario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        txtSalario.setToolTipText("Salario Funcionario");
        txtSalario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtSalario.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtSalario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalarioActionPerformed(evt);
            }
        });
        jPanel1.add(txtSalario, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 290, 220, 30));

        txtEmail.setBackground(new java.awt.Color(153, 153, 153));
        txtEmail.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtEmail.setToolTipText("Digite Senha do Funcionario");
        txtEmail.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 290, 220, 30));

        txtConfirmacao.setBackground(new java.awt.Color(153, 153, 153));
        txtConfirmacao.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtConfirmacao.setToolTipText("Cofirme a Senha Desejada");
        txtConfirmacao.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtConfirmacao.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtConfirmacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConfirmacaoActionPerformed(evt);
            }
        });
        jPanel1.add(txtConfirmacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 360, 220, 30));

        lblNome.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        lblNome.setText("Nome:");
        jPanel1.add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 50, 30));

        lbSelecionado.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jPanel1.add(lbSelecionado, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, 330, 30));

        lblCpf.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        lblCpf.setText("CPF:");
        jPanel1.add(lblCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, 40, 30));

        lblTelefone.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        lblTelefone.setText("Telefone:");
        jPanel1.add(lblTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 220, 70, 30));

        lblSenha.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        lblSenha.setText("E-mail:");
        jPanel1.add(lblSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 290, 50, 30));

        lblConfimacao.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        lblConfimacao.setText("Confirmar :");
        jPanel1.add(lblConfimacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 360, 90, 30));

        lblSenha1.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        lblSenha1.setText("Senha:");
        jPanel1.add(lblSenha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 360, 60, 30));

        lbFuncionarioSelecionado1.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        lbFuncionarioSelecionado1.setText("Funcionário:");
        jPanel1.add(lbFuncionarioSelecionado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 80, 30));

        lblMargem.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        lblMargem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMargem.setText("Cadastrar Funcionários");
        lblMargem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lblMargem, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 40));

        btnPesquisar.setBackground(new java.awt.Color(153, 153, 153));
        btnPesquisar.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/Icone_Pesquisar.png"))); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(btnPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 110, 40));

        lblImagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/funcionarios (1).png"))); // NOI18N
        lblImagem.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.add(lblImagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 130, 120));

        lblSobrenome1.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        lblSobrenome1.setText("Sobrenome:");
        jPanel1.add(lblSobrenome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 150, 80, 30));

        lblSalario.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        lblSalario.setText("Salário R$:");
        jPanel1.add(lblSalario, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, 80, 30));

        btnDesselecionar.setBackground(new java.awt.Color(153, 153, 153));
        btnDesselecionar.setFont(new java.awt.Font("Arial Narrow", 0, 10)); // NOI18N
        btnDesselecionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/Icone_Desmarcar.png"))); // NOI18N
        btnDesselecionar.setText("Desselecionar");
        btnDesselecionar.setToolTipText("Limpar Campo");
        btnDesselecionar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDesselecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesselecionarActionPerformed(evt);
            }
        });
        jPanel1.add(btnDesselecionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 370, 110, 40));

        btnLimpar.setBackground(new java.awt.Color(153, 153, 153));
        btnLimpar.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/Icone_LimparTela.png"))); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.setToolTipText("Limpar Campo");
        btnLimpar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, 110, 40));

        btnSalvar.setBackground(new java.awt.Color(153, 153, 153));
        btnSalvar.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/Icone_Salvar.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setToolTipText("Finaliza o Cadastro");
        btnSalvar.setActionCommand("");
        btnSalvar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 110, 40));

        btnSair.setBackground(new java.awt.Color(153, 153, 153));
        btnSair.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/Icone_Sair_1.png"))); // NOI18N
        btnSair.setToolTipText("Finaliza o Cadastro");
        btnSair.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSair.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        jPanel1.add(btnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 0, 60, 40));

        lblDadosGerais.setBackground(new java.awt.Color(204, 204, 204));
        lblDadosGerais.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados Gerais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Narrow", 0, 14))); // NOI18N
        jPanel1.add(lblDadosGerais, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 700, 400));

        lblMargensBotoes.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.add(lblMargensBotoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 130, 250));

        tbFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Nome", "Cpf", "Salario", "Status"
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
        jScrollPane1.setViewportView(tbFuncionarios);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 490, 960, 310));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, 0, 1000, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtConfirmacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConfirmacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtConfirmacaoActionPerformed

    private void txtCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCpfActionPerformed

    private void txtTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefoneActionPerformed

    private void txtSalarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalarioActionPerformed

    private void txtSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSenhaActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        criarFuncionario();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnDesselecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesselecionarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDesselecionarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        // TODO add your handling code here:
        limparCampos();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // TODO add your handling code here:
        this.dispose();
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new CadastroFuncionarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDesselecionar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbFuncionarioSelecionado1;
    private javax.swing.JLabel lbSelecionado;
    private javax.swing.JLabel lblConfimacao;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblDadosGerais;
    private javax.swing.JLabel lblImagem;
    private javax.swing.JLabel lblMargem;
    private javax.swing.JLabel lblMargensBotoes;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSalario;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblSenha1;
    private javax.swing.JLabel lblSobrenome1;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JTable tbFuncionarios;
    private javax.swing.JPasswordField txtConfirmacao;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtSalario;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtSobrenome;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables

    private void criarFuncionario() {
        SenhaUtil senhaUtils = new SenhaUtil();
        ValidacaoUtil validacaoUtil = new ValidacaoUtil();
        double salarioNumero = 0;

        String nome = txtNome.getText();
        String sobrenome = txtSobrenome.getText();
        String cpf = txtCpf.getText();
        String telefone = txtTelefone.getText();
        String senha = txtSenha.getText();
        String confirmacao = txtConfirmacao.getText();
        String salario = txtSalario.getText();
        try {
            salarioNumero = Double.parseDouble(salario);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Numero inválido");
        }
        if (!validacaoUtil.validaConfirmacaoSenha(senha, confirmacao, txtConfirmacao) && validacaoUtil.validaTamanhoSenhaFuncionario(txtSenha)) {
            JOptionPane.showMessageDialog(null, "As senhas não coincidem, Por favor digite novamente!");
            txtConfirmacao.setText("");
            return;
        }
        Funcionario funcionario = new Funcionario(nome, sobrenome, telefone, cpf, salarioNumero, senhaUtils.criptografarSenha(senha), true);
        tipoService.salvarFuncionario(funcionario);
        setCpfFuncionario(cpf);
        limparCampos();
    }

    private void selecionarFuncionario() {
        tbFuncionarios.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int index = tbFuncionarios.getSelectedRow();
                    if (index != -1) {
                        idSelecionado = (int) tbFuncionarios.getValueAt(index, 0);
                        Funcionario funcionario = tipoService.retornaIdFuncionario(getIdSelecionado());

                        txtNome.setText(funcionario.getNome());
                        txtSobrenome.setText(funcionario.getSobrenome());
                        txtCpf.setText(funcionario.getCpf());
                        txtTelefone.setText(funcionario.getTelefone());
                        txtSalario.setText(String.valueOf(funcionario.getSalario()));
                        // txtEmail.setText(funcionario.getEmail());

                    }
                }
            }
        });
    }

    private int getIdSelecionado() {
        return idSelecionado;
    }

    private void preencherAtualizarTabela() {
        tipoService.preencherTabelaFuncionario(tbFuncionarios);
    }

    private void limparCampos() {
        txtNome.setText("");
        txtSenha.setText("");
        txtConfirmacao.setText("");
        txtCpf.setText("");
        txtTelefone.setText("");
        txtSalario.setText("");
        txtEmail.setText("");
        txtSobrenome.setText("");
    }
}
