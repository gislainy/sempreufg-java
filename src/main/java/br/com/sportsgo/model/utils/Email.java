package br.com.sportsgo.model.utils;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.sportsgo.model.usuario.Usuario;

//*Atributos CamelCase: Verificar BD/Diagrama ER.

@Entity
public class Email {
	private Long idEmail;
	private String enderecoEmail;
	private boolean receberNotificoes;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="idUsuario")
	private Usuario usuario;
	
	@Id
	@GeneratedValue
	public Long getIdEmail() {
		return idEmail;
	}
	public String getEnderecoEmail() {
		return enderecoEmail;
	}
	public void setEnderecoEmail(String enderecoEmail) {
		this.enderecoEmail = enderecoEmail;
	}
	public boolean isReceberNotificoes() {
		return receberNotificoes;
	}
	public void setReceberNotificoes(boolean receberNotificoes) {
		this.receberNotificoes = receberNotificoes;
	}
	public void setIdEmail(Long idEmail) {
		this.idEmail = idEmail;
	}
	
	@Column(name="idUsuario")
	public Long getUsuario() {
		return usuario.getIdUsuario();
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
