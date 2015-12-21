package Interface;

import java.awt.event.*;

import Sistema.Gerenciador;

public class BotaoVolta  implements ActionListener
{
	
	public void actionPerformed(ActionEvent ev) 
	{
		Gerenciador.janelas[Gerenciador.index].setVisible(false);
		Gerenciador.janelas[--Gerenciador.index].setVisible(true);
	}

}
