package br.com.sportsgo.model.anuncio;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AnuncioLocal {

	private Long idLocalAnuncio;
	@Column(length = 120)
	private String local;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "codAnuncio")
	private Anuncio anuncio;

	@Id
	@GeneratedValue
	public Long getIdLocalAnuncio() {
		return idLocalAnuncio;
	}

	public void setIdLocalAnuncio(Long idLocalAnuncio) {
		this.idLocalAnuncio = idLocalAnuncio;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	@Column(name = "codAnuncio")
	public Long getAnuncio() {
		return anuncio.getCodAnuncio();
	}

	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}

}
