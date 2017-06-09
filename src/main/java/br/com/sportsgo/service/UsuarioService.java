package br.com.sportsgo.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
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
	IUsuarioDAO usuarioDao;

	@ResponseBody
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public Usuario novoUsuario(@RequestBody Usuario usuario) throws SQLException {
		usuarioDao.adiciona(usuario);
		return usuarioDao.busca(usuario.getId());
	}
	
}
