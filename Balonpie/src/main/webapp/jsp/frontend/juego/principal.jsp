<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="/jsp/header.jsp" />

<script type="text/javascript" src="/balonpie/static/js/dashboard.js"></script>
<script type="text/javascript" src="/balonpie/static/js/torneo/listado.js"></script>

<c:url value="/nuevoTorneo.htm" var="url">
	<c:param name="participanteId" value="${participanteId}" />
</c:url>

<c:url value="/torneoDeParticipante.htm" var="urlMisTorneos">
	<c:param name="participanteId" value="${participanteId}" />
</c:url>

<div>
	<ul>
		<li><a href="${url}">Nuevo Torneo</a></li>

		<li id="misTorneos"><a href="${urlMisTorneos}"><label>Mis
					Torneos</label></a></li>
		<li id="miPerfil"><label>Mi Perfil</label></li>
	</ul>
</div>
principal mostro
<div id="container"
	style="position: relative; top: 0px; left: 221px;">
	<div id="listadoDiv">
		<ul>
			<c:forEach items="${torneos}" var="torneo">
				<a onclick="Torneos.mostrarDetalles('${torneo.id}');" href="#"><li><c:out value="${torneo.descripcion}"></c:out></li></a>
			</c:forEach>
		</ul>
	</div>
	
	<div id="misEquiposDiv">
	
	</div>
</div>
<jsp:include page="/jsp/footer.jsp" />