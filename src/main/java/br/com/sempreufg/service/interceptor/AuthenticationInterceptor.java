package br.com.sempreufg.service.interceptor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {
	@SuppressWarnings({ "null", "static-access" })
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller)
			throws Exception {

		final String CAMINHO_LOGIN = "/services/usuario/autenticar";
		final String CAMINHO_NOVO_USUARIO = "/services/usuario/novo";
		final String CAMINHO_VALIDAR_CADASTRO_USUARIO = "/services/usuario/validar-cadastro";
		final String CAMINHO_ENVIAR_EMAIL_USUARIO = "/services/usuario/enviar-email";
		final String CAMINHO_LISTAR_ANUNCIOS = "/services/anuncio/listar-anuncios-publicados";
		final String CAMINHO_BUSCA_AUTOR_ANUNCIO = "/services/usuario/buscaUsuario";
		final String CAMINHO_BUSCAR_COMENTARIO_ANUNCIO = "/services/anuncio/buscar-comentarios-anuncio";
		boolean caminhoLogin = request.getRequestURI().equals(CAMINHO_LOGIN);
		boolean caminhoNovoUsuario = request.getRequestURI().equals(CAMINHO_NOVO_USUARIO);
		boolean caminhoValidarCadastroUsuario = request.getRequestURI().equals(CAMINHO_VALIDAR_CADASTRO_USUARIO);
		boolean caminhoEnviarEmailUsuario = request.getRequestURI().equals(CAMINHO_ENVIAR_EMAIL_USUARIO);
		boolean caminhoListarAnuncios = request.getRequestURI().equals(CAMINHO_LISTAR_ANUNCIOS);
		boolean caminhoAutorAnuncio = request.getRequestURI().contains(CAMINHO_BUSCA_AUTOR_ANUNCIO);
		boolean caminhoComentarioAnuncio = request.getRequestURI().contains(CAMINHO_BUSCAR_COMENTARIO_ANUNCIO);
		String header = request.getHeader("Authorization");

		if (header == null && header.startsWith("Bearer ")) {
			throw new ServletException("Token inexistente ou inválido");
		}

		String token = header.substring(7);

		if (!token.equals("null")) {
			TokenResponse.validarToken(token);
			return true;
		} else {
			boolean caminhosLivres = !caminhoLogin && !caminhoNovoUsuario && !caminhoValidarCadastroUsuario
					&& !caminhoEnviarEmailUsuario && !caminhoListarAnuncios && !caminhoAutorAnuncio && !caminhoComentarioAnuncio;
			if (caminhosLivres) {
				response.sendError(response.SC_UNAUTHORIZED, "Usuário não autenticado");
				return false;
			} else {
				return true;
			}
		}

	}
}
