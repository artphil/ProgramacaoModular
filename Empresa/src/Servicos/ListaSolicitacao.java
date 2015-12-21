package Servicos;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Pessoas.Cliente;
import Pessoas.Tecnico;
import Sistema.Gerenciador;

public class ListaSolicitacao 
{
private ArrayList<Solicitacao> lista;
	
	public ListaSolicitacao () 
	{
		lista = new ArrayList<Solicitacao>();
	}
	
	public void add (Solicitacao solicitacao) 
	{
		lista.add(solicitacao);
	}
	
	public Solicitacao getSolicitacao (int index)
	{
		return (Solicitacao) lista.get(index);
	}
	
	public int existe (int idcliente, int idTecnico, int inicio)
	{
		int index = -1;
		int i = inicio;
		Solicitacao solicitacao;
		
		while ( i <lista.size() && index == -1 )
		{
			solicitacao = (Solicitacao) lista.get(i);
			if (solicitacao.getCliente().getId() == idcliente && solicitacao.getTecnico().getId() == idTecnico)
				index = i;
			i++;
		}
		
		return index;
	}
	
	public int existe (int idcliente, int inicio)
	{
		int index = -1;
		int i = inicio;
		Solicitacao solicitacao;
		
		while ( i <lista.size() && index == -1 )
		{
			solicitacao = (Solicitacao) lista.get(i);
			if (solicitacao.getCliente().getId() == idcliente)
				index = i;
			i++;
		}
		
		return index;
	}
	
	public int existe (int formacao, int inicio, char zero)
	{
		int index = -1;
		int i = inicio;
		Solicitacao solicitacao;
		
		while ( i <lista.size() && index == -1 )
		{
			solicitacao = (Solicitacao) lista.get(i);
			if (solicitacao.getFormacao() == formacao)
				index = i;
			i++;
		}
		
		return index;
	}
	
	public Solicitacao Busca (int idcliente, int idTecnico)
	{
		int index = existe (idcliente, idTecnico, 0);
		if (index == -1)
			return null;
		else 
			return (Solicitacao) lista.get(index);
	}
	
	public ListaSolicitacao BuscaTodos (int formacao, char zero)
	{
		ListaSolicitacao solicitacoes = new ListaSolicitacao();
		int index = -1;
		do
		{
			index = existe (formacao, index+1, zero);
			if (index != -1)
			{
				solicitacoes.add((Solicitacao) lista.get(index));
			}
		}while (index != -1);
		
		return solicitacoes;
	}
	
	public ListaSolicitacao BuscaTodos (int idcliente)
	{
		ListaSolicitacao solicitacoes = new ListaSolicitacao();
		int index = -1;
		do
		{
			index = existe (idcliente, index+1);
			if (index != -1)
			{
				solicitacoes.add((Solicitacao) lista.get(index));
			}
		}while (index != -1);
		
		return solicitacoes;
	}
	
	public ListaSolicitacao BuscaTodos (int idcliente, int idTecnico) throws IOException
	{
		ListaSolicitacao solicitacoes = new ListaSolicitacao();
		int index = -1;
		do
		{
			index = existe (idcliente, idTecnico, index+1);
			if (index != -1)
			{
				solicitacoes.add((Solicitacao) lista.get(index));
			}
		}while (index != -1);
		
		return solicitacoes;
	}
	
	public void grava () throws IOException
	{
		Solicitacao solicitacao;
		FileWriter arquivoSolicitacao = new FileWriter("arquivos/solicitacoes.txt");
		for (int i = 0; i < lista.size(); i++)
		{
			solicitacao = (Solicitacao) lista.get(i);
			arquivoSolicitacao.write(solicitacao.imprime());
		}
	
		arquivoSolicitacao.close();
	}
	
