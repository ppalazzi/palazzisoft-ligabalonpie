<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="/jsp/backend/header.jsp" />

</br>
<form:form id="nuevoEquipoForm" action="nuevoEquipo.adm" method="POST"
	commandName="equipoCommand">
	
	<div id="equipoDivId" class="hide">
		<c:out  value="${equipo.id}"/> 		
	</div>
		
	<c:if test="${equipo.id != null}">
		<spring:bind path="id">
			<input type="hidden" name="id" value="${equipo.id}">
			<input type="hidden" name="fechaCreacion" value="${equipo.fechaCreacion}">
		</spring:bind>												
	</c:if>
	<ul>
		<li><label>Nombre</label> <spring:bind path="nombre">
				<input type="text" name="nombre"
					value='<c:out value="${equipo.nombre}" />' maxlength="254">
			</spring:bind> <label>Descripción</label> <spring:bind paval()th="equipo.descripcion">
				<input type="text" name="descripcion"
					value='<c:out value="${equipo.descripcion}" />' maxlength="254">
			</spring:bind></li>

		<li><label>Estado</label> <spring:bind path="jugador.estado">
				<select name="estado">
					<option <c:if test='${jugador.estado == 1}'>selected</c:if>
						value="1">Activo</option>
					<option <c:if test='${jugador.estado == 0}'>selected</c:if>
						value="0">Inactivo</option>
				</select>
			</spring:bind><label>Presupuesto</label> <spring:bind path="equipo.presupuesto">
				<input type="text" name="presupuesto"
					value='<c:out value="${equipo.presupuesto}" />' maxlength="25">
			</spring:bind></li>
		<li><label>Puntos</label> <spring:bind path="puntos">
				<input type="text" name="puntos"
					value='<c:out value="${equipo.puntos}" />' maxlength="25">
			</spring:bind></li>
		<li><span>Participante Creador</span> 
			<spring:bind path="participanteId">
				<input type="text" name="participanteId"
					value='<c:out value="${equipo.participanteId}" />' maxlength="25">			
			</spring:bind>		
		</li>	

		<a href="#"id="jugadoresDialog">Vender Jugadores</a></br>
		<a href="/balonpie/listadoJugadorDisponibles.adm?equipoId=5&tipoJugadorId=0">Comprar Jugadores</a></br> 
		<input type="submit" value="Guardar">
		
	</ul>

	<div id="message">
		<c:if test="${not empty mensaje}">
			<font color="green">
				<c:out value="${mensaje}" />
			</font>
		</c:if>	
	</div>
	
	<div id="error">
		<font color="red"> 
			<form:errors path="*" />
			
			<c:if test="${not empty error}">
				<c:out value="${error}"></c:out>
			</c:if>				
		</font>
	</div>
			

</form:form>

<script type="text/javascript"
	src="/balonpie/static/js/equipo/nuevo.js"></script>		
	
		
<jsp:include page="/jsp/backend/footer.jsp" />