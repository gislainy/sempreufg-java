package br.com.sportsgo.model;

public class Telefone{
	private Long idTelefone;
	private String codPais;
	private String dddNumero;
	private String tipo;
	
	//Metodos Getters e Setters
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