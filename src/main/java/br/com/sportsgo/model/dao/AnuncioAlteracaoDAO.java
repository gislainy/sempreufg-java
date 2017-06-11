package br.com.sportsgo.model.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.sportsgo.model.anuncio.AnuncioAlteracao;
import br.com.sportsgo.model.dao.interfaces.IAnuncioAlteracaoDAO;


@Repository
public class AnuncioAlteracaoDAO implements IAnuncioAlteracaoDAO{
	 	
	private final GenericDAO<AnuncioAlteracao,Long> dao;
	    
	    @Autowired
	    public AnuncioAlteracaoDAO(final SessionFactory factory) {
	        dao  = new GenericDAO<AnuncioAlteracao,Long>(factory, AnuncioAlteracao.class);
	    }
		
	    @Transactional
		public Long adiciona(AnuncioAlteracao t) {
			return dao.adiciona(t);
		}

	    @Transactional
		public void remove(AnuncioAlteracao t) {
			dao.remove(t);	
		}

	    @Transactional
		public AnuncioAlteracao busca(Long id) {
			return dao.busca(id);
		}

	    @Transactional
		public List<AnuncioAlteracao> lista() {
			return dao.lista();
		}

	    @Transactional
		public void atualiza(AnuncioAlteracao t) {
			dao.atualiza(t);
		}

	    @Transactional
		public void remove(Long id) {
			dao.remove(id);
		}

}
