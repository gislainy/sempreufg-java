package br.com.sportsgo.model.anuncio;

public enum EnumStatusAnuncio {
	NOVO(0, "Novo"),
	EM_ANALISE(1, "Em Análise"),
	PUBLICADO (2, "Publicado"),
	BLOQUEADO (3, "Bloqueado");
	
	private final Integer valor;
	private final String descricao;
	
	EnumStatusAnuncio(Integer valor, String descricao){
		this.valor = valor;
		this.descricao = descricao;
	}
	
	public Integer getValor(){ return this.valor; }
	public String getDescricao(){ return this.descricao; }
}
