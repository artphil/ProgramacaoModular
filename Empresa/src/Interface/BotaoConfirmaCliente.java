package Interface;

import java.awt.event.*;
import java.io.IOException;

import javax.swing.JOptionPane;

import Excecoes.*;

import Pessoas.Cliente;
import Sistema.Gerenciador;

public class BotaoConfirmaCliente implements ActionListener
{
	JanelaCadastroCliente janela;
	Cliente cliente;
	
	public BotaoConfirmaCliente (JanelaCadastroCliente janela)
	{
		this.janela = janela;
	}
	
	public void actionPerformed(ActionEvent ev) {
		try{
			validaCadastro();
		}catch(blankFieldsException e){
			JOptionPane.showMessageDialog(null, e.getMessage());
			return;
		}
		
		cliente = new Cliente();
		cliente.setNome(janela.nome.getText());
		cliente.setCPF(janela.cpf.getText());
		cliente.setDataNasc(janela.dataNasc.getText());
		cliente.setEmail(janela.email.getText());
		cliente.setEndereco(janela.endereco.getText());
		cliente.setIdentidade(janela.identidade.getText());
		cliente.setTelefone(janela.telefone.getText());
		
		Gerenciador.listaCliente.add(cliente);
		
		try {
			Gerenciador.listaCliente.grava();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		janela.setVisible(false);
	}

	public void validaCadastro() throws blankFieldsException{
		if(janela.nome.getText().isEmpty() ||
		   janela.dataNasc.getText().isEmpty() ||
		   janela.email.getText().isEmpty() ||
		   janela.cpf.getText().isEmpty() ||
		   janela.endereco.getText().isEmpty() ||
		   janela.identidade.getText().isEmpty() ||
		   janela.telefone.getText().isEmpty()){
			throw new blankFieldsException("Favor preencher todos os campos solicitados.");
		}
			
	}
	
}
