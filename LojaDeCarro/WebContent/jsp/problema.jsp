<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagina de erro</title>
</head>
<body>
	
	<c:choose>
		<c:when test="${not empty msg}">
			<c:out value="${msg}" />
			<br />
		</c:when>
		
		<c:otherwise>
			<br/><h1>Verifique se o numero digitado � valido! N�o esquecesa de trocar a virgula por ponto.</h1>
		</c:otherwise>
	</c:choose>
<c:import url="/jsp/comum/opcaoMenuPrincipal.jsp" /> 
</body>
</html>