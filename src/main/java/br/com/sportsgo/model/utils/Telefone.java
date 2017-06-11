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

@Entity
public class Telefone{
	private Long idTelefone;
	private String codPais;
	private String dddNumero;
	private String tipo;
	
	
	//Metodos Getters e Setters
	
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="idUsuario")
	private Usuario usuario;
	
	@Id
	@GeneratedValue
	public Long getIdTelefone() {
		return idTelefone;
	}
	public void setIdTelefone(Long idTelefone) {
		this.idTelefone = idTelefone;
	}
	@Column(name="idUsuario")
	public Long getUsuario() {
		return usuario.getIdUsuario();
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getCodPais() {
		return codPais;
	}
	public void setCodPais(String codPais) {
		this.codPais = codPais;
	}
	
	public String getDddNumero() {
		return dddNumero;
	}
	public void setDddNumero(String dddNumero) {
		this.dddNumero = dddNumero;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}