<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<style>

a:link, a:visited {
    background-color: #6495ED;
    color: white;
    padding: 10px 20px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
}
a:hover, a:active {
    background-color: blue;
}

input[type=button], input[type=submit], input[type=reset] {
    background-color: red;
    border: none;
    color: black;
    padding: 16px 32px;
    text-decoration: underline;
    margin: 4px 2px;
    cursor: pointer;
}


</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu principal do sistema</title>
</head>
<body>
<center>
	<h1 style="color: #6495ED"><c:out value="Bem vindo ao sistema ${usuario} !!!" /></h1>

<table>
<th>
	<h2 style="color: #6495ED">Carro</h2>
	<p><a href="/LojaDeCarro/jsp/carro/cadastroCarro.jsp">Cadastro de carro</a><br/>
	<p><a href="/LojaDeCarro/carro?acao=Listar"> Lista dos carros</a>
	</th>
<th>
	<h2 style="color: #6495ED">Cliente</h2>
	<p><a	href="/LojaDeCarro/jsp/cliente/cadastroCliente.jsp">Cadastro de cliente</a><br/>
	<p><a href="/LojaDeCarro/cliente?acao=Listar">Lista de clientes</a>
	</th>
<th>
	<h2 style="color: #6495ED">Venda</h2>
	<p><a href="/LojaDeCarro/venda?acao=Vender">Realizer uma venda</a><br/>
	<p><a href="/LojaDeCarro/venda?acao=Listar"> Listar as vendas</a>
	</th>
</table>

	<p><input type="button" onclick="location='/LojaDeCarro/login'" value="Sair"><br/>
	</center>
	</p>s	
	


</body>
</html>