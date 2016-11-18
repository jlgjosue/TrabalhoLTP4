<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista das vendas realizadas</title>
<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;   
    width: 80%;
}

td, th {
    border: 1px solid #dddddd;
     text-align: center;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
th {
    background-color: #6495ED;
    color: white;
}
</style>
</head>
<body>

	<center>
 <c:choose>  
 <c:when test="${vendas.size()>0}">
	<table >
	
		<tr>
			<th>Cliente</th>
			<th>CPF</th>
			<th>E-Mail</th>
			<th>Sexo</th>
			<th>Carro</th>
			<th>Preço</th>
			<th>Descrição da venda</th>
			<th>Opçao</th>
		</tr>
		
		<c:forEach var="v" items="${vendas}">
			<tr>
				<td>${v.cliente["nome"]}</td>
				<td>${v.cliente["cpf"]}</td>
				<td>${v.cliente["email"]}</td>
				<td>${v.cliente["sexo"]}</td>
				<td>${v.carro["nome"]}</td>
				<td><fmt:formatNumber value="${v.carro['preco']}" type="currency"/></td>
				
				<c:choose>
				<c:when test="${empty v.descricao}">
				<td>Descrição não informada</td>
				</c:when>
				<c:otherwise>
				<td>${v.descricao}</td>
				</c:otherwise>
				</c:choose>
				
				<td><input type="button" onclick="location='/LojaDeCarro/venda?acao=Excluir&id=${v.idVenda}'" value="Excluir"/></td>
				
			</tr>
		</c:forEach>
	</table>
	<p><input type="button" onclick="location='/LojaDeCarro/venda?acao=Vender'" value="Cadastar nova venda"><br/>
<c:import url="/jsp/comum/opcaoMenuPrincipal.jsp" /> 
	
	</c:when>
	<c:otherwise>
	<h1> Nao temos nenhuma venda cadastrada no sistema!</h1>
	<p><input type="button" onclick="location='/LojaDeCarro/venda?acao=Vender'" value="Realizar nova venda"></a><br/>
	</c:otherwise>
</c:choose>
</center>
</body>
</html>