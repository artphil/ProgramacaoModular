package Interface;

import java.awt.event.*;

import javax.swing.*;

import Excecoes.blankFieldsException;
import Pessoas.*;
import Sistema.Gerenciador;

public class BotaoEntraTecnico implements ActionListener
{
	public Tecnico tecnico = null;
	JanelaTecnico janela;
	
	public BotaoEntraTecnico (JanelaTecnico janela)
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
		
		tecnico = Gerenciador.listaTecnico.Busca(Integer.parseInt(janela.matricula.getText()));
		
		if (tecnico != null)
		{
			Gerenciador.janelas[Gerenciador.index].setVisible(false);
			Gerenciador.janelas[++Gerenciador.index] = new JanelaDadosTecnico(tecnico);	
		}
		else
		{
			
			int dialogButton = JOptionPane.showConfirmDialog(null, "Usuario nao cadastro \ndeseja cadastrar agora?");
			
			if(dialogButton == 0){
				new JanelaCadastroTecnico();
			}
			else{
				return;
			}
		}
	}
	
	public void validaLogin() throws blankFieldsException{
		
		if(janela.matricula.getText().isEmpty()){
			throw new blankFieldsException("Favor preencher todos os campos solicitados.");
		}
	}
}
