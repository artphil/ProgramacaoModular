package Interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class BotaoCancela implements ActionListener
{
	JFrame janela;

	public BotaoCancela (JFrame janela)
	{
		this.janela = janela;
	}
	
	public void actionPerformed(ActionEvent e) {
		janela.setVisible(false);
	}

}
