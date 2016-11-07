package br.com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.banco.Conexao;
import br.com.entidade.Carro;
import br.com.entidade.Cliente;
import br.com.entidade.Venda;

public class VendaDAO {

	public boolean cadastrarVenda(Venda venda)  {
		try{
		Connection con = Conexao.getConexao();
		if (con != null) {

			PreparedStatement ps = con
					.prepareStatement("insert into venda (carro_id, cliente_id, descricao) values (?,?,?)");
			ps.setInt(1, venda.getCarro().getId());
			ps.setInt(2, venda.getCliente().getId());
			ps.setString(3, venda.getDescricao());
			ps.execute();
			ps.close();
			con.close();
			return true;
		}
		return false;
		}catch (SQLException e) {
			e.printStackTrace();
		}
			return false;	
	

	}

	public List<Venda> listarTodas() throws SQLException{
		List<Venda> vendas = new ArrayList<Venda>();
		try {
			Connection con = Conexao.getConexao();
			Venda venda = new Venda();
			Cliente cliente = null;
			Carro carro = null;
			

			PreparedStatement query = con.prepareStatement(
					"SELECT ven.idVenda ,cli.nome, cli.email, cli.sexo, car.nome, car.preco, ven.descricao FROM venda ven "
					+ "JOIN cliente cli ON cli.id = ven.Cliente_id  "
					+ "JOIN carro car ON ven.carro_id = car.id ORDER BY cli.nome, car.nome");
			ResultSet result = query.executeQuery();

			while (result.next()) {

				venda = new Venda();			
				venda.setIdVenda(result.getInt("ven.idVenda"));
				
				cliente = venda.getCliente();
				cliente.setNome(result.getString("cli.nome"));
				cliente.setEmail(result.getString("cli.email"));
				cliente.setSexo(result.getString("cli.sexo").charAt(0));				
				venda.setCliente(cliente);
				
				carro = venda.getCarro();
				carro.setNome(result.getString("car.nome"));
				carro.setPreco(result.getDouble("car.preco"));
				venda.setCarro(carro);	
				
				
				venda.setDescricao(result.getString("ven.descricao"));

				vendas.add(venda);

			}
			result.close();
			query.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return vendas;
	}

	public void excluir(int idVenda) {
		try{
			
			Connection con = Conexao.getConexao();

			PreparedStatement ps = con.prepareStatement("DELETE FROM venda WHERE idVenda = ? ");
			ps.setInt(1, idVenda);
			ps.execute();
			ps.close();
			con.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
