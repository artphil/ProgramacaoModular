package Editora;

public class Editora {
	
	// Variaveis de campo
	private String nome;
	private String cnpj;
	private String endereco;
	
	// Metodos de recupera��o de dados (Get)
	public String getNome() {
		return nome;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	// Metodos de atribui��o de valor (Set)
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	// Metodo toString
	public String toString () {
		return "Editora:	" + nome + "\nCNPJ:		" + cnpj + "\nEnd:		" + endereco;
	}

}
