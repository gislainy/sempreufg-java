package br.com.sportsgo.model.dao;

import br.com.sportsgo.model.Telefone;

public class TelefoneDAO extends GenericDao<Telefone, Long> {
	public TelefoneDAO(){
		super(Telefone.class);
	}
}
