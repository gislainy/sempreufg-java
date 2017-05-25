package br.com.sportsgo.service;

import java.sql.SQLException;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.sportsgo.model.usuario.Usuario;
import br.com.sportsgo.model.usuario.UsuarioDAO;


@Service
@RequestMapping("/usuario")
public class UsuarioService {
	
	UsuarioDAO usuariodao = new UsuarioDAO();

	@ResponseBody
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public boolean novoUsuario(@RequestBody Usuario usuario) throws SQLException {
		if(usuariodao.novoUsuario(usuario) == 1) {
			return true;
		} else {
			return false;
		}
	}
	
}
