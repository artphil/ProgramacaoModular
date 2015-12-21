package Tests;

import Pessoas.*;
import junit.framework.*;

public class EmpregadoTest extends TestCase 
{

	public void testCostrutor ()
	{
		Empregado pessoa = new Empregado ();
		pessoa.setNome("João do Carmo");
		pessoa.setEndereco("Rua Araribá, 131");
		pessoa.setCPF("321.654.987-88");
		pessoa.setDataNasc("20/11/1956");
		pessoa.setEmail("joao@domain.com");
		pessoa.setIdentidade("MG16.654.98");
		pessoa.setTelefone("96546-5485");
		pessoa.setFormacao("Bombeiro");
		
		String esperado = "Nome:		" + "João do Carmo" + "\nEmail:		" + "joao@domain.com" 
						+ "\nEndereço:	" + "Rua Araribá, 131" + "\nTelefone:	" + "96546-5485" 
						+ "\nNascimento:	" + "20/11/1956" + "\nCPF:		" + "321.654.987-88" 
						+ "\nIdentidade:	" + "MG16.654.98" + "Formação:	" + "Bombeiro";
		
		assertEquals ( esperado, pessoa.toString() );
	}
}
