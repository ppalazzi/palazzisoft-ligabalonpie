<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/jsp/backend/header.jsp" />

<div width="60%" align="center">

<table cellpadding="0" cellspacing="0" border="1" id="example">
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
		</tr>
	</thead>
	<tbody>
		<c:forEach var="jugador" items="${jugadores}">
			<tr>
				<td>${jugador.nombre}</td>
				<td>${jugador.apellido}</td>
				<td>${jugador.fechaNacimiento}</td>
				<td>
					<select id="jugadores_velocidad">
						<c:set var="i" value="1"/>
						<c:forEach begin="${i}" end="10">
							<option <c:if test="${jugador.velocidad == i}">selected</c:if>><c:out value="${i}"/></option>
							<c:set var="i" value="${i + 1}"/>
						</c:forEach>
					</select>
				</td>
				<td>
					<select id="jugadores_remate">
						<c:set var="i" value="1"/>
						<c:forEach begin="${i}" end="10">
							<option <c:if test="${jugador.remate == i}">selected</c:if>><c:out value="${i}"/></option>
							<c:set var="i" value="${i + 1}"/>
						</c:forEach>
					</select>
				</td>		
				<td>
					<select id="jugadores_habilidad">
						<c:set var="i" value="1"/>
						<c:forEach begin="${i}" end="10">
							<option <c:if test="${jugador.habilidad == i}">selected</c:if>><c:out value="${i}"/></option>
							<c:set var="i" value="${i + 1}"/>
						</c:forEach>
					</select>
				</td>						
				<td>
					<select id="jugadores_fisico">
						<c:set var="i" value="1"/>
						<c:forEach begin="${i}" end="10">
							<option <c:if test="${jugador.fisico == i}">selected</c:if>><c:out value="${i}"/></option>
							<c:set var="i" value="${i + 1}"/>
						</c:forEach>
					</select>
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
			</tr>		
		</c:forEach>
		<tr>
			<td></td>
		</tr>
	</tbody>
</table>

</div>

<jsp:include page="/jsp/backend/footer.jsp" />
