package Interface;

import java.awt.*;

import javax.swing.*;

import Pessoas.Cliente;

public class JanelaSolicitCliente extends JFrame
{
	public JPanel 	portatexto;
	public JLabel 	texto;
	public JPanel 	conteudo,
					botoes;
	public JTextField 	nome,
						telefone,
						email;
	public JTextArea	solicitacao;
	public int tecnicoid;
	public JButton 	confirma,
					volta;
	
	public JanelaSolicitCliente (Cliente cliente)
	{
		/*Texto da barra superior*/
		setTitle("Fazconcertos Soluções em Serviços");
		
		/*Texto de informação*/
		portatexto = new JPanel ();
		texto = new JLabel ("CLIENTE");
		portatexto.add(texto);
		add(portatexto, BorderLayout.PAGE_START);

		/*Conteudo*/
		conteudo =  new JPanel ();
		conteudo.setLayout(new BoxLayout(conteudo, BoxLayout.Y_AXIS));
						
		JPanel portanom = new JPanel();
		portanom.setLayout(new GridLayout(3, 1));
		
		portanom.add( new JLabel("Cliente ID: #" + cliente.getId()));
		
		portanom.add( new JLabel("Cliente"));
		
		nome = new JTextField(cliente.getNome(), 41);
		nome.setEditable(false);
		JPanel portaTexto1 = new JPanel();
		portaTexto1.add(nome);
		portanom.add(portaTexto1);
		
		conteudo.add(portanom);

		JPanel portacont = new JPanel();
		portacont.setLayout(new GridLayout(3, 2));
		
		portacont.add(new JLabel("Telefone"));
		portacont.add(new JLabel("Email"));
		
		telefone = new JTextField(cliente.getTelefone(), 20);
		telefone.setEditable(false);
		JPanel portaTexto2 = new JPanel();
		portaTexto2.add(telefone);
		portacont.add(portaTexto2);
				
		email = new JTextField(cliente.getEmail(), 20);
		email.setEditable(false);
		JPanel portaTexto3 = new JPanel();
		portaTexto3.add(email);
		portacont.add(portaTexto3);
		
		portacont.add(new JLabel("Solicitação"));
		conteudo.add(portacont);
		
		solicitacao = new JTextArea(10, 40);
		conteudo.add(solicitacao);
		
		add(conteudo, BorderLayout.CENTER);
		
		/*Botões de ação*/
		botoes = new JPanel ();
		
		confirma = new JButton ("Confirma");
		//confirma.addActionListener(new BotaoCliente());
		botoes.add(confirma);
		
		volta = new JButton ("Volta");
		volta.addActionListener(new BotaoVolta());
		botoes.add(volta);
		
		add(botoes, BorderLayout.PAGE_END);
		

		/*Configurações da Janela*/
		setSize(470, 600);
		setLocationRelativeTo(null); 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
