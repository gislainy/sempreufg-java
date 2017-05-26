package br.com.sportsgo.service;

import java.sql.SQLException;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.sportsgo.model.pessoa.Pessoa;
import br.com.sportsgo.model.pessoa.PessoaDAO;


@Service
@RequestMapping("/usuario")
public class UsuarioService {
	
	PessoaDAO pessoa = new PessoaDAO();

	@ResponseBody
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public boolean novoUsuario(@RequestBody Pessoa pessoa) throws SQLException {
		if(this.pessoa.cadastrarNovaPessoaUsuario(pessoa) == 1) {
			return true;
		} else {
			return false;
		}
	}
	
}
