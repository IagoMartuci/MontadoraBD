package br.com.montadorabd.teste;

import java.sql.Connection;

import br.com.montadorabd.conexao.Conexao;
import br.com.montadorabd.dao.CarroDAO;

public class ProgramaDeletarSemWhere {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = Conexao.abrirConexao();
		
		CarroDAO carroDao = new CarroDAO(con);
		
		System.out.println(carroDao.deletarTudo());
		
		Conexao.fecharConexao(con);
	}

}
