package br.com.sempreufg.model.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.sempreufg.model.anuncio.Anuncio;
import br.com.sempreufg.model.anuncio.EnumStatusAnuncio;
import br.com.sempreufg.model.dao.interfaces.IAnuncioDAO;

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
		Criteria criteria = dao.getCriteria();
    	criteria.add(Restrictions.eq("codAnuncio",id));
    	return (Anuncio) criteria.uniqueResult();
	}

	public List<Anuncio> lista() {
		return dao.lista();
	}

	public void atualiza(Anuncio t) {
		dao.atualiza(t);
	}

	@SuppressWarnings("unchecked")
	public List<Anuncio> consultaPorModalidade(String modalidade) {
		//http://www.devmedia.com.br/hibernate-api-criteria-realizando-consultas/29627
		Criteria criteria = dao.getCriteria();
    	criteria.add(Restrictions.eq("modalidade",modalidade));
    	return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Anuncio> buscarAnunciosPendentes(EnumStatusAnuncio status) {
		//http://www.devmedia.com.br/hibernate-api-criteria-realizando-consultas/29627
		Criteria criteria = dao.getCriteria();
    	criteria.add(Restrictions.eq("status",status));
    	return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Anuncio> buscarAnunciosPublicados(EnumStatusAnuncio status) {
		//http://www.devmedia.com.br/hibernate-api-criteria-realizando-consultas/29627
		Criteria criteria = dao.getCriteria();
    	criteria.add(Restrictions.eq("status",status));
    	return criteria.list();
	}	
	
	@SuppressWarnings("unchecked")
	public List<Anuncio> buscarAnunciosBloqueados(EnumStatusAnuncio status) {
		//http://www.devmedia.com.br/hibernate-api-criteria-realizando-consultas/29627
		Criteria criteria = dao.getCriteria();
    	criteria.add(Restrictions.eq("status",status));
    	return criteria.list();
	}	
	
	@SuppressWarnings("unchecked")
	public List<Anuncio> consultarAnunciosPublicadosPorUsuario(Long idUsuario) {
    	Criteria criteria = dao.getCriteria();
    	criteria.add(Restrictions.eq("usuario",idUsuario)).add(Restrictions.eqOrIsNull("status", EnumStatusAnuncio.PUBLICADO)) ;
    	return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Anuncio> consultarAnunciosEmAnalisePorUsuario(Long idUsuario) {
    	Criteria criteria = dao.getCriteria();
    	criteria.add(Restrictions.eq("usuario",idUsuario)).add(Restrictions.eqOrIsNull("status", EnumStatusAnuncio.EM_ANALISE)) ;
    	return criteria.list();
	}

}
