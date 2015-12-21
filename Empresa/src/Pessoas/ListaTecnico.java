	package Pessoas;

import java.io.*;
import java.util.*;

public class ListaTecnico {

	private ArrayList<Tecnico> lista;
	
	public ListaTecnico () 
	{
		lista = new ArrayList<Tecnico>();
	}
	
	public void add (Tecnico tecnico)
	{
		lista.add(tecnico);
	}
	
	public Tecnico getTecnico (int index)
	{
		return lista.get(index);
	}
	
	public int existe (int matricula)
	{
		int index = -1;
		int i = 0;
		Tecnico tecnico;
		
		while ( i < lista.size() && index == -1 )
		{
			tecnico = (Tecnico) lista.get(i);
			if (tecnico.getId() == matricula)
				index = i;
			i++;
		}
		
		return index;
	}
	
	public Tecnico Busca (int matricula)
	{
		int index = existe (matricula);
		if (index == -1)
			return null;
		else 
			return (Tecnico) lista.get(index);
	}
	
	public void grava () throws IOException
	{
		Tecnico tecnico;
		FileWriter arquivoTecnicos = new FileWriter("arquivos/tecnicos.txt");
		for (int i = 0; i < lista.size(); i++)
		{
			tecnico = (Tecnico) lista.get(i);
			arquivoTecnicos.write(tecnico.imprime());
		}
	
		arquivoTecnicos.close();
	}
	
	public void preenche () throws IOException
	{
		Tecnico tecnico;
		FileReader arquivoTecnicos = new FileReader("arquivos/tecnicos.txt");
		char [] buffer = new char[1];
		int eof, 
			estado 		= 0,
			formacao	= 0,
			id 			= 0;
		String 	idAux 		= "", 
				nome 		= "", 
				endereco 	= "", 
				identidade 	= "", 
				cpf 		= "", 
				email 		= "", 
				telefone 	= "", 
				dataNasc 	= "",
				formString 	= "";
		
		try 
		{ 
			do 
			{ 
				eof = arquivoTecnicos.read(buffer,0,buffer.length); 
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
							estado++;
							formString = "";
						}
						else
						{
							identidade += String.valueOf(buffer[i]);
						}
					}
					else if (estado == 9)
					{
						if(buffer[i] == '#')
						{
							formacao = Integer.parseInt(formString);
							
							estado = 0;
							idAux = "";
							
							tecnico = new Tecnico(id);
							tecnico.setNome(nome);
							tecnico.setCPF(cpf);
							tecnico.setDataNasc(dataNasc);
							tecnico.setEmail(email);
							tecnico.setEndereco(endereco);
							tecnico.setIdentidade(identidade);
							tecnico.setTelefone(telefone);
							tecnico.setFormacao(formacao);
							
//							System.out.println(tecnico); 
							
							lista.add(tecnico);
						}
						else
						{
							formString += String.valueOf(buffer[i]);
						}
					}
									
				}
				
			} while (eof != -1); 
			arquivoTecnicos.close(); 
		} catch (IOException e) {
			System.out.println( "erro � arquivo n�o encontrado:" + e.toString());
		}
		
		arquivoTecnicos.close();
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
