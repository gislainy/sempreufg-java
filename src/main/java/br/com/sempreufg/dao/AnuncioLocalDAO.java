package br.com.sempreufg.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.sempreufg.dao.interfaces.IAnuncioLocalDAO;
import br.com.sempreufg.model.anuncio.AnuncioLocal;

@Repository
public class AnuncioLocalDAO implements IAnuncioLocalDAO{

	private final GenericDAO<AnuncioLocal,Long> dao;
    
    @Autowired
    public AnuncioLocalDAO(final SessionFactory factory) {
        dao  = new GenericDAO<AnuncioLocal,Long>(factory, AnuncioLocal.class);
    }
	
    @Transactional
	public Long adiciona(AnuncioLocal t) {
		return dao.adiciona(t);
	}

    @Transactional
	public void remove(AnuncioLocal t) {
		dao.remove(t);	
	}

    @Transactional
	public List<AnuncioLocal> lista() {
		return dao.lista();
	}

    @Transactional
	public void atualiza(AnuncioLocal t) {
		dao.atualiza(t);
	}

    @Transactional
	public void remove(Long id) {
		dao.remove(id);
	}

	@Override
	public AnuncioLocal busca(Long id) {
		// TODO Auto-generated method stub
		return null;
	}	
	
}
