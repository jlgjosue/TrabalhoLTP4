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
	

	<center>
	<c:choose>	
	<c:when test="${clientes.size()<1 and carros.size()>0}">
	
	<h1> Não exite nenhum cliente cadastrado!</h1>
	<P><input type="button" onclick="location='/LojaDeCarro/jsp/cliente/cadastroCliente.jsp'" value="Cadastar novo cliente"><br/>
	<c:import url="/jsp/comum/opcaoMenuPrincipal.jsp" /> 
	</c:when>

	<c:when test="${clientes.size()>0 and carros.size()<1}">
	
	<h1>Nenhum  carro cadastrado no sistema!</h1>
	<P><input type="button" onclick="location='/LojaDeCarro/jsp/carro/cadastroCarro.jsp'" value="Cadastar novo carro"><br/>
	<c:import url="/jsp/comum/opcaoMenuPrincipal.jsp" /> 
	</c:when>	
	
	
	<c:when test="${clientes.size()<1 and carros.size()<1}">	
	
		<h1>Não temos nenhum produto ou carro cadastrados no sistema!</h1>
		<P><input type="button" onclick="location='/LojaDeCarro/jsp/cliente/cadastroCliente.jsp'" value="Cadastar novo cliente"><br/>
		<P><input type="button" onclick="location='/LojaDeCarro/jsp/carro/cadastroCarro.jsp'" value="Cadastar novo carro"><br/>
		<c:import url="/jsp/comum/opcaoMenuPrincipal.jsp" /> 
	</c:when>


	<c:otherwise>
			<h3><c:out value=" ${usuario} escolha para quem vender, qual carro vender e uma breve descrição da venda!"/></h3><br/>
	
		<p><form action="/LojaDeCarro/venda" method="post">
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
			<P> <textarea rows="6" cols="40" name="descricao" wrap="hard"></textarea>
			
			<p>	<input type="submit" value="Vender">
			<input type="reset" value="Limpar">
		</form>
		<input type="button" onclick="location='/LojaDeCarro/venda?acao=Listar'" value=" Lista das vendas"><br/>
				<c:import url="/jsp/comum/opcaoMenuPrincipal.jsp" /> 
		
</c:otherwise>
</c:choose>
	</center>
</body>
</html>