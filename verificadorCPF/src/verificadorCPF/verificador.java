package verificadorCPF;

import javax.swing.JOptionPane;

public class verificador {

	private static int opcao;
	private static int[] numero;
	private static int[] digito;
	private static int[] tamanho = { 9, 11 };
	private static String saida = " ";

	// programa principal
	public static void main(String[] args) {

		leOpcao();

		leCPF();

		if (opcao == 0) {
			validaCPF();
			imprime(opcao);
		} else {
			verificaCPF();
		}

	}

	// Lê a opção de programa que o usuário quer executar
	static void leOpcao() {

		String entrada,
				mensagem1 = "Digite a opção desejada \n 1 - obter digito para CPF\n 2 - verificar se CPF é valido",
				mensagem2 = "Opção invalida";

		entrada = JOptionPane.showInputDialog(mensagem1);
		opcao = Integer.parseInt(entrada);

		// Verifica se a pessoa digitou uma opção valida
		while (opcao < 1 || opcao > 2) {
			entrada = JOptionPane.showInputDialog(mensagem2 + "\n" + mensagem1);
			opcao = Integer.parseInt(entrada);
		}

		opcao--;

	}

	// Lê o CPF completo ou não e armazena
	static void leCPF() {

		String[] mensagem = new String[3];
		String entrada;
		char[] array = null;
		int[] num = new int[9];
		int[] dig = new int[2];

		mensagem[0] = "digite CPF (somente numeros) 'SEM' o digito";
		mensagem[1] = "digite CPF (somente numeros) 'COM' o digito";
		mensagem[2] = "valor incorreto";

		entrada = JOptionPane.showInputDialog(mensagem[opcao]);

		// Verifica se o usuário digitou o CPF correto por tamanho da entrada
		while (entrada.length() != tamanho[opcao])
			entrada = JOptionPane.showInputDialog(mensagem[2] + "\n" + mensagem[opcao]);

		// Transforma a string em um vetor de inteiros
		array = entrada.toCharArray();

		for (int i = 0; i < 9; i++) {

			num[i] = Character.getNumericValue(array[i]);
		}

		// Armazena a sequencia numérica
		setNumero(num);

		// Armazena o digito se necessário
		if (opcao == 1) {

			for (int i = 0; i < 2; i++) {

				dig[i] = Character.getNumericValue(array[i + 9]);
			}
			setDigito(dig);
		}
	}

	// Transforma o CPF em string para impressão
	static void geraSaida() {

		for (int i = 0; i < 9; i++) {

			saida = saida + numero[i];
		}

		saida = saida + "-";
		for (int i = 0; i < 2; i++) {

			saida = saida + digito[i];
		}
	}

	// Imprime em tela o CPF válido
	static void imprime(int op) {

		String[] mensagem = { "CPF: ", "CPF válido.\n CPF: " };

		JOptionPane.showMessageDialog(null, mensagem[op] + saida);
	}

	// Calcula o digito para a sequencia dada
	static void validaCPF() {

		int[] digit = { 0, 0 };

		for (int i = 0; i < 9; i++) {

			digit[0] += numero[i] * (10 - i);
			digit[1] += numero[i] * (11 - i);
		}

		digit[0] = digit[0] % 11;
		if (digit[0] < 2) {
			digit[0] = 0;
		} else {
			digit[0] = 11 - digit[0];
		}

		digit[1] += digit[0] * 2;

		digit[1] = digit[1] % 11;
		if (digit[1] < 2) {
			digit[1] = 0;
		} else {
			digit[1] = 11 - digit[1];
		}

		setDigito(digit);

		geraSaida();

	}

	// Verifica validade de um CPF dado
	static void verificaCPF() {

		int[] digit = getDigito();
		int print;

		validaCPF();

		if (digito[0] == digit[0] && digito[1] == digit[1]) {
			imprime(opcao);
		} else {
			print = JOptionPane.showConfirmDialog(null,
					"Valor de CPF inválido. \n Deseja gerar um CPF válido para essa sequencia?");

			if (print == 0)
				imprime(opcao);
		}

	}

	// Pega Sequencia armazenada
	public int[] getNumero() {
		return numero;
	}

	// Armazena sequencia
	public static void setNumero(int[] num) {
		numero = num;
	}

	// Pega dígito armazenadao
	public static int[] getDigito() {
		return digito;
	}

	// Armazena dígito
	public static void setDigito(int[] dig) {
		digito = dig;
	}

}
