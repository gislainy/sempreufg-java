package br.com.sportsgo.service.interceptor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import br.com.sportsgo.service.interceptor.TokenResponse;

@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller)
			throws Exception {

		final String CAMINHO_LOGIN = "/services/login/autenticar";
		final String CAMINHO_NOVO_USUARIO = "/services/usuario/novo";
		final String CAMINHO_VERIFICAR_USUARIO = "/services/usuarios/verificar";
		boolean caminhoLogin = request.getRequestURI().equals(CAMINHO_LOGIN);
		boolean caminhoNovoUsuario = request.getRequestURI().equals(CAMINHO_NOVO_USUARIO);
		boolean caminhoVerificarUsuario = request.getRequestURI().equals(CAMINHO_VERIFICAR_USUARIO);
		String header = request.getHeader("Authorization");

		if (header == null && header.startsWith("Bearer ")) {
			throw new ServletException("Token inexistente ou inválido");
		}

		String token = header.substring(7);

		if (!token.equals("null")) {
			TokenResponse.validarToken(token);
			return true;
		} else {
			if (!caminhoLogin && !caminhoNovoUsuario && !caminhoVerificarUsuario) {
				response.sendError(response.SC_UNAUTHORIZED, "Usuário não autenticado");
				return false;
			} else {
				return true;
			}
		}

	}

}
