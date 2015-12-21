package Interface;

import java.awt.*;

import javax.swing.*;
import Sistema.*;

public class JanelaInicio extends JFrame
{
	public JPanel portatexto;
	public JLabel texto;
	public JPanel botoes;
	public JButton cliente;
	public JButton tecnico;
	
	public JanelaInicio ()
	{
		/*Texto da barra superior*/
		setTitle("Fazconcertos Soluções em Serviços");
		
		/*Texto de informação*/
		portatexto = new JPanel ();
		texto = new JLabel ("Escolha a opção"
				+ " desejada para acessar o Sistema");
		portatexto.add(texto);
		portatexto.setAlignmentX(Component.CENTER_ALIGNMENT); 
		add(portatexto, BorderLayout.PAGE_START);
		
		/*Botões de ação*/
		botoes = new JPanel ();
		
		cliente = new JButton ("Cliente");
		cliente.addActionListener(new BotaoCliente());
		botoes.add(cliente);
		
		tecnico = new JButton ("Tecnico");
		tecnico.addActionListener(new BotaoTecnico());
		botoes.add(tecnico);
		
		add(botoes, BorderLayout.CENTER);
		

		/*Configurações da Janela*/
		setSize(400, 200);
		setLocationRelativeTo(null); 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
}
