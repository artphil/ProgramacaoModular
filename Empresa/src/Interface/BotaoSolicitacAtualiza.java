package Interface;

import java.awt.event.*;
import java.io.IOException;

import Servicos.Solicitacao;
import Sistema.Gerenciador;

public class BotaoSolicitacAtualiza  implements ActionListener
{
	JanelaSolicitacao janela;
	Solicitacao solicitacao;
	int tipo;
	
	public BotaoSolicitacAtualiza (JanelaSolicitacao j, Solicitacao solicitacao, int t)
	{
		janela = j;
		tipo = t;
		this.solicitacao = solicitacao;
	}
	
	public void actionPerformed(ActionEvent ev) 
	{
		if (solicitacao.getEstado() == 2) 
		{
			float valor = Float.parseFloat((janela.orcamento.getText()));
			if (valor >= 0)
			{
				solicitacao.setOrcamento(valor);
				
				solicitacao.setEstado(solicitacao.getEstado()+1);
			
				Gerenciador.janelas[Gerenciador.index].setVisible(false);
				Gerenciador.janelas[--Gerenciador.index].setVisible(true);
			}
		}
		else 
		{
			solicitacao.setEstado(solicitacao.getEstado()+1);
			
			Gerenciador.janelas[Gerenciador.index].setVisible(false);
			Gerenciador.janelas[--Gerenciador.index].setVisible(true);
		}
		
		try {
			Gerenciador.listaSolicitacao.grava();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
