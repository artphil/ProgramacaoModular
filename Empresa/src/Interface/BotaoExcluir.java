package Interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Sistema.Gerenciador;

public class BotaoExcluir implements ActionListener
{
	JanelaSolicitacao janela;

	public BotaoExcluir (JanelaSolicitacao janela)
	{
		this.janela = janela;
	}
	
	public void actionPerformed(ActionEvent e) {
		janela.solicitacao.setEstado(9);
		
		JOptionPane.showMessageDialog(null, "Solicitação cancelada pelo Usuário");
		
		Gerenciador.janelas[Gerenciador.index].setVisible(false);
		Gerenciador.janelas[--Gerenciador.index].setVisible(true);
	}

}
