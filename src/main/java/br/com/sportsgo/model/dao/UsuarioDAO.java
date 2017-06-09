package br.com.sportsgo.model.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.sportsgo.model.dao.interfaces.IUsuarioDAO;
import br.com.sportsgo.model.usuario.Usuario;

@Repository
public class UsuarioDAO implements IUsuarioDAO {

	private final GenericDAO<Usuario,Long> dao;
	
	@Autowired
    public UsuarioDAO(final SessionFactory factory) {
        dao  = new GenericDAO<Usuario,Long>(factory, Usuario.class);
    }
	
    @Transactional
	public void adiciona(Usuario t) {
		dao.adiciona(t);
	}

    @Transactional
	public void remove(Usuario t) {
		dao.remove(t);	
	}

    @Transactional
	public Usuario busca(Long id) {
		return dao.busca(id);
	}

    @Transactional
	public List<Usuario> lista() {
		return dao.lista();
	}

    @Transactional
	public void atualiza(Usuario t) {
		dao.atualiza(t);
	}

    @Transactional
	public void remove(Long id) {
		dao.remove(id);
	}	
}
