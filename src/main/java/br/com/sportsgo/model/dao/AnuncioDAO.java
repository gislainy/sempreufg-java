package br.com.sportsgo.model.dao;

import br.com.sportsgo.model.Anuncio;

public class AnuncioDAO extends GenericDao<Anuncio, Long> {
	public AnuncioDAO(){
		super(Anuncio.class);
	}
}
