package br.com.BO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.DAO.CarroDAO;
import br.com.DAO.VendaDAO;
import br.com.Exception.CampoVazioExcetion;
import br.com.Exception.CarroDeGraca;
import br.com.entidade.Carro;

public class CarroBO {
	static CarroDAO DAO = new CarroDAO();
	public boolean cadastro(Carro carro) throws  SQLException, CampoVazioExcetion, CarroDeGraca {
		verificarCarro(carro);
	return DAO.cadastrar(carro);
		
	}

	public static List<Carro> listarTodos() throws  SQLException {
	
		return DAO.listarTodos();
	}
	
	

	public static Carro consutarPorId(int Id) throws  SQLException {
		// TODO Auto-generated method stub
		return DAO.consultarPorId(Id);
	}

	public static void alterarCarro(Carro carro) throws  SQLException, CampoVazioExcetion, CarroDeGraca {
		verificarCarro(carro);
		DAO.alterarCarro(carro);
		
	}

	public static void excluirCarro(Carro produto) throws  SQLException {
		DAO.excluirCarro(produto);
		
	}
	public static boolean verificarCarroNaVenda(int id){
		return VendaDAO.verificaCarro(id);
	}
	
	public static void verificarCarro(Carro car) throws CampoVazioExcetion, CarroDeGraca  {
		
		
		if((car.getNome() == null || car.getNome() =="") ){
			 throw new  CampoVazioExcetion();
		}
		if(car.getPreco() <=0){
			throw new CarroDeGraca();
		}
		
		
	}

}
