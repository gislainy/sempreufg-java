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

@Entity @Table(name="anuncio_local",schema="public")
public class AnuncioLocal {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long idLocalAnuncio;
	@Column(length=120)
	private String local;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="codAnuncio")
	private Anuncio anuncio;
	
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public Long getIdLocalAnuncio() {
		return idLocalAnuncio;
	}
	public void setIdLocalAnuncio(Long idLocalAnuncio) {
		this.idLocalAnuncio = idLocalAnuncio;
	}

	public Anuncio getAnuncio() {
		return anuncio;
	}
	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}
	
	
}
