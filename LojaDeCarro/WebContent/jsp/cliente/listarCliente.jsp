<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de CLiente</title>
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
<c:when test="${clientes.size()>0}">
	
		<table >
			<tr>
			<th>Nome</th>
			<th>E-mail</th>
			<th>CPF</th>
			<th>Sexo</th>
			<th>Opçôes</th>
			
			
			</tr>
			<c:forEach var="c" items="${clientes}">
			<tr>
			<td>${c.nome}</td>
			<td>${c.email}</td>
			<td>${c.cpf}</td>	
			<td>${c.sexo}</td>
			<td><input type="button" onclick="location='/LojaDeCarro/cliente?acao=Consultar&id=${c.id}'" value="Alterar"/>
			<input type="button" onclick="location='/LojaDeCarro/cliente?acao=Excluir&id=${c.id}'" value="Excluir"/></td>
			</tr>
			</c:forEach>
		</table>
		<p><input type="button" onclick="location='/LojaDeCarro/jsp/cliente/cadastroCliente.jsp'" value="Cadastar novo cliente"/><br/>
		<c:import url="/jsp/comum/opcaoMenuPrincipal.jsp" /> 

	
</c:when>	
	<c:otherwise>
	<h1> não exite nenhum cliente cadastrado!</h1>
	<P><input type="button" onclick="location='/LojaDeCarro/jsp/cliente/cadastroCliente.jsp'" value="Cadastar novo cliente"><br/>
	</c:otherwise>
</c:choose>	
 </center>
</body>
</html>