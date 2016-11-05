package br.com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class logautServlet extends HttpServlet{
	private String acao;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		acao = req.getParameter("acao");
		
		HttpSession session = req.getSession();
		if ((session.getAttribute("user") != null && session.getAttribute("senha") != null)) {
			if(acao.equals("Sair")){
				
				session.invalidate();
				resp.sendRedirect("../LojaDeCarro/index.jsp");
				
			}else{
				System.out.println("acao incorreta!!!");
				resp.sendRedirect("../LojaDeCarro/index.jsp");
			}
			
		} else {
			System.out.println("-Erroou!!!");
			resp.sendRedirect("../LojaDeCarro/index.jsp");
			
		}
	
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
