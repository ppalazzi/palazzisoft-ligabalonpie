<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<jsp:include page="/jsp/backend/header.jsp" />

</br>
<div width="80%" align="center">


	<table cellpadding="0" cellspacing="0" border="1" id="example" 
		align="center" width="80%" >
		<thead>
			<tr>
				<th>Nombre</th>
				<th>Descripci�n</th>
				<th>Fecha de Creaci�n</th>
				<th>Estado</th>
				<th>Id del Usuario</th>
				<th>Presupuesto</th>
				<th>Puntos</th>
				<th>Id del Torneo</th>
				<th>Acci�n</th>
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
						<a href="/balonpie/listadoJugadorPorEquipo.adm?equipoId=<c:out value="${equipo.id}" />">Ver Jugadores</a>
						<a href="/balonpie/nuevoEquipo.adm?id=${equipo.id}">Modificar
					</a>
					</td>
				</tr>
			</c:forEach>			
		</tbody>
	</table>

</div>

<jsp:include page="/jsp/backend/footer.jsp" />
