package br.com.sportsgo.model.pessoa;

import br.com.sportsgo.model.usuario.Usuario;

public class Pessoa {

	private String nome;
	private String telefone;
	private String cpfcnpj;
	private String email;
	private String tipopessoa;
	private int codigo;
	private Usuario usuario;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getTipopessoa() {
		return tipopessoa;
	}
	public void setTipopessoa(String tipopessoa) {
		this.tipopessoa = tipopessoa;
	}
	public String getCpfcnpj() {
		return cpfcnpj;
	}
	public void setCpfcnpj(String cpfcnpj) {
		this.cpfcnpj = cpfcnpj;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
