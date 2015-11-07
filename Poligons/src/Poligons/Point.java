package Poligons;

public class Point {
	
	// variáveis de instancia 
	private float x;
	private float y;
	
	// construtor o qual atribui valores iniciais
	public Point (){
		setCoordenadas(0, 0);
	}
	
	// Metodo de acesso para obter o valor armazenado em x
	public float getX() {
		return x;
	}
	
	// Metodo de acesso para obter o valor armazenado em y
	public float getY() {
		return y;
	}
	 
	// Metodo para atribuir um novo valor para x e y
	public void setCoordenadas(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	// Metodo que fornece uma string com os dados do objeto
	public String toString (){
		return "coordenadas (" + x + ", " + y + ")";
	}
}
