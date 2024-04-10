/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GerenciadorDeHoteis.Service;

import GerenciadorDeHoteis.Types.Funcionario;
import GerenciadorDeHoteis.Types.Quarto;
import GreneciadorDeHoteis.Repository.TipoRepository;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcos
 */
public class TipoService {
    
    private TipoRepository tipoRepository;
    
    public TipoService(){
        this.tipoRepository = new TipoRepository();
    }
    
    //Service Funcionario
    private boolean validaDadosFuncionario(Funcionario funcionario) {
	if (funcionario.getNome() == null || funcionario.getSobrenome() == null || funcionario.getSenha() == null || funcionario.getTelefone() == null || funcionario.getCpf() == null) {
            JOptionPane.showInternalMessageDialog(null, "Um dos campos esta nulo.");
            return false;
        
	} else if (funcionario.getNome().trim().isBlank() || funcionario.getSobrenome().trim().isBlank() || funcionario.getSenha().trim().isBlank() 
                || funcionario.getTelefone().trim().isBlank() || funcionario.getCpf().trim().isBlank()) {
            JOptionPane.showInternalMessageDialog(null, "Um dos campos esta em branco.");
            return false;

	} else if (funcionario.getNome().length() > 50 || funcionario.getSobrenome().length() > 50) {
            JOptionPane.showInternalMessageDialog(null,"O nome ou sobrenome não pode conter mais de 50 caracteres");
            return false;
        
	}else if ( funcionario.getTelefone().length() > 14){
            JOptionPane.showInternalMessageDialog(null,"O telefone não pode conter mais de 11 caracteres");
            return false;

        }else if(funcionario.getCpf().length() > 14){
            JOptionPane.showInternalMessageDialog(null,"A senha não pode ter mais de 11 caracteres");
            return false;
        }
        
        if(!validaFormatoCampoTextoFuncionario(funcionario)){
            System.out.println("um dos campos de formato de texto esta errado");
            return false;
        }
        
	if (!validaDuplicidadeDadosFuncionario(funcionario)) {
            JOptionPane.showInternalMessageDialog(null, "Ja existe um funcionário com o mesmo CPF");
            return false;
	}
		
	return true;
    }
    
    public boolean validaFormatoCampoTextoFuncionario(Funcionario funcionario){
        boolean nomeValido = funcionario.getNome().matches("[a-zA-Z]+");
        boolean sobreNomeValido = funcionario.getSobrenome().matches("[a-zA-Z]+");
        boolean cpfValido = funcionario.getCpf().trim().matches("^(?!\\d+$)(?!\\d+-\\d+$)\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$");
        boolean telefoneValido = funcionario.getTelefone().matches("\\(\\d{2}\\)\\d{4,5}-\\d{4}");
       
        if(!nomeValido || !sobreNomeValido){
             JOptionPane.showInternalMessageDialog(null, "Nome ou Sobrenome contem caracteres invalidos");
             return false;
        }
        
        if(!cpfValido){
             JOptionPane.showInternalMessageDialog(null, "CPF contem caracteres invalidos");
             return false;
        }
        
        if(!telefoneValido){
            JOptionPane.showInternalMessageDialog(null, "Telefone contem caracteres invalidos");
             return false;
        }
        return true;   
    }
    
    public boolean validaDuplicidadeDadosFuncionario(Funcionario funcionario) {
        Funcionario funcionarioExistente = tipoRepository.buscarPorCPFFuncionario(funcionario.getCpf());
        if(funcionarioExistente != null ){
            System.out.println("Ja existe um funcionário com o mesmo CPF");
            return false;
        }
        return true;
    }
    
    public void salvarFuncionario(Funcionario funcionario) {
	System.out.println("Cadastrando o tipo...");
        if ( validaDadosFuncionario(funcionario) ) {
            System.out.println("Dados validados com sucesso");
            if (funcionario.getId() == null) {
                System.out.println("Inserindo os dados");
                tipoRepository.inserirFuncionario(funcionario);
            }
	}   
    }
    
    //Service Quartos
    private boolean validaDadosQuarto(Quarto quarto){
        if (quarto.getNome().trim().isEmpty() || quarto.getNumeroCamas() < 0) {
            JOptionPane.showInternalMessageDialog(null, "Um dos campos esta nulo.");
            return false;
        
	} else if (quarto.getNome().trim().isBlank()) {
            JOptionPane.showInternalMessageDialog(null, "O campo Nome de Quarto esta em branco.");
            return false;

	} else if (quarto.getNome().length() > 50) {
            JOptionPane.showInternalMessageDialog(null,"O nome ou sobrenome não pode conter mais de 50 caracteres");
            return false;
        
	}else if ( quarto.getNumeroCamas() > 10 || quarto.getNumeroCamas() < 1){
            JOptionPane.showInternalMessageDialog(null,"O numero de camas não pode ser maior que 10 e menor que 1");
            return false;
        }
        
        if(!validaFormatoCampoTextoQuarto(quarto)){
            System.out.println("um dos campos de formato de texto esta errado");
            return false;
        }
        
	if (!validaDuplicidadeDadosQuarto(quarto)) {
            JOptionPane.showInternalMessageDialog(null, "Ja existe um quarto com o mesmo nome");
            return false;
	}	
	return true;
    }
    
    public boolean validaDuplicidadeDadosQuarto(Quarto quarto) {
        Quarto quartoExistente = tipoRepository.buscarPorNomeQuarto(quarto.getNome());
        if(quartoExistente != null ){
            System.out.println("Ja existe um quarto com o mesmo nome");
            return false;
        }
        return true;
    }
    
    public boolean validaFormatoCampoTextoQuarto(Quarto quarto){
        String numeroCamasValidoString = String.valueOf(quarto.getNumeroCamas());
        boolean nomeValido = quarto.getNome().matches("[a-zA-Z0-9]+");  
        boolean numeroCamasValido =  numeroCamasValidoString.matches("[0-9]+");
       
        if(!nomeValido){
             JOptionPane.showInternalMessageDialog(null, "Nome contem caracteres invalidos");
             return false;
        }
        
        if(!numeroCamasValido){
             JOptionPane.showInternalMessageDialog(null, "Numero de camas contem caracteres invalidos");
             return false;
        }
        
        return true;   
    }   
    
    public void salvarQuarto(Quarto quarto){
        System.out.println("Cadastrando o tipo...");
        if ( validaDadosQuarto(quarto) ) {
            System.out.println("Dados validados com sucesso");
            if (quarto.getId() == null) {
                System.out.println("Inserindo os dados");
                tipoRepository.inserirQuarto(quarto);
            }
	}   
    }
    
    // Criptografa senha
    public String criptografarSenha(String senha) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(senha.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Erro ao criptografar senha: " + e.getMessage());
            return null;
        }
    }  
}
