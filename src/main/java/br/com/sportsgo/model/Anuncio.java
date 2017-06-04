package br.com.sportsgo.model;

import java.util.ArrayList;
import br.com.sportsgo.model.usuario.Usuario;
//*Atributos CamelCase: Verificar BD/Diagrama ER.

public class Anuncio {
	private Usuario usuario;
	private long codAnuncio;
	private String descricao;
	private ArrayList<String> local = new ArrayList<String> ();
	private Integer dataInclusao;
	private Integer dataAlteracao;
	private ArrayList<String> observacaoAlteracao = new ArrayList<String> ();
	private ArrayList<String> dataDoEvento = new ArrayList<String> ();
	private Integer dataTermino;
	private Integer validade;
	private double enderecoDosArquivos;
	private String modalidade;
	private Boolean existePendencias;
	private double valorDoAnuncio;
	private long nrViews;
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
	
	//Metodos Getters and Setters
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
	public ArrayList<String> getLocal() {
		return local;
	}
	public void setLocal(ArrayList<String> local) {
		this.local = local;
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

	public ArrayList<String> getObservacaoAlteracao() {
		return observacaoAlteracao;
	}
	public void setObservacaoAlteracao(ArrayList<String> observacaoAlteracao) {
		this.observacaoAlteracao = observacaoAlteracao;
	}
	public ArrayList<String> getDataDoEvento() {
		return dataDoEvento;
	}
	public void setDataDoEvento(ArrayList<String> dataDoEvento) {
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
	public long getNrViews() {
		return nrViews;
	}
	public void setNrViews(long nrViews) {
		this.nrViews = nrViews;
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