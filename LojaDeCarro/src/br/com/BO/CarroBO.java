package br.com.BO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.DAO.CarroDAO;
import br.com.entidade.Carro;

public class CarroBO {

	public boolean cadastro(Carro produto) throws  SQLException {
	CarroDAO DAO = new CarroDAO();
	return DAO.cadastrar(produto);
		
	}

	public static List<Carro> listarTodos() throws  SQLException {
	
		return CarroDAO.listarTodos();
	}
	
	

	public static Carro consutarPorId(int Id) throws  SQLException {
		// TODO Auto-generated method stub
		return CarroDAO.consultarPorId(Id);
	}

	public static void alterarCarro(Carro produto) throws  SQLException {
		CarroDAO.alterarCarro(produto);
		
	}

	public static void excluirCarro(Carro produto) throws  SQLException {
		CarroDAO.excluirCarro(produto);
		
	}

}
