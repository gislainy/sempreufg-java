package br.com.sportsgo.service;

import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.sportsgo.model.dao.interfaces.IUsuarioDAO;
import br.com.sportsgo.model.usuario.SendHTMLEmail;
import br.com.sportsgo.model.usuario.Usuario;

@Service
@RequestMapping("/usuario")
public class UsuarioService {

	@Autowired
	private IUsuarioDAO usuarioDao;

	@ResponseBody
	@RequestMapping(value = "/novo", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Usuario novoUsuario(@RequestBody Usuario usuario) throws SQLException, MalformedURLException {
		usuario.setSenha(usuario.getSenha());
		//if (valideCadastroDeUsuario(usuario)) {
			usuarioDao.adiciona(usuario);
			SendHTMLEmail email = new SendHTMLEmail(usuario.getEmails().get(0).getEnderecoEmail());
			email.enviarEmail(usuario.getLogin(), usuario.getSenha());
		//}
		return usuario;
	}

	@ResponseBody
	@RequestMapping(value = "/blankUsuario", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Usuario usuarioEmBranco() throws SQLException {
		return new Usuario();
	}

	@ResponseBody
	@RequestMapping(value = "/listaUsuarios", method = RequestMethod.GET)
	public ArrayList<Usuario> listaUsuarios() throws SQLException {
		ArrayList<Usuario> listaUsuarios = (ArrayList<Usuario>) usuarioDao.lista();
		return listaUsuarios;
	}

	@ResponseBody
	@RequestMapping(value = "/buscaUsuario/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Usuario buscaUsuario(@PathVariable(value = "id") Long id) throws SQLException {
		Usuario usuario = (Usuario) usuarioDao.busca(id);
		return usuario;
	}

	private Boolean valideCadastroDeUsuario(Usuario usuario) throws MalformedURLException, SQLException {
		Boolean emailExiste = false;
		Boolean cpfCnpjExiste = false;
		Boolean usuarioExiste = false;
		EmailService servicoEmail = new EmailService();

		emailExiste = servicoEmail.valideEmailsDoUsuario(usuario);
		cpfCnpjExiste = this.cpfCnpjJaCadastrado(usuario);
		usuarioExiste = this.loginJaCadastrado(usuario);

		return emailExiste || cpfCnpjExiste || usuarioExiste;
	}

	private Boolean cpfCnpjJaCadastrado(Usuario usuario) {
		Boolean cpfCnpjExiste = false;
		ArrayList<Usuario> listaUsarios = (ArrayList<Usuario>) usuarioDao.lista();
		for (Usuario usuarioLista : listaUsarios) {
			cpfCnpjExiste = usuarioLista.getCpfcnpj().equals(usuario.getCpfcnpj());
			if (cpfCnpjExiste)
				break;
		}

		return cpfCnpjExiste;
	}

	private Boolean loginJaCadastrado(Usuario usuario) {
		Boolean loginExiste = false;
		ArrayList<Usuario> listaUsarios = (ArrayList<Usuario>) usuarioDao.lista();
		for (Usuario usuarioLista : listaUsarios) {
			loginExiste = usuarioLista.getLogin().equals(usuario.getLogin());
			if (loginExiste)
				break;
		}

		return loginExiste;
	}

}
