<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
	<c:forEach items="${participante.torneos}" var="torneo">
		<a href="#"
			onclick="traerEquiposPorTorneo(<c:out value='${torneo.id}' />,<c:out value='${participanteId}' />);"><c:out
				value="${torneo.descripcion}" /></a>
		</br>
	</c:forEach>
</div>