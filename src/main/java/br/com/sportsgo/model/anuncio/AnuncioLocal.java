package br.com.sportsgo.model.anuncio;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AnuncioLocal {

	private Long idLocalAnuncio;
	@Column(length = 120)
	private String local;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "codAnuncio")
	private Anuncio anuncio;
	
	public AnuncioLocal() {
		anuncio = new Anuncio();
	}

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

	public void setAnuncio(Long codAnuncio) {
		this.anuncio.setCodAnuncio(codAnuncio);
	}

}
