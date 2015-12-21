package Interface;

import java.awt.event.*;
import java.io.IOException;

import Pessoas.Cliente;
import Servicos.Solicitacao;
import Sistema.Gerenciador;

public class BotaoConfirmaSolicit implements ActionListener
{
	JanelaCadastroSolicit janela;
	Solicitacao solicitacao;
	
	public BotaoConfirmaSolicit (JanelaCadastroSolicit janela)
	{
		this.janela = janela;
	}
	
	public void actionPerformed(ActionEvent ev) {
		solicitacao = new Solicitacao(janela.cliente);
		solicitacao.setTecnico(janela.tecnico);
		solicitacao.setData(janela.data.getText());
		solicitacao.setDescricao(janela.descricao.getText());
		solicitacao.setFormacao(janela.listaFormacao.getSelectedIndex());
		
		Gerenciador.listaSolicitacao.add(solicitacao);
		
		try {
			Gerenciador.listaSolicitacao.grava();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Gerenciador.janelas[Gerenciador.index].setVisible(false);
		Gerenciador.janelas[--Gerenciador.index].setVisible(true);
	}

	
}
