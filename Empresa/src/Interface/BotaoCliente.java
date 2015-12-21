package Interface;

import java.awt.event.*;
import javax.swing.*;

import Sistema.Gerenciador;

public class BotaoCliente implements ActionListener
{
	
	public void actionPerformed(ActionEvent ev) 
	{
		Gerenciador.janelas[Gerenciador.index].setVisible(false);
		Gerenciador.janelas[++Gerenciador.index] = new JanelaCliente ();		
	}

}
