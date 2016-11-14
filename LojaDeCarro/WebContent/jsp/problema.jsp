<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagina de erro</title>
</head>
<body>
	
	<c:choose>
		<c:when test="${origem eq 'car' }">
			<c:out value="${msg}" />
			<c:import url="/jsp/comum/opcaoBotoesCarro.js" />
			<br />
		</c:when>
		  <c:when test="${origem eq 'cliente' }">
	 
		  <c:out value="${msg}"/><br/>
		   <c:import url="/jsp/comum/opcaoBotoesCliente.jsp"/>
		  </c:when>
		  <c:when test="${origem eq 'venda' }">
		  
		  <p><c:out value="${msg}"></c:out><br />
		<a href="/LojaDeCarro/venda?acao=Vender">Realizer uma venda</a><br/>
		  </c:when>
		<c:otherwise>
			<br/><h1>Verifique se o numero digitado é valido! não esquecesa de trocar a virgula por ponto.</h1>
			<c:import url="/jsp/comum/opcaoMenuPrincipal.jsp" /> 
		</c:otherwise>
	</c:choose>

</body>
</html>