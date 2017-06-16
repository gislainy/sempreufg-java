package br.com.sportsgo.model.usuario;

import java.io.File;
import java.net.MalformedURLException;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class EmailUsuarioHtml {

	HtmlEmail email;
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
	
	public EmailUsuarioHtml(String email, String destinatario) throws EmailException {
		this.emailDestinatario = email;
		this.destinatario = destinatario;
		this.email = new HtmlEmail();
	}
	
	public void enviarEmail(String usuario, String senha) throws MalformedURLException, EmailException {
		email.setSSL(true);
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator( new DefaultAuthenticator(EMAIL, SENHA_EMAIL));
		try {
		    email.setFrom(EMAIL);
		    email.setDebug(true); 
		    email.setSubject("PRE-CADASTRO SPORTSGO");
		    StringBuilder builder = new StringBuilder();
		    String id = email.embed( new File("src/main/webapp/lib/img/logo.png") );
		    builder.append("<img src=\"cid:"+id+"\">");
		    builder.append("<p>Bem vindo! Obrigado por se cadastrar.</p>");
		    builder.append("<h2>Credenciais</h2>");
		    builder.append("<p>Usuário: "+ usuario +"</p>");
		    builder.append("<p>Senha: "+ senha +"</p>");
		    email.setHtmlMsg(builder.toString());
		    email.addTo(emailDestinatario); 
		    email.send();
		     
		} catch (EmailException e) {
		    e.printStackTrace();
		} 
	}
	
}
