package br.com.sportsgo.model.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.sportsgo.model.dao.interfaces.IEnderecoDAO;
import br.com.sportsgo.model.utils.Endereco;

@Repository
public class EnderecoDAO implements IEnderecoDAO {
    
	private final GenericDAO<Endereco,Long> dao;
	
	@Autowired
    public EnderecoDAO(final SessionFactory factory) {
        dao  = new GenericDAO<Endereco,Long>(factory, Endereco.class);
    }
	
    @Transactional
	public Long adiciona(Endereco t) {
		return dao.adiciona(t);
	}

    @Transactional
	public void remove(Endereco t) {
		dao.remove(t);	
	}

    @Transactional
	public Endereco busca(Long id) {
		return dao.busca(id);
	}

    @Transactional
	public List<Endereco> lista() {
		return dao.lista();
	}

    @Transactional
	public void atualiza(Endereco t) {
		dao.atualiza(t);
	}

    @Transactional
	public void remove(Long id) {
		dao.remove(id);
	}	
}
