package br.com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.BO.LoginBO;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("acao") == null ||req.getParameter("acao").equals("Logar")) {
			resp.sendRedirect("../LojaDeCarro/index.jsp");
		}else{
			doPost(req, resp);
		}
		

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		

			 if (req.getParameter("acao").equals("Logar")) {
				 	String user = req.getParameter("user");
				 	String senha = req.getParameter("senha");

					if (LoginBO.verificaLogin(user, senha)) {
						req.getSession().setAttribute("usuario", "josue");
						req.getRequestDispatcher("/jsp/menuPrincipal.jsp").forward(req, resp);

					} else {

						resp.sendRedirect("../LojaDeCarro/index.jsp");
				}
			} else if(req.getParameter("acao").equals("Sair") ){
				
					req.getSession().invalidate();
					resp.sendRedirect("../LojaDeCarro/index.jsp");
			}else{
				resp.sendRedirect("../LojaDeCarro/index.jsp");
			}
		

	}

}
