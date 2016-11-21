package br.com.BO;

import java.sql.SQLException;
import java.util.List;

import br.com.DAO.ClienteDAO;
import br.com.DAO.VendaDAO;
import br.com.Exception.CPFInvalidoException;
import br.com.Exception.CampoVazioException;
import br.com.Exception.ClienteJaExiteException;
import br.com.Exception.EmailInvalidoException;
import br.com.DAO.CarroDAO;
import br.com.entidade.Cliente;
import br.com.entidade.Carro;

public class ClienteBO {
	private static ClienteDAO dao = new ClienteDAO();

	public void cadastar(Cliente cliente) throws SQLException, CampoVazioException, EmailInvalidoException,
			CPFInvalidoException, ClienteJaExiteException {

		if (verificarCPFNoBancoCliente(cliente.getCpf())) {
			throw new ClienteJaExiteException();
			
		} else if (vereficarCliente(cliente)) {
			dao.cadastrar(cliente);
		}

	}

	public static List<Cliente> listarTodos() throws SQLException {

		return dao.listarTodos();
	}

	public Cliente consultarPorId(int id) throws SQLException {
		return dao.consultarPorId(id);
	}

	public void excluirCliente(Cliente cliente) throws SQLException {
		dao.excluirCliente(cliente);

	}

	public void alterarCliente(Cliente cliente)
			throws SQLException, CampoVazioException, EmailInvalidoException, CPFInvalidoException {
		if (vereficarCliente(cliente)) {
			dao.alterarCliente(cliente);
		}

	}

	public boolean verificarClienteNaVenda(int id) {
		return VendaDAO.verificaCliente(id);
	}

	private boolean vereficarCliente(Cliente cliente)
			throws CampoVazioException, EmailInvalidoException, CPFInvalidoException {

		if (cliente.getNome() == "" || cliente.getCpf() == "" || cliente.getEmail() == "") {
			throw new CampoVazioException();
		}
		if (cliente.getEmail().indexOf("@") == -1) {
			throw new EmailInvalidoException();
		}

		if (!validarCPF(cliente.getCpf())) {
			throw new CPFInvalidoException();
		}
		return true;

	}

	private boolean verificarCPFNoBancoCliente(String string) {

		return ClienteDAO.verificarCPFNoBancoCliente(string);
	}

	private boolean validarCPF(String cpf) {
		
		if (cpf.length() > 14) {
			return false;
		}

		int contPonto = 0;
		int contTraco = 0;
		for (int i = 0; i < cpf.length(); i++) {
			if (cpf.charAt(i) == '.') {
				contPonto++;
			}
			if (cpf.charAt(i) == '-') {
				contTraco++;
			}
		}

		if (contPonto > 2 || contPonto < 2) {
			return false;
		}

		if (contTraco > 1 || contTraco < 1) {
			return false;
		}

		if (!(cpf.charAt(3) == '.' && cpf.charAt(7) == '.' && cpf.charAt(11) == '-')) {
			return false;
		}
		if (cpf.length() - (contPonto + contTraco) < 11) {
			return false;
		}
		if (!procurarLetar(cpf)) {
			return false;
		}

		return true;
	}

	private boolean procurarLetar(String cpf) {
		boolean verficador = false;
		for (int i = 0; i < cpf.length(); i++) {
			switch (cpf.charAt(i)) {
			case '1':
				verficador = true;
				break;
			case '2':
				verficador = true;
				break;
			case '3':
				verficador = true;
				break;
			case '4':
				verficador = true;
				break;
			case '5':
				verficador = true;
				break;
			case '6':
				verficador = true;
				break;
			case '7':
				verficador = true;
				break;
			case '8':
				verficador = true;
				break;
			case '9':
				verficador = true;
				break;
			case '.':
				verficador = true;
				break;
			case '0':
				verficador = true;
				break;
			case '-':
				verficador = true;
				break;
			default:
				verficador = false;
				break;
			}
		}

		return verficador;

	}

}
