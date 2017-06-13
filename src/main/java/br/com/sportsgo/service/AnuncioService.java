package br.com.sportsgo.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.sportsgo.model.anuncio.Anuncio;
import br.com.sportsgo.model.dao.interfaces.IAnuncioDAO;
import br.com.sportsgo.model.usuario.Usuario;



@Service
@RequestMapping("/anuncio")
public class AnuncioService {
	
	@Autowired
	private IAnuncioDAO anuncioDao;

	@ResponseBody
	@RequestMapping(value = "/novo", method = RequestMethod.POST,
					consumes=MediaType.APPLICATION_JSON_VALUE)
	public Anuncio novoUsuario(@RequestBody Anuncio anuncio) throws SQLException {
		anuncio.setCodAnuncio(anuncioDao.adiciona(anuncio));
		return anuncio;
	}
	
	@ResponseBody
	@RequestMapping(value = "/blankAnuncio", method = RequestMethod.GET,
					produces = MediaType.APPLICATION_JSON_VALUE)
	public Anuncio  anuncioEmBranco() {
		Anuncio anuncio = new Anuncio();
		anuncio.setUsuario(new Usuario());
		return anuncio;
	}
	
	@ResponseBody
	@RequestMapping(value = "/listaAnuncios", method = RequestMethod.GET)
	public ArrayList<Anuncio> listaAnuncios() throws SQLException {
		ArrayList<Anuncio> listaAnuncios = (ArrayList<Anuncio>) anuncioDao.lista();
		return listaAnuncios;
	}
	
}
