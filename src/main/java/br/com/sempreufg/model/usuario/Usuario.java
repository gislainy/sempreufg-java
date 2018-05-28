package br.com.sempreufg.model.usuario;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.SelectBeforeUpdate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.sempreufg.model.pessoa.Pessoa;
import br.com.sempreufg.model.utils.Email;
import br.com.sempreufg.model.utils.Endereco;
import br.com.sempreufg.model.utils.RedeSocial;
import br.com.sempreufg.model.utils.Telefone;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@DynamicUpdate(value=true)
@SelectBeforeUpdate(value=true)
public class Usuario extends Pessoa {

	private Long idUsuario;
	private String login;
	private String senha;
	private boolean admin;
	private List<Email> emails;
	private List<Endereco> enderecos;
	private List<RedeSocial> redesSociais;
	private List<Telefone> telefones;
	
	@Lob
	private byte[] imagem;

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
		if(emails != null && !emails.isEmpty()){
			this.emails = emails;
			for (Email email : this.emails) {
				email.setUsuario(this.idUsuario);
			}
		}
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		if(enderecos != null && !enderecos.isEmpty()){
			this.enderecos = enderecos;
			for (Endereco endereco : this.enderecos) {
				endereco.setUsuario(this.idUsuario);
			}
		}
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<RedeSocial> getRedesSociais() {
		return redesSociais;
	}

	public void setRedesSociais(List<RedeSocial> redesSociais) {
		if(redesSociais != null && !redesSociais.isEmpty()){
			this.redesSociais = redesSociais;
			for (RedeSocial redeSocial : this.redesSociais) {
				redeSocial.setUsuario(this.idUsuario);
			}
		}
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		if(telefones != null && !telefones.isEmpty()){
			this.telefones = telefones;
			for (Telefone telefone : this.telefones) {
				telefone.setUsuario(this.idUsuario);
			}
		}

	}

	/**
	 * @return the admin
	 */
	public boolean getAdmin() {
		return admin;
	}

	/**
	 * @param admin the admin to set
	 */
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}
}