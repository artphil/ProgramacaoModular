package Editora;

public class Assinatura extends Item{
	
	// Variaveis de campo
	private Publicacao periodico;
	private int edicaoInicial;
	private int numeroAssinat;
	private Cliente assinante;
	
	// Construtor
	public Assinatura (Cliente cliente, Publicacao publicacao) {
		setPeriodico(publicacao);
		setAssinante(cliente);
		setChave(assinante.getNome() + periodico.getNome());
	}

	// Metodos de recuperação de dados (Get)
	public Publicacao getPeriodico() {
		return periodico;
	}
	
	public int getEdicaoInicial() {
		return edicaoInicial;
	}
	
	public int getNumeroAssinat() {
		return numeroAssinat;
	}

	public Cliente getAssinante() {
		return assinante;
	}
	
	// Metodos de atribuição de valor (Set)	
	public void setPeriodico(Publicacao periodico) {
		this.periodico = periodico;
	}	

	public void setEdicaoInicial(int edicaoInicial) {
		this.edicaoInicial = edicaoInicial;
	}
	
	public void setNumeroAssinat(int numeroAssinat) {
		this.numeroAssinat = numeroAssinat;
	}

	public void setAssinante(Cliente assinante) {
		this.assinante = assinante;
	}

	// Metodo toString
	public String toString () {
		return "\nAssinatura:" + assinante + periodico + "\nEdição inicial: " + edicaoInicial + "\nNumero de exemplares: " + numeroAssinat;
	}
}
