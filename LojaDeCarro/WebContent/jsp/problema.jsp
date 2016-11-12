<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagina de erro</title>
</head>
<body>
	
	<c:choose>
		<c:when test="${origem eq 'car' }">
	
			<c:out value="${msg}" />
			<br />
		</c:when>
		  <c:when test="${origem eq 'cliente' }">
		 
		  <c:out value="${msg}"/><br/>
		  </c:when>
		  <c:when test="${origem eq 'venda' }">
		  
		  <p><c:out value="${msg}"></c:out><br />
		
		  </c:when>
		<c:otherwise>
			<c:out value="Um novo problema encontrado!!! :("/>
		</c:otherwise>
	</c:choose>

</body>
</html>