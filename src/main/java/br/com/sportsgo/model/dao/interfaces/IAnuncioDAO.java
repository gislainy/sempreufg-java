package br.com.sportsgo.model.dao.interfaces;

import java.util.List;

import br.com.sportsgo.model.anuncio.Anuncio;

public interface IAnuncioDAO extends IDao<Anuncio, Long>{
	public List<Anuncio> consultaPorModalidade(String modalidade);
	public List<Anuncio> consultaPorUsuario(Long idUsuario);
}
