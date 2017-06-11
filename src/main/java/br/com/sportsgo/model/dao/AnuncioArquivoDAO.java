package br.com.sportsgo.model.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.sportsgo.model.anuncio.AnuncioArquivo;
import br.com.sportsgo.model.dao.interfaces.IAnuncioArquivoDAO;

@Repository
public class AnuncioArquivoDAO implements IAnuncioArquivoDAO {
	
	private final GenericDAO<AnuncioArquivo,Long> dao;
    
    @Autowired
    public AnuncioArquivoDAO(final SessionFactory factory) {
        dao  = new GenericDAO<AnuncioArquivo,Long>(factory, AnuncioArquivo.class);
    }
	
    @Transactional
	public Long adiciona(AnuncioArquivo t) {
		return dao.adiciona(t);
	}

    @Transactional
	public void remove(AnuncioArquivo t) {
		dao.remove(t);	
	}

    @Transactional
	public AnuncioArquivo busca(Long id) {
		return dao.busca(id);
	}

    @Transactional
	public List<AnuncioArquivo> lista() {
		return dao.lista();
	}

    @Transactional
	public void atualiza(AnuncioArquivo t) {
		dao.atualiza(t);
	}

    @Transactional
	public void remove(Long id) {
		dao.remove(id);
	}
	
}
