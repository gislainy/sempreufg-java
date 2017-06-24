package br.com.sportsgo.model.anuncio;

import java.util.Calendar;
import java.util.List;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.sportsgo.model.usuario.Usuario;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Anuncio {

	private Long codAnuncio;
	private String descricao;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataInclusao;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataTermino;
	
	private double precoEvento;
	private String modalidade;
	private long nrViews;
	private Boolean anuncioEhProfissional;
	private String titulo;
	
	public Anuncio(){
		this.usuario = new Usuario();
		this.status = EnumStatusAnuncio.EM_ANALISE;
	}
	
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.MERGE)
	@JoinColumn(name = "idUsuario")
	@LazyCollection(LazyCollectionOption.FALSE)
	private Usuario usuario;
	
	@Column(name = "statusAnuncio")
	private EnumStatusAnuncio status;

	private List<AnuncioAlteracao> alteracoes;
	private List<AnuncioArquivo> arquivos;
	private List<AnuncioDataEvento> datas;
	private List<AnuncioLocal> locais;
	private List<AnuncioPendencia> pendencias;
	private List<AnuncioPremium> dadosPremium;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getCodAnuncio() {
		return codAnuncio;
	}

	public void setCodAnuncio(Long codAnuncio) {
		this.codAnuncio = codAnuncio;
	}

	@Column(name = "idUsuario")
	public Long getUsuario() {
		return usuario.getIdUsuario();
	}
	
	public void setUsuario(Long idUsuario) {
		this.usuario.setIdUsuario(idUsuario);
	}
	
	@JsonProperty
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Calendar dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public double getPrecoEvento() {
		return precoEvento;
	}

	public void setPrecoEvento(double precoEvento) {
		this.precoEvento = precoEvento;
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

	public Calendar getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Calendar dataTermino) {
		this.dataTermino = dataTermino;
	}

	public Boolean getAnuncioEhProfissional() {
		return anuncioEhProfissional;
	}

	public void setAnuncioEhProfissional(Boolean anuncioEhProfissional) {
		this.anuncioEhProfissional = anuncioEhProfissional;
	}

	@Enumerated(EnumType.STRING)
	public EnumStatusAnuncio getStatus() {
		return status;
	}

	public void setStatus(EnumStatusAnuncio status) {
		this.status = status;
	}

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "anuncio")
	public List<AnuncioAlteracao> getAlteracoes() {
		return alteracoes;
	}

	public void setAlteracoes(List<AnuncioAlteracao> alteracoes) {
		if(alteracoes != null && !alteracoes.isEmpty()){
			this.alteracoes = alteracoes;
			for (AnuncioAlteracao alteracao : this.alteracoes) {
				alteracao.setAnuncio(this.codAnuncio);
			}
		}
	}
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "anuncio")
	public List<AnuncioArquivo> getArquivos() {
		return arquivos;
	}

	public void setArquivos(List<AnuncioArquivo> arquivos) {
		if(arquivos != null && !arquivos.isEmpty()){
			this.arquivos = arquivos;
			for (AnuncioArquivo arquivo : this.arquivos) {
				arquivo.setAnuncio(this.codAnuncio);
			}
		}
	}
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "anuncio")
	public List<AnuncioDataEvento> getDatas() {
		return datas;
	}

	public void setDatas(List<AnuncioDataEvento> datas) {
		if(datas != null && !datas.isEmpty()){
			this.datas = datas;
			for (AnuncioDataEvento data : this.datas) {
				data.setAnuncio(this.getCodAnuncio());
			}
		}
	}

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "anuncio")
	public List<AnuncioLocal> getLocais() {
		return locais;
	}

	public void setLocais(List<AnuncioLocal> locais) {
		if(locais != null && !locais.isEmpty()){
			this.locais = locais;
			for (AnuncioLocal local : this.locais) {
				local.setAnuncio(this.getCodAnuncio());
			}
		}
	}

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "anuncio")
	public List<AnuncioPendencia> getPendencias() {
		return pendencias;
	}

	public void setPendencias(List<AnuncioPendencia> pendencias) {
		if(pendencias != null && !pendencias.isEmpty()){
			this.pendencias = pendencias;
			for (AnuncioPendencia pendencia : this.pendencias) {
				pendencia.setAnuncio(this.getCodAnuncio());
			}
		}
	}

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "anuncio")
	public List<AnuncioPremium> getDadosPremium() {
		return dadosPremium;
	}

	public void setDadosPremium(List<AnuncioPremium> dadosPremium) {
		if(dadosPremium != null && !dadosPremium.isEmpty()){
			this.dadosPremium = dadosPremium;
			for (AnuncioPremium premium : this.dadosPremium) {
				premium.setAnuncio(this.getCodAnuncio());
			}
		}
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}