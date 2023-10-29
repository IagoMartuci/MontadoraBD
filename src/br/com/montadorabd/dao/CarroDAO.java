package br.com.montadorabd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.montadorabd.beans.Carro;

public class CarroDAO {

	private Connection con;

	public final Connection getCon() {
		return con;
	}

	public final void setCon(Connection con) {
		this.con = con;
	}

	// Método construtor que recebe como parametro a conexão e inicializa o objeto
	// da classe
	// CarroDAO
	public CarroDAO(Connection con) {
		setCon(con);
	}

	public String inserir(Carro carro) {
		String sql = "insert into carro(modelo, capacidadeCombustivel, quantidadePortas) values (?,?,?)";
		try {
			// "Carrinho" que trafega os dados da aplicação para o banco de dados
			PreparedStatement ps = getCon().prepareStatement(sql);
			// Interrogação 1
			ps.setString(1, carro.getModelo());
			// Interrogação 2
			ps.setFloat(2, carro.getCapacidadeCombustivel());
			// Interrogação 3
			ps.setInt(3, carro.getQuantidadePortas());

			// Quando a operação no BD for efetuada com sucesso, o retorno será 1
			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso.";
			} else {
				return "Erro ao inserir.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	// Deletar sem Where (não recebe objeto)
	public String deletarTudo() {
		String sql = "delete from carro";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);

			if (ps.executeUpdate() != 0)
				return "Todos os dados foram deletados com sucesso.";
			else
				return "Erro ao deletar.";
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	// Deletar com Where
	public String deletarComWhere(Carro carro) {
		String sql = "delete from carro where quantidadePortas = ?";
		try {
			// "Carrinho" que trafega os dados da aplicação para o banco de dados
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, carro.getQuantidadePortas());

			// Quando a operação no BD for efetuada com sucesso, o retorno será 1
			if (ps.executeUpdate() > 0) {
				return "Deletado com sucesso.";
			} else {
				return "Erro ao deletar.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	// Update
	public String modificar(Carro carro) {
		String sql = "update carro set quantidadePortas = 3 where modelo = (?)";

		try {
			// "Carrinho" que trafega os dados da aplicação para o banco de dados
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, carro.getModelo());

			if (ps.executeUpdate() != 0) {
				return "Modificado com sucesso.";
			} else {
				return "Erro ao modificar.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	// Select
	public ArrayList<Carro> selecionar() {
		String sql = "select * from carro";
		ArrayList<Carro> retornarCarro = new ArrayList<Carro>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					Carro carro = new Carro();
					carro.setModelo(rs.getString(1));
					carro.setCapacidadeCombustivel(rs.getFloat(2));
					carro.setQuantidadePortas(rs.getInt(3));
					retornarCarro.add(carro);
				}
				return retornarCarro;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}
}
