package br.com.sportsgo.model.dao.interfaces;

import java.util.List;

import br.com.sportsgo.model.anuncio.Anuncio;
import br.com.sportsgo.model.anuncio.EnumStatusAnuncio;

public interface IAnuncioDAO extends IDao<Anuncio, Long>{
	public List<Anuncio> consultaPorModalidade(String modalidade);
	public List<Anuncio> consultaPorUsuario(Long idUsuario);
	public List<Anuncio> buscarAnunciosPendentes(EnumStatusAnuncio emAnalise);
	public List<Anuncio> buscarAnunciosPublicados(EnumStatusAnuncio publicado);
	public List<Anuncio> buscarAnunciosBloqueados(EnumStatusAnuncio bloqueado);
	
}
