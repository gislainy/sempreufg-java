package br.com.sportsgo.model.dao;

import br.com.sportsgo.model.pessoa.Pessoa;

public class PessoaDAO extends GenericDao<Pessoa, Long> {
	public PessoaDAO(){
		super(Pessoa.class);
	}
}
