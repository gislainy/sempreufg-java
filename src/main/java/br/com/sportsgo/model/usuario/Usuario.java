package br.com.sportsgo.model.usuario;

import java.util.ArrayList;
import br.com.sportsgo.model.Endereco;
import br.com.sportsgo.model.RedeSocial;
import br.com.sportsgo.model.Telefone;
import br.com.sportsgo.model.pessoa.Pessoa;
//*Atributos CamelCase verificar banco/Diagrama ER.

public class Usuario extends Pessoa{
	private String login;
	private String id;
	private String senha;	
	private String nome;
	private String email;
	private String cpnjCpf;
	private Boolean pessoaJuridica;
	private ArrayList<String> notificacoesEmail = new ArrayList<String> ();
	private ArrayList<Endereco> endereco = new ArrayList<Endereco> ();
	private ArrayList<Telefone> telefone = new ArrayList<Telefone> ();
	private ArrayList<RedeSocial> redeSocial = new ArrayList<RedeSocial> ();
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpnjCpf() {
		return cpnjCpf;
	}
	public void setCpnjCpf(String cpnjCpf) {
		this.cpnjCpf = cpnjCpf;
	}
	public Boolean getPessoaJuridica() {
		return pessoaJuridica;
	}
	public void setPessoaJuridica(Boolean pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}
	public ArrayList<String> getNotificacoesEmail() {
		return notificacoesEmail;
	}
	public void setNotificacoesEmail(ArrayList<String> notificacoesEmail) {
		this.notificacoesEmail = notificacoesEmail;
	}
	public ArrayList<Endereco> getEndereco() {
		return endereco;
	}
	public void setEndereco(ArrayList<Endereco> endereco) {
		this.endereco = endereco;
	}
	public ArrayList<Telefone> getTelefone() {
		return telefone;
	}
	public void setTelefone(ArrayList<Telefone> telefone) {
		this.telefone = telefone;
	}
	public ArrayList<RedeSocial> getRedeSocial() {
		return redeSocial;
	}
	public void setRedeSocial(ArrayList<RedeSocial> redeSocial) {
		this.redeSocial = redeSocial;
	}
	
	
}