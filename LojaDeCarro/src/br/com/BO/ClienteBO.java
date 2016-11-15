package br.com.BO;

import java.sql.SQLException;
import java.util.List;

import br.com.DAO.ClienteDAO;
import br.com.DAO.VendaDAO;
import br.com.Exception.CPFInvalidoException;
import br.com.Exception.CampoVazioException;
import br.com.Exception.EmailInvalidoException;
import br.com.DAO.CarroDAO;
import br.com.entidade.Cliente;
import br.com.entidade.Carro;

public class ClienteBO {
	 private static ClienteDAO dao = new ClienteDAO();
	 
	public void cadastar(Cliente cliente) throws  SQLException, CampoVazioException, EmailInvalidoException, CPFInvalidoException {
		vereficarCliente(cliente);
		dao.cadastrar(cliente);
		
	}

	public static List<Cliente> listarTodos() throws  SQLException {
		
		return dao.listarTodos();
	}

	public Cliente consultarPorId(int id) throws  SQLException {
		return dao.consultarPorId(id);
	}

	public void excluirCliente(Cliente cliente) throws  SQLException {
		dao.excluirCliente(cliente);
		
	}

	public void alterarCliente(Cliente cliente) throws  SQLException, CampoVazioException, EmailInvalidoException, CPFInvalidoException {
		vereficarCliente(cliente);
		dao.alterarCliente(cliente);
		
	}
	
	public boolean verificarClienteNaVenda(int id){
		return VendaDAO.verificaCliente(id);
				}
	
	private void vereficarCliente(Cliente cliente) throws CampoVazioException, EmailInvalidoException, CPFInvalidoException{
		if(cliente.getNome() == "" || cliente.getCpf() =="" || cliente.getEmail()==""){
			throw new CampoVazioException();
		}
		if(cliente.getEmail().indexOf("@") == -1){
			throw new EmailInvalidoException();
		}
		
		if(validarCPF(cliente.getCpf())==false){
			throw new CPFInvalidoException();
		}
	}
	private boolean validarCPF(String cpf){
		//formato 1 2 3 . 4 5 6 . 7 8 9 - 10 11 == com os dois pontos e o traço 14 caracteres
		if(cpf.length() >14){
			return false;
		}
		
		int contPonto=0;
		
		for(int i=0;i<cpf.length(); i++){
			if(cpf.charAt(i)=='.'){
				contPonto++;	
			}
		}
		
		if(contPonto >2 || contPonto<2){
			return false;
		}
		int contTraco=0;
		for(int i=0;i<cpf.length(); i++){
			if(cpf.charAt(i) =='-'){
				contTraco++;	
			}
		}
		if(contTraco >1 || contTraco<1){
			return false;
		}
		
		if(!(cpf.charAt(3)=='.' && cpf.charAt(7)=='.' && cpf.charAt(11)=='-')){
			return false;
		}
		if(cpf.length() - (contPonto + contTraco) <11){
			return false;
		}
		
		
				return true;
	}
	
	

}
