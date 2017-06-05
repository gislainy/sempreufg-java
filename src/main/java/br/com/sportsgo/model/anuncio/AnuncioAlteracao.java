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
@Table(name="anuncio_alteracao",schema="public")
public class AnuncioAlteracao {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long idAlteracao;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="codAnuncio")
	private Anuncio anuncio;
	
	@Column
	private String observacao;
	@Column
	private Integer data;
	
	public long getId() {
		return idAlteracao;
	}
	public void setId(long id) {
		this.idAlteracao = id;
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
	public long getIdAlteracao() {
		return idAlteracao;
	}
	public void setIdAlteracao(long idAlteracao) {
		this.idAlteracao = idAlteracao;
	}
	public Anuncio getAnuncio() {
		return anuncio;
	}
	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}
}
