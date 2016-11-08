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

	<center>
 <c:choose>  
 <c:when test="${vendas.size()>0}">
	<table border="1">
	
		<tr>
			<td>Cliente</td>
			<td>E-Mail</td>
			<td>Sexo</td>
			<td>Carro</td>
			<td>Preço</td>
			<td>Descrição da venda</td>
			<td></td>
		</tr>
		
		<c:forEach var="v" items="${vendas}">
			<tr>
				<td>${v.cliente["nome"]}</td>
				<td>${v.cliente["email"]}</td>
				<td>${v.cliente["sexo"]}</td>
				<td>${v.carro["nome"]}</td>
				<td>${v.carro["preco"]}</td>
				<td>${v.descricao}</td>
				<td><a href="/LojaDeCarro/venda?acao=Excluir&id=${v.idVenda}"/>Excluir </td>
				
			</tr>
		</c:forEach>
	</table>
	</c:when>
	<c:otherwise>
	<h1> Nao temos nenhuma venda cadastrada no sistema!</h1>
	<p><input type="button" onclick="location='/LojaDeCarro/venda?acao=Vender'" value="Realizar nova venda"></a><br/>
	</c:otherwise>
</c:choose>
<p><input type="button" onclick="location='/LojaDeCarro/jsp/menuPrincipal.jsp'" value="Voltar ao menu principal"><br/>
</center>
</body>
</html>