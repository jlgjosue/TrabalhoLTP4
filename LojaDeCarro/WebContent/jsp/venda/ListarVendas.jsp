<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista das vendas realizadas</title>
</head>
<body>

	<c:if test="${user==null && senha==null}">
    	<c:redirect url="../../LojaDeCarro/index.jsp"/>
    </c:if>
    
	<table border="1">
	
		<tr>
			<td>Cliente</td>
			<td>E-Mail</td>
			<td>Sexo</td>
			<td>Carro</td>
			<td>Pre�o</td>
			<td>Descri��o da venda</td>
		</tr>
		
		<c:forEach var="v" items="${vendas}">
			<tr>
				<td>${v.cliente["nome"]}</td>
				<td>${v.cliente["email"]}</td>
				<td>${v.cliente["sexo"]}</td>
				<td>${v.carro["nome"]}</td>
				<td>${v.carro["preco"]}</td>
				<td>${v.descricao}</td>
				
			</tr>
		</c:forEach>
	</table>
</body>
</html>