<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/jsp/backend/header.jsp" />

<script type="text/javascript"
	src="/balonpie/static/js/jquery.dataTables.js"></script>

<script type="text/javascript">
$(document).ready(function () {
    $("#torneoTableId").dataTable({
        "sPaginationType": "full_numbers",
        "bJQueryUI": true
    });
});
</script>

</br>
<div width="80%" align="center">

<table cellpadding="0" cellspacing="0" border="1" id="torneoTableId" class="display" align="center" width="80%" >
	<thead>
		<tr>
			<th>Descripci&oacute;n</th>
			<th>Fecha de Creaci&oacute;n</th>
			<th>Estado</th>			
			<th>Fecha de Inicio</th>
			<th>Fecha de Fin</th>
			<th>Acciones</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="torneo" items="${torneos}">
			<tr>
				<td>${torneo.descripcion}</td>
				<td>
					<fmt:parseDate value="${torneo.fechaCreacion}" var="fechaCreacion" 
					                              pattern="MM/dd/yyyy" />
					<fmt:formatDate value="${fechaCreacion}"/>                            
				</td>
				<td>
					<c:choose>
						<c:when test="${torneo.estado == 1}">
							<c:out value="Activo" />
						</c:when>
						<c:otherwise>
							<c:out value="Inactivo" />					
						</c:otherwise>
					</c:choose>
				</td>				
				<td>
					<fmt:parseDate value="${torneo.fechaInicio}" var="fechaInicio" 
					                              pattern="MM/dd/yyyy" />
					<fmt:formatDate value="${fechaInicio}"/>    				
				</td>
				<td>
					<fmt:parseDate value="${torneo.fechaFin}" var="fechaFin" 
					                              pattern="MM/dd/yyyy" />
					<fmt:formatDate value="${fechaFin}"/>  
				</td>		
				<td>
					<a href="/balonpie/nuevoTorneo.adm?id=${torneo.id}">Modificar</a>
				</td>	
			</tr>		
		</c:forEach>
	</tbody>
</table>

</div>

<jsp:include page="/jsp/backend/footer.jsp" />
