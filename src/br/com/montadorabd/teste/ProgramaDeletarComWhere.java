package br.com.montadorabd.teste;

import java.sql.Connection;

import br.com.montadorabd.beans.Carro;
import br.com.montadorabd.conexao.Conexao;
import br.com.montadorabd.dao.CarroDAO;

public class ProgramaDeletarComWhere {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Armazenando o método abrirConexao da classe Conexao
		Connection con = Conexao.abrirConexao();
		
		Carro carro = new Carro();
		// Testando o método deletar
		carro.setQuantidadePortas(3);
		
		// Chamada para que o objeto seja enviado para o BD - Tabela
		CarroDAO carroDao = new CarroDAO(con);
		
		System.out.println(carroDao.deletarComWhere(carro));
		
		// Fecha a conexão para "destruir o carrinho" que levou o objeto ao banco de dados, se deixar aberto, consome memória do servidor do banco de dados
		Conexao.fecharConexao(con);
	}

}
