package Interface;

import java.awt.*;
import javax.swing.*;

import Pessoas.*;


public class JanelaTecnico extends JFrame
{
	public JLabel		texto;
	public JPanel 		portatexto, 
						login;
	public JTextField 	matricula;
	public JButton 		entra,
						volta;
	public JComboBox<String> listaFormacao;
	
	public JanelaTecnico ()
	{
		/*Texto da barra superior*/
		setTitle("Fazconcertos Soluções em Serviços");
		
		/*Texto de informação*/
		portatexto = new JPanel ();
		texto = new JLabel ("TECNICO");
		texto.setHorizontalTextPosition(SwingConstants.CENTER);
		portatexto.add(texto);
		portatexto.setAlignmentX(Component.CENTER_ALIGNMENT); 
		add(portatexto, BorderLayout.PAGE_START);
		
		/*Conteudo*/
		login = new JPanel ();
		login.setLayout(new BoxLayout(login, BoxLayout.Y_AXIS));
		
		login.add(new JLabel("Matricula"));
		
		matricula = new JTextField(20);
		JPanel portaTexto1 = new JPanel();
		portaTexto1.add(matricula);
		login.add(portaTexto1);
		
				
		add(login, BorderLayout.CENTER);

		JPanel portaBotao = new JPanel();
		
		entra = new JButton ("ENTRA");
		entra.addActionListener(new BotaoEntraTecnico(this));
		portaBotao.add(entra);
		
		volta = new JButton ("VOLTAR");
		volta.addActionListener(new BotaoVolta());
		portaBotao.add(volta);
		
		add(portaBotao, BorderLayout.PAGE_END);
		
		/*Configurações da Janela*/
		setSize(250, 150);
		setLocationRelativeTo(null); 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
