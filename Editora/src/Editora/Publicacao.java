package Editora;

import java.util.Date;

import javax.swing.JOptionPane;

public class Publicacao extends Item{

	// Variaveis de campo
	private String nome;
	private int edicaoAtual;
	private String periodic;
	private int dias;
	private Date ultimaPub;
	private Date proximaPub;
	
	// Metodos de recuperação de dados (Get)
	public Date getProximaPub() {
		return proximaPub;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getEdicaoAtual() {
		return edicaoAtual;
	}
	
	public String getPeriodic() {
		return periodic;
	}
	
	public Date getUltimaPub() {
		return ultimaPub;
	}

	// Metodos de atribuição de valor (Set)
	public void setNome(String nome) {
		this.nome = nome;
		setChave(getNome());
	}
	
	public void setNome() {
		this.nome = JOptionPane.showInputDialog("Nome da publicação");
		setChave(getNome());
	}
	
	
	public void setEdicaoAtual(int numero) {
		this.edicaoAtual = numero;
	}
	
	public void setEdicaoAtual() {
		this.edicaoAtual = Integer.parseInt(JOptionPane.showInputDialog("Edição atual da publicação"));
	}
	
	public void setPeriodic(String period) {
			
		if (period.equals("Semanal")) {
			this.periodic = period;
			this.dias = 7;
		} else if (period.equals("Quinzenal")) {
			this.periodic = period;
			this.dias = 14;
		} else if (period.equals("Mensal")) {
			this.periodic = period;
			this.dias = 30;
		}
	}
	
	public void setPeriodic() {
		String period = JOptionPane.showInputDialog("Periodicidade da publicação");
		if (period.equals("Semanal")) {
			this.periodic = period;
			this.dias = 7;
		} else if (period.equals("Quinzenal")) {
			this.periodic = period;
			this.dias = 14;
		} else if (period.equals("Mensal")) {
			this.periodic = period;
			this.dias = 30;
		} else {
			System.out.println("Periodicidade inválida");
			setPeriodic();
		}
	}

	
	public void setUltimaPub(int dia, int mes, int ano) {
		this.ultimaPub = new Date(ano, mes, dia);
		proximaPub = ultimaPub;
		proximaPub.setDate(proximaPub.getDate() + dias);
	}
	
	public void setUltimaPub() {
		int dia = Integer.parseInt(JOptionPane.showInputDialog("Dia da ultima publicação"));
		int mes = Integer.parseInt(JOptionPane.showInputDialog("Mês da ultima publicação"));
		int ano = Integer.parseInt(JOptionPane.showInputDialog("Ano da ultima publicação"));
		
		this.ultimaPub = new Date(ano, mes, dia);
		proximaPub = ultimaPub;
		proximaPub.setDate(proximaPub.getDate() + dias);
	}
	
	// Metodos de atualização de dados
	public void atualizaEdicao() {
		this.edicaoAtual++ ;
	}

	public void atualiza () {
		atualizaEdicao();
		ultimaPub = proximaPub;
		proximaPub.setDate(proximaPub.getDate() + dias);
	}
	
	// Metodo toString
	public String toString () {
		return "\nPublicação:	" + nome + "\nEdição atual:	" + edicaoAtual  + "\nData:		" 
				+ ultimaPub.getDay() + "/" + ultimaPub.getMonth() + "/" + ultimaPub.getYear() + "\nPeriodicidade:	" + periodic;
	}
	
}
