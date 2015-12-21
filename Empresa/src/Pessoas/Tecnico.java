package Pessoas;

public class Tecnico extends Pessoa{

	private static int serial = 1000; 
	public static final String[] formacoes = {"Bombeiro", "Eletricista","Pedreiro", "Arquiteto", 
			"Tecnico em informática"};
	
	private int 	id;
	private int 	formacao;

	public Tecnico ()
	{
		id = ++serial;
	}
	
	public Tecnico (int numero)
	{
		id = numero;
		if (numero > serial)
			serial = numero;
	}
	
	public int getFormacao() 
	{
		return formacao;
	}
	
	public String getFormacaoString() 
	{
		return formacoes[formacao];
	}
	
	public int getId() 
	{
		return id;
	}
	
	public void setFormacao(int formacao) 
	{
		this.formacao = formacao;
	}
	
	public String imprime () 
	{
		return 	"#" + getId() + 
				"#" + getNome () + 
				"#" + getEmail () + 
				"#" + getEndereco () + 
				"#" + getTelefone () + 
				"#" + getDataNasc () + 
				"#" + getCPF () + 
				"#" + getIdentidade () + 
				"#"	+ getFormacao () + 
				"#\n";
	}
	
	public String toString ()
	{
		return "\nMatricula:	" + getId () 
				+ "\nNome:		" + getNome() 
				+ "\nEmail:		" + getEmail () 
				+ "\nEndereço:	" + getEndereco ()
				+ "\nTelefone:	" + getTelefone () 
				+ "\nNascimento:	" + getDataNasc ()
				+ "\nCPF:		" + getCPF () 
				+ "\nIdentidade:	" + getIdentidade () 
				+ "\nFormação:	" + getFormacaoString();
	}
	
}

