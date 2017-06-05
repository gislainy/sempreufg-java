package br.com.sportsgo.model.anuncio;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity @Table(name="anuncio_arquivo",schema="public")
public class AnuncioArquivos {
	@Id
	private long idArquivo;
	@Column
	private String enderecoArquivo;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="codAnuncio")
	private Anuncio anuncio;
}
