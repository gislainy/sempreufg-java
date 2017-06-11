package br.com.sportsgo.model.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.sportsgo.model.anuncio.Anuncio;
import br.com.sportsgo.model.dao.interfaces.IAnuncioDAO;

@Repository
@Transactional
public class AnuncioDAO implements IAnuncioDAO{

	private final GenericDAO<Anuncio,Long> dao;
    
    @Autowired
    public AnuncioDAO(final SessionFactory factory) {
        dao  = new GenericDAO<Anuncio,Long>(factory, Anuncio.class);
    }
	
	public Long adiciona(Anuncio t) {
		return dao.adiciona(t);
	}

	public void remove(Anuncio t) {
		dao.remove(t);
	}

	public void remove(Long id) {
		dao.remove(id);
	}

	public Anuncio busca(Long id) {
		return dao.busca(id);
	}

	public List<Anuncio> lista() {
		return dao.lista();
	}

	public void atualiza(Anuncio t) {
		dao.atualiza(t);
	}


}
