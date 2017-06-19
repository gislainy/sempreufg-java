package br.com.sportsgo.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.sportsgo.model.dao.interfaces.IEmailDAO;
import br.com.sportsgo.model.utils.Email;

@Repository
public class EmailDAO implements IEmailDAO{
	
	private final GenericDAO<Email,Long> dao;
    
    @Autowired
    public EmailDAO(final SessionFactory factory) {
        dao  = new GenericDAO<Email,Long>(factory, Email.class);
    }
	
    @Transactional
	public Long adiciona(Email t) {
		return dao.adiciona(t);
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

    @SuppressWarnings("unchecked")
	@Transactional
	public List<Email> consultaEmail(String email) {
    	//http://www.devmedia.com.br/hibernate-api-criteria-realizando-consultas/29627
    	Criteria criteria = dao.getCriteria();
    	criteria.add(Restrictions.eq("enderecoEmail",email));
    	return  criteria.list();
	}
}
