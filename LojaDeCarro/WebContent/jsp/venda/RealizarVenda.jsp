<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Realizar venda!!!</title>
</head>
<body>
	<c:if test="${user==null && senha==null}">
    	<c:redirect url="../../LojaDeCarro/index.jsp"/>
    </c:if>

	<center>
<!-- 	escolha -->
	<c:choose>	
<!-- 	caso a lista de clientes esteja vasia, aparece somete a mesagem de lista vasia e o botão de cadastro -->
	<c:when test="${clientes.size() == 0 and carros.size()>0}">
	
	<h1> Não exite nenhum cliente cadastrado!</h1>
	<P><input type="button" onclick="location='/LojaDeCarro/jsp/cliente/cadastroCliente.jsp'" value="Cadastar novo cliente"><br/>
	</c:when>

<!-- 	caso a lista de carros esteja vasia, aparece somete a mesagem de lista vasia e o botão de cadastro -->
	<c:when test="${clientes.size() > 0 and carros.size()== 0}">
	
	<h1>Nenhum  carro no sistema!</h1>
	<P><input type="button" onclick="location='/LojaDeCarro/jsp/carro/cadastro.jsp'" value="Cadastar novo produto"><br/>
	</c:when>	
	
<!-- 	caso as listas estejam vasias, aparece a mensagem de erro e os botões de cadastro. -->
	<c:when test="${clientes.size() == 0 and carros.size() == 0}">	
	
		<h1>Não temos nenhum produto ou carro cadastrados no sistema!</h1>
		<P><input type="button" onclick="location='/LojaDeCarro/jsp/cliente/cadastroCliente.jsp'" value="Cadastar novo cliente"><br/>
		<P><input type="button" onclick="location='/LojaDeCarro/jsp/carro/cadastro.jsp'" value="Cadastar novo produto"><br/>
	</c:when>
	
<!-- 	senão  -->	
	<c:otherwise>
		<form action="/LojaDeCarro/venda" method="post">
			<p>	<a> Escolhar um cliente</a>	</p>
			<input  type="hidden"  name="acao" value="CadastrarVenda"/>
			<p>	<select name="idCliente">
					<c:forEach var="c" items="${clientes}">
						<option value="${c.id}">
							<c:out value="${c.nome}" />
						</option>
					</c:forEach>
				</select>
			</p>
			
			<p>	<a> Escolhar um carro</a><p>
				<select name="idCarro">
					<c:forEach var="car" items="${carros}">
						<option value="${car.id}">
							<c:out value="${car.nome}" />
						</option>
					</c:forEach>
				</select>
			</p>

			<p>	<a>Descrição:</a></p>
			<p>	<input type="text" name="descricao"  /></p>
			
			<p>	<input type="submit" value="Vender"></p>
		</form>
</c:otherwise>
</c:choose>
	</center>
</body>
</html>