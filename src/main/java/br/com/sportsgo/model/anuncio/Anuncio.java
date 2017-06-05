package br.com.sportsgo.model.anuncio;

import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.sportsgo.model.usuario.Usuario;
//*Atributos CamelCase: Verificar BD/Diagrama ER.

@Entity
@Table(name="anuncio", 
	   schema="public")
public class Anuncio {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long codAnuncio;
	@Column
	private String descricao;
	@Column
	private Integer dataInclusao;
	@Column
	private double precoEvento;
	@Column
	private String modalidade;
	@Column
	private long nrViews;
	@Column
	private Integer dataTermino;
	@Column
	private Boolean anuncioEhProfissional;
	
	@Column(name="statusAnuncio")
	private EnumStatusAnuncio status;
	
	@OneToMany(mappedBy="anuncio",fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private ArrayList<AnuncioAlteracao> ultimasAlteracoes;
	
	@OneToMany(mappedBy="anuncio",fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private ArrayList<AnuncioDataEvento> datasDoEvento;
	
	@OneToMany(mappedBy="anuncio",fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private ArrayList<AnuncioArquivos> arquivos;
	
	@OneToMany(mappedBy="anuncio",fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private ArrayList<AnuncioLocal> local;
	
	@OneToMany(mappedBy="anuncio",fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private ArrayList<AnuncioPendencia> pendencias;

	@OneToMany(mappedBy="anuncio",fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private ArrayList<AnuncioPremium> dadosAnuncioPremium;
	
/*	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="idUsuario")
	private Usuario usuario;*/
	
	//Metodos Getters and Setters
/*	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}*/
	public long getCodAnuncio() {
		return codAnuncio;
	}
	public void setCodAnuncio(long codAnuncio) {
		this.codAnuncio = codAnuncio;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getDataInclusao() {
		return dataInclusao;
	}
	public void setDataInclusao(Integer dataInclusao) {
		this.dataInclusao = dataInclusao;
	}
	
	public Integer getDataTermino() {
		return dataTermino;
	}
	public void setDataTermino(Integer dataTermino) {
		this.dataTermino = dataTermino;
	}
	public String getModalidade() {
		return modalidade;
	}
	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}
	public long getNrViews() {
		return nrViews;
	}
	public void setNrViews(long nrViews) {
		this.nrViews = nrViews;
	}
	public double getPrecoEvento() {
		return precoEvento;
	}
	public void setPrecoEvento(double precoEvento) {
		this.precoEvento = precoEvento;
	}
	public ArrayList<AnuncioAlteracao> getUltimasAlteracoes() {
		return ultimasAlteracoes;
	}
	public void setUltimasAlteracoes(ArrayList<AnuncioAlteracao> ultimasAlteracoes) {
		this.ultimasAlteracoes = ultimasAlteracoes;
	}
	public ArrayList<AnuncioDataEvento> getDatasDoEvento() {
		return datasDoEvento;
	}
	public void setDatasDoEvento(ArrayList<AnuncioDataEvento> datasDoEvento) {
		this.datasDoEvento = datasDoEvento;
	}
	
	@Enumerated(EnumType.ORDINAL)
	public EnumStatusAnuncio getStatus() {
		return status;
	}
	public void setStatus(EnumStatusAnuncio status) {
		this.status = status;
	}
	public ArrayList<AnuncioLocal> getLocal() {
		return local;
	}
	public void setLocal(ArrayList<AnuncioLocal> local) {
		this.local = local;
	}
	public ArrayList<AnuncioArquivos> getArquivos() {
		return arquivos;
	}
	public void setArquivos(ArrayList<AnuncioArquivos> arquivos) {
		this.arquivos = arquivos;
	}
	public Boolean getAnuncioEhProfissional() {
		return anuncioEhProfissional;
	}
	public void setAnuncioEhProfissional(Boolean anuncioEhProfissional) {
		this.anuncioEhProfissional = anuncioEhProfissional;
	}
	public ArrayList<AnuncioPendencia> getPendencias() {
		return pendencias;
	}
	public void setPendencias(ArrayList<AnuncioPendencia> pendencias) {
		this.pendencias = pendencias;
	}
	public ArrayList<AnuncioPremium> getDadosAnuncioPremium() {
		return dadosAnuncioPremium;
	}
	public void setDadosAnuncioPremium(ArrayList<AnuncioPremium> dadosAnuncioPremium) {
		this.dadosAnuncioPremium = dadosAnuncioPremium;
	}
	
	
}