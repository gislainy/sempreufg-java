package br.com.sportsgo.model.usuario;

import java.util.ArrayList;
import br.com.sportsgo.model.pessoa.Pessoa;
//*Atributos CamelCase: Verificar BD/Diagrama ER.

public class Usuario extends Pessoa{
	private String id;
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
	public ArrayList<String> getNotificacoesEmail() {
		return notificacoesEmail;
	}
	public void setNotificacoesEmail(ArrayList<String> notificacoesEmail) {
		this.notificacoesEmail = notificacoesEmail;
	}	
	
}