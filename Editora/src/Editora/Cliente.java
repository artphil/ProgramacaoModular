package Editora;

import javax.swing.JOptionPane;

public class Cliente extends Item{
	
	// Variaveis de campo
	private String nome;
	private String cpf;
	private String endereco;
	private String telefone;
	
	// Metodos de recuperação de dados (Get)
	public String getNome() {
		return nome;
	}
	
	public String getCPF() {
		return cpf;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public String getTelefone() {
		return telefone;
	}
		
	// Metodos de atribuição de valor (Set)
	public void setNome(String nome) {
		this.nome = nome;
		setChave(getNome());
	}
	
	public void setNome() {
		this.nome = JOptionPane.showInputDialog("Nome do cliente");
		setChave(getNome());
	}
		
	public void setCPF( String cpf) {
		this.cpf = cpf;
	}
	
	public void setCPF() {
		this.cpf = JOptionPane.showInputDialog("CPF do cliente");
	}
		
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public void setEndereco() {
		this.endereco = JOptionPane.showInputDialog("Endereço do cliente");
	}
		
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public void setTelefone() {
		this.telefone = JOptionPane.showInputDialog("Telefone do cliente");
	}
	
	// Metodo toString
	public String toString () {
		return "\nCliente:	" + nome + "\nCPF:		" + cpf + "\nEndereço:	" + endereco + "\nTelefone:	" + telefone;
	}
	
}
