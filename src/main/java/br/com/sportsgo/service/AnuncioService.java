package br.com.sportsgo.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.sportsgo.model.anuncio.Anuncio;
import br.com.sportsgo.model.anuncio.AnuncioArquivo;
import br.com.sportsgo.model.dao.interfaces.IAnuncioArquivoDAO;
import br.com.sportsgo.model.dao.interfaces.IAnuncioDAO;



@Service
@RequestMapping("/anuncio")
public class AnuncioService {
	
	@Autowired
	private IAnuncioDAO anuncioDao;
	
	@Autowired
	private IAnuncioArquivoDAO arquivoDao;
	
	@Autowired
	ServletContext context;

	@ResponseBody
	@RequestMapping(value = "/novo", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ModelMap novoUsuario(@RequestParam("file") MultipartFile[] files, HttpServletRequest request) throws SQLException, IOException {
		
		ModelMap model = new ModelMap();
		model.putAll(request.getParameterMap());
		String anuncioJSON = ((String[]) model.get("anuncio"))[0];
		
		ObjectMapper mapper = new ObjectMapper();
		Anuncio anuncio = new Anuncio();
		anuncio = mapper.readValue(anuncioJSON, Anuncio.class);
		if (!anuncio.getDescricao().isEmpty()){
			anuncio.setCodAnuncio(anuncioDao.adiciona(anuncio));
			if (anuncio.getCodAnuncio()>0){
				return this.uploadFilesArquivos(files, anuncio);
			}
		}else{
			throw new RuntimeException("A descrição deve ser preenchida");
		} 
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value = "/blank-anuncio", method = RequestMethod.GET,
					produces = MediaType.APPLICATION_JSON_VALUE)
	public Anuncio  anuncioEmBranco() {
		return new Anuncio();
	}
	
	@ResponseBody
	@RequestMapping(value = "/listar-anuncios", method = RequestMethod.GET)
	public ArrayList<Anuncio> listaAnuncios() throws SQLException {
		ArrayList<Anuncio> listaAnuncios = (ArrayList<Anuncio>) anuncioDao.lista();
		return listaAnuncios;
	}
	
	@ResponseBody
	@RequestMapping(value = "/listar-anuncios-por-modalidade/{modalidade}", method = RequestMethod.GET)
	public ArrayList<Anuncio> listaAnunciosPorModalidade(@PathVariable("modalidade") String modalidade) throws SQLException {
		ArrayList<Anuncio> listaAnuncios = (ArrayList<Anuncio>) anuncioDao.consultaPorModalidade(modalidade);
		return listaAnuncios;
	}
	
	@ResponseBody
	@RequestMapping(value = "/anuncio-imagem", 
					consumes = MediaType.MULTIPART_FORM_DATA_VALUE, headers = ("content-type=multipart/*"), method = RequestMethod.POST)
	public ModelMap uploadFilesArquivos(@RequestParam("file") MultipartFile[] files, 
									  @RequestBody Anuncio anuncio) {
		ArrayList<MultipartFile> arquivos = new ArrayList<MultipartFile>(Arrays.asList(files));
		AnuncioArquivo imagemDoAnuncio;
		ModelMap retorno = new ModelMap();
		for (MultipartFile file : arquivos) {
			String name = file.getOriginalFilename();
			try {
				byte[] bytes = file.getBytes();
							
				// Caso não exista diretório para o anúncio o mesmo será criado
				String rootPath = context.getRealPath("/uploaded") + File.separator + anuncio.getUsuario();
				File dir = new File(rootPath + File.separator + anuncio.getCodAnuncio());
				if (!dir.exists())
					dir.mkdirs();

				// Arquivo criado no server
				File caminhoDoArquivo = new File(dir.getAbsolutePath()
						+ File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(caminhoDoArquivo));
				stream.write(bytes);
				stream.close();
				String caminhobd = "uploaded" + File.separator + anuncio.getUsuario() + File.separator + anuncio.getCodAnuncio() + File.separator +  name;
				imagemDoAnuncio = new AnuncioArquivo(anuncio, caminhobd);
				arquivoDao.adiciona(imagemDoAnuncio);
				anuncio.getArquivos().add(imagemDoAnuncio);
				
				retorno.addAttribute("retorno", true);
				
			} catch (Exception e) {
				retorno.addAttribute("retorno", false);
				return retorno ;
			}
		}
		return retorno;
	}
	
	
}
