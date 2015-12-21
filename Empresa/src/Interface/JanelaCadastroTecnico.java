package Interface;

import java.awt.*;

import javax.swing.*;

import Pessoas.Tecnico;


public class JanelaCadastroTecnico extends JFrame
{
	public JPanel 	portatexto;
	public JLabel 	texto;
	public JPanel 	conteudo,
					botoes;
	public JTextField 	nome,
						endereco,
						identidade,
						cpf,
						email,
						telefone,
						dataNasc;
	public JButton 	confirma,
					volta;
	public JComboBox<String> listaFormacao;
	
	public JanelaCadastroTecnico ()
	{
		/*Texto da barra superior*/
		setTitle("Fazconcertos Soluï¿½ï¿½es em Serviï¿½os");
		
		/*Texto de informaï¿½ï¿½o*/
		portatexto = new JPanel ();
		texto = new JLabel ("TECNICO");
		portatexto.add(texto);
		add(portatexto, BorderLayout.PAGE_START);

		/*Conteudo*/
		conteudo =  new JPanel ();
		conteudo.setLayout(new BoxLayout(conteudo, BoxLayout.Y_AXIS));
						
		JPanel portanom = new JPanel();
		portanom.setLayout(new GridLayout(3, 1));
		
		portanom.add( new JLabel("Ficha de cadastro: Preencher todos os campos"));
		
		portanom.add( new JLabel("Nome"));
		
		nome = new JTextField(41);
		JPanel portaTexto1 = new JPanel();
		portaTexto1.add(nome);
		portanom.add(portaTexto1);
		
		conteudo.add(portanom);

		JPanel portaid = new JPanel();
		portaid.setLayout(new GridLayout(2, 2));
				
		portaid.add(new JLabel("Identidade"));
		portaid.add(new JLabel("CPF"));
			
		identidade = new JTextField(20);
		JPanel portaTexto2 = new JPanel();
		portaTexto2.add(identidade);
		portaid.add(portaTexto2);
		
		cpf = new JTextField(20);
		JPanel portaTexto3 = new JPanel();
		portaTexto3.add(cpf);
		portaid.add(portaTexto3);
		
		conteudo.add(portaid);
		
		JPanel portaend = new JPanel();
		portaend.setLayout(new GridLayout(0, 1));
		
		portaend.add(new JLabel("Endereco"));
		
		endereco = new JTextField(41);
		JPanel portaTexto4 = new JPanel();
		portaTexto4.add(endereco);
		portaend.add(portaTexto4);
		
		conteudo.add(portaend);
		
		JPanel portacont = new JPanel();
		portacont.setLayout(new GridLayout(0, 2));
		
		portacont.add(new JLabel("Email"));
		portacont.add(new JLabel("Formação"));
		
		email = new JTextField(20);
		JPanel portaTexto6 = new JPanel();
		portaTexto6.add(email);
		portacont.add(portaTexto6);
		
		listaFormacao = new JComboBox<String>(Tecnico.formacoes);
		portacont.add(listaFormacao);		
		
		portacont.add(new JLabel("Telefone"));
		portacont.add(new JLabel("Data de Nascimento"));
		
		telefone = new JTextField(20);
		JPanel portaTexto5 = new JPanel();
		portaTexto5.add(telefone);
		portacont.add(portaTexto5);
				
		dataNasc = new JTextField(20);
		JPanel portaTexto7 = new JPanel();
		portaTexto7.add(dataNasc);
		portacont.add(portaTexto7);
		
		conteudo.add(portacont);
		
		add(conteudo, BorderLayout.CENTER);
		
		/*Botï¿½es de aï¿½ï¿½o*/
		botoes = new JPanel ();
		
		confirma = new JButton ("Confirma");
		confirma.addActionListener(new BotaoConfirmaTecnico(this));
		botoes.add(confirma);
		
		volta = new JButton ("Cancela");
		volta.addActionListener(new BotaoCancela(this));
		botoes.add(volta);
		
		add(botoes, BorderLayout.PAGE_END);
		

		/*Configuraï¿½ï¿½es da Janela*/
		setSize(470, 600);
		setLocationRelativeTo(null); 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
