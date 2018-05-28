package br.com.sempreufg.model.pessoa;
//Nao utilizado

public enum EnumTipoPessoa{
	CPF(""),
	CNPJ("");
	
	private String numero;
	
	EnumTipoPessoa(String numero){
		this.numero = numero;
	}
	public String getTipoEnum(){
		return this.numero;
	}
}
