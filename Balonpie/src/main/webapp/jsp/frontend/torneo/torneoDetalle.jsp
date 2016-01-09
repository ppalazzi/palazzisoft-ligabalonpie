<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div>
	<div id="torneoDiv">
		<ul>
			<li>
				<label>Nombre Torneo</label>
			</li>
			<li>
				<label><c:out value="${torneo.descripcion}"/></label>
			</li>
		</ul>
	</div>
	
	<div id="equipoDiv">
		<ul>
			<li>
				<label>Nombre Equipo</label>
			</li>
			<li>
				<label><c:out value="${equipo.nombre}"/></label>
			</li>
		</ul>	
	</div>
				
	<form:form id="jugarTorneo" action="jugarTorneo.htm" method="POST">
		<input type="hidden" value="<c:out value='${participanteId}' />" name="participanteId">
		<input type="hidden" value="<c:out value='${torneo.id}' />" name="torneoId">
		<input type="hidden" value="<c:out value='${equipo.id}' />" name="equipoId">
		
		<div>
			<input type="submit" value="Jugar">
		</div>
	</form:form>
</div>