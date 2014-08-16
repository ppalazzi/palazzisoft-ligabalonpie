<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="/jsp/backend/header.jsp" />

</br>
<form:form id="nuevoJugadorForm" action="nuevoJugador.adm" method="POST" commandName="jugadorCommand">
	<c:if test="${jugador.id != null}">
		<spring:bind path="id">
			<input type="hidden" name="id" value="${jugador.id}" >
		</spring:bind>
	</c:if>
<ul>
		<li>
		<label>Nombre</label>
		<spring:bind path="nombre">
			<input type="text" name="nombre" value='<c:out value="${jugador.nombre}" />'>					
		</spring:bind>
		<label>Apellido</label>
		<spring:bind path="jugador.apellido">
			<input type="text" name="apellido" value='<c:out value="${jugador.apellido}" />'>					
		</spring:bind>			
	</li>
	<li>
		<label>Fecha de Nacimiento</label>
		<spring:bind path="jugador.fechaNacimiento" >
			<input type="text" name="fechaNacimiento" id="datepicker" value="<c:out value='${jugador.fechaNacimiento}' />">			
		</spring:bind>		
		<label>Velocidad</label>
		<spring:bind path="jugador.velocidad">
			<input type="text" name="velocidad" value='<c:out value="${jugador.velocidad}" />'>
		</spring:bind>	
	</li>
	<li>
		<label>Remate</label>
		<spring:bind path="jugador.remate">
			<input type="text" name="remate" value='<c:out value="${jugador.remate}" />'>					
		</spring:bind>	
		<label>Habilidad</label>
		<spring:bind path="jugador.habilidad">
			<input type="text" name="habilidad" value='<c:out value="${jugador.habilidad}" />'>					
		</spring:bind>	
	</li>
	<li>
		<label>Físico</label>
		<spring:bind path="jugador.fisico">
			<input type="text" name="fisico" value='<c:out value="${jugador.fisico}" />'>					
		</spring:bind>	
		<label>Estado</label>
		<spring:bind path="jugador.estado">
			<select name="estado">
				<option <c:if test='${jugador.estado == 1}'>selected</c:if> value="1">Activo</option>
				<option <c:if test='${jugador.estado == 0}'>selected</c:if> value="0">Inactivo</option>
			</select>						
		</spring:bind>	
	</li>
	<li>
		<label>Valor</label>
		<spring:bind path="jugador.valor">
			<input type="text" name="valor" value='<c:out value="${jugador.valor}" />'>
		</spring:bind>
		<label>Tipo de Jugador</label>
		<spring:bind path="jugador.tipoJugadorId">
			<select name="tipoJugadorId">
				<c:forEach items="${tipoJugador}" var="tipo">
					<option <c:if test='${jugador.tipoJugadorId == tipo.id}'>selected</c:if> value="${tipo.id}"><c:out value="${tipo.descripcion}"></c:out></option>						
				</c:forEach>				
			</select>
		</spring:bind>
	</li>
	<li>
		<u>
			<input type="submit" value="Guardar">
			<input type="button" value="Volver">
		</u>
	</li>		
	<li>
		<div id="error">
			 <font color="red">
				<form:errors path="*"/>						 
			 </font> 
		</div>
	</li>
</ul>
</form:form>

<jsp:include page="/jsp/backend/footer.jsp" />