<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/jsp/backend/header.jsp" />

<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script type="text/javascript"
	src="/balonpie/static/js/jquery.dataTables.js"></script>

<script type="text/javascript">
$(document).ready(function () {
    $("#jugadoresTableId").dataTable({
        "sPaginationType": "full_numbers",
        "bJQueryUI": true
    });
});
</script>

</br>
<div width="80%" align="center">

<table cellpadding="0" cellspacing="0" border="1" id="jugadoresTableId" class="display" align="center" width="80%" >
	<thead>
		<tr>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Fecha de Nacimiento</th>
			<th>Velocidad</th>
			<th>Remate</th>
			<th>Habilidad</th>
			<th>Físico</th>
			<th>Estado</th>
			<th>Valor</th>
			<th>Posición</th>
			<th>Acción</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="jugador" items="${jugadores}">
			<tr>
				<td>${jugador.nombre}</td>
				<td>${jugador.apellido}</td>
				<td>${jugador.fechaNacimiento}</td>
				<td>
					<c:out value="${jugador.velocidad}"/>
				</td>
				<td>
					<c:out value="${jugador.remate}"/>
				</td>		
				<td>
					<c:out value="${jugador.habilidad}"/>		
				</td>						
				<td>
					<c:out value="${jugador.fisico}"/>				
				</td>	
				<td>
					<c:choose>
						<c:when test="${jugador.estado == 1}">
							<c:out value="Activo" />
						</c:when>
						<c:otherwise>
							<c:out value="Inactivo" />					
						</c:otherwise>
					</c:choose>
				</td>		
				<td><c:out value="${jugador.valor}" /></td>
				<td><c:out value="${jugador.tipoJugadorDescripcion}" /></td>	
				<td>
					<a href="/balonpie/nuevoJugador.adm?id=${jugador.id}">Modificar</a>
				</td>	
			</tr>		
		</c:forEach>
	</tbody>
</table>

</div>

<jsp:include page="/jsp/backend/footer.jsp" />
