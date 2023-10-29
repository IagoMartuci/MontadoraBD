package br.com.montadorabd.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	public static Connection abrirConexao() {
		Connection con = null;
		try {
			// Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("com.mysql.jdbc.Driver");
			// ETEC
			String url = "jdbc:mysql://localhost:3307/iago";
			// final significa que a variável não pode sofrer alteração de valor em outras partes do código
			final String USER = "root";
			final String PASS = "*123456HAS*";
			// CASA
			/*String url = "jdbc:mysql://localhost:3306/iago";
			// final significa que a variável não pode sofrer alteração de valor em outras partes do código
			final String USER = "root";
			final String PASS = "123456";*/
			con = DriverManager.getConnection(url, USER, PASS);
			System.out.println("Conexão aberta");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage() + "Erro no envio dos dados");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "Erro no envio dos dados");
		}
		return con;
	}

	public static void fecharConexao(Connection con) {
		try {
			con.close();
			System.out.println("Conexão fechada");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + " Erro para fechar");
		} catch (Exception e) {
			System.out.println(e.getMessage() + " Erro para fechar");
		}
	}
}