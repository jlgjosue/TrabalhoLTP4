package br.com.BO;

import java.sql.SQLException;
import java.util.List;

import br.com.DAO.VendaDAO;
import br.com.entidade.Venda;

public class VendaBO {
	private VendaDAO dao = new VendaDAO();
		
	public void cadastrar(Venda venda) throws  SQLException {
		dao.cadastrarVenda(venda);
		
	}

	public List<Venda> listar() throws SQLException {
		
		return dao.listarTodas();
	}
	
	

}
