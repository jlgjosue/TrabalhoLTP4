package br.com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FiltroSeguranca implements Filter {

   

	
	public void destroy() {
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String url = httpServletRequest.getRequestURI();
		HttpSession sessao = httpServletRequest.getSession();
		
		if(sessao.getAttribute("usuario") != null || url.lastIndexOf("index.jsp") > -1
				|| url.lastIndexOf("/login") > -1){
			
			chain.doFilter(request, response);
			
		}else{
			
			((HttpServletResponse) response).sendRedirect("/LojaDeCarro/index.jsp");

		}
	}


	public void init(FilterConfig fConfig) throws ServletException {
	}

}
