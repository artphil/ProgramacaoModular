package Servicos;

import Pessoas.*;

public class Solicitacao {

	private static int serial;
	public static final String estados [] = {"Cadastrada", "Aguardando Orçamento", 
			"Aguardando Aprovação", "Aprovada",	"Em Andamento",	"Concluída", 
			"Em Cobrança", "Encerrada", "Cancelada pelo Usuário"};
	
	private int 	id;
	private Cliente cliente;
	private String 	descricao,
					data;
	private Tecnico tecnico;
	private int 	estado,
					formacao;
	private float 	orcamento;
	
	public Solicitacao()
	{
		setId(++serial);
		setEstado(1);
	}

	public Solicitacao(Cliente cliente) 
	{
		this();
		setCliente(cliente);
		
	}
	
	public Solicitacao (int numero)
	{
		id = numero;
		if (numero > serial)
			serial = numero;
	}

	/* Funções Get */
	public Cliente getCliente()
	{
		return cliente;
	}
	
	public int getFormacao() {
		return formacao;
	}
	
	public Tecnico getTecnico()
	{
		return tecnico;
	}

	public static int getSerial() 
	{
		return serial;
	}

	public int getId() 
	{
		return id;
	}

	public int getEstado() {
		return estado;
	}
	
	public String getEstadoString() {
		return estados[estado];
	}

	public float getOrcamento() {
		return orcamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getData() {
		return data;
	}

	/* Funções Set */
	
	public void setCliente(Cliente cliente)
	{
		this.cliente = cliente;
	}
	
	public void setTecnico(Tecnico tecnico)
	{
		this.tecnico = tecnico;
	}
	
	public void setSerial(int serial) 
	{
		Solicitacao.serial = serial;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public void setOrcamento(float orcamento) {
		this.orcamento = orcamento;
	}

	public void setFormacao(int formacao) {
		this.formacao = formacao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
		
	public void setData(String data) {
		this.data = data;
	}
	public String imprime () 
	{
		return 	"#" + getId() + 
				"#" + getCliente().getId()+ 
				"#" + getTecnico().getId() + 
				"#" + getEstado() + 
				"#" + getData() +
				"#" + getFormacao() + 
				"#" + getOrcamento() + 
				"#" + getDescricao() + 
				"#\n";
	}

	public String toString ()
	{
		return 	"Solicitante:	" + getCliente().getNome() +
				"\nContato:		" + getCliente().getTelefone() + " / " + getCliente().getEmail() +
				"\nResponsável:	" + getTecnico().getNome() + 
				"\nFormação:	" + getTecnico().getFormacaoString() + 
				"\nDescrição:	" + getDescricao() + 
				"\nData:		" + getData() +
				"\nEstado:		" + getEstadoString() ;
				
	}

	

}
