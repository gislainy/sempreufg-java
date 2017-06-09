package br.com.sportsgo.model;
//*Atributos CamelCase: Verificar BD/Diagrama ER.

public class Email {
	private Long idEmail;
	private String loginConta;
	private boolean notificacoes;
	public String getLoginConta() {
		return loginConta;
	}
	public void setLoginConta(String loginConta) {
		this.loginConta = loginConta;
	}
	public boolean isNotificacoes() {
		return notificacoes;
	}
	public void setNotificacoes(boolean notificacoes) {
		this.notificacoes = notificacoes;
	}
	public Long getIdEmail() {
		return idEmail;
	}
	public void setIdEmail(Long idEmail) {
		this.idEmail = idEmail;
	}
	
}
