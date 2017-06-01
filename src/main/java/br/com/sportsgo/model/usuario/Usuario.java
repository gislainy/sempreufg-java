package br.com.sportsgo.model.usuario;
import br.com.sportsgo.model.Endereco;
import br.com.sportsgo.model.RedeSocial;
import br.com.sportsgo.model.Telefone;
import br.com.sportsgo.model.pessoa.Pessoa;
//*Atributos CamelCase verificar banco/Diagrama ER.
//*Get Arrays [N]? --> Getters comentados.

public class Usuario extends Pessoa{
	private String login;
	private String id;
	private String senha;	
	private String nome;
	private String email;
	private String cpnjCpf;
	private Boolean pessoaJuridica;
	private String notificacoesEmail[];
	private Endereco endereco[];
	private Telefone telefone[];
	private RedeSocial redeSocial[];
	
	//Getters and Setters methods
	public String[] getNotificacoesEmail() {
		return notificacoesEmail;
	}
	public void setNotificacoesEmail(String[] notificacoesEmail) {
		this.notificacoesEmail = notificacoesEmail;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getCpnjCpf() {
		return cpnjCpf;
	}
	public void setCpnjCpf(String cpnjCpf) {
		this.cpnjCpf = cpnjCpf;
	}
	
	public Integer getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Integer dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	private Integer dataCadastro;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Boolean getPessoaJuridica() {
		return pessoaJuridica;
	}
	public void setPessoaJuridica(Boolean pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/*public Telefone[] getTelefone() {
		return telefone;
	}*/
	public void setTelefone(Telefone[] telefone) {
		this.telefone = telefone;
	}
	
	/*public RedeSocial[] getRedeSocial() {
		return redeSocial;
	}*/
	public void setRedeSocial(RedeSocial[] redeSocial) {
		this.redeSocial = redeSocial;
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	/*public Endereco[] getEndereco() {
		return endereco;
	}*/
	public void setEndereco(Endereco[] endereco) {
		this.endereco = endereco;
	}
}