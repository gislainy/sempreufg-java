package br.com.sempreufg.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.sempreufg.dao.interfaces.IAnuncioPremiumDAO;
import br.com.sempreufg.model.anuncio.AnuncioPremium;

@Repository
public class AnuncioPremiumDAO implements IAnuncioPremiumDAO {
	
	private final GenericDAO<AnuncioPremium,Long> dao;
    
    @Autowired
    public AnuncioPremiumDAO(final SessionFactory factory) {
        dao  = new GenericDAO<AnuncioPremium,Long>(factory, AnuncioPremium.class);
    }
	
    @Transactional
	public Long adiciona(AnuncioPremium t) {
		return dao.adiciona(t);
	}

    @Transactional
	public void remove(AnuncioPremium t) {
		dao.remove(t);	
	}

    @Transactional
	public AnuncioPremium busca(Long id) {
		return dao.busca(id);
	}

    @Transactional
	public List<AnuncioPremium> lista() {
		return dao.lista();
	}

    @Transactional
	public void atualiza(AnuncioPremium t) {
		dao.atualiza(t);
	}

    @Transactional
	public void remove(Long id) {
		dao.remove(id);
	}	
}
