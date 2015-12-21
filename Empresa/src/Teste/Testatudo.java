package Teste;

import java.io.IOException;

import javax.swing.JOptionPane;

import Interface.*;
import Pessoas.*;
import Servicos.Solicitacao;
import Sistema.Gerenciador;

public class Testatudo {

	private static Cliente cliente;
	private static Tecnico tecnico;
	private static Solicitacao solicitacao; 
	
	public static void main(String[] args) throws IOException {
		
		Gerenciador gerenciador = new Gerenciador();
		
		Gerenciador.listaCliente.preenche();
		Gerenciador.listaTecnico.preenche();
		Gerenciador.listaSolicitacao.preenche();
		
		tecnico = Gerenciador.listaTecnico.getTecnico(1);
		cliente = Gerenciador.listaCliente.getCliente(0);
		solicitacao = Gerenciador.listaSolicitacao.getSolicitacao(0);
			
		//JOptionPane.showMessageDialog(null, "Matrícula de ");
		
		new JanelaSolicitacao(solicitacao, 1);

	}

}
