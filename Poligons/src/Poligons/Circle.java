package Poligons;

public class Circle extends Point{

	// variáveis de instancia 
	private double radius;
	private String color;
	private double perimetro;
	
	// Primeiro construtor o qual atribui valores iniciais a ambos: radius e color .
	public Circle() {
	
		setRadius(1.0);
		setColor("red");
	}
	
	// Segundo construtor que inicia radius com o parâmetro recebido, e matem color com
	// o valor padrão definido.
	public Circle(double r) {
	
		this( ); 
		setRadius(r);
	}
	
	// Construtor capaz de criar instancia de Circle com valores dados para o raio e cor.
	public Circle (double r, String c) {
		
		this( ); 
		setRadius(r);
		setColor(c);
	}
	
	// Metodo de acesso para obter o valor armazenado em radius
	public double getRadius() { 
		return radius;
	}
	
	// Metodo para atribuir um novo valor para radius e calcular novo comprimento
	public void setRadius(double r) {
		this.radius = r;
		calcPerimetro();
	}
	
	// Metodo que atribui um valor para o comprimento do circulo 
	private void calcPerimetro (){
		this.perimetro =  2.0 * radius * Math.PI; 
	}
	
	// Metodo de acesso para obter o valor armazenado em length
	public double getPerimetro() {
		return perimetro;
	}
	// Metodo de acesso para computar a área de um circulo.
	public double getArea() {
	
		return radius*radius*Math.PI; // PI é a constante de Math é a classe onde PI é definido.
	}

	// Metodo de acesso para obter o valor armazenado em color
	public String getColor() {
		return color;
	}

	// Metodo para atribuir um novao valor para color
	public void setColor(String c) {
		this.color = c;
	}

	// Metodo que fornece uma string com todos os dados do objeto
	public String toString() {
		return "Circulo: raio = " + radius + " cor = " + color + " " + super.toString()
				+ " area = " + getArea() + " comprimento = " +  getPerimetro();
	}
}
