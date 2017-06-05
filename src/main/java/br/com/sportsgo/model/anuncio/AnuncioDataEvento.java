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

@Entity
@Table(name="anuncio_dtevento",schema="public")
public class AnuncioDataEvento {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer idDtEvento;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="codAnuncio")
	private Anuncio anuncio;
	
	@Column
	private Integer dataEvento;
	
	public Integer getIdDtEvento() {
		return idDtEvento;
	}
	public void setIdDtEvento(Integer idDtEvento) {
		this.idDtEvento = idDtEvento;
	}
	public Integer getDataEvento() {
		return dataEvento;
	}
	public void setDataEvento(Integer dataEvento) {
		this.dataEvento = dataEvento;
	}
	public Anuncio getAnuncio() {
		return anuncio;
	}
	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}
}
