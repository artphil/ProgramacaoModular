package Editora;

public class Etiqueta extends Item{
	
	// Variaveis de campo
	private Assinatura assinat;
	
	// Construtor
	public Etiqueta(Assinatura assinat) {
		setAssinat(assinat);
		setChave(assinat.getChave());
	}

	// Metodos de recuperação de dados (Get)
	public Assinatura getAssinat() {
		return assinat;
	}
	
	// Metodos de atribuição de valor (Set)
	public void setAssinat(Assinatura assinat) {
		this.assinat = assinat;
	}
	
	// Metodo toString
	public String toString () {
		return "\n" + assinat;
	} 

}
