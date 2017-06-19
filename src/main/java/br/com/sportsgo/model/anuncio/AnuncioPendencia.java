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
public class AnuncioPendencia {

	private Long idPendencia;
	private Integer dataInclusao;
	private Integer dataSolucao;
	@Column(length = 60)
	private String descricao;
	@Column(length = 60)
	private String solucao;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "codAnuncio")
	private Anuncio anuncio;

	@Id
	@GeneratedValue
	public Long getIdPendencia() {
		return idPendencia;
	}

	public void setIdPendencia(Long idPendencia) {
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

	@Column(name = "codAnuncio")
	public Long getAnuncio() {
		return anuncio.getCodAnuncio();
	}

	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}

}