	public void preenche () throws IOException
	{
		Solicitacao solicitacao;
		FileReader arquivoClientes = new FileReader("arquivos/solicitacoes.txt");
		char [] buffer = new char[1];
		int eof, 
			estado 		= 0, 
			id 			= 0,
			clienteId 	= 0,
			tecnicoId 	= 1000,
			estadSolic 	= 0,
			formacao 	= 0;
		float orcamento	= 0;
		String 	idAux 		= "", 
				clienteS 	= "",
				formString 	= "",
				data		= "",
				descricao 	= "",
				tecnicoS 	= "",
				estadString	= "",
				orcaString 	= "";
				
		
		try 
		{ 
			do 
			{ 
				eof = arquivoClientes.read(buffer,0,buffer.length); 
				for (int i = 0; i < buffer.length; i++) 
				{
					if (estado == 0)
					{
						if(buffer[i] == '#')
							estado++;
					}
					else if (estado == 1)
					{
						if(buffer[i] == '#')
						{
							estado++;
							id = Integer.parseInt(idAux);
							clienteS = "";
						}
						else
						{
							idAux += String.valueOf(buffer[i]);
						}
					}
					else if (estado == 2)
					{
						if(buffer[i] == '#')
						{
							estado++;
							clienteId = Integer.parseInt(clienteS);
							tecnicoS = "";
						}
						else
						{
							clienteS += String.valueOf(buffer[i]);
						}
					}
					else if (estado == 3)
					{
						if(buffer[i] == '#')
						{
							estado++;
							tecnicoId = Integer.parseInt(tecnicoS);
							estadString = "";
						}
						else
						{
							tecnicoS += String.valueOf(buffer[i]);
						}
					}
					else if (estado == 4)
					{
						if(buffer[i] == '#')
						{
							estado++;
							estadSolic = Integer.parseInt(estadString);
							data = "";
						}
						else
						{
							estadString += String.valueOf(buffer[i]);
						}
					}
					else if (estado == 5)
					{
						if(buffer[i] == '#')
						{
							estado++;
							formString = "";
						}
						else
						{
							data += String.valueOf(buffer[i]);
						}
					}
					else if (estado == 6)
					{
						if(buffer[i] == '#')
						{
							estado++;
							formacao = Integer.parseInt(formString);
							orcaString = "";
						}
						else
						{
							formString += String.valueOf(buffer[i]);
						}
					}
					else if (estado == 7)
					{
						if(buffer[i] == '#')
						{
							estado++;
							orcamento = Float.parseFloat(orcaString);
							descricao = "";
						}
						else
						{
							orcaString += String.valueOf(buffer[i]);
						}
					}
					else if (estado == 8)
					{
						if(buffer[i] == '#')
						{
							estado = 0;
							idAux = "";
							
							solicitacao = new Solicitacao(id);
							Cliente cliente = Gerenciador.listaCliente.Busca(clienteId);
							solicitacao.setCliente(cliente);
							Tecnico tecnico = Gerenciador.listaTecnico.Busca(tecnicoId);
							solicitacao.setTecnico(tecnico);
							solicitacao.setEstado(estadSolic);
							solicitacao.setFormacao(formacao);
							solicitacao.setOrcamento(orcamento);
							solicitacao.setDescricao(descricao);
							
//							System.out.println(solicitacao); 
							
							lista.add(solicitacao);
						}
						else
						{
							descricao += String.valueOf(buffer[i]);
						}
					}
									
				}
				
			} while (eof != -1); 
			arquivoClientes.close(); 
		} catch (IOException e) {
			System.out.println( "erro – arquivo não encontrado:" + e.toString());
		}
		
		arquivoClientes.close();
	}
	
	public String[] toArray ()
	{
		String[] elementos = new String[lista.size()];
		for (int i = 0; i < lista.size(); i++)
		{
			elementos[i] = lista.get(i).getData() + " " +
					Tecnico.formacoes[lista.get(i).getFormacao()] + " " +
					Solicitacao.estados[lista.get(i).getEstado()] ;
			
		}
		return elementos;
	}
	
	public String toString ()
	{
		String elementos = "";
		for (int i = 0; i < lista.size(); i++)
		{
			elementos += lista.get(i).toString();
			elementos += "\n";
		}
		return elementos;
	}


}
