package br.com.sportsgo.model.dao;

import br.com.sportsgo.model.anuncio.Anuncio;

public class AnuncioDAO extends GenericDao<Anuncio, Long> {
	public AnuncioDAO(){
		super(Anuncio.class);
	}
}
