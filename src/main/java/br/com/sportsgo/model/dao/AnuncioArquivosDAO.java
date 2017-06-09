package br.com.sportsgo.model.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.sportsgo.model.anuncio.AnuncioArquivos;
import br.com.sportsgo.model.dao.interfaces.IAnuncioArquivosDAO;

@Repository
public class AnuncioArquivosDAO implements IAnuncioArquivosDAO {
	
	private final GenericDAO<AnuncioArquivos,Long> dao;
    
    @Autowired
    public AnuncioArquivosDAO(final SessionFactory factory) {
        dao  = new GenericDAO<AnuncioArquivos,Long>(factory, AnuncioArquivos.class);
    }
	
    @Transactional
	public void adiciona(AnuncioArquivos t) {
		dao.adiciona(t);
	}

    @Transactional
	public void remove(AnuncioArquivos t) {
		dao.remove(t);	
	}

    @Transactional
	public AnuncioArquivos busca(Long id) {
		return dao.busca(id);
	}

    @Transactional
	public List<AnuncioArquivos> lista() {
		return dao.lista();
	}

    @Transactional
	public void atualiza(AnuncioArquivos t) {
		dao.atualiza(t);
	}

    @Transactional
	public void remove(Long id) {
		dao.remove(id);
	}
	
}
