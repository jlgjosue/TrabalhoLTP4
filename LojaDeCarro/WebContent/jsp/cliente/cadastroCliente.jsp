<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de cliente</title>
</head>
<body>

<center>
<form action="/LojaDeCarro/cliente" method="post">
	<input type="hidden" name="acao" value="inserir" />
	<p><label>Nome: </label> <input type="text"  name="nome" placeholder="Seu nome!" required/><br/>	
	<p><label>Email: </label><input  type="email"  name="email" placeholder="Seu email" required /><br/>
	<p><label>CPF:</label> <input type="text" name="cpf" placeholder="Seu CPF" required/> <br/>
	<p><label>Sexo: </label><br/>
	<input type="radio" name="sexo" checked="checked" value="M" />Masculino <br/>
	<input type="radio" name="sexo"  value="F"/>Feminino<br/>
	<p><input type="submit" value="Cadastrar"/>
</form>
<c:import url="/jsp/comum/opcaoBotoesCliente.jsp"/>
</center>

</body>
</html>