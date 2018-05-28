package br.com.sempreufg.model.dao.interfaces;

import java.util.List;

import br.com.sempreufg.model.usuario.Usuario;

public interface IUsuarioDAO extends IDao<Usuario, Long> {
	 public List<Usuario> consultaLogin(String login);
	 public List<Usuario> consultaPorCpfCnpj(String cpfCnpj);
	 public List<Usuario> consultaPorDadosDeLogin(String login, String senha);
}
