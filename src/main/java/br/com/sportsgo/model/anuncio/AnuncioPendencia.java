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

@Entity	@Table(name="anuncio_pendencia",schema="public")
public class AnuncioPendencia {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long idPendencia;
	@Column
	private Integer dataInclusao;
	@Column
	private Integer dataSolucao;
	@Column(length=60)
	private String descricao;
	@Column(length=60)
	private String solucao;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="codAnuncio")
	private Anuncio anuncio;
	
	public long getIdPendencia() {
		return idPendencia;
	}
	public void setIdPendencia(long idPendencia) {
		this.idPendencia = idPendencia;
	}
	public Integer getDataInclusao() {
		return dataInclusao;
	}
	public void setDataInclusao(Integer dataInclusao) {
		this.dataInclusao = dataInclusao;
	}
	public Integer getDataSolucao() {
		return dataSolucao;
	}
	public void setDataSolucao(Integer dataSolucao) {
		this.dataSolucao = dataSolucao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getSolucao() {
		return solucao;
	}
	public void setSolucao(String solucao) {
		this.solucao = solucao;
	}
	public Anuncio getAnuncio() {
		return anuncio;
	}
	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}

}
