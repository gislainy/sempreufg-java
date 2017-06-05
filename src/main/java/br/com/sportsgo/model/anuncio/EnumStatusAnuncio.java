package br.com.sportsgo.model.anuncio;

public enum EnumStatusAnuncio {
	EM_ANALISE(0, "Em Análise"),
	PUBLICADO (1, "Publicado"),
	BLOQUEADO (2, "Bloqueado");
	
	private final Integer valor;
	private final String descricao;
	
	EnumStatusAnuncio(Integer valor, String descricao){
		this.valor = valor;
		this.descricao = descricao;
	}
	
	public Integer getValor(){ return this.valor; }
	public String getDescricao(){ return this.descricao; }
}
