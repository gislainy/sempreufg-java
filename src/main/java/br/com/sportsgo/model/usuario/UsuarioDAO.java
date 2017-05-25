package br.com.sportsgo.model.usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.sportsgo.model.ConnectionFactory;
import br.com.sportsgo.model.pessoa.Pessoa;
import br.com.sportsgo.service.interceptor.TokenResponse;

public class UsuarioDAO {

	public int novaPessoa(Pessoa pessoa) throws SQLException {
		
		Connection conn = new ConnectionFactory().obterConexao();
		int resultado = 0;

		String sql = "insert into sppessoa(nome,cpfcnpj,telefone,email,tipopessoa) values(?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, pessoa.getNome());
		pstmt.setString(2, pessoa.getCpfcnpj());
		pstmt.setString(3, pessoa.getTelefone());
		pstmt.setString(4, pessoa.getEmail());
		pstmt.setString(5, pessoa.getTipopessoa());
		
		try {
			resultado = pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new SQLException("Falha no cadastrado da pessoa");
		}
		
		conn.close();
		pstmt.close();
	
		return resultado;
	}
	
	public int novoUsuario(Usuario usuario) throws SQLException {

		if(novaPessoa(usuario.getPessoa()) == 1) {
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
		} else {
			return 0;
		}
	}
	
}
