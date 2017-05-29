package br.com.sportsgo.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private final static String URL = "jdbc:postgresql://localhost:5432/sportsgo";
	private final static String USUARIO = "postgres";
	private final static String SENHA = "aula321";

	public Connection obterConexao() throws SQLException {
		try {
			return DriverManager.getConnection(URL, USUARIO, SENHA);
		} catch (SQLException e) {
			throw new SQLException("N�o foi poss�vel estabaceler conex�o com BD");
		}
	}
	
}
