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
import br.com.entidade.Carro;

public class CarroServlet extends HttpServlet {

	private String acao;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
		
		acao = req.getParameter("acao");
		String msg = null;
		Carro carro = new Carro();
		CarroBO carroBO = new CarroBO();

		HttpSession session = req.getSession();
		if ((session.getAttribute("user") != null && session.getAttribute("senha") != null)) {
			if (acao.equals("inserir")) {
				try {
					carro.setNome(req.getParameter("nome"));
					carro.setPreco(Double.parseDouble(req.getParameter("preco")));
					carro.setFornecedor(req.getParameter("fornecedor"));

					boolean verificacao = carroBO.cadastro(carro);

					if (verificacao) {
						msg = "O novo carro " + carro.getNome() + " foi cadastrado.";

					} else {
						msg = "O novo carro " + carro.getNome() + " não foi cadastrado.";

					}

				
				} catch (SQLException e) {

					e.printStackTrace();
					msg = "Erro ao cadastrar um novo carro." + e;
					
				} finally {

					req.setAttribute("msg", msg);
					req.getRequestDispatcher("jsp/resultado/carro.jsp").forward(req, resp);
				}

			} else if (acao.equals("Listar")) {
				try {

					List<Carro> Lista = CarroBO.listarTodos();
					req.setAttribute("Lista", Lista);
					req.getRequestDispatcher("jsp/carro/listarCarros.jsp").forward(req, resp);

				
				} catch (SQLException e) {

					e.printStackTrace();
					msg = "Erro ao listar os carros cadastrados.\n" + e;
					req.setAttribute("msg", msg);
					req.getRequestDispatcher("jsp/resultado/carro.jsp").forward(req, resp);

				}

			} else if (acao.equals("ConsultarCarro")) {
				try {
					carro = 	carroBO.consutarPorId(Integer.parseInt(req.getParameter("id")));
					req.setAttribute("carro", carro);
					req.getRequestDispatcher("jsp/carro/alterarCarro.jsp").forward(req, resp);

				

				} catch (SQLException e) {

					e.printStackTrace();
					msg = "Erro ao culsutar o carro que iria se alterado!\n" + e;
					req.setAttribute("msg", msg);
					req.getRequestDispatcher("jsp/resultado/carro.jsp").forward(req, resp);

				}
			} else if (acao.equals("Alterar")) {
				try {

					carro.setId((Integer.parseInt(req.getParameter("id"))));
					carro.setNome(req.getParameter("nome"));
					carro.setPreco(Double.parseDouble(req.getParameter("preco")));
					carro.setFornecedor(req.getParameter("fornecedor"));
					carroBO.alterarCarro(carro);
					msg = "O novo carro " + carro.getNome() + " foi alterado com suscesso!!!.";

				

				} catch (SQLException e) {

					e.printStackTrace();
					msg = "Erro ao alterar o carro!\n" + e;

				} finally {

					req.setAttribute("msg", msg);
					req.getRequestDispatcher("jsp/resultado/carro.jsp").forward(req, resp);
				}

			} else if (acao.equals("Excluir")) {
				try {

					carro = carroBO.consutarPorId(Integer.parseInt(req.getParameter("id")));
					carroBO.excluirCarro(carro);
					msg = "O  carro " + carro.getNome() + " foi excluido com suscesso!!!.";

				

				} catch (SQLException e) {

					e.printStackTrace();
					msg = "Erro ao excluir o carro!\n" + e;

				} finally {

					req.setAttribute("msg", msg);
					req.getRequestDispatcher("jsp/resultado/carro.jsp").forward(req, resp);
				}
			}else{
				msg ="Erro na Acao...";
				req.setAttribute("msg", msg);
				req.getRequestDispatcher("jsp/resultado/carro.jsp").forward(req, resp);
			}

		} else {
			resp.sendRedirect("../Mercado/index.jsp");
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
