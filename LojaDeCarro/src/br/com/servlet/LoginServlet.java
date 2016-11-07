package br.com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.BO.LoginBO;

public class LoginServlet extends HttpServlet {
	private String acao ;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(req.getParameter("acao") != null){
		
			acao = req.getParameter("acao");
		
		}else{
			
			resp.sendRedirect("../LojaDeCarro/index.jsp");
		}
		
		if (acao.equals("Logar")) {
			String user = req.getParameter("user");
			String senha = req.getParameter("senha");

			
			if (LoginBO.verificaLogin(user, senha)) {
				
				req.getSession().setAttribute("user", user);
				req.getSession().setAttribute("senha", senha);
				req.getRequestDispatcher("/jsp/menuPrincipal.jsp").forward(req, resp);
				
			} else {
				
				System.out.println("Não entrou na festa!");
				resp.sendRedirect("../LojaDeCarro/index.jsp");
			}
		}else {
				resp.sendRedirect("../LojaDeCarro/index.jsp");
		}

	}


}
