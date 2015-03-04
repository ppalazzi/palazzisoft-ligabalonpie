<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
	
	<div id="container" style="position: relative; top: -112px; left: 290px;" >
		<jsp:include page="/jsp/common/torneo/nuevo.jsp" />
	</div>
<jsp:include page="/jsp/footer.jsp" />	