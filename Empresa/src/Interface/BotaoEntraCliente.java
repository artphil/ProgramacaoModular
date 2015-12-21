package Interface;

import java.awt.event.*;

import javax.swing.*;

import Pessoas.*;
import Sistema.Gerenciador;
import Excecoes.*;

public class BotaoEntraCliente implements ActionListener
{
	public Cliente cliente;
	JanelaCliente janela;
	
	public BotaoEntraCliente (JanelaCliente janela)
	{
		this.janela = janela;
	}
	
	public void actionPerformed(ActionEvent ev) 
	{
		try{
			validaLogin();
		}catch(blankFieldsException e){
			JOptionPane.showMessageDialog(null, e.getMessage());
			return;
		}
				
		cliente = Gerenciador.listaCliente.Busca(janela.nome.getText(), janela.cpf.getText(), janela.telefone.getText());
		
		if (cliente != null)
		{
			Gerenciador.janelas[Gerenciador.index].setVisible(false);
			Gerenciador.janelas[++Gerenciador.index] = new JanelaDadosCliente(cliente);	
		}
		else
		{	
			int dialogButton = JOptionPane.showConfirmDialog(null, "Usuario nao cadastro \ndeseja cadastrar agora?");
			
			if(dialogButton == 0){
				new JanelaCadastroCliente();
			}
			else{
				return;
			}
            
		}
	}
	
	public void validaLogin() throws blankFieldsException{
		
		if(janela.nome.getText().isEmpty() || janela.cpf.getText().isEmpty() || janela.telefone.getText().isEmpty()){
			throw new blankFieldsException("Favor preencher todos os campos solicitados.");
		}
	}
	
}


