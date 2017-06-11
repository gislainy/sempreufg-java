package br.com.sportsgo.model.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import br.com.sportsgo.model.dao.interfaces.ITelefoneDAO;
import br.com.sportsgo.model.utils.Telefone;

@Repository
public class TelefoneDAO implements ITelefoneDAO {

	private final GenericDAO<Telefone,Long> dao;
	
	@Autowired
    public TelefoneDAO(final SessionFactory factory) {
        dao  = new GenericDAO<Telefone,Long>(factory, Telefone.class);
    }
	
    @Transactional
	public Long adiciona(Telefone t) {
		return dao.adiciona(t);
	}

    @Transactional
	public void remove(Telefone t) {
		dao.remove(t);	
	}

    @Transactional
	public Telefone busca(Long id) {
		return dao.busca(id);
	}

    @Transactional
	public List<Telefone> lista() {
		return dao.lista();
	}

    @Transactional
	public void atualiza(Telefone t) {
		dao.atualiza(t);
	}

    @Transactional
	public void remove(Long id) {
		dao.remove(id);
	}
}
