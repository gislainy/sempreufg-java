package br.com.sportsgo.model.anuncio;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity @Table(name="auncio_premium",schema="public")
public class AnuncioPremium {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long idAnuncioPremium;
	@Column
	private Integer dataInicio;
	@Column
	private Integer dataTermino;
	@Column
	private Double valor;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="codAnuncio")
	private Anuncio anuncio;
	
	public Long getIdAnuncioPremium() {
		return idAnuncioPremium;
	}
	public void setIdAnuncioPremium(Long idAnuncioPremium) {
		this.idAnuncioPremium = idAnuncioPremium;
	}
	public Integer getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Integer dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Integer getDataTermino() {
		return dataTermino;
	}
	public void setDataTermino(Integer dataTermino) {
		this.dataTermino = dataTermino;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Anuncio getAnuncio() {
		return anuncio;
	}
	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}
}
