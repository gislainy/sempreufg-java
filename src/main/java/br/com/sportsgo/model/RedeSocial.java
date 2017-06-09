package br.com.sportsgo.model;


public class RedeSocial{
	private Long idRedeSocial;
	private String nomeRede;
	private String profile;
	
	//Metodos Getters and Setters
	public String getNomeRede() {
		return nomeRede;
	}
	public void setNomeRede(String nomeDaRede) {
		this.nomeRede = nomeDaRede;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public Long getIdRedeSocial() {
		return idRedeSocial;
	}
	public void setIdRedeSocial(Long idRedeSocial) {
		this.idRedeSocial = idRedeSocial;
	}
}