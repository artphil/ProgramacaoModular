package Editora;


public class Lista {

	// Variaveis de campo
	public Item item;
	public Lista proximo;
	private int numItens;
	
	// Construtores
	public Lista (Item item) {
		this.item = item; 
		numItens++;
	}
	
	public Lista() {
		numItens = 0;
	}

	// Metodos de recuperação de dados (Get)
	public int getNumItens () {
		return numItens;
	}
	
	// Metodo para inserir elemento à lista
	public void insereItem (Item item) {
		
		Lista aux = this;
		
		while (aux.proximo != null) {
			aux = aux.proximo;
		}
		aux.proximo = new Lista (item);
		numItens++;
		System.out.println("Objeto inserido");
	}
	
	// Metodo para retirar elemento da lista
	public void retiraItem (Item item) {
		
		Lista aux = this;
	
		while (aux.proximo != null && !aux.proximo.item.equals(item)) {
			aux = aux.proximo;
		}
		if (aux.proximo == null) {
			System.out.println("Objeto não encontrado");
		} else {
			aux.proximo = aux.proximo.proximo;
			numItens--;
			System.out.println("Objeto retirado");
		}
		
	}
	 
	// Metodo para imprimir todos os elementos da lista
	public void imprime () {
		if (proximo != null) {
			
			System.out.println("Total: " + getNumItens());
			Lista aux = proximo;
			while (aux != null) {
				System.out.println(aux.item);
				aux = aux.proximo;
			} 
		} else {
			System.out.println("Não há itens inseridos");
		}
	}
	
	// Metodo para buscar um elemento na lista
	public Item Busca (String chave) {
		Lista aux = proximo;
		
		while (aux != null && !(chave.equals(aux.item.getChave())))
			aux = aux.proximo;
		
		if (aux != null){
			return aux.item;
		} else {
			System.out.println("Registro não encontrado");
			return null;
		}
	}

}
