package br.com.BO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.DAO.CarroDAO;
import br.com.DAO.VendaDAO;
import br.com.Exception.CampoVazioExcetion;
import br.com.entidade.Carro;

public class CarroBO {
	static CarroDAO DAO = new CarroDAO();
	public boolean cadastro(Carro produto) throws  SQLException {
	return DAO.cadastrar(produto);
		
	}

	public static List<Carro> listarTodos() throws  SQLException {
	
		return DAO.listarTodos();
	}
	
	

	public static Carro consutarPorId(int Id) throws  SQLException {
		// TODO Auto-generated method stub
		return DAO.consultarPorId(Id);
	}

	public static void alterarCarro(Carro produto) throws  SQLException {
		
		DAO.alterarCarro(produto);
		
	}

	public static void excluirCarro(Carro produto) throws  SQLException {
		DAO.excluirCarro(produto);
		
	}
	public static boolean verificarCarroNaVenda(int id){
		return VendaDAO.verificaCarro(id);
	}
	
	public boolean verificarCarro(Carro car) throws CampoVazioExcetion  {
		
		if((car.getNome() == null) || (car.getPreco()==0)){
			 throw new  CampoVazioExcetion();
		}
		
		return true;
		
	}

}
