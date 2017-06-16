package br.com.sportsgo.service;

import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.sportsgo.model.dao.interfaces.IUsuarioDAO;
import br.com.sportsgo.model.usuario.EmailUsuario;
import br.com.sportsgo.model.usuario.Usuario;
import br.com.sportsgo.service.interceptor.TokenResponse;



@Service
@RequestMapping("/usuario")
public class UsuarioService {
	
	@Autowired
	private IUsuarioDAO usuarioDao;

	@ResponseBody
	@RequestMapping(value = "/novo", method = RequestMethod.POST,
					consumes=MediaType.APPLICATION_JSON_VALUE)
	public Usuario novoUsuario(@RequestBody Usuario usuario) throws SQLException, EmailException, MalformedURLException {
		usuario.setSenha(TokenResponse.gerarToken(usuario.getSenha()));
		usuarioDao.adiciona(usuario);
		//EmailUsuario email = new EmailUsuario(usuario.getEmails().get(0).getEnderecoEmail(), usuario.getNome());
		//email.enviarEmail(usuario.getLogin(),usuario.getSenha());
		return usuario;
	}
	
	@ResponseBody
	@RequestMapping(value = "/blankUsuario", method = RequestMethod.GET,
					produces = MediaType.APPLICATION_JSON_VALUE)
	public Usuario  usuarioEmBranco() throws SQLException {
		return new Usuario();
	}
	
	@ResponseBody
	@RequestMapping(value = "/listaUsuarios", method = RequestMethod.GET)
	public ArrayList<Usuario> listaUsuarios() throws SQLException {
		ArrayList<Usuario> listaUsuarios = (ArrayList<Usuario>) usuarioDao.lista();
		return listaUsuarios;
	}
	
}
