<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu principal do sistema</title>
</head>
<body >

<center>
	<h1><c:out value="Bem vindo ao sistema ${usuario} !!!" /></h1>

<tr>
	<h2>Carro</h2>
	<a href="/LojaDeCarro/jsp/carro/cadastroCarro.jsp">Cadastro de carro</a><br/>
	<a href="/LojaDeCarro/carro?acao=Listar"> Lista dos carros</a>
	
	<h2>Cliente</h2>
	<a	href="/LojaDeCarro/jsp/cliente/cadastroCliente.jsp">Cadastro de cliente</a><br/>
	<a href="/LojaDeCarro/cliente?acao=Listar">Lista de clientes</a>
	
	<h2>Venda</h2>
	<a href="/LojaDeCarro/venda?acao=Vender">Realizer uma venda</a><br/>
	<a href="/LojaDeCarro/venda?acao=Listar"> Listar as vendas</a>
	</tr>
	
	<p><input type="button" onclick="location='/LojaDeCarro/login?acao=Sair'" value="Sair"><br/>
</center>


</body>
</html>