package br.com.sportsgo.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.sportsgo.model.dao.interfaces.IUsuarioDAO;
import br.com.sportsgo.model.usuario.Usuario;



@Service
@RequestMapping("/usuario")
public class UsuarioService {
	
	@Autowired
	private IUsuarioDAO usuarioDao;

	@ResponseBody
	@RequestMapping(value = "/novo", method = RequestMethod.POST,
					consumes=MediaType.APPLICATION_JSON_VALUE)
	public Usuario novoUsuario(@RequestBody Usuario usuario) throws SQLException {
		System.out.println(usuario);
		usuario.setIdUsuario(usuarioDao.adiciona(usuario));
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
