<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/jsp/backend/header.jsp" />

<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script type="text/javascript"
	src="/balonpie/static/js/jquery.dataTables.js"></script>

<script type="text/javascript">
$(document).ready(function () {
    $("#participanteesTableId").dataTable({
        "sPaginationType": "full_numbers",
        "bJQueryUI": true
    });
});
</script>

</br>
<div width="80%" align="center">

<table cellpadding="0" cellspacing="0" border="1" id="participanteesTableId" class="display" align="center" width="80%" >
	<thead>
		<tr>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Email</th>
			<th>Fecha de Nacimiento</th>
			<th>Pa&iacute;s</th>
			<th>Calle</th>
			<th>N&uacute;mero</th>
			<th>Estado</th>
			<th>Ciudad</th>
			<th>Acción</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="participante" items="${participantes}">
			<tr>
				<td>${participante.nombre}</td>
				<td>${participante.apellido}</td>
				<td>${participante.email}</td>
				<td>${participante.fechaNacimiento}</td>
				<td>${participante.pais}</td>
				<td>
					<c:out value="${participante.calle}"/>
				</td>		
				<td>
					<c:out value="${participante.numero}"/>		
				</td>						
				<td>
					<c:choose>
						<c:when test="${participante.estado == 1}">
							<c:out value="Activo" />
						</c:when>
						<c:otherwise>
							<c:out value="Inactivo" />					
						</c:otherwise>
					</c:choose>
				</td>		
				<td><c:out value="${participante.ciudad}" /></td>
				<td>
					<a href="/balonpie/nuevoParticipante.adm?id=${participante.id}">Modificar</a>
				</td>	
			</tr>		
		</c:forEach>
	</tbody>
</table>

</div>

<jsp:include page="/jsp/backend/footer.jsp" />
