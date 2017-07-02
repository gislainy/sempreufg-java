package br.com.sportsgo.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.sportsgo.model.anuncio.AnuncioComentario;
import br.com.sportsgo.model.dao.interfaces.IAnuncioComentarioDAO;

@Repository
public class AnuncioComentarioDAO implements IAnuncioComentarioDAO {

private final GenericDAO<AnuncioComentario,Long> dao;
    
    @Autowired
    public AnuncioComentarioDAO(final SessionFactory factory) {
        dao  = new GenericDAO<AnuncioComentario,Long>(factory, AnuncioComentario.class);
    }
	
    @Transactional
	public Long adiciona(AnuncioComentario t) {
		return dao.adiciona(t);
	}

    @Transactional
	public void remove(AnuncioComentario t) {
		dao.remove(t);
	}

    @Transactional
	public void remove(Long id) {
		dao.remove(id);
	}

    @Transactional
	public AnuncioComentario busca(Long id) {
		Criteria criteria = dao.getCriteria();
    	criteria.add(Restrictions.eq("idComentario",id));
    	return (AnuncioComentario) criteria.uniqueResult();
	}

    @Transactional
	public List<AnuncioComentario> lista() {
		return dao.lista();
	}

    @Transactional
	public void atualiza(AnuncioComentario t) {
		dao.atualiza(t);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<AnuncioComentario> listarComentariosDesc(Long id) {
		Criteria criteria = dao.getCriteria();
    	criteria.add(Restrictions.eq("anuncio",id)).addOrder(Order.asc("idComentario"));
    	return criteria.list();
	}
}
