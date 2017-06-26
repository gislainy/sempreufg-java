package br.com.sportsgo.model.anuncio;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class AnuncioDataEvento {

	private Long idDtEvento;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataEvento;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "codAnuncio")
	private Anuncio anuncio;

	public AnuncioDataEvento() {
		anuncio = new Anuncio();
	}

	@Id
	@GeneratedValue
	public Long getIdDtEvento() {
		return idDtEvento;
	}

	public void setIdDtEvento(Long idDtEvento) {
		this.idDtEvento = idDtEvento;
	}

	public Calendar getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(Calendar dataEvento) {
		this.dataEvento = dataEvento;
	}

	@Column(name = "codAnuncio")
	public Long getAnuncio() {
		return anuncio.getCodAnuncio();
	}

	public void setAnuncio(Long codAnuncio) {
		this.anuncio.setCodAnuncio(codAnuncio);
	}
}
