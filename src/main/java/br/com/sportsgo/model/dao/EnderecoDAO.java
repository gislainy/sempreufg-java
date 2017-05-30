package br.com.sportsgo.model.dao;

import br.com.sportsgo.model.Endereco;

public class EnderecoDAO extends GenericDao<Endereco, Long> {
	public EnderecoDAO(){
		super(Endereco.class);
	}
}
