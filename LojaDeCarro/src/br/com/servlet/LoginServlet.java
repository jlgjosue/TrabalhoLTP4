package br.com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.BO.LoginBO;

public class LoginServlet extends HttpServlet {
	private String acao;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
		
			acao = req.getParameter("acao");
		
		
		
		if (acao.equals("Logar")) {
			String user = req.getParameter("user");
			String senha = req.getParameter("senha");

			
			if (LoginBO.verificaLogin(user, senha)) {
				
				req.getSession().setAttribute("usuario", "josue");
				req.getRequestDispatcher("/jsp/menuPrincipal.jsp").forward(req, resp);
				
			} else {
				
				System.out.println("Não entrou na festa!");
				resp.sendRedirect("../LojaDeCarro/index.jsp");
			}
		}else if(acao.equals("Sair")){
			
			req.getSession().invalidate();
			resp.sendRedirect("../LojaDeCarro/index.jsp");
			
		}else{
			System.out.println("acao incoreta!!");
			resp.sendRedirect("../LojaDeCarro/index.jsp");
		}

	}

}
