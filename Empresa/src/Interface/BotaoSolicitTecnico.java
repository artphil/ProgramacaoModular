package Interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import Pessoas.*;
import Sistema.Gerenciador;

public class BotaoSolicitTecnico implements ActionListener
{
	Tecnico tecnico;
	JanelaDadosTecnico janela;
	
	public BotaoSolicitTecnico (JanelaDadosTecnico janela, Tecnico tecnico)
	{
		this.tecnico = tecnico;
		this.janela = janela;
	}

	public void actionPerformed(ActionEvent e) 
	{
		tecnico.setNome(janela.nome.getText());
		tecnico.setCPF(janela.cpf.getText());
		tecnico.setDataNasc(janela.dataNasc.getText());
		tecnico.setEmail(janela.email.getText());
		tecnico.setEndereco(janela.endereco.getText());
		tecnico.setIdentidade(janela.identidade.getText());
		tecnico.setTelefone(janela.telefone.getText());
		tecnico.setFormacao(janela.listaFormacao.getSelectedIndex());
		
		try {
			Gerenciador.listaCliente.grava();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		Gerenciador.janelas[Gerenciador.index].setVisible(false);
		Gerenciador.janelas[++Gerenciador.index] = new JanelaQuadSolicitTecnico(tecnico);	
	}

}
