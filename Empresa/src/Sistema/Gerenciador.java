package Sistema;

import javax.swing.JFrame;

import Pessoas.ListaCliente;
import Pessoas.ListaTecnico;
import Servicos.ListaSolicitacao;

public class Gerenciador 
{
	public static JFrame[] janelas;
	public static int index;
	public static ListaCliente listaCliente;
	public static ListaTecnico listaTecnico;
	public static ListaSolicitacao listaSolicitacao;

	
	public Gerenciador ()
	{
		listaCliente =  new ListaCliente();
		listaTecnico = new ListaTecnico();
		listaSolicitacao = new ListaSolicitacao();
		janelas = new JFrame[50];
		index = 0;
	}

}
