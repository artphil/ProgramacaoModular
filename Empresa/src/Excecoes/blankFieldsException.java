package Excecoes;

import javax.swing.JOptionPane;

public class blankFieldsException extends Exception{
	
	public blankFieldsException(String message){
		super(message);
		//System.out.println("Erro");
		//JOptionPane.showMessageDialog(null, "Erro");
	}
}