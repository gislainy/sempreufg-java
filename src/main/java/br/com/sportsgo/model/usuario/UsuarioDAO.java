package br.com.sportsgo.model.usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.ui.Model;

import br.com.sportsgo.model.dao.ConnectionFactory;
import br.com.sportsgo.service.interceptor.TokenResponse;

public class UsuarioDAO {
	
	Model retorno;

	public Model novoUsuario(Usuario usuario) throws SQLException {
		Connection conn = new ConnectionFactory().obterConexao();
		int resultado = 0;

		String sql = "insert into spusuario(nome,sobrenome,cpfcnpj,login,senha,pessoajuridica,pessoafisica,datacadastro) values(?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, usuario.getNome());
		pstmt.setString(2, usuario.getSobrenome());
		pstmt.setString(3, usuario.getCpfCnpj());
		pstmt.setString(4, usuario.getLogin());
		pstmt.setString(5, TokenResponse.gerarToken(usuario.getSenha()));
		pstmt.setBoolean(6, usuario.isPessoaJuridica());
		pstmt.setBoolean(7, usuario.isPessoaFisica());
		
		java.util.Date dataUtil = new java.util.Date();
		java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
		pstmt.setDate(6, dataSql);
	
		try {
			resultado = pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new SQLException("Falha no cadastrado do usuário");
		}
		
		conn.close();
		pstmt.close();

		if(resultado == 1) {
			retorno.addAttribute("retorno", true);
		} else {
			retorno.addAttribute("retorno", false);
		}
		return retorno;
	}
	
}
