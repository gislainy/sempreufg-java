package br.com.sempreufg.model.utils;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.sempreufg.model.usuario.Usuario;

@Entity
public class Telefone{
	private Long idTelefone;
	private String codPais;
	private String dddNumero;
	private String tipo;
	private String numero;
	
	
	//Metodos Getters e Setters
	
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.MERGE)
	@JoinColumn(name="idUsuario")
	private Usuario usuario;
	
	public Telefone() {
		usuario = new Usuario();
	}
	
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
	public void setUsuario(Long idUsuario) {
		this.usuario.setIdUsuario(idUsuario);
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
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
}