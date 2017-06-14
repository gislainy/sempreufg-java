package br.com.sportsgo.model.usuario;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import br.com.sportsgo.model.pessoa.Pessoa;
import br.com.sportsgo.model.utils.Email;
import br.com.sportsgo.model.utils.Endereco;
import br.com.sportsgo.model.utils.RedeSocial;
import br.com.sportsgo.model.utils.Telefone;


@Entity
public class Usuario extends Pessoa{

	private Long idUsuario;
	private String login;
	private String senha;
	private String email;
    public List<Email>  emails;
	private List<Endereco> enderecos;
	private List<RedeSocial> redeSocias;
	private List<Telefone> telefones;
	
	//Metodos Getters e Setters

	@Id
	@GeneratedValue
	@Column(name="idUsuario")
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
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmail")
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<Email> getEmails() {
		return emails;
	}

	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "codEndereco")
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idRedeSocial")
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<RedeSocial> getRedeSocias() {
		return redeSocias;
	}

	public void setRedeSocias(List<RedeSocial> redeSocias) {
		this.redeSocias = redeSocias;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idTelefone")
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
}