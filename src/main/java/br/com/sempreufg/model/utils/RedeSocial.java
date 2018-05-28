package br.com.sempreufg.model.utils;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.sempreufg.model.usuario.Usuario;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class RedeSocial{
	private Long idRedeSocial;
	private String nomeRede;
	private String profile;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.REFRESH)
	@JoinColumn(name="idUsuario")
	private Usuario usuario;
	
	public RedeSocial(){
		this.usuario = new Usuario();
	}
	
	//Metodos Getters and Setters
	@Id
	@GeneratedValue
	public Long getIdRedeSocial() {
		return idRedeSocial;
	}
	public void setIdRedeSocial(Long idRedeSocial) {
		this.idRedeSocial = idRedeSocial;
	}
	@Column(name="idUsuario")
	public Long getUsuario() {
		return usuario.getIdUsuario();
	}
	public void setUsuario(Long idUsuario) {
		this.usuario.setIdUsuario(idUsuario);
	}
	public String getNomeRede() {
		return nomeRede;
	}
	public void setNomeRede(String nomeDaRede) {
		this.nomeRede = nomeDaRede;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
}