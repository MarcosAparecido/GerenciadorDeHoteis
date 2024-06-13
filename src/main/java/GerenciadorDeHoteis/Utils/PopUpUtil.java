/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GerenciadorDeHoteis.Utils;

import javax.swing.JOptionPane;

/**
 *
 * @author Marcos
 */
public class PopUpUtil {
    
    public boolean confirmacaoPopUp(String nome) {
        int opcao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar o quarto " + nome + " ?", "Confirmar Deleção", JOptionPane.YES_NO_OPTION);
        return opcao == JOptionPane.YES_OPTION;
    }
}
