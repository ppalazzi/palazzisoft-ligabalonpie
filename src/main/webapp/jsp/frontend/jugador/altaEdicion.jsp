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
					<form:errors path="apellido"></form:errors>	
				</td>		
			</tr>
			<tr>
				<td>Velocidad</td>
				<td>
					<spring:bind path="velocidad">
						<input type="text" name="velocidad" value='<c:out value="${jugadorCommand.velocidad}" />'>					
					</spring:bind>		
					<form:errors path="velocidad"></form:errors>
				</td>		
			</tr>					
			<tr>
				<td>Remate</td>
				<td>
					<spring:bind path="remate">
						<input type="text" name="remate" value='<c:out value="${jugadorCommand.remate}" />'>					
					</spring:bind>		
					<form:errors path="remate"></form:errors>
				</td>		
			</tr>
																<tr>
				<td>Habilidad</td>
				<td>
					<spring:bind path="habilidad">
						<input type="text" name="habilidad" value='<c:out value="${jugadorCommand.habilidad}" />'>					
					</spring:bind>		
					<form:errors path="habilidad"></form:errors>
				</td>		
			</tr>			
			<tr>
				<td>Físico</td>
				<td>
					<spring:bind path="fisico">
						<input type="text" name="fisico" value='<c:out value="${jugadorCommand.fisico}" />'>					
					</spring:bind>		
					<form:errors path="fisico"></form:errors>
				</td>		
			</tr>			
			<tr>
				<td>Valor</td>
				<td>
					<spring:bind path="valor">
						<input type="text" name="valor" value='<c:out value="${jugadorCommand.valor}" />'>					
					</spring:bind>		
					<form:errors path="valor"></form:errors>
				</td>		
			</tr>						
			<tr>
				<td>Tipo De Jugador</td>
				<td>
					<spring:bind path="tipoJugadorId">
						<select name="tipoJugadorSeleccionado">
<!--							<c:forEach var="tipoJugador" items="${tipoJugadores}">-->
<!--								<option <c:if test="${tipoJugador.id == jugadorCommand.id}">selected</c:if> value="<c:out value="${tipoJugador.id}" />"><c:out value="${tipoJugador.descripcion}" /></option>-->
<!--							</c:forEach>						-->
							<option <c:if test="${1 == jugadorCommand.id}">selected</c:if> value="1" >Arquero</option>
							<option <c:if test="${2 == jugadorCommand.id}">selected</c:if> value="2" >Defensor</option>
							<option <c:if test="${3 == jugadorCommand.id}">selected</c:if> value="3" >Mediocampista</option>							
							<option <c:if test="${4 == jugadorCommand.id}">selected</c:if> value="4" >Atacante</option>
						</select>					
					</spring:bind>		
					<form:errors path="tipoJugadorId"></form:errors>
				</td>		
			</tr>			
			<tr>
				<td>Estado</td>	
				<td>
					<spring:bind path="estado">
						<select name="estadoSeleccionado">
							<option <c:if test='${jugadorCommand.id == 1}'>selected</c:if> value="1">Activo</option>
							<option <c:if test='${jugadorCommand.id == 0}'>selected</c:if> value="0">Inactivo</option>
						</select>					
					</spring:bind>		
					<form:errors path="estado"></form:errors>
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