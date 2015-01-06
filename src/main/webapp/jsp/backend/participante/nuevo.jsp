<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="/jsp/backend/header.jsp" />

<script>
	$(function() {
		$("#datepicker").datepicker();
	});
</script>

</br>
<form:form id="nuevoParticipanteForm" action="nuevoParticipante.adm"
	method="POST" commandName="participanteCommand">

	<div id="participanteDivId" class="hide">
		<c:out value="${participante.id}" />
	</div>

	<c:if test="${participante.id != null}">
		<spring:bind path="id">
			<input type="hidden" name="id" value="${participante.id}">
		</spring:bind>
	</c:if>
	<ul>
		<li><label>Nombre</label> <spring:bind path="participante.nombre">
				<input type="text" name="nombre"
					value='<c:out value="${participante.nombre}" />' maxlength="50">
			</spring:bind> <label>Apellido</label> <spring:bind path="participante.apellido">
				<input type="text" name="apellido"
					value='<c:out value="${participante.apellido}" />' maxlength="50">
			</spring:bind></li>

		<li><label>Estado</label> <spring:bind path="participante.estado">
				<select name="estado">
					<option <c:if test='${participante.estado == 1}'>selected</c:if>
						value="1">Activo</option>
					<option <c:if test='${participante.estado == 0}'>selected</c:if>
						value="0">Inactivo</option>
				</select>
			</spring:bind><label>Email</label> <spring:bind path="participante.email">
				<input type="text" name="email"
					value='<c:out value="${participante.email}" />' maxlength="255">
			</spring:bind></li>
		<li><label>Fecha de Nacimiento</label> <spring:bind
				path="participante.fechaNacimiento">
				<input type="text" name="fechaNacimiento" id="datepicker"
					value='<c:out value="${participante.fechaNacimiento}" />'
					maxlength="25">
			</spring:bind></li>
		<li><span>Ciudad</span> <spring:bind path="participante.ciudad">
				<input type="text" name="ciudad"
					value='<c:out value="${participante.ciudad}" />' maxlength="50">
			</spring:bind></li>
		<li><span>Calle</span> <spring:bind path="participante.calle">
				<input type="text" name="calle"
					value='<c:out value="${participante.calle}" />' maxlength="25">
			</spring:bind></li>
		<li><span>N&uacute;mero</span> <spring:bind
				path="participante.numero">
				<input type="text" name="numero"
					value='<c:out value="${participante.numero}" />' maxlength="25">
			</spring:bind></li>
		<li><span>Pa&iacute;s</span> <spring:bind
				path="participante.pais">
				<select id="pais" name="pais">
					<c:forEach items="${paises}" var="pais">
						<option value="<c:out value="${pais.key}" />" <c:if test="${pais.key == participante.pais}" >selected</c:if> >
							<c:out value="${pais.value}" />
						</option>
					</c:forEach>
				</select>
			</spring:bind></li>
		<li><span>Password</span>
			<spring:bind path="participante.password">
				<input type="text" name="password"
					value='<c:out value="${participante.password}" />' maxlength="50">				
			</spring:bind>
		</li>	

		<input type="submit" value="Guardar">
	</ul>

</form:form>

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


<jsp:include page="/jsp/backend/footer.jsp" />