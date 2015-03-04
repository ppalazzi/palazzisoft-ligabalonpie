<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script>
	$(function() {
		$("#inicioPicker").datepicker();
		$("#finPicker").datepicker();
		
	    $("#equiposTableId").dataTable({
	        "bJQueryUI": true
	    });		
	});
</script>

</br>
<form:form id="nuevoTorneoForm" action="nuevoTorneo.adm" method="POST"
	commandName="torneoCommand">

	<div id="torneoDivId" class="hide">
		<c:out value="${torneo.id}" />
	</div>

	<c:if test="${torneo.id != null}">
		<spring:bind path="id">
			<input type="hidden" name="id" value="${torneo.id}">
			<input type="hidden" name="fechaCreacion" value="${torneo.fechaCreacion}">
		</spring:bind>
	</c:if>
	<ul>
		<li><label>Descripci&oacute;n</label> <spring:bind
				path="torneo.nombre">
				<input type="text" name="descripcion"
					value='<c:out value="${torneo.descripcion}" />' maxlength="50">
			</spring:bind></li>
		<li><label>Estado</label> <spring:bind path="torneo.estado">
				<select name="estado">
					<option <c:if test='${torneo.estado == 1}'>selected</c:if>
						value="1">Activo</option>
					<option <c:if test='${torneo.estado == 0}'>selected</c:if>
						value="0">Inactivo</option>
				</select>
			</spring:bind><label>Fecha Inicio</label> <spring:bind path="torneo.fechaInicio">
				<input type="text" name="fechaInicio" id="inicioPicker"
					value='<c:out value="${torneo.fechaInicio}" />' maxlength="25">
			</spring:bind></li>
		<li><label>Fecha Fin</label> <spring:bind path="torneo.fechaFin">
				<input type="text" name="fechaFin" id="finPicker"
					value='<c:out value="${torneo.fechaFin}" />' maxlength="25">
			</spring:bind></li>
		<li><label>Id del Participante</label><spring:bind path="torneo.participanteId">
			<input type="text" name="participanteId" value="${torneo.participanteId}" maxlength="" >
		</spring:bind>
		</li>
		<li>
			<div id="error">
				<font color="red"> <form:errors path="*" />
				</font>
			</div>
		</li>

	</ul>

	<input type="submit" value="Guardar">
	<jsp:include page="/jsp/backend/messages.jsp" />

	<div id="message">
		<c:if test="${not empty mensaje}">
			<font color="green"> <c:out value="${mensaje}" />
			</font>
		</c:if>
	</div>
	
	<div id="error">
		<font color="red"> <form:errors path="*" /> <c:if
				test="${not empty error}">
				<c:out value="${error}"></c:out>
			</c:if>
		</font>
	</div>

	</br>

	<c:if test="${not empty torneo.equipos}">
	<div id="equiposContainer">
		<table cellpadding="0" cellspacing="0" border="1"
		 align="center" width="80%" id="equiposTableId" class="display">
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Descripción</th>
					<th>Fecha de Creaci&oacute;n</th>
					<th>Estado</th>
					<th>Id del Usuario</th>
					<th>Acción</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${torneo.equipos}" var="equipo">
					<tr>
						<td>${equipo.nombre}</td>
						<td>${equipo.descripcion}</td>
						<td>
							<fmt:parseDate value="${equipo.fechaCreacion}" var="fechaCreacion" 
							                              pattern="MM/dd/yyyy" />
							<fmt:formatDate value="${fechaCreacion}"/>  										
						</td>
						<td><c:choose>
								<c:when test="${equipo.estado == 1}">
									<c:out value="Activo" />
								</c:when>
								<c:otherwise><td>${equipo.valor}</td>
									<c:out value="Inactivo" />
								</c:otherwise>
							</c:choose></td>
						<td>${equipo.participanteId}</td>
						<td>
							<a href="/balonpie/nuevoEquipo.adm?id=${equipo.id}">Modificar</a>
						</td>
					</tr>
				</c:forEach>			
			</tbody>
		</table>	
		</div>
	</c:if>
</form:form>