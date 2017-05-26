package br.com.sportsgo.model.pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.sportsgo.model.ConnectionFactory;
import br.com.sportsgo.model.usuario.UsuarioDAO;

public class PessoaDAO {

	public int novaPessoa(Pessoa pessoa) throws SQLException {

		Connection conn = new ConnectionFactory().obterConexao();
		int resultado = 0;

		String sql = "insert into sppessoa(nome,cpfcnpj,telefone,email,tipopessoa,codusuario) values(?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, pessoa.getNome());
		pstmt.setString(2, pessoa.getCpfcnpj());
		pstmt.setString(3, pessoa.getTelefone());
		pstmt.setString(4, pessoa.getEmail());
		pstmt.setString(5, pessoa.getTipopessoa());
		pstmt.setInt(6, pessoa.getUsuario().getCodigo());

		try {
			resultado = pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new SQLException("Falha no cadastrado da pessoa");
		}

		conn.close();
		pstmt.close();

		return resultado;
	}

	public int cadastrarNovaPessoaUsuario(Pessoa pessoa) throws SQLException {
		UsuarioDAO usuario = new UsuarioDAO();
		if (usuario.novoUsuario(pessoa.getUsuario()) == 1) {
			pessoa.getUsuario().setCodigo(usuario.buscarCodigoUsuario(pessoa.getUsuario().getUsuario()));
			return novaPessoa(pessoa);
		}
		return 0;
	}

}
