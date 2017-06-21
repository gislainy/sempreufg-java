package br.com.sportsgo.model.usuario;

import java.beans.Transient;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.sportsgo.model.pessoa.Pessoa;
import br.com.sportsgo.model.utils.Email;
import br.com.sportsgo.model.utils.Endereco;
import br.com.sportsgo.model.utils.RedeSocial;
import br.com.sportsgo.model.utils.Telefone;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Usuario extends Pessoa {

	private Long idUsuario;
	private String login;
	private String senha;
	private List<Email> emails;
	private List<Endereco> enderecos;
	private List<RedeSocial> redeSocias;
	private List<Telefone> telefones;

	@Id
	@GeneratedValue
	@Column(name = "idUsuario")
	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario", orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<Email> getEmails() {
		return emails;
	}

	public void setEmails(List<Email> emails) {
		this.emails = emails;
		for (Email email : this.emails) {
			email.setUsuario(this.getIdUsuario());
		}
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<RedeSocial> getRedeSocias() {
		return redeSocias;
	}

	public void setRedeSocias(List<RedeSocial> redeSocias) {
		this.redeSocias = redeSocias;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;

	}
}