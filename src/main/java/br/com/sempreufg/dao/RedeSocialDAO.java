package br.com.sempreufg.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.sempreufg.dao.interfaces.IRedeSocialDAO;
import br.com.sempreufg.model.utils.RedeSocial;

@Repository
public class RedeSocialDAO implements IRedeSocialDAO {

	private final GenericDAO<RedeSocial,Long> dao;
	
	@Autowired
    public RedeSocialDAO(final SessionFactory factory) {
        dao  = new GenericDAO<RedeSocial,Long>(factory, RedeSocial.class);
    }
	
    @Transactional
	public Long adiciona(RedeSocial t) {
		return dao.adiciona(t);
	}

    @Transactional
	public void remove(RedeSocial t) {
		dao.remove(t);	
	}

    @Transactional
	public RedeSocial busca(Long id) {
		return dao.busca(id);
	}

    @Transactional
	public List<RedeSocial> lista() {
		return dao.lista();
	}

    @Transactional
	public void atualiza(RedeSocial t) {
		dao.atualiza(t);
	}

    @Transactional
	public void remove(Long id) {
		dao.remove(id);
	}	
}
