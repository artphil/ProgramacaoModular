package Interface;

import java.awt.event.*;
import java.io.IOException;

import javax.swing.JOptionPane;

import javax.swing.JOptionPane;

import Excecoes.blankFieldsException;
import Pessoas.*;
import Sistema.Gerenciador;

public class BotaoConfirmaTecnico implements ActionListener
{
	JanelaCadastroTecnico janela;
	Tecnico tecnico;
	
	public BotaoConfirmaTecnico (JanelaCadastroTecnico janela)
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
		
		tecnico = new Tecnico();
		tecnico.setNome(janela.nome.getText());
		tecnico.setCPF(janela.cpf.getText());
		tecnico.setDataNasc(janela.dataNasc.getText());
		tecnico.setEmail(janela.email.getText());
		tecnico.setEndereco(janela.endereco.getText());
		tecnico.setIdentidade(janela.identidade.getText());
		tecnico.setTelefone(janela.telefone.getText());
		tecnico.setFormacao(janela.listaFormacao.getSelectedIndex());
		
		Gerenciador.listaTecnico.add(tecnico);
		
		JOptionPane.showMessageDialog(janela, "Matrícula de " + tecnico.getNome() + "\n" + tecnico.getId());
		
		try {
			Gerenciador.listaTecnico.grava();
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
