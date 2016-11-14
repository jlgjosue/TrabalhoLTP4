<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>cadastro do produto</title>
</head>
<body>

	
	<center>
	<h1>cadastro do carro!!</h1>
	
	<form action="/LojaDeCarro/carro" method="post">
		<input type="hidden" name="acao" value="inserir" />
		Nome: <input type="text" name="nome" ></br>
		Preço: <input type="text" name="preco" ></br>
		Fornecedor: <input type="text" name="fornecedor"></br>
		<input type="submit" value="cadastrar">

	</form>	
	<c:import url="/jsp/comum/opcaoBotoesCarro.jsp"/>
	</center>
</body>
</html>