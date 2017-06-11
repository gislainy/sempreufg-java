package br.com.sportsgo.model.pessoa;

import javax.persistence.MappedSuperclass;

//*Atributos CamelCase: Verificar BD/Diagrama ER.

@MappedSuperclass
public class Pessoa{

	private String cpfCnpj;
	private String nome;
    private boolean pessoaJuridica = false; 
    private String sobrenome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public boolean isPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(boolean pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
}