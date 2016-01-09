<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/jsp/header.jsp" />

<script type="text/javascript"
	src="/balonpie/static/js/dashboard.js"></script>

	
	<c:url value="/nuevoTorneo.htm" var="url">
		<c:param name="participanteId" value="${participanteId}"/>
	</c:url>

	<c:url value="/torneoDeParticipante.htm" var="urlMisTorneos">
		<c:param name="participanteId" value="${participanteId}"/>
	</c:url>
		
	<div>
		<ul>
			<li><a href="${url}">Nuevo Torneo</a></li>

		<li id="misTorneos"><a href="${urlMisTorneos}"><label>Mis Torneos</label></a>
			</li>
		<li id="miPerfil">
				<label>Mi Perfil</label>
			</li>
		</ul>
	</div>
	
	<div id="container" style="position: relative; top: -112px; left: 290px;" >
	
	</div>
<jsp:include page="/jsp/footer.jsp" />	