package Poligons;

public class Triangle extends Point{

	// variáveis de instancia 
	private double ladoA;
	private double ladoB;
	private double ladoC;
	private String tipo;
	private double[] angulos = new double[3];
	
	// Primeiro construtor o qual atribui valores iniciais para
	// o tamanho dos lados
	public Triangle () {
		setSides(1.0, 1.0, 1.0);		
	}
	
	// Segundo construtor que inicia os lados com os parâmetros recebidos
	public Triangle (double a, double b, double c) {
		this ();
		
		if (isTriangle(a, b, c)) // Verifica se os lados fornecidos formam un triangulo
			setSides(a, b, c);
		else 					// Senão informa que o triangulo padrão foi criado
			System.out.println("As medidas fornecidas não formam um triangulo "
					+ "\nTriangulo padrão criado");
	}
	
	// Metodos de acesso para obter o valor armazenado nos lados separadamente
	public double getASide (){
		return ladoA;
	}
	
	public double getBSide (){
		return ladoB;
	}
	
	public double getCSide (){
		return ladoC;
	}
	
	// Metodo para atribuir um novo valor para os tres lados
	public void setSides (double a,  double b, double c){
		this.ladoA = a;
		this.ladoB = b;
		this.ladoC = c;	
		setTipo ();
		setAngulos ();
	}
	
	// Metodo que fornece uma string com os dados do objeto
	public String toString (){
		return "Triangulo: lados (" + ladoA + ", " + ladoB + ", " + ladoC + ") tipo = " 
				+ tipo + " perímetro = " + getPerimetro() + " área = " + getArea()+ " "
				+ getAngulos() + " " + super.toString();
	}
	
	// Metodo que computa o perimetro do triangulo 
	public double getPerimetro() {
		return ladoA + ladoB + ladoC;
	}

	// Metodo que computa a area do triangulo
	public double getArea (){
		double semip = getPerimetro() / 2;
		
		return Math.sqrt(semip * (semip - ladoA) * (semip - ladoB) * (semip - ladoC));
	}
	
	// Metodo que verifica se e possivel formar um triangulo com os lados fornecidos
	public Boolean isTriangle (double a, double b, double c) {
		Boolean is = true;
		if (a > b && a > c){
			if (a > (b + c))
				is = false;
		}
		else if (b > a && b > c){
			if (b > (a + c))
				is = false;
		}
		else if (c > b && c > a){
			if (c > (b + a))
				is = false;
		}
		
		return is;	
	}
	
	// Ordena um vetor de exatamente 3 posicoes
	public void ordena (double[] vetor3){
		double  aux;
		
		if (vetor3[0] < vetor3[1]){
			aux = vetor3[0];
			vetor3[0] = vetor3[1];
			vetor3[1] = aux;			
		}
		if (vetor3[0] < vetor3[2]){
			aux = vetor3[0];
			vetor3[0] = vetor3[2];
			vetor3[2] = aux;			
		}
		if (vetor3[1] < vetor3[2]){
			aux = vetor3[1];
			vetor3[1] = vetor3[2];
			vetor3[2] = aux;			
		}
	}
	
	// Metodos de acesso para obter o tipo do triangulo
	private String getTipo () {
		return tipo;
	}
	
	// Metodo que verifiica e armazena o tipo do triangulo criado
	private void setTipo () {
		double[]  lados = {ladoA, ladoB, ladoC};
				
		// Ordena os tamanhos
		ordena(lados); 
		
		
		// Define o tipo de triangulo
		if (lados[0] == lados[1] && lados[0] == lados[2]){
			this.tipo = "Equilátero";
		}
		else if (lados[0] == lados[1] || lados[1] == lados[2]){
			this.tipo = "Isóceles";
		}
		else if ((lados[0]*lados[0]) == (lados[1]*lados[1] + lados[2]*lados[2])){
			this.tipo = "Retângulo";
		}
		else{
			this.tipo = "Escaleno";
		}
	}

	// Metodo que fornece uma string com os angulos do triangulo
	public String getAngulos() {
		return "angulos (" + angulos[0]+","+ angulos[1]+","+ angulos[2]+")";
	}

	// Metodo que computa e armazena os angulos do triangulo criado
	private void setAngulos() {
		if (tipo == "Equilátero"){
			angulos[0] = angulos[1] = angulos[2] = 60.0;
		}
		else {
			double area = getArea();
			
			angulos[0] = Math.asin((2 * area) / (ladoB * ladoC)) * (180.0 / Math.PI); 
			angulos[1] = Math.asin((2 * area) / (ladoA * ladoC)) * (180.0 / Math.PI); 
			angulos[2] = 180.0 - angulos[0] - angulos[1]; 
			
			ordena(angulos);
		}
	}
}
