package Pessoas;

import java.io.*;
import java.util.*;

public class ListaCliente {

	private ArrayList<Cliente> lista;
	
	public ListaCliente () 
	{
		lista = new ArrayList<Cliente>();
	}
	
	public void add (Cliente cliente) 
	{
		lista.add(cliente);
	}
	
	public Cliente getCliente (int index)
	{
		return lista.get(index);
	}
	
	public int existe (String nome, String cpf, String telefone)
	{
		int index = -1;
		int i = 0;
		Cliente cliente;
		
		while ( i <lista.size() && index == -1 )
		{
			cliente = (Cliente) lista.get(i);
			if (cliente.getNome().equals(nome) && cliente.getCPF().equals(cpf) && cliente.getTelefone().equals(telefone))
				index = i;
			i++;
		}
		
		return index;
	}
	
	public int existe (int matricula)
	{
		int index = -1;
		int i = 0;
		Cliente cliente;
		
		while ( i < lista.size() && index == -1 )
		{
			cliente = (Cliente) lista.get(i);
			if (cliente.getId() == matricula)
				index = i;
			i++;
		}
		
		return index;
	}
	
	public Cliente Busca (int matricula)
	{
		int index = existe (matricula);
		if (index == -1)
			return null;
		else 
			return (Cliente) lista.get(index);
	}
	
	public Cliente Busca (String nome, String cpf, String telefone)
	{
		int index = existe (nome, cpf, telefone);
		if (index == -1)
			return null;
		else 
			return (Cliente) lista.get(index);
	}
	
	public void grava () throws IOException
	{
		Cliente cliente;
		FileWriter arquivoClientes = new FileWriter("arquivos/clientes.txt");
		for (int i = 0; i < lista.size(); i++)
		{
			cliente = (Cliente) lista.get(i);
			arquivoClientes.write(cliente.imprime());
		}
	
		arquivoClientes.close();
	}
	
	public void preenche () throws IOException
	{
		Cliente cliente;
		FileReader arquivoClientes = new FileReader("arquivos/clientes.txt");
		char [] buffer = new char[1];
		int eof, 
			estado = 0, 
			id = 0;
		String 	idAux = "", 
				nome = "", 
				endereco = "", 
				identidade = "", 
				cpf = "", 
				email = "", 
				telefone = "", 
				dataNasc = "";
		
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
							nome = "";
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
							email = "";
						}
						else
						{
							nome += String.valueOf(buffer[i]);
						}
					}
					else if (estado == 3)
					{
						if(buffer[i] == '#')
						{
							estado++;
							endereco = "";
						}
						else
						{
							email += String.valueOf(buffer[i]);
						}
					}
					else if (estado == 4)
					{
						if(buffer[i] == '#')
						{
							estado++;
							telefone = "";
						}
						else
						{
							endereco += String.valueOf(buffer[i]);
						}
					}else if (estado == 5)
					{
						if(buffer[i] == '#')
						{
							estado++;
							dataNasc = "";
						}
						else
						{
							telefone += String.valueOf(buffer[i]);
						}
					}
					else if (estado == 6)
					{
						if(buffer[i] == '#')
						{
							estado++;
							cpf = "";
						}
						else
						{
							dataNasc += String.valueOf(buffer[i]);
						}
					}
					else if (estado == 7)
					{
						if(buffer[i] == '#')
						{
							estado++;
							identidade = "";
						}
						else
						{
							cpf += String.valueOf(buffer[i]);
						}
					}
					else if (estado == 8)
					{
						if(buffer[i] == '#')
						{
							estado = 0;
							idAux = "";
							
							cliente = new Cliente(id);
							cliente.setNome(nome);
							cliente.setCPF(cpf);
							cliente.setDataNasc(dataNasc);
							cliente.setEmail(email);
							cliente.setEndereco(endereco);
							cliente.setIdentidade(identidade);
							cliente.setTelefone(telefone);
							
//							System.out.println(cliente); 
							
							lista.add(cliente);
						}
						else
						{
							identidade += String.valueOf(buffer[i]);
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
