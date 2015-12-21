package Interface;

import java.awt.event.*;
import javax.swing.*;

import Pessoas.Cliente;
import Servicos.Solicitacao;
import Sistema.Gerenciador;

public class BotaoClienteVerSolic implements ActionListener
{
	Cliente cliente;
	
	public BotaoClienteVerSolic (Cliente client)
	{
		cliente = client;
	}
	
	public void actionPerformed(ActionEvent ev) 
	{
		Gerenciador.janelas[Gerenciador.index].setVisible(false);
		Gerenciador.janelas[++Gerenciador.index] = new JanelaQuadSolicitCliente(cliente);		
	}

}
