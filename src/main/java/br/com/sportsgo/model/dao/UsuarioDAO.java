package br.com.sportsgo.model.dao;

import br.com.sportsgo.model.usuario.Usuario;

public class UsuarioDAO extends GenericDao<Usuario, Long> {
	public UsuarioDAO(){
		super(Usuario.class);
	}
}
