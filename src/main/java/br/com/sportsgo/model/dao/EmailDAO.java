package br.com.sportsgo.model.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.sportsgo.model.Email;
import br.com.sportsgo.model.dao.interfaces.IEmailDAO;

@Repository
public class EmailDAO implements IEmailDAO{
	
	private final GenericDAO<Email,Long> dao;
    
    @Autowired
    public EmailDAO(final SessionFactory factory) {
        dao  = new GenericDAO<Email,Long>(factory, Email.class);
    }
	
    @Transactional
	public void adiciona(Email t) {
		dao.adiciona(t);
	}

    @Transactional
	public void remove(Email t) {
		dao.remove(t);	
	}

    @Transactional
	public Email busca(Long id) {
		return dao.busca(id);
	}

    @Transactional
	public List<Email> lista() {
		return dao.lista();
	}

    @Transactional
	public void atualiza(Email t) {
		dao.atualiza(t);
	}

    @Transactional
	public void remove(Long id) {
		dao.remove(id);
	}
}
