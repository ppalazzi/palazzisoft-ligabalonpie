<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="listadoDiv">
	<ul>
		<c:forEach items="${torneos}" var="torneo">
			<li><c:out value="${torneo.descripcion}"></c:out></li>		
		</c:forEach>
	</ul>
</div>