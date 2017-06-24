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
public class Endereco{
	private Long codEndereco;
	private String Logradouro;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	private String pais;
	private String cep;
	private String numero;
	
	
	//Metodos Getters and Setters
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.MERGE)
	@JoinColumn(name="idUsuario")
	private Usuario usuario;
	
	public Endereco(){
		usuario = new Usuario();
	}
	
	
	@Id
	@GeneratedValue
	public Long getCodEndereco() {
		return codEndereco;
	}
	public void setCodEndereco(Long codEndereco) {
		this.codEndereco = codEndereco;
	}
	@Column(name="idUsuario")
	public Long getUsuario() {
		return usuario.getIdUsuario();
	}
	public void setUsuario(Long idUsuario) {
		this.usuario.setIdUsuario(idUsuario);
	}
	public String getLogradouro() {
		return Logradouro;
	}
	public void setLogradouro(String logradouro) {
		Logradouro = logradouro;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
}