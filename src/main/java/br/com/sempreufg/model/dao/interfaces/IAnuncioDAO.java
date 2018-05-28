package br.com.sempreufg.model.dao.interfaces;

import java.util.List;

import br.com.sempreufg.model.anuncio.Anuncio;
import br.com.sempreufg.model.anuncio.EnumStatusAnuncio;

public interface IAnuncioDAO extends IDao<Anuncio, Long>{
 	public List<Anuncio> consultaPorModalidade(String modalidade);
	public List<Anuncio> consultarAnunciosPublicadosPorUsuario(Long idUsuario);
	public List<Anuncio> consultarAnunciosEmAnalisePorUsuario(Long idUsuario);
	public List<Anuncio> buscarAnunciosPendentes(EnumStatusAnuncio emAnalise);
	public List<Anuncio> buscarAnunciosPublicados(EnumStatusAnuncio publicado);
	public List<Anuncio> buscarAnunciosBloqueados(EnumStatusAnuncio bloqueado);
	
}
