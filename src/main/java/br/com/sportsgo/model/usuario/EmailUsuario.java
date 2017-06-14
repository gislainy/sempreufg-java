package br.com.sportsgo.model.usuario;

import java.net.MalformedURLException;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailUsuario {

	SimpleEmail email;
	private String emailDestinatario;
	private String destinatario;

	final String EMAIL = "ssportsgo@gmail.com";
	final String SENHA_EMAIL = "sportsgoiania";
	
	public String getEmailDestinatario() {
		return emailDestinatario;
	}

	public void setEmailDestinatario(String emailDestinatario) {
		this.emailDestinatario = emailDestinatario;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}
	
	public EmailUsuario(String email, String destinatario) throws EmailException {
		this.emailDestinatario = email;
		this.destinatario = destinatario;
		this.email = new SimpleEmail();
	}
	
	public void enviarEmail(String usuario, String senha) throws MalformedURLException, EmailException {
		email.setSSL(true);
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(587);
		email.setAuthenticator( new DefaultAuthenticator(EMAIL, SENHA_EMAIL));
		try {
		    email.setFrom(EMAIL);
		    email.setDebug(true); 
		    email.setSubject("PRE-CADASTRO SPORTSGO");
		    email.setMsg("Bem vindo a SportsGO!! \n\n"
		    		+ "Cadastro concluído com sucesso. \n\n"
		    		+ "Usuário: "+ usuario +"\n"
		    		+ "Senha: "+ senha
		    		+ "");
		    email.addTo(emailDestinatario); 
		    email.send();
		     
		} catch (EmailException e) {
		    e.printStackTrace();
		} 
	}
	
}
