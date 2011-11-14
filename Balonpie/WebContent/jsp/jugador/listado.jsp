<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<body>
	<jsp:include page="/jsp/header.jsp" />
		
	<table border="1" width="30%" height="30%">
		<tr>
			<td>
				<label>Id</label>
			</td>
			<td>
				<label>Nombre</label>
			</td>			
			<td>
				<label>Apellido</label>
			</td>
		</tr>
					
		<c:forEach var="jugador" items="${jugadores}">
			<tr>
				<td><a href="jugadorListado.htm?jugadorId=1"><c:out value="${jugador.id}" /></a></td>
				<td><c:out value="${jugador.nombre}" /></td>
				<td><c:out value="${jugador.apellido}" /></td>
			</tr>			
		</c:forEach>
		
		<tr>
			<td>
				<form:form action="jugadorListado.htm?jugadorId=0" method="post">
					<input type="submit" value="Nuevo Jugador" />				
				</form:form>				
			</td>
		</tr>
	</table>

</body>
</html>