package br.com.sempreufg.dao.interfaces;

import java.util.List;

import br.com.sempreufg.model.anuncio.AnuncioComentario;

public interface IAnuncioComentarioDAO extends IDao<AnuncioComentario, Long>{

	public List<AnuncioComentario> listarComentariosDesc(Long id);
	
}
