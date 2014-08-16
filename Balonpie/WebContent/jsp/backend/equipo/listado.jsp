<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/jsp/backend/header.jsp" />

</br>
<div width="80%" align="center">

<table cellpadding="0" cellspacing="0" border="1" id="example" align="center" width="80%" >
	<thead>
		<tr>
			<th>Nombre</th>
			<th>Descripción</th>
			<th>Fecha de Creación</th>
			<th>Estado</th>
			<th>Id del Usuario</th>
			<th>Presupuesto</th>
			<th>Ver Jugadores</th>
			<th>Puntos</th>
			<th>Id del Torneo</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${equipos}" var="equipo">
			<tr>
				<td>${equipo.nombre}
			</tr>
		</c:forEach>
	</tbody>
</table>

</div>

<jsp:include page="/jsp/backend/footer.jsp" />
