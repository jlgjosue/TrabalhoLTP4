<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resultado!!!</title>
</head>
<body>
	<c:if test="${user==null && senha==null}">
    	<c:redirect url="../../../LojaDeCarro/index.jsp"/>
    </c:if>
	<c:out value="${msg}" /><br/>
	<c:import url="../comum/opcaoBotoesCarro.jsp" />
</body>
</html>