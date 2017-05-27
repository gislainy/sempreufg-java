
public class Anuncio {
	private long codigo;
	private String descricao;
	private String local;
	private Integer dataDeInclusao;
	private Integer dataDaUltimaAlteracao;
	private Integer dataDoEvento;
	private double enderecoDosArquivos;
	private String modalidade;
	private Boolean existePendencias;
	private Boolean anuncioPublicado;
	private Boolean anuncioBloqueado;
	private double valorDoAnuncio;
	private long numeroDeViews;
	private boolean anuncioFree;
	private boolean anuncioPremium;
	
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public Integer getDataDeInclusao() {
		return dataDeInclusao;
	}
	public void setDataDeInclusao(Integer dataDeInclusao) {
		this.dataDeInclusao = dataDeInclusao;
	}
	public Integer getDataDaUltimaAlteracao() {
		return dataDaUltimaAlteracao;
	}
	public void setDataDaUltimaAlteracao(Integer dataDaUltimaAlteracao) {
		this.dataDaUltimaAlteracao = dataDaUltimaAlteracao;
	}
	public Integer getDataDoEvento() {
		return dataDoEvento;
	}
	public void setDataDoEvento(Integer dataDoEvento) {
		this.dataDoEvento = dataDoEvento;
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
	public Boolean getAnuncioPublicado() {
		return anuncioPublicado;
	}
	public void setAnuncioPublicado(Boolean anuncioPublicado) {
		this.anuncioPublicado = anuncioPublicado;
	}
	public Boolean getAnuncioBloqueado() {
		return anuncioBloqueado;
	}
	public void setAnuncioBloqueado(Boolean anuncioBloqueado) {
		this.anuncioBloqueado = anuncioBloqueado;
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
}
