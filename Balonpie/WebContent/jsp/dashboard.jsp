<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/jsp/header.jsp" />
<script type="text/javascript" src="static/js/dashboard.js"></script>
	<div>
		<ul>
			<li><a href="nuevoTorneo.htm?participanteId=<c:out value="${participanteId}" />">Nuevo Torneo</a></li>

			<li id="misTorneos">Mis Torneos</a>
				<div id="listadoTorneoDiv">
					<jsp:include page="/jsp/frontend/torneo/listado.jsp" />				
				</div>
			</li>			
			<li><a
				href="registro.htm?participanteId=<c:out value="${participanteId}" />">Ver Perfil</a></li>
		</ul>
	</div>
	
	<div id="equipoResumenDiv" style="display:none">
		<jsp:include page="/jsp/frontend/equipo/equipoResumen.jsp" />	
	</div>
<jsp:include page="/jsp/footer.jsp" />	