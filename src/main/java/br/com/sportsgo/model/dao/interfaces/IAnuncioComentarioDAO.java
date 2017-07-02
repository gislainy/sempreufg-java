package br.com.sportsgo.model.dao.interfaces;

import java.util.List;

import br.com.sportsgo.model.anuncio.AnuncioComentario;

public interface IAnuncioComentarioDAO extends IDao<AnuncioComentario, Long>{

	public List<AnuncioComentario> listarComentariosDesc(Long id);
	
}
