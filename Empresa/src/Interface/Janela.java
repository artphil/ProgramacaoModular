package Interface;

import java.awt.BorderLayout;

import javax.swing.*;
import Pessoas.*;
import Servicos.*;

public class Janela extends JFrame{

	public JPanel conteudo;
	
	public Janela (JPanel conteudo)
	{
		setTitle("Empresa13 Soluções em Serviços");
		this.conteudo = conteudo;
		add(conteudo, BorderLayout.CENTER);
		
		setSize(800, 600);
		setVisible(true);
	}
}
