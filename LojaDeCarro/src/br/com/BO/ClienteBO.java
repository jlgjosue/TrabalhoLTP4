package br.com.BO;

import java.sql.SQLException;
import java.util.List;

import br.com.DAO.ClienteDAO;
import br.com.DAO.CarroDAO;
import br.com.entidade.Cliente;
import br.com.entidade.Carro;

public class ClienteBO {
	 private static ClienteDAO dao = new ClienteDAO();
	public void cadastar(Cliente cliente) throws  SQLException {
		
		dao.cadastrar(cliente);
		
	}

	public static List<Cliente> listarTodos() throws  SQLException {
		
		return dao.listarTodos();
	}

	public Cliente consultarPorId(int id) throws  SQLException {
		// TODO Auto-generated method stub
		return dao.consultarPorId(id);
	}

	public void excluirCliente(Cliente cliente) throws  SQLException {
		dao.excluirCliente(cliente);
		
	}

	public void alterarCliente(Cliente cliente) throws  SQLException {
		dao.alterarProduto(cliente);
		
	}

}
