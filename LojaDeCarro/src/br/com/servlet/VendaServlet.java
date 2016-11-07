package br.com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.BO.CarroBO;
import br.com.BO.ClienteBO;
import br.com.BO.VendaBO;
import br.com.entidade.Carro;
import br.com.entidade.Cliente;
import br.com.entidade.Venda;

public class VendaServlet extends HttpServlet {
	private String acao;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		acao = req.getParameter("acao");
		HttpSession session = req.getSession();
		String msg = null;
		ClienteBO clienteBO = new ClienteBO();
		CarroBO carroBO = new CarroBO();
		VendaBO vendaBO = new  VendaBO();
		Venda venda = new Venda();
		Cliente cliente = new Cliente();
		Carro carro = new Carro();
		
		if ((session.getAttribute("user") != null && session.getAttribute("senha") != null)) {
			
			if(acao.equals("Vender")){

				try {

					List<Cliente> clientes;
					clientes = clienteBO.listarTodos();
					req.setAttribute("clientes", clientes);
					
					List<Carro> carros;
					carros = carroBO.listarTodos();
					req.setAttribute("carros", carros);
					req.getRequestDispatcher("jsp/venda/RealizarVenda.jsp").forward(req, resp);

				

				} catch (SQLException e) {
					
					msg = "	Erro ao listar os clientes ou produtos disponíveis!" + e;
					e.printStackTrace();
					req.setAttribute("msg", msg);
					req.setAttribute("origem", "venda");
					req.getRequestDispatcher("jsp/problema.jsp").forward(req, resp);
				}
				
			}else if(acao.equals("CadastrarVenda")){
				
				try{
					carro.setId(Integer.parseInt(req.getParameter("idCarro")));
					cliente.setId(Integer.parseInt(req.getParameter("idCliente")));
					venda.setDescricao(req.getParameter("descricao"));
				
					venda.setCliente(cliente);
					venda.setCarro(carro);
					vendaBO.cadastrar(venda);
					
					resp.sendRedirect("/LojaDeCarro/venda?acao=Listar");
				
				

				} catch (SQLException e) {
					
					msg = "	Erro ao cadastrar a nova venda!\n" + e;
					e.printStackTrace();
					req.setAttribute("msg", msg);
					req.setAttribute("origem", "venda");
					req.getRequestDispatcher("jsp/problema.jsp").forward(req, resp);
				}
				
			} else if(acao.equals("Listar")){
				try {
					List<Venda> vendas = vendaBO.listar();	
					
					
					req.setAttribute("vendas", vendas);
					req.getRequestDispatcher("jsp/venda/ListarVendas.jsp").forward(req, resp);
					
				} catch (SQLException e) {
					
					msg = "	Erro ao listar as vendas!" + e;
					e.printStackTrace();
					req.setAttribute("msg", msg);
					req.setAttribute("origem", "venda");
					req.getRequestDispatcher("jsp/problema.jsp").forward(req, resp);
				}
			}else if(acao.equals("Excluir")) {
			
				int idVenda = Integer.parseInt(req.getParameter("id"));
				vendaBO.excluir(idVenda);
				resp.sendRedirect("/LojaDeCarro/venda?acao=Listar");
				
			}
		} else {

			resp.sendRedirect("../LojaDeCarro/index.jsp");

		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
