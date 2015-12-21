package Interface;

import java.awt.*;

import javax.swing.*;

import Pessoas.Cliente;
import Pessoas.Tecnico;
import Servicos.Solicitacao;

public class JanelaSolicitacao extends JFrame
{
	public JPanel 	portatexto;
	public JLabel 	texto,
					titulo;
	public JPanel 	conteudo,
					botoes;
	public JTextField 	nome,
						telefone,
						email,
						formacao,
						tecnico,
						orcamento,
						estado;
	public JTextArea	descricao;
	public int 		tecnicoid;
	public JButton 	confirma,
					cancelar,
					volta;
	public Solicitacao solicitacao;
	
	public String[] cofirmacao = {"Enviar", "Confirmar Orçamento", 
			"Aprovar", "Iniciar",	"Concluir",	"Concluída", 
			"Encerrar", "N/A", "N/A"};
	
	public JanelaSolicitacao ()
	{
		/*Texto da barra superior*/
		setTitle("Fazconcertos Soluções em Serviços");
		
		/*Texto de informação*/
		titulo = new JLabel ("SOLICITAÇÃO");
		portatexto = new JPanel ();
		portatexto.add(titulo);
		add(portatexto, BorderLayout.PAGE_START);

		/*Conteudo*/
		conteudo =  new JPanel ();
		conteudo.setLayout(new BoxLayout(conteudo, BoxLayout.Y_AXIS));
						
		JPanel portanom = new JPanel();
		portanom.setLayout(new GridLayout(3, 1));
		
		texto = new JLabel("Cliente ID: #");
		portanom.add(texto);
		
		portanom.add( new JLabel("Cliente"));
		
		nome = new JTextField(41);
		nome.setEditable(false);
		JPanel portaTexto1 = new JPanel();
		portaTexto1.add(nome);
		portanom.add(portaTexto1);
		
		conteudo.add(portanom);

		JPanel portacont = new JPanel();
		portacont.setLayout(new GridLayout(0, 2));
		
		portacont.add(new JLabel("Telefone"));
		portacont.add(new JLabel("Email"));
		
		telefone = new JTextField(20);
		telefone.setEditable(false);
		JPanel portaTexto2 = new JPanel();
		portaTexto2.add(telefone);
		portacont.add(portaTexto2);
				
		email = new JTextField(20);
		email.setEditable(false);
		JPanel portaTexto3 = new JPanel();
		portaTexto3.add(email);
		portacont.add(portaTexto3);
		
		portacont.add(new JLabel("Serviço solicitado"));
				
		formacao = new JTextField(20);
		formacao.setEditable(false);
		portacont.add(formacao);
				
		portacont.add(new JLabel("Solicitação"));
		conteudo.add(portacont);
		
		descricao = new JTextArea(10, 40);
		descricao.setEditable(false);
		JPanel portaTexto5 = new JPanel();
		portaTexto5.add(descricao);
		conteudo.add(portaTexto5);
		
		JPanel portaconc = new JPanel();
		portaconc.setLayout(new GridLayout(0, 2));
		
		portaconc.add(new JLabel("Tecnico"));
		portaconc.add(new JLabel("Orçamento"));
		
		tecnico = new JTextField(20);
		tecnico.setEditable(false);
		JPanel portaTexto6 = new JPanel();
		portaTexto6.add(tecnico);
		portaconc.add(portaTexto6);
		
		orcamento = new JTextField(20);
		JPanel portaTexto7 = new JPanel();
		portaTexto7.add(orcamento);
		portaconc.add(portaTexto7);
		
		portaconc.add(new JLabel("Estado"));
		
		estado = new JTextField(20);
		estado.setEditable(false);
		JPanel portaTexto8 = new JPanel();
		portaTexto8.add(estado);
		portaconc.add(portaTexto8);
		
		conteudo.add(portaconc);
		
		
		add(conteudo, BorderLayout.CENTER);
		
		/*Botões de ação*/
		botoes = new JPanel ();
		
		confirma = new JButton ("Confirma");
		botoes.add(confirma);
		
		cancelar = new JButton ("Excluir");
		botoes.add(cancelar);
		
		volta = new JButton ("Volta");
		volta.addActionListener(new BotaoVolta());
		botoes.add(volta);
		
		add(botoes, BorderLayout.PAGE_END);
		
	}
	
	public JanelaSolicitacao (Solicitacao solicit, int tipo)
	{
		this();
		
		solicitacao = solicit;
		
		texto.setText(texto.getText() + solicitacao.getCliente().getId());
		
		nome.setText(solicitacao.getCliente().getNome());
		
		telefone.setText(solicitacao.getCliente().getTelefone());
				
		email.setText(solicitacao.getCliente().getEmail());
				
		formacao.setText(Tecnico.formacoes[solicitacao.getFormacao()]);

		descricao.setText(solicitacao.getDescricao());

		tecnico.setText(solicitacao.getTecnico().getNome());

		orcamento.setText(""+solicitacao.getOrcamento());
		if (solicitacao.getEstado() != 1)
			orcamento.setEditable(false);
		
		estado.setText(solicitacao.getEstadoString());
		
		confirma.setText(cofirmacao[solicitacao.getEstado()]);
		confirma.addActionListener(new BotaoSolicitacAtualiza(this, solicitacao, tipo));
		if (!(solicitacao.getEstado() == 0) && (solicitacao.getEstado()+1) % 2 == 0)
		{
			if (tipo == 1)
				confirma.setEnabled(false);
		}
		else 
		{
			if (tipo == 2)
				confirma.setEnabled(false);
		}
		
		cancelar.addActionListener(new BotaoExcluir(this));
		if (tipo == 2)
			cancelar.setEnabled(false);
		
		if (solicitacao.getEstado() > 7)
		{
			confirma.setEnabled(false);
			cancelar.setEnabled(false);
		}
		
				/*Configurações da Janela*/
		setSize(470, 600);
		setLocationRelativeTo(null); 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
}
