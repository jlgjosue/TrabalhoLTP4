package br.com.BO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.DAO.CarroDAO;
import br.com.DAO.VendaDAO;
import br.com.Exception.CampoVazioException;
import br.com.Exception.CarroDeGracaException;
import br.com.Exception.CarroJaExisteException;
import br.com.entidade.Carro;

public class CarroBO {
	static CarroDAO DAO = new CarroDAO();
	public boolean cadastro(Carro carro) throws  SQLException, CampoVazioException, CarroDeGracaException, CarroJaExisteException {
		
		verificarCarro(carro);
		
		carroJaExite(carro);
		
	return DAO.cadastrar(carro);
		
	}

	public static List<Carro> listarTodos() throws  SQLException {
	
		return DAO.listarTodos();
	}
	
	

	public static Carro consutarPorId(int Id) throws  SQLException {
		// TODO Auto-generated method stub
		return DAO.consultarPorId(Id);
	}

	public static void alterarCarro(Carro carro) throws  SQLException, CampoVazioException, CarroDeGracaException {
		verificarCarro(carro);
		DAO.alterarCarro(carro);
		
	}

	public static void excluirCarro(Carro produto) throws  SQLException {
		DAO.excluirCarro(produto);
		
	}
	public static boolean verificarCarroNaVenda(int id){
		return VendaDAO.verificaCarro(id);
	}
	
	private static void verificarCarro(Carro car) throws CampoVazioException, CarroDeGracaException  {
		
		
		if( car.getNome() =="" || car.getFornecedor() ==""){
			 throw new  CampoVazioException();
		}
		if(car.getPreco() <=0){
			throw new CarroDeGracaException();
		}
		
		
	}
 private static void carroJaExite(Carro carro) throws CarroJaExisteException{
	 if(CarroDAO.VerificarCarroExite(carro)){
		 throw new CarroJaExisteException();
	 }
 }

}
