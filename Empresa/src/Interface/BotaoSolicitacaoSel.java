package Interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Pessoas.*;
import Servicos.Solicitacao;
import Sistema.Gerenciador;

public class BotaoSolicitacaoSel implements ActionListener
{
	Solicitacao solicitacao;
	JanelaQuadSolicitCliente janela1;
	JanelaQuadSolicitTecnico janela2;
	int index;
	int tipo;
	Tecnico tecnico;
	
	public BotaoSolicitacaoSel (JanelaQuadSolicitCliente jan, int tipo)
	{
		this.tipo = tipo;
		janela1 = jan;
		
	}
		
	public BotaoSolicitacaoSel (JanelaQuadSolicitTecnico jan, Tecnico tecnico, int tipo)
	{
		this.tipo = tipo;
		janela2 = jan;
		this.tecnico = tecnico;
		
	}
	
	public void actionPerformed(ActionEvent ev) 
	{			
		if (tipo == 1)
		{
			this.index = janela1.solicitacao.getSelectedIndex();
			if (index >= 0)
				this.solicitacao = janela1.solicitacoes.getSolicitacao(index);
		}
		else if (tipo == 2)
		{
			this.index = janela2.solicitacao.getSelectedIndex();
			if (index >= 0)
				this.solicitacao = janela2.solicitacoes.getSolicitacao(index);
			solicitacao.setTecnico(tecnico);
		}
		
		if (solicitacao != null)
		{
			Gerenciador.janelas[Gerenciador.index].setVisible(false);
			Gerenciador.janelas[++Gerenciador.index] = new JanelaSolicitacao(solicitacao, tipo);
		}
	}

}