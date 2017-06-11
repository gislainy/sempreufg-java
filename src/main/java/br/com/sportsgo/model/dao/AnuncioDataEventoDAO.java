package br.com.sportsgo.model.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.sportsgo.model.anuncio.AnuncioDataEvento;
import br.com.sportsgo.model.dao.interfaces.IAnuncioDataEventoDAO;

@Repository
public class AnuncioDataEventoDAO implements IAnuncioDataEventoDAO {
	
	private final GenericDAO<AnuncioDataEvento,Long> dao;
    
    @Autowired
    public AnuncioDataEventoDAO(final SessionFactory factory) {
        dao  = new GenericDAO<AnuncioDataEvento,Long>(factory, AnuncioDataEvento.class);
    }
	
    @Transactional
	public Long adiciona(AnuncioDataEvento t) {
		return dao.adiciona(t);
	}

    @Transactional
	public void remove(AnuncioDataEvento t) {
		dao.remove(t);	
	}

    @Transactional
	public AnuncioDataEvento busca(Long id) {
		return dao.busca(id);
	}

    @Transactional
	public List<AnuncioDataEvento> lista() {
		return dao.lista();
	}

    @Transactional
	public void atualiza(AnuncioDataEvento t) {
		dao.atualiza(t);
	}

    @Transactional
	public void remove(Long id) {
		dao.remove(id);
	}	
}
