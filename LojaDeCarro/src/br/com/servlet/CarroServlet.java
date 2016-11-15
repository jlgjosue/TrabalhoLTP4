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
import br.com.Exception.CampoVazioException;
import br.com.Exception.CarroDeGracaException;
import br.com.entidade.Carro;

public class CarroServlet extends HttpServlet {

	private String acao;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		acao = req.getParameter("acao");
		String msg = null;
		Carro carro = new Carro();
		CarroBO carroBO = new CarroBO();

		
		
			if (acao.equals("inserir")) {
				try {
					carro.setNome(req.getParameter("nome"));
					carro.setPreco(Double.parseDouble(req.getParameter("preco")));
					carro.setFornecedor(req.getParameter("fornecedor"));

					carroBO.cadastro(carro);
					resp.sendRedirect("/LojaDeCarro/carro?acao=Listar");

				} catch (SQLException e) {

					e.printStackTrace();
					msg = "Erro ao cadastrar um novo carro." + e;
					req.setAttribute("msg", msg);
					req.setAttribute("origem", "car");
					req.getRequestDispatcher("jsp/problema.jsp").forward(req, resp);

				} catch (CampoVazioException e) {
					
					e.printStackTrace();
					msg = "Erro ao cadastrar um novo carro pois o nome não foi digitado!!";
					req.setAttribute("msg", msg);
					req.setAttribute("origem", "car");
					req.getRequestDispatcher("jsp/problema.jsp").forward(req, resp);
					
				} catch (CarroDeGracaException e) {
					msg = "Erro ao cadastrar um novo carro, não foi posivel pois o seu preço esta igual ou abaixo de zero. NÃO VENDEMOS CARROS DE GRAÇA!!" ;
					req.setAttribute("msg", msg);
					req.setAttribute("origem", "car");
					req.getRequestDispatcher("jsp/problema.jsp").forward(req, resp);
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
					req.setAttribute("origem", "car");
					req.getRequestDispatcher("jsp/problema.jsp").forward(req, resp);

				}

			} else if (acao.equals("Consultar")) {
				try {
					carro = carroBO.consutarPorId(Integer.parseInt(req.getParameter("id")));
					req.setAttribute("carro", carro);
					req.getRequestDispatcher("jsp/carro/alterarCarro.jsp").forward(req, resp);

				} catch (SQLException e) {

					e.printStackTrace();
					msg = "Erro ao culsutar o carro que iria se alterado!\n" + e;
					req.setAttribute("msg", msg);
					req.setAttribute("origem", "car");
					req.getRequestDispatcher("jsp/problema.jsp").forward(req, resp);

				}
			} else if (acao.equals("Alterar")) {
				try {

					carro.setId((Integer.parseInt(req.getParameter("id"))));
					carro.setNome(req.getParameter("nome"));
					carro.setPreco(Double.parseDouble(req.getParameter("preco")));
					carro.setFornecedor(req.getParameter("fornecedor"));
					
					carroBO.alterarCarro(carro);

					resp.sendRedirect("/LojaDeCarro/carro?acao=Listar");
					

				} catch (SQLException e) {

					e.printStackTrace();
					msg = "Erro ao alterar o carro!\n" + e;
					req.setAttribute("msg", msg);
					req.getRequestDispatcher("jsp/problema.jsp").forward(req, resp);

				}catch (CampoVazioException e) {
					
					e.printStackTrace();
					msg = "Erro ao ao alterar o carro pois o nome não foi digitado!!";
					req.setAttribute("msg", msg);
					req.getRequestDispatcher("jsp/problema.jsp").forward(req, resp);
					
				} catch (CarroDeGracaException e) {
					msg = "Erro ao alterar o novo carro, não foi posivel pois o seu preço esta igual ou abaixo de zero. NÃO VENDEMOS CARROS DE GRAÇA!!" ;
					req.setAttribute("msg", msg);
					req.getRequestDispatcher("jsp/problema.jsp").forward(req, resp);
				}

			} else if (acao.equals("Excluir")) {
				try {
					
					carro = carroBO.consutarPorId(Integer.parseInt(req.getParameter("id")));
					if(carroBO.verificarCarroNaVenda(carro.getId())){
						
					carroBO.excluirCarro(carro);
					resp.sendRedirect("/LojaDeCarro/carro?acao=Listar");
					
					}else{
						msg = "Erro ao excluir o carro! por causa da venda";
						req.setAttribute("msg", msg);
						req.getRequestDispatcher("jsp/problema.jsp").forward(req, resp);
					}

				} catch (SQLException e) {

					e.printStackTrace();
					msg = "Erro ao excluir o carro!\n" + e;
					req.setAttribute("msg", msg);
					req.getRequestDispatcher("jsp/problema.jsp").forward(req, resp);

				}

			} else {
				msg = "Erro na Acao...";
				req.setAttribute("msg", msg);
				req.getRequestDispatcher("jsp/problema.jsp").forward(req, resp);
			}

		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
