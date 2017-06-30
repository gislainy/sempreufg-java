package br.com.sportsgo.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.sportsgo.model.anuncio.AnuncioComentario;


public class AnuncioComentarioDAO {

private final GenericDAO<AnuncioComentario,Long> dao;
    
    @Autowired
    public AnuncioComentarioDAO(final SessionFactory factory) {
        dao  = new GenericDAO<AnuncioComentario,Long>(factory, AnuncioComentario.class);
    }
	
	public Long adiciona(AnuncioComentario t) {
		return dao.adiciona(t);
	}

	public void remove(AnuncioComentario t) {
		dao.remove(t);
	}

	public void remove(Long id) {
		dao.remove(id);
	}

	public AnuncioComentario busca(Long id) {
		Criteria criteria = dao.getCriteria();
    	criteria.add(Restrictions.eq("idComentario",id));
    	return (AnuncioComentario) criteria.uniqueResult();
	}

	public List<AnuncioComentario> lista() {
		return dao.lista();
	}

	public void atualiza(AnuncioComentario t) {
		dao.atualiza(t);
	}
	
}
