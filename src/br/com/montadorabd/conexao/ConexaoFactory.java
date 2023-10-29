package br.com.montadorabd.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Classe de configuração e teste da conexão com o banco de dados
public class ConexaoFactory {

	// throws caso dê algum erro, ele ajuda a capturar a mensagem de erro
	public static void main(String[] args) throws SQLException {
		
		// ETEC
		String url = "jdbc:mysql://localhost:3307/iago";
		final String USER = "root";
		final String PASS = "*123456HAS*";
		// CASA
		/*String url = "jdbc:mysql://localhost:3306/iago";
		final String USER = "root";
		final String PASS = "123456";*/
		// DriverManager responsável por trafegar informações entre o backend e o banco de dados (jdbc.jar)
		// Connection conexao = DriverManager.getConnection(url, "root","*123456HAS*");
		Connection conexao = DriverManager.getConnection(url, USER, PASS);
		System.out.println("Abriu conexão: " + conexao);
	}
}