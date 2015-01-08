<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="/jsp/backend/header.jsp" />

<script>
	$(function() {
		$("#inicioPicker").datepicker();
		$("#finPicker").datepicker();
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
		<li>
			<div id="error">
				<font color="red"> <form:errors path="*" />
				</font>
			</div>
		</li>

		<input type="submit" value="Guardar">
	</ul>

</form:form>

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


<jsp:include page="/jsp/backend/footer.jsp" />