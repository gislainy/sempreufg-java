package br.com.sportsgo.model;

import br.com.sportsgo.model.usuario.Usuario;
//*Implementado Camel Case, verificar MER.

public class Anuncio {
	private Usuario usuario;
	private long codAnuncio;
	private String descricao;
	private String local[];
	private long nViews;
	private Integer dataInclusao;
	private Integer dataAlteracao;
	private String observacaoAlteracao;
	private Integer dataDoEvento[];
	private Integer dataTermino;
	private Integer validade;
	private double enderecoDosArquivos;
	private String modalidade;
	private Boolean existePendencias;
	private double valorDoAnuncio;
	private long numeroDeViews;
	private boolean anuncioFree;
	private boolean anuncioPremium;
	private String precoEvento;
	private Boolean possuiPendencia;
	private String observacaoPendencia;
	private String enderecoArquivo;
	private Boolean anuncioPublicadoStatus;
	private Boolean anuncioBloqueadoStatus;
	private Boolean anuncioProfissionalStatus;
	private Integer dataAlteracaoStatus;
	private Integer validadePremium;
	private Integer dataTerminoPremium;
	private Integer dataInicioPremium;
	private Boolean adquiridoPremium;
	private String valorPremium;
	
	//Metódos Getters and Setters
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
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
	public String[] getLocal() {
		return local;
	}
	public void setLocal(String[] local) {
		this.local = local;
	}
	public long getnViews() {
		return nViews;
	}
	public void setnViews(long nViews) {
		this.nViews = nViews;
	}
	public Integer getDataInclusao() {
		return dataInclusao;
	}
	public void setDataInclusao(Integer dataInclusao) {
		this.dataInclusao = dataInclusao;
	}
	public Integer getDataAlteracao() {
		return dataAlteracao;
	}
	public void setDataAlteracao(Integer dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}
	public String getObservacaoAlteracao() {
		return observacaoAlteracao;
	}
	public void setObservacaoAlteracao(String observacaoAlteracao) {
		this.observacaoAlteracao = observacaoAlteracao;
	}
	public Integer[] getDataDoEvento() {
		return dataDoEvento;
	}
	public void setDataDoEvento(Integer[] dataDoEvento) {
		this.dataDoEvento = dataDoEvento;
	}
	public Integer getDataTermino() {
		return dataTermino;
	}
	public void setDataTermino(Integer dataTermino) {
		this.dataTermino = dataTermino;
	}
	public Integer getValidade() {
		return validade;
	}
	public void setValidade(Integer validade) {
		this.validade = validade;
	}
	public double getEnderecoDosArquivos() {
		return enderecoDosArquivos;
	}
	public void setEnderecoDosArquivos(double enderecoDosArquivos) {
		this.enderecoDosArquivos = enderecoDosArquivos;
	}
	public String getModalidade() {
		return modalidade;
	}
	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}
	public Boolean getExistePendencias() {
		return existePendencias;
	}
	public void setExistePendencias(Boolean existePendencias) {
		this.existePendencias = existePendencias;
	}
	public double getValorDoAnuncio() {
		return valorDoAnuncio;
	}
	public void setValorDoAnuncio(double valorDoAnuncio) {
		this.valorDoAnuncio = valorDoAnuncio;
	}
	public long getNumeroDeViews() {
		return numeroDeViews;
	}
	public void setNumeroDeViews(long numeroDeViews) {
		this.numeroDeViews = numeroDeViews;
	}
	public boolean isAnuncioFree() {
		return anuncioFree;
	}
	public void setAnuncioFree(boolean anuncioFree) {
		this.anuncioFree = anuncioFree;
	}
	public boolean isAnuncioPremium() {
		return anuncioPremium;
	}
	public void setAnuncioPremium(boolean anuncioPremium) {
		this.anuncioPremium = anuncioPremium;
	}
	public String getPrecoEvento() {
		return precoEvento;
	}
	public void setPrecoEvento(String precoEvento) {
		this.precoEvento = precoEvento;
	}
	public Boolean getPossuiPendencia() {
		return possuiPendencia;
	}
	public void setPossuiPendencia(Boolean possuiPendencia) {
		this.possuiPendencia = possuiPendencia;
	}
	public String getObservacaoPendencia() {
		return observacaoPendencia;
	}
	public void setObservacaoPendencia(String observacaoPendencia) {
		this.observacaoPendencia = observacaoPendencia;
	}
	public String getEnderecoArquivo() {
		return enderecoArquivo;
	}
	public void setEnderecoArquivo(String enderecoArquivo) {
		this.enderecoArquivo = enderecoArquivo;
	}
	public Boolean getAnuncioPublicadoStatus() {
		return anuncioPublicadoStatus;
	}
	public void setAnuncioPublicadoStatus(Boolean anuncioPublicadoStatus) {
		this.anuncioPublicadoStatus = anuncioPublicadoStatus;
	}
	public Boolean getAnuncioBloqueadoStatus() {
		return anuncioBloqueadoStatus;
	}
	public void setAnuncioBloqueadoStatus(Boolean anuncioBloqueadoStatus) {
		this.anuncioBloqueadoStatus = anuncioBloqueadoStatus;
	}
	public Boolean getAnuncioProfissionalStatus() {
		return anuncioProfissionalStatus;
	}
	public void setAnuncioProfissionalStatus(Boolean anuncioProfissionalStatus) {
		this.anuncioProfissionalStatus = anuncioProfissionalStatus;
	}
	public Integer getDataAlteracaoStatus() {
		return dataAlteracaoStatus;
	}
	public void setDataAlteracaoStatus(Integer dataAlteracaoStatus) {
		this.dataAlteracaoStatus = dataAlteracaoStatus;
	}
	public Integer getValidadePremium() {
		return validadePremium;
	}
	public void setValidadePremium(Integer validadePremium) {
		this.validadePremium = validadePremium;
	}
	public Integer getDataTerminoPremium() {
		return dataTerminoPremium;
	}
	public void setDataTerminoPremium(Integer dataTerminoPremium) {
		this.dataTerminoPremium = dataTerminoPremium;
	}
	public Integer getDataInicioPremium() {
		return dataInicioPremium;
	}
	public void setDataInicioPremium(Integer dataInicioPremium) {
		this.dataInicioPremium = dataInicioPremium;
	}
	public Boolean getAdquiridoPremium() {
		return adquiridoPremium;
	}
	public void setAdquiridoPremium(Boolean adquiridoPremium) {
		this.adquiridoPremium = adquiridoPremium;
	}
	public String getValorPremium() {
		return valorPremium;
	}
	public void setValorPremium(String valorPremium) {
		this.valorPremium = valorPremium;
	}
	
}
