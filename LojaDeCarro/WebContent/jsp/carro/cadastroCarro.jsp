<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>cadastro do carro</title>
</head>
<body>

	
	<center>
	<h1>Cadastre o carro, ${usuario}!!!!</h1>
	
	<form action="/LojaDeCarro/carro" method="post">
		<input type="hidden" name="acao" value="inserir" />
		Nome: <input type="text" name="nome" required="required"></br>
		<p>Preço: <input type="number" name="preco" required="required"></br>
		<p>Fornecedor: <input type="text" name="fornecedor" required="required"></br>
		<p><input type="submit" value="cadastrar">
		<input type="reset" value="Limpar">

	</form>	
	
	<c:import url="../comum/opcaoBotoesCarro.jsp"/>
	</center>
</body>
</html>