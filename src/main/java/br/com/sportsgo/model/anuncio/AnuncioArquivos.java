package br.com.sportsgo.model.anuncio;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity @Table(name="anuncio_arquivo",schema="public")
public class AnuncioArquivos {

	private long idArquivo;	
	private String enderecoArquivo;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="codAnuncio")
	private Anuncio anuncio;
	
	@Id
	@GeneratedValue
	public long getIdArquivo() {
		return idArquivo;
	}

	public void setIdArquivo(long idArquivo) {
		this.idArquivo = idArquivo;
	}

	public String getEnderecoArquivo() {
		return enderecoArquivo;
	}

	public void setEnderecoArquivo(String enderecoArquivo) {
		this.enderecoArquivo = enderecoArquivo;
	}

	public Anuncio getAnuncio() {
		return anuncio;
	}

	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}	
	
	
}
