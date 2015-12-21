package Interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import Pessoas.Cliente;
import Sistema.Gerenciador;

public class BotaoSolicitCliente implements ActionListener
{
	Cliente cliente;
	JanelaDadosCliente janela;
	
	public BotaoSolicitCliente (JanelaDadosCliente janela, Cliente cliente)
	{
		this.cliente = cliente;
		this.janela = janela;
	}

	public void actionPerformed(ActionEvent e) 
	{
		cliente.setNome(janela.nome.getText());
		cliente.setCPF(janela.cpf.getText());
		cliente.setDataNasc(janela.dataNasc.getText());
		cliente.setEmail(janela.email.getText());
		cliente.setEndereco(janela.endereco.getText());
		cliente.setIdentidade(janela.identidade.getText());
		cliente.setTelefone(janela.telefone.getText());
		
		try {
			Gerenciador.listaCliente.grava();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Gerenciador.janelas[Gerenciador.index].setVisible(false);
		Gerenciador.janelas[++Gerenciador.index] = new JanelaQuadSolicitCliente(cliente);	
	}

}
