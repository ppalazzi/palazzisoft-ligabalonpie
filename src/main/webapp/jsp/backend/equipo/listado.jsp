<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="/jsp/backend/header.jsp" />

<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script type="text/javascript"
	src="/balonpie/static/js/jquery.dataTables.js"></script>

<script type="text/javascript">
$(document).ready(function () {
    $("#equiposTableId").dataTable({
        "sPaginationType": "full_numbers",
        "bJQueryUI": true
    });
});
</script>

</br>
<div width="80%" align="center">


	<table cellpadding="0" cellspacing="0" border="1"
	 align="center" width="80%" id="equiposTableId" class="display">
		<thead>
			<tr>
				<th>Nombre</th>
				<th>Descripción</th>
				<th>Fecha de Creación</th>
				<th>Estado</th>
				<th>Id del Usuario</th>
				<th>Presupuesto</th>
				<th>Puntos</th>
				<th>Id del Torneo</th>
				<th>Acción</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${equipos}" var="equipo">
				<tr>
					<td>${equipo.nombre}</td>
					<td>${equipo.descripcion}</td>
					<td>${equipo.fechaCreacion}</td>
					<td><c:choose>
							<c:when test="${equipo.estado == 1}">
								<c:out value="Activo" />
							</c:when>
							<c:otherwise><td>${equipo.valor}</td>
								<c:out value="Inactivo" />
							</c:otherwise>
						</c:choose></td>
					<td>${equipo.participanteId}</td>
					<td>${equipo.presupuesto}</td>
					<td>${equipo.puntos}</td>
					<td>${equipo.torneoId}</td>
					<td>
						<a href="/balonpie/nuevoEquipo.adm?id=${equipo.id}">Modificar
					</a>
					</td>
				</tr>
			</c:forEach>			
		</tbody>
	</table>

</div>

<jsp:include page="/jsp/backend/footer.jsp" />
