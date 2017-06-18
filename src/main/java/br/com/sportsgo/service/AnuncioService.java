package br.com.sportsgo.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.util.JSONPObject;

import br.com.sportsgo.model.anuncio.Anuncio;
import br.com.sportsgo.model.anuncio.AnuncioArquivo;
import br.com.sportsgo.model.dao.UsuarioDAO;
import br.com.sportsgo.model.dao.interfaces.IAnuncioDAO;
import br.com.sportsgo.model.dao.interfaces.IUsuarioDAO;
import br.com.sportsgo.model.usuario.Usuario;



@Service
@RequestMapping("/anuncio")
public class AnuncioService {
	
	@Autowired
	private IAnuncioDAO anuncioDao;
	
	@Autowired
	ServletContext context;

	@ResponseBody
	@RequestMapping(value = "/novo", method = RequestMethod.POST,
					produces = MediaType.APPLICATION_JSON_VALUE)
	public Anuncio novoUsuario(@RequestParam("file") MultipartFile[] files,
							   @RequestBody Anuncio anuncio) throws SQLException {
	
		if (!anuncio.getDescricao().isEmpty()){
			anuncio.setCodAnuncio(anuncioDao.adiciona(anuncio));
			if (anuncio.getCodAnuncio()>0){
				this.uploadFilesArquivos(files, anuncio);
			}
		}else{
			throw new RuntimeException("A descrição deve ser preenchida");
		}
		return anuncio;
	}
	
	@ResponseBody
	@RequestMapping(value = "/blankAnuncio", method = RequestMethod.GET,
					produces = MediaType.APPLICATION_JSON_VALUE)
	public Anuncio  anuncioEmBranco() {
		return new Anuncio();
	}
	
	@ResponseBody
	@RequestMapping(value = "/listaAnuncios", method = RequestMethod.GET)
	public ArrayList<Anuncio> listaAnuncios() throws SQLException {
		ArrayList<Anuncio> listaAnuncios = (ArrayList<Anuncio>) anuncioDao.lista();
		return listaAnuncios;
	}
	
	@ResponseBody
	@RequestMapping(value = "/anuncioimagem", 
					consumes = MediaType.MULTIPART_FORM_DATA_VALUE, headers = ("content-type=multipart/*"), method = RequestMethod.POST)
	public String uploadFilesArquivos(@RequestParam("file") MultipartFile[] files, 
									  @RequestBody Anuncio anuncio) {
		ArrayList<MultipartFile> arquivos = new ArrayList<MultipartFile>(Arrays.asList(files));
		String message = "";
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
				
				anuncio.getArquivos().add(new AnuncioArquivo(anuncio, caminhoDoArquivo.getAbsolutePath()));
				
				message = message + "Seu arquivo '" + name + "' foi carregado com êxito!\n";
				anuncioDao.atualiza(anuncio);
				
			} catch (Exception e) {
				return "Ao carregar o arquivo '" + name + "' ocorreu a seguinte falha => " + e.getMessage();
			}
		}
		return message;
	}
	
	
}
