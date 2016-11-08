package br.com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.BO.ClienteBO;

import br.com.entidade.Cliente;

public class ClienteServlet extends HttpServlet {
	private String acao;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		acao = req.getParameter("acao");
		Cliente cliente = new Cliente();
		ClienteBO clienteBO = new ClienteBO();
		String msg = null;

		

			if (acao.equals("inserir")) {
				try {

					cliente.setNome(req.getParameter("nome"));
					cliente.setEmail(req.getParameter("email"));
					cliente.setTelefone(req.getParameter("telefone"));
					cliente.setSexo(req.getParameter("sexo").charAt(0));
					clienteBO.cadastar(cliente);
					resp.sendRedirect("/LojaDeCarro/cliente?acao=Listar");

				

				} catch (SQLException e) {
					e.printStackTrace();
					msg = "Erro ao inserir um novo ususario!!\n" + e;
					req.setAttribute("msg", msg);
					req.setAttribute("origem", "cliente");
					req.getRequestDispatcher("jsp/problema.jsp").forward(req, resp);

				
				}
			}
			if (acao.equals("Listar")) {
				try {

					List<Cliente> clientes;
					clientes = clienteBO.listarTodos();
					req.setAttribute("clientes", clientes);
					req.getRequestDispatcher("jsp/cliente/listarCliente.jsp").forward(req, resp);

				

				} catch (SQLException e) {
					
					msg = "	Erro ao listar os clientes disponíveis!\n" + e;
					e.printStackTrace();
					req.setAttribute("msg", msg);
					req.setAttribute("origem", "cliente");
					req.getRequestDispatcher("jsp/problema.jsp").forward(req, resp);
				}

			}
			if (acao.equals("Excluir")) {
				try {
					cliente = clienteBO.consultarPorId(Integer.parseInt(req.getParameter("id")));
					clienteBO.excluirCliente(cliente);
					resp.sendRedirect("/LojaDeCarro/cliente?acao=Listar");

				

				} catch (SQLException e) {
					e.printStackTrace();
					msg = "Erro ao excluir o cliente!!\n" + e;
					req.setAttribute("msg", msg);
					req.setAttribute("origem", "cliente");
					req.getRequestDispatcher("jsp/problema.jsp").forward(req, resp);

				} 

			}
			if (acao.equals("Consultar")) {
				try {

					cliente = clienteBO.consultarPorId(Integer.parseInt(req.getParameter("id")));
					req.setAttribute("cliente", cliente);
					req.getRequestDispatcher("jsp/cliente/alterarCliente.jsp").forward(req, resp);

				

				} catch (SQLException e) {
					e.printStackTrace();
					msg = "Erro ao consultar o cliente a ser alterado\n" + e;
					req.setAttribute("msg", msg);
					req.setAttribute("origem", "cliente");
					req.getRequestDispatcher("jsp/problema.jsp").forward(req, resp);

				} 

			}
			if (acao.equals("Alterar")) {
				try {
					
					cliente.setId(Integer.parseInt(req.getParameter("id")));
					cliente.setNome(req.getParameter("nome"));
					cliente.setEmail(req.getParameter("email"));
					cliente.setTelefone(req.getParameter("telefone"));
					cliente.setSexo(req.getParameter("sexo").charAt(0));
					clienteBO.alterarCliente(cliente);
					resp.sendRedirect("/LojaDeCarro/cliente?acao=Listar");
					
				

				} catch (SQLException e) {
					
					e.printStackTrace();
					msg = "Erro ao alterar o cliente!\n" + e;
					req.setAttribute("msg", msg);
					req.setAttribute("origem", "cliente");
					req.getRequestDispatcher("jsp/problema.jsp").forward(req, resp);

				} 

			}

		

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
