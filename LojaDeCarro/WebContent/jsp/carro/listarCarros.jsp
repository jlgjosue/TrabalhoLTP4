
<%@page import="br.com.entidade.Carro"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de todos os produtos!</title>
<link rel="stylesheet"  href="css/Table.css">
</head>
<body >

<center>
<c:choose>
<c:when test="${Lista.size()>0}">
	<h1> Lista dos carros cadastrados</h1>
	<table >
		<tr>
			<th>Nome do carro</th>
			<th>Preço</th>
			<th>Fornecedor</th>
			<th>Opções</th>
		</tr>
	

	<c:forEach var="l" items="${Lista}">
	<tr>
		<td>${l.nome}</td>
		<td><fmt:formatNumber value="${l.preco}" type="currency"/></td>
		<td>${l.fornecedor}</td>
		<td>
		<input type="button" onclick="location='/LojaDeCarro/carro?acao=Consultar&id=${l.id}'" value="Alterar">
		<input type="button" onclick="location='/LojaDeCarro/carro?acao=Excluir&id=${l.id}'" value="Excluir">
		
	</tr>
	
	</c:forEach>
	</table>
	<p><input type="button" onclick="location='/LojaDeCarro/jsp/carro/cadastroCarro.jsp'" value="Cadastar novo carro no sistema"><br/> 
    <c:import url="/jsp/comum/opcaoMenuPrincipal.jsp" /> 
	 </c:when>

<c:otherwise>
	<h1>Nenhum carro cadastrado no sistema!</h1>
	<P><input type="button" onclick="location='/LojaDeCarro/jsp/carro/cadastroCarro.jsp'" value="Cadastar novo carro!"><br/>
	<c:import url="/jsp/comum/opcaoMenuPrincipal.jsp" /> 
</c:otherwise>
</c:choose>
</center>
</body>
</html>