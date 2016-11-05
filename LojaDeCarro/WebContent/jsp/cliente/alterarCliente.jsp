<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar produto!!!</title>
</head>
<body>
<c:if test="${user==null && senha==null}">
    	<c:redirect url="../../../Mercado/index.jsp"/>
    </c:if>
<center>
<c:set var="cli" value="${cliente}"/>
<form action="/LojaDeCarro/cliente" method="post">
	<input type="hidden" name="acao" value="Alterar" />
	<input type="hidden" name="id" value="${cli.id}"/>
	<label>Nome: </label> <input type="text"  name="nome" value="${cli.nome}" /><br/>	
	<label>Email: </label><input  type="text"  name="email" value="${cli.email}"/><br/>
	<label>Telefone:</label> <input type="text" name="telefone" value="${cli.telefone}" /> <br/>
	<label>Sexo: </label><br/>
	
	<c:set var="m" value="M"/>
<c:choose>
	<c:when test="${cli.sexo.toString() eq m}">
		<input type="radio" name="sexo" checked="checked" value="M" />Masculino <br/>
		<input type="radio" name="sexo"  value="F"/>Feminino<br/>
	</c:when>
	<c:otherwise>
		<input type="radio" name="sexo" value="M" />Masculino <br/>
		<input type="radio" name="sexo" checked="checked" value="F"/>Feminino<br/>
	</c:otherwise>
</c:choose>

<p><input type="submit" value="Alterar"/>
</form>
	<c:import url="../comum/opcaoBotoesCliente.jsp" />
</center>

</body>
</html>