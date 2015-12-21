package Interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Sistema.Gerenciador;

public class BotaoTecnico implements ActionListener
{
		
	public void actionPerformed(ActionEvent ev) 
	{
		Gerenciador.janelas[Gerenciador.index].setVisible(false);
		Gerenciador.janelas[++Gerenciador.index] = new JanelaTecnico ();		
	}

}