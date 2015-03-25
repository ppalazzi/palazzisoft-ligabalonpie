<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="/jsp/header.jsp" />

<script type="text/javascript"
	src="/balonpie/static/js/dashboard.js"></script>

	<input type="hidden" id="participanteId" value="<c:out value='${participanteId}' />" >
	
	<div>
		<ul>
			<li><a href="nuevoTorneo.htm?participanteId=<c:out value="${participanteId}" />">Nuevo Torneo</a></li>

			<li id="misTorneos"><label>Mis Torneos</label>
				<div id="listadoTorneoDiv"></div>
			</li>			
			<li id="miPerfil">
				<label>Mi Perfil</label>
			</li>
		</ul>
	</div>
	
	<div id="container" style="position: relative; top: 10px; left: 290px;" >
		<form:form modelAttribute="equipo" action="${flowExecutionUrl}&_eventId=guardarEquipo2">
			<ul>
				<li><label>Nombre</label> 
					<form:input path="nombre" maxlength="50" />
				</li>
				<li>
					<label>Descripción</label> 
					<form:input path="descripcion" maxlength="50" />
				</li>		
			</ul>
	
			<input type="submit" value="Continuar">		
		</form:form>
	</div>
<jsp:include page="/jsp/footer.jsp" />	