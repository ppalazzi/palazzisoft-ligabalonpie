<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
</head>
<body>
	<jsp:include page="/jsp/header.jsp" />
	<form:form action="altaEdicion.htm" method="post" commandName="jugadorCommand">					
		<table>
			<tr>
				<td>Nombre</td>					
				<td>
					<spring:bind path="nombre">
						<input type="text" name="nombre" value='<c:out value="${jugadorCommand.nombre}" />'>					
					</spring:bind>
					<form:errors path="nombre"></form:errors>	
				</td>			
			</tr>
			<tr>
				<td>Apellido</td>
				<td>
					<spring:bind path="apellido">
						<input type="text" name="apellido" value='<c:out value="${jugadorCommand.apellido}" />'>					
					</spring:bind>		
				</td>		
			</tr>
			<tr>
				<td>Velocidad</td>
				<td>
					<spring:bind path="velocidad">
						<input type="text" name="velocidad" value='<c:out value="${jugadorCommand.velocidad}" />'>					
					</spring:bind>		
				</td>		
			</tr>					
			<tr>
				<td>Remate</td>
				<td>
					<spring:bind path="remate">
						<input type="text" name="remate" value='<c:out value="${jugadorCommand.remate}" />'>					
					</spring:bind>		
				</td>		
			</tr>
																<tr>
				<td>Habilidad</td>
				<td>
					<spring:bind path="habilidad">
						<input type="text" name="habilidad" value='<c:out value="${jugadorCommand.habilidad}" />'>					
					</spring:bind>		
				</td>		
			</tr>			
															<tr>
				<td>Físico</td>
				<td>
					<spring:bind path="fisico">
						<input type="text" name="fisico" value='<c:out value="${jugadorCommand.fisico}" />'>					
					</spring:bind>		
				</td>		
			</tr>			
											
			<tr>
				<td>
					<spring:bind path="id">
						<input type="hidden" name="id" value='<c:out value="${jugadorCommand.id}" />' />
					</spring:bind>
					<spring:bind path="estado">
						<input type="hidden" name="estado" value="1" />
					</spring:bind>					
					<input type="submit" value="Modificar" />
				</td>				
			</tr>
		</table>
	</form:form>
</body>
</html>