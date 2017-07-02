package br.com.sportsgo.model.anuncio;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class AnuncioComentario {
	
	private Long idComentario;
	private String texto;
	private String autor;
	private Long idUsuario;
	
	@Lob
	private byte[] imagem;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataInclusao;
	
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "codAnuncio")
	private Anuncio anuncio;
	
	
	public AnuncioComentario() {
		anuncio = new Anuncio();
	}
	
	
	@Column(name = "codAnuncio")
	public Long getAnuncio() {
		return anuncio.getCodAnuncio();
	}

	public void setAnuncio(Long codAnuncio) {
		this.anuncio.setCodAnuncio(codAnuncio);
	}
	
	@Id
	@GeneratedValue
	public Long getIdComentario() {
		return idComentario;
	}

	public void setIdComentario(Long idComentario) {
		this.idComentario = idComentario;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}


	public Long getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public void setDataInclusao(Calendar dataInclusao) {
		this.dataInclusao = dataInclusao;
	}
	
	public Calendar getDataInclusao() {
		return dataInclusao;
	}
	
	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}
	
	public byte[] getImagem(){
		return imagem;
	}
}
