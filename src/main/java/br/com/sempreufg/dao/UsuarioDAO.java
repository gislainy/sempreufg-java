package br.com.sempreufg.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.sempreufg.dao.interfaces.IUsuarioDAO;
import br.com.sempreufg.model.usuario.Usuario;

@Repository
public class UsuarioDAO implements IUsuarioDAO {

	private final GenericDAO<Usuario,Long> dao;
	
	@Autowired
    public UsuarioDAO(final SessionFactory factory) {
        dao  = new GenericDAO<Usuario,Long>(factory, Usuario.class);
    }
	
    @Transactional
	public Long adiciona(Usuario t) {
		return dao.adiciona(t);
	}

    @Transactional
	public void remove(Usuario t) {
		dao.remove(t);	
	}

    @Transactional
	public Usuario busca(Long id) {
    	Criteria criteria = dao.getCriteria();
    	criteria.add(Restrictions.eq("idUsuario",id));
    	return (Usuario) criteria.uniqueResult();
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
    
    @SuppressWarnings("unchecked")
	@Transactional
    public List<Usuario> consultaLogin(String login){
    	//http://www.devmedia.com.br/hibernate-api-criteria-realizando-consultas/29627
    	Criteria criteria = dao.getCriteria();
    	criteria.add(Restrictions.eq("login",login));
    	return criteria.list();
    }

    @SuppressWarnings("unchecked")
	@Transactional
	public List<Usuario> consultaPorCpfCnpj(String cpfCnpj) {
    	Criteria criteria = dao.getCriteria();
    	criteria.add(Restrictions.eq("cpfcnpj",cpfCnpj));
    	return  criteria.list();
	}

    @SuppressWarnings("unchecked")
	@Transactional
	public List<Usuario> consultaPorDadosDeLogin(String login, String senha) {
    	Criteria criteria = dao.getCriteria();
    	criteria.add(Restrictions.eq("login",login));
    	criteria.add(Restrictions.eq("senha",senha));
    	return  criteria.list();
	}
}
