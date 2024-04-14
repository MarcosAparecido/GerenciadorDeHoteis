/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GerenciadorDeHoteis.Views;

import GerenciadorDeHoteis.Service.TipoService;
import GerenciadorDeHoteis.Types.Funcionario;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcos
 */
public class CadastroFuncionarios extends javax.swing.JFrame {

    TipoService tipoService = new TipoService();

    /**
     * Creates new form CadastroFuncionarios
     */
    public CadastroFuncionarios() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNome = new javax.swing.JTextField();
        txtSobrenome = new javax.swing.JTextField();
        txtCpf = new javax.swing.JFormattedTextField();
        txtTelefone = new javax.swing.JFormattedTextField();
        txtSenha = new javax.swing.JPasswordField();
        txtConfirmacao = new javax.swing.JPasswordField();
        lblNome = new javax.swing.JLabel();
        lblSobrenome = new javax.swing.JLabel();
        lblCpf = new javax.swing.JLabel();
        lblTelefone = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        lblConfimacao = new javax.swing.JLabel();
        lblCadastroFuncionarios = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        lblFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNome.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtNome.setToolTipText("nome do funcionario");
        getContentPane().add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 380, 30));

        txtSobrenome.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtSobrenome.setToolTipText("sobrenome do funcionario");
        getContentPane().add(txtSobrenome, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 380, 30));

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCpfActionPerformed(evt);
            }
        });
        getContentPane().add(txtCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 380, 30));

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefone.setToolTipText("telefone do usuario");
        txtTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefoneActionPerformed(evt);
            }
        });
        getContentPane().add(txtTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 219, 380, 30));

        txtSenha.setToolTipText("senha desejada");
        getContentPane().add(txtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 380, 30));

        txtConfirmacao.setToolTipText("cofirme a senha desejada");
        txtConfirmacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConfirmacaoActionPerformed(evt);
            }
        });
        getContentPane().add(txtConfirmacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, 380, 30));

        lblNome.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        lblNome.setText("Nome:");
        getContentPane().add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 70, 30));

        lblSobrenome.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        lblSobrenome.setText("Sobrenome:");
        getContentPane().add(lblSobrenome, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 120, 30));

        lblCpf.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        lblCpf.setText("Cpf:");
        getContentPane().add(lblCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 50, 30));

        lblTelefone.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        lblTelefone.setText("Telefone:");
        getContentPane().add(lblTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 100, 30));

        lblSenha.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        lblSenha.setText("Senha:");
        getContentPane().add(lblSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 70, 30));

        lblConfimacao.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        lblConfimacao.setText("Confirmar Senha:");
        getContentPane().add(lblConfimacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 170, 30));

        lblCadastroFuncionarios.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblCadastroFuncionarios.setText("Cadastro de funcionarios");
        getContentPane().add(lblCadastroFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 290, 40));

        btnSalvar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Julia\\Desktop\\Projeto imagens\\Icone_Salvar.png")); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setToolTipText("finaliza o cadastro");
        btnSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 360, 130, 30));

        btnSair.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnSair.setText("Voltar");
        btnSair.setToolTipText("volta a tela de login");
        btnSair.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        getContentPane().add(btnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 360, 130, 30));

        lblFundo.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblFundo.setText("Fundo");
        getContentPane().add(lblFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -10, 680, 910));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtConfirmacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConfirmacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtConfirmacaoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        criarUsuario();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void txtCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCpfActionPerformed

    private void txtTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefoneActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // TODO add your handling code here:
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
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel lblCadastroFuncionarios;
    private javax.swing.JLabel lblConfimacao;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblSobrenome;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JPasswordField txtConfirmacao;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtSobrenome;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables

    private void criarUsuario() {
        String nome = txtNome.getText();
        String sobrenome = txtSobrenome.getText();
        String cpf = txtCpf.getText();
        String telefone = txtTelefone.getText();
        String senha = txtSenha.getText();
        String confirmacao = txtConfirmacao.getText();

        if (senha.length() > 50) {
            JOptionPane.showMessageDialog(null, "A senha deve possuir menos de 50 caracteres");
            return;
        }

        if (!validaConfirmacaoSenha(senha, confirmacao)) {
            JOptionPane.showMessageDialog(null, "As senhas não coincidem, Por favor digite novamente!");
            return;
        }

        Funcionario funcionario = new Funcionario(nome, sobrenome, telefone, cpf, tipoService.criptografarSenha(senha));
        tipoService.salvarFuncionario(funcionario);
    }

    public boolean validaConfirmacaoSenha(String senha, String confirmacao) {
        if (!confirmacao.equals(senha)) {
            System.out.println("As senhas não coincidem");
            txtConfirmacao.setText("");
            return false;
        }
        return true;
    }
}
