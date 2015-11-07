package Editora;

import java.util.*;
import javax.swing.JOptionPane;

public class Sistema {
	
	//Variaveis de acesso ao sistema
	private static Editora editora = new Editora ();
	private static Lista listaCliente = new Lista ();
	private static Lista listaPublic = new Lista ();
	private static Lista listaAssinat = new Lista ();
	private static Lista listaEtiqueta;
	
	// Variavéis de navegação no menu
	private static int[] opcao = new int[2];
	private static int[] limite = {4, 2};
	private static String[] listaOpcoes = {"Sistema\n","Publicação\n", "Cliente\n", "Assinatura\n", "Gerar Etiqueta\n"};
	private static String[] mensagOpcao = new String[3];
	
	// Programa principal
	public static void main(String[] args) {
		
		//inicialização da editora
		editora.setNome ("SN Publicações");
		editora.setCnpj("2014.262.885-55");
		editora.setEndereco("Av. Ubatuba, 724 - Caxias, RN");
		
		// Inicialização de Publicações, Clientes e Assinaturas 
		Preenche.publicacao(listaPublic);
		Preenche.cliente(listaCliente);
		Preenche.assinat(listaAssinat, listaCliente, listaPublic);
		
		// Inicialização das opçõs do menu
		// Opções de nivel 1
		mensagOpcao[0] = "Digite a categoria desejada\n"
						+ "1." + listaOpcoes[1]
						+ "2." + listaOpcoes[2]
						+ "3." + listaOpcoes[3]
						+ "4." + listaOpcoes[4]
						+ "0.Sair";
		// Opções de nivel 2
		mensagOpcao[1] = "Digite a opção desejada\n"
						+ "1.Inserir\n"
						+ "2.Visualizar\n"
						+ "0.Voltar";
		
		// Inicio do Programa
		System.out.println("Sistema iniciado\n" + editora);
		
		// Menu
		verificaOpcao (0,0);
		
		while (opcao[0] != 0) {
			
			if (opcao[0] == 1) {// Relativo a Publicação
			
				verificaOpcao (1,1);
				
				while (opcao[1] != 0) {
				
					if (opcao[1] == 1) {
						inserePublic ();
					} else if (opcao[1] == 2) {
						listaPublic.imprime(); 
					}
					
					verificaOpcao (1,1);
				}
			
			} else if (opcao[0] == 2) {// Relativo a Clientes
				
				verificaOpcao (1,2);
				
				while (opcao[1] != 0) {
					
					if (opcao[1] == 1) {
						insereClient();
					} else if (opcao[1] == 2) {
						listaCliente.imprime(); 
					}
					
					verificaOpcao (1,2);
				}
				
			} else if (opcao[0] == 3) {// Relativo a Assinaturas
				
				verificaOpcao (1,3);
				
				while (opcao[1] != 0) {
					
					if (opcao[1] == 1) {
						insereAssinat();
					} else if (opcao[1] == 2) {
						listaAssinat.imprime(); 
					}
					
					verificaOpcao (1,3);
				}
			} else if (opcao[0] == 4) {// Relativo a Etiquetas
				geraetiqueta ();
			}
			
			verificaOpcao (0,0);
		}	
	}
	
	// Verifica qual opção do menu foi selecionada
	public static void verificaOpcao (int indice, int indice2) {
		String entrada = JOptionPane.showInputDialog(listaOpcoes[indice2] + mensagOpcao[indice]);
		
		opcao[indice] = Integer.parseInt(entrada);
		
		if (opcao[indice] < 0 || opcao[indice] > limite[indice]) {
			opcao[indice] = 0;
		}
	}
	
	// Insere elementos nas listas
	// Lista de Publicações
	public static void inserePublic () {
		Publicacao publicacao = new Publicacao ();
		publicacao.setNome();
		publicacao.setPeriodic();
		publicacao.setEdicaoAtual();
		publicacao.setUltimaPub();
		
		listaPublic.insereItem(publicacao);
		System.out.println("Nova publicação cadastrada.");
	}
	
	// Lista de Clientes
	public static void insereClient () {
		Cliente cliente = new Cliente ();
		cliente.setNome();
		cliente.setCPF();
		cliente.setEndereco();
		cliente.setTelefone();
		
		listaCliente.insereItem(cliente);
		System.out.println("Novo cliente cadastrado.");
	}
	
	// Lista de Assinaturas
	public static void insereAssinat () {
		Cliente cliente = achaCliente ();
		Publicacao publicacao = achaPublic ();
		if (cliente != null && publicacao != null) {
			Assinatura assinat = new Assinatura (cliente, publicacao);
			assinat.setEdicaoInicial(Integer.parseInt(JOptionPane.showInputDialog("Digite a edição inicial")));
			assinat.setNumeroAssinat(Integer.parseInt(JOptionPane.showInputDialog("Digite a o numero de edições assinasdas")));
			
			listaAssinat.insereItem(assinat);
			System.out.println("Assinatura efetuada com sucesso.");
		} else {
			System.out.println("A assinatura não pode ser efetuada.\nCliente ou Publicação invalidos.");
		}
	}

	// Encontra elementos da lista Atraves de uma String
	// Encontra Cliente
	public static Cliente achaCliente () {
		Cliente cliente = null;
		String nome = " ";
		while (cliente == null && !nome.equals("0")) {
			nome = JOptionPane.showInputDialog("Nome do cliente\nDigite '0' para sair");
			cliente = (Cliente) listaCliente.Busca(nome);
		}
		return cliente;
	}
	
	// Encontra Publicação
	public static Publicacao achaPublic () {
		Publicacao publicacao = null;
		String nome = " ";
		while (publicacao == null && !nome.equals("0")) {
			nome = JOptionPane.showInputDialog("Nome da publicacao\nDigite '0' para sair");
			publicacao = (Publicacao) listaPublic.Busca(nome);
		}
		return publicacao;
	}

	// Cria etiquetas para assinaturas de determinada data
	public static void geraetiqueta () {
		Lista aux = listaAssinat.proximo;
		Date data = informaData();
		Assinatura assinat;
		listaEtiqueta = new Lista ();
		
		while (aux != null) {
			assinat = (Assinatura)aux.item;
			if (data.equals(assinat.getPeriodico().getProximaPub())){
				listaEtiqueta.insereItem(new Etiqueta(assinat));
				
			}
			aux = aux.proximo;
		}
		listaEtiqueta.imprime();
	}
	
	// Recebe uma data do usuário
	public static Date informaData() {
		int dia = Integer.parseInt(JOptionPane.showInputDialog("Informe o dia"));
		int mes = Integer.parseInt(JOptionPane.showInputDialog("Informe o mês"));
		int ano = Integer.parseInt(JOptionPane.showInputDialog("Informe o ano"));
		
		return new Date(ano, mes, dia);
		
	}

}
