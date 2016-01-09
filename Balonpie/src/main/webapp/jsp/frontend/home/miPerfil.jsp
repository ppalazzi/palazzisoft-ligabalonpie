<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
	<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
</head>
<script>
	$(function() {
		$("#datepicker").datepicker();
	});
</script>

<form:form  commandName="participanteCommand">
<div id="perfilDiv">

	<input type="hidden" name="nombre" id="id" value="${participante.id}">
	<input type="hidden" name="estado" id="estado" value="${participante.estado}">	

	<ul>
		<li><label>Nombre</label><spring:bind path="participante.nombre">
			<input type="text" name="nombre" id="nombre"
					value='<c:out value="${participante.nombre}" />' maxlength="50"></spring:bind> 
			<label>Apellido</label>
				<input type="text" name="apellido" id="apellido"
					value='<c:out value="${participante.apellido}" />' maxlength="50">
		</li>

		<li>
			<label>Email</label>
				<input type="text" name="email" id="email"
					value='<c:out value="${participante.email}" />' maxlength="255">
		</li>
		<li><label>Fecha de Nacimiento</label> 
				<input type="text" name="fechaNacimiento" id="datepicker"
					value='<c:out value="${participante.fechaNacimiento}" />'
					maxlength="25">
		</li>
		<li><span>Ciudad</span>
				<input type="text" name="ciudad" id="ciudad"
					value='<c:out value="${participante.ciudad}" />' maxlength="50">
		</li>
		<li><span>Calle</span>
				<input type="text" name="calle" id="calle"
					value='<c:out value="${participante.calle}" />' maxlength="25">
		</li>
		<li><span>N&uacute;mero</span> <spring:bind
				path="participante.numero">
				<input type="text" name="numero" id="numero"
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
				<input type="text" name="password" id="password"
					value='<c:out value="${participante.password}" />' maxlength="20">				
			</spring:bind>
		</li>	
		
		<input id="perfilBtnGuardar" type="button" value="Guardar" onclick="Dashboard.actualizarPerfil();">
		
	</ul>
</div>
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