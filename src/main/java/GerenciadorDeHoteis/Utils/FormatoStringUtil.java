/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GerenciadorDeHoteis.Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Marcos
 */
public class FormatoStringUtil {

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

    public boolean validaNumeroEmString(String nome) {
        String numero = pegaNumeroDaString(nome);
        if (numero == null || numero.isBlank() || numero.isEmpty()) {
            System.out.println("Nenhum número encontrado na string da validação.");
            return false;
        }
        return true;
    }
    
    public static String removerBarras(String texto) {
        return texto.replace("/", "");
    }
}
