package br.com.sportsgo.model.usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.sportsgo.model.ConnectionFactory;
import br.com.sportsgo.service.interceptor.TokenResponse;

public class UsuarioDAO {
	
	public int novoUsuario(Usuario usuario) throws SQLException {
		Connection conn = new ConnectionFactory().obterConexao();
		int resultado = 0;

		String sql = "insert into spusuario(usuario,senha,tipousuario) values(?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, usuario.getUsuario());
		pstmt.setString(2, TokenResponse.gerarToken(usuario.getSenha()));
		pstmt.setString(3,"administrador");
		try {
			resultado = pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new SQLException("Falha no cadastrado do usuário");
		}
		
		conn.close();
		pstmt.close();

		return resultado;
	}
	
	public int buscarCodigoUsuario(String usuario) throws SQLException {
		Connection conn = new ConnectionFactory().obterConexao();

		String sql = "select codigo from spusuario where usuario = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, usuario);
		ResultSet rs = null;
		try {
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			throw new SQLException("Falha no cadastrado do usuário");
		}
		
		while(rs.next()) {
			return rs.getInt("codigo");
		}
		return 0;
	}
	
}
