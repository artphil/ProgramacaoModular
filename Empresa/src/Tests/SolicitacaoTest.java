package Tests;

import Pessoas.*;
import Servicos.*;
import junit.framework.*;

public class SolicitacaoTest  extends TestCase
{
	public void testCostrutor ()
	{
		Solicitacao solicitacao;
		Cliente cliente = novoCliente();
		solicitacao = new Solicitacao (cliente); 
		
		assertEquals ( cliente, solicitacao.getCliente() );
	}
	
	private Cliente novoCliente()
	{
		Cliente pessoa = new Cliente ();
		pessoa.setNome("João do Carmo");
		pessoa.setEndereco("Rua Araribá, 131");
		pessoa.setCPF("321.654.987-88");
		pessoa.setDataNasc("20/11/1956");
		pessoa.setEmail("joao@domain.com");
		pessoa.setIdentidade("MG16.654.98");
		pessoa.setTelefone("96546-5485");
		
		return pessoa;
	}
	
	public void testSerial () 
	{
		Solicitacao solicitacao = new Solicitacao ();;
		
		assertEquals ( 2, solicitacao.getNumero() );
	}
}
