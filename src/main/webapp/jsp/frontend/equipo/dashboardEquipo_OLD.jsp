<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<link href="../static/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<jsp:include page="/jsp/header.jsp" />

	<div>
		<label>Presupuesto : <c:out value="${presupuesto}" /></label>
	</div>

	<table border="0" width="30%" height="30%">
		<tr>
			<td><h3>Jugadores del Equipo</h3></td>
		</tr>
		<tr>
			<td>
				<table border="1">
					<tr>
						<td>
							<label>Nombre</label>
						</td>
						<td>
							<label>Apellido</label>
						</td>					
						<td>
							<label>Habilidad</label>
						</td>					
						<td>
							<label>Velocidad</label>
						</td>				
						<td>
							<label>Físico</label>
						</td>				
						<td>
							<label>Remate</label>
						</td>				
						<td>
							<label>Tipo de Jugador</label>
						</td>
						<td>
							<label>Valor</label>
						</td>																																																		
					</tr>
					<tr>
						<td></td>
						<td>
							<c:forEach var="jug" items="${disponibles}">
								<tr>
									<td><c:out value="${jug.nombre}" /></td>
									<td><c:out value="${jug.apellido}" /></td>
									<td><c:out value="${jug.habilidad}" /></td>
									<td><c:out value="${jug.velocidad}" /></td>
									<td><c:out value="${jug.fisico}" /></td>
									<td><c:out value="${jug.remate}" /></td>
									<td>
										<select name="tipoJugadorSeleccionado" disabled="disabled">
											<option <c:if test="${1 == jug.tipoJugador.id}">selected</c:if> value="1" >Arquero</option>
											<option <c:if test="${2 == jug.tipoJugador.id}">selected</c:if> value="2" >Defensor</option>
											<option <c:if test="${3 == jug.tipoJugador.id}">selected</c:if> value="3" >Mediocampista</option>							
											<option <c:if test="${4 == jug.tipoJugador.id}">selected</c:if> value="4" >Atacante</option>
										</select>														
									</td>
									<td><c:out value="${jug.valor}" /></td>
								</tr>			
							</c:forEach>								
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<h3>Jugadores Disponibles</h3>
			</td>
		</tr>
		<tr>
			<td>
				<table border="1">
					<tr>
						<td>
							<label>Nombre</label>
						</td>
						<td>
							<label>Apellido</label>
						</td>					
						<td>
							<label>Habilidad</label>
						</td>					
						<td>
							<label>Velocidad</label>
						</td>				
						<td>
							<label>Físico</label>
						</td>				
						<td>
							<label>Remate</label>
						</td>				
						<td>
							<label>Tipo de Jugador</label>
						</td>
						<td>
							<label>Valor</label>
						</td>																																																		
					</tr>
					<tr>
						<td></td>
						<td>
							<c:forEach var="jugadores" items="${jugadores}">
								<tr>
									<td><c:out value="${jugadores.nombre}" /></td>
									<td><c:out value="${jugadores.apellido}" /></td>
									<td><c:out value="${jugadores.habilidad}" /></td>
									<td><c:out value="${jugadores.velocidad}" /></td>
									<td><c:out value="${jugadores.fisico}" /></td>
									<td><c:out value="${jugadores.remate}" /></td>
									<td>
										<select name="tipoJugadorSeleccionado" disabled="disabled">
											<option <c:if test="${1 == jugadores.tipoJugador.id}">selected</c:if> value="1" >Arquero</option>
											<option <c:if test="${2 == jugadores.tipoJugador.id}">selected</c:if> value="2" >Defensor</option>
											<option <c:if test="${3 == jugadores.tipoJugador.id}">selected</c:if> value="3" >Mediocampista</option>							
											<option <c:if test="${4 == jugadores.tipoJugador.id}">selected</c:if> value="4" >Atacante</option>
										</select>														
									</td>
									<td><c:out value="${jugadores.valor}" /></td>
									<td>
										<input type="button" value="Agregar Jugador"  onclick="location.href='/balonpie/comprarJugador.htm?jugadorId=<c:out value='${jugadores.id}' />&equipoId=<c:out value='${equipoId}' />&presupuesto=<c:out value='${presupuesto}' />'"  />
									</td>
								</tr>										
							</c:forEach>								
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<c:out value="${mensaje}"></c:out>
			</td>
		</tr>
		
		
	</table>				
</body>