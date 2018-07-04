package br.com.sempreufg.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.ArrayList;

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

import br.com.sempreufg.dao.interfaces.IEmailDAO;
import br.com.sempreufg.dao.interfaces.IUsuarioDAO;
import br.com.sempreufg.model.usuario.SendHTMLEmail;
import br.com.sempreufg.model.usuario.Usuario;
import br.com.sempreufg.model.utils.Email;
import br.com.sempreufg.service.interceptor.TokenResponse;

@Service
@RequestMapping("/usuario")
public class UsuarioService {

	@Autowired
	private IUsuarioDAO usuarioDao;
	
	@Autowired
	private IEmailDAO emailDao;

	@ResponseBody
	@RequestMapping(value = "/novo", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Usuario novoUsuario(@RequestBody Usuario usuario) throws SQLException, MalformedURLException {
		usuarioDao.adiciona(usuario);
		return usuario;
	}
	
/*	@ResponseBody
	@RequestMapping(value = "/completar-cadastro", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ModelMap completarCadastroUsuario(@RequestBody Usuario usuario) throws SQLException, MalformedURLException {
		ModelMap retorno = new ModelMap();
		usuarioDao.atualiza(usuario);
		retorno.addAttribute("retorno", true);
		return retorno;
	} */
	
	@ResponseBody
	@RequestMapping(value = "/completar-cadastro", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ModelMap novoUsuario(@RequestParam("file") MultipartFile[] files, HttpServletRequest request) throws SQLException, IOException {
		
		ModelMap model = new ModelMap();
		ModelMap retorno = new ModelMap();
		model.putAll(request.getParameterMap());
		String usuarioJSON = ((String[]) model.get("usuario"))[0];
		
		ObjectMapper mapper = new ObjectMapper();
		Usuario usuario = new Usuario();
		usuario = mapper.readValue(usuarioJSON, Usuario.class);
		
		byte[] imagem = null;
		try {
			imagem = files[0].getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		usuario.setImagem(imagem);
		
		usuarioDao.atualiza(usuario);
		retorno.addAttribute("retorno", true);
		return retorno;
	}
	
	@ResponseBody
	@RequestMapping(value = "/enviar-email", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void enviarEmail(@RequestBody Usuario usuario) throws SQLException, MalformedURLException {
		SendHTMLEmail email = new SendHTMLEmail(usuario.getEmails().get(0).getEnderecoEmail());
		email.enviarEmail(usuario.getLogin(), usuario.getSenha());
	}

	@ResponseBody
	@RequestMapping(value = "/autenticar", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ModelMap autenticar(@RequestBody Usuario usuario) {
		return autenticarUsuario(usuario);
	}

	@ResponseBody
	@RequestMapping(value = "/blankUsuario", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Usuario usuarioEmBranco() throws SQLException {
		return new Usuario();
	}

	@ResponseBody
	@RequestMapping(value = "/listaUsuarios", method = RequestMethod.GET)
	public ArrayList<Usuario> listaUsuarios() throws SQLException {
		ArrayList<Usuario> listaUsuarios = (ArrayList<Usuario>) usuarioDao.lista();
		return listaUsuarios;
	}

	@ResponseBody
	@RequestMapping(value = "/buscaUsuario/{id}", method = RequestMethod.GET)
	public Usuario buscaUsuario(@PathVariable(value = "id") Long id) throws SQLException {
		Usuario usuario = usuarioDao.busca(id);
		return usuario;
	}
	
	@ResponseBody
	@RequestMapping(value = "/validar-cadastro", method = RequestMethod.POST)
	public ModelMap validarCadastro(@RequestBody Usuario usuario) throws SQLException {
		ModelMap cadastroValido = new ModelMap();
		try {
			cadastroValido = validarCadastroDeUsuario(usuario);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return cadastroValido;
	}

	private ModelMap validarCadastroDeUsuario(Usuario usuario) throws MalformedURLException, SQLException {
		Boolean emailExiste = false;
		Boolean usuarioExiste = false;
		ModelMap retorno = new ModelMap();
		ArrayList<String> erros = new ArrayList<String>();

		emailExiste = valideEmailsDoUsuario(usuario);
		usuarioExiste = loginJaCadastrado(usuario);
		
		retorno.addAttribute("retorno", emailExiste || usuarioExiste);
		if(emailExiste) erros.add("Email");
		if(usuarioExiste) erros.add("Usuário");
		retorno.addAttribute("erros", erros);
		
		return retorno;
	}
	
	public Boolean valideEmail(Email email) throws SQLException, MalformedURLException {
		Boolean emailJaCadastrado = !emailDao.consultaEmail(email.getEnderecoEmail()).isEmpty();
		return emailJaCadastrado;
	}
	
	public Boolean valideEmailsDoUsuario(Usuario usuario) throws SQLException, MalformedURLException {
		Boolean EmailExiste =  false;
		for(Email email : usuario.getEmails()){
			EmailExiste = this.valideEmail(email);
			if (EmailExiste)  break;
		}
		
		return EmailExiste;
	}

	@SuppressWarnings("unused")
	private Boolean cpfCnpjJaCadastrado(Usuario usuario) {
		Boolean cpfCnpjExiste = !usuarioDao.consultaPorCpfCnpj(usuario.getCpfcnpj()).isEmpty();
		return cpfCnpjExiste;
	}

	private Boolean loginJaCadastrado(@RequestBody Usuario usuario) {
		Boolean loginExiste = !usuarioDao.consultaLogin(usuario.getLogin()).isEmpty();
		return loginExiste;
	}
	
	private ModelMap autenticarUsuario(Usuario usuario) {
		Boolean usuarioExiste = false;
		ArrayList<Usuario> listaUsarios = (ArrayList<Usuario>) usuarioDao.consultaPorDadosDeLogin(usuario.getLogin(), usuario.getSenha());
		usuarioExiste = !listaUsarios.isEmpty();
		if (usuarioExiste){
			ModelMap retorno = new ModelMap();
			for (Usuario usuarioLista : listaUsarios) {
				retorno.addAttribute("id", usuarioLista.getIdUsuario());
				retorno.addAttribute("token", TokenResponse.gerarToken(usuarioLista.getSenha()));
				retorno.addAttribute("nome", usuarioLista.getNome() + " " + usuarioLista.getSobrenome());
				retorno.addAttribute("admin", usuarioLista.getAdmin());
				return retorno;
			}
		}
		return null;
	}
}
