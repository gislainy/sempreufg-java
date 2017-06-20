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
public class AnuncioAlteracao {

	private Long idAlteracao;
	private String observacao;
	private Integer data;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "codAnuncio")
	private Anuncio anuncio;

	public AnuncioAlteracao() {
		anuncio = new Anuncio();
	}

	@Id
	@GeneratedValue
	@Column(name = "idAlteracao")
	public Long getIdAlteracao() {
		return idAlteracao;
	}

	public void setIdAlteracao(Long idAlteracao) {
		this.idAlteracao = idAlteracao;
	}

	@Column(name = "codAnuncio")
	public Long getAnuncio() {
		return anuncio.getCodAnuncio();
	}

	public void setAnuncio(Long codAnuncio) {
		this.anuncio.setCodAnuncio(codAnuncio);
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Integer getData() {
		return data;
	}

	public void setData(Integer data) {
		this.data = data;
	}
}
