package br.com.sportsgo.model.usuario;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.com.sportsgo.model.pessoa.Pessoa;
//*Atributos CamelCase: Verificar BD/Diagrama ER.

@Entity
public class Usuario extends Pessoa{
	private Long id;
	private String login;
	private String senha;	
	private ArrayList<String> notificacoesEmail = new ArrayList<String> ();

	//Metodos Getters e Setters
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public ArrayList<String> getNotificacoesEmail() {
		return notificacoesEmail;
	}
	public void setNotificacoesEmail(ArrayList<String> notificacoesEmail) {
		this.notificacoesEmail = notificacoesEmail;
	}
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}	
	
}