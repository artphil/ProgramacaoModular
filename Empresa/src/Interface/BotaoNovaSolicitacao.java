package Interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Pessoas.Cliente;
import Sistema.Gerenciador;

public class BotaoNovaSolicitacao implements ActionListener
{
	Cliente cliente;
	
	public BotaoNovaSolicitacao (Cliente client)
	{
		this.cliente = client;
	}
		
	public void actionPerformed(ActionEvent ev) 
	{
		Gerenciador.janelas[Gerenciador.index].setVisible(false);
		Gerenciador.janelas[++Gerenciador.index] = new JanelaCadastroSolicit(cliente);		
	}

}