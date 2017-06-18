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
public class AnuncioArquivo {

	private Long idArquivo;	
	private String enderecoArquivo;
	
	public AnuncioArquivo(){
	}
	
	public AnuncioArquivo(Anuncio anuncio, String enderecoArquivo){
		this.anuncio = anuncio;
		this.enderecoArquivo = enderecoArquivo;
	}
	
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="codAnuncio")
	private Anuncio anuncio;
	
	@Id
	@GeneratedValue
	public Long getIdArquivo() {
		return idArquivo;
	}

	public void setIdArquivo(Long idArquivo) {
		this.idArquivo = idArquivo;
	}
	@Column(name="codAnuncio")
	public Long getAnuncio() {
		return anuncio.getCodAnuncio();
	}
	public void setAnuncio(Long codAnuncio) {
		this.anuncio.setCodAnuncio(codAnuncio);
	}
	public String getEnderecoArquivo() {
		return enderecoArquivo;
	}

	public void setEnderecoArquivo(String enderecoArquivo) {
		this.enderecoArquivo = enderecoArquivo;
	}
}
