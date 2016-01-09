<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
$(document).ready(function () {
    $("#jugadoresCompraTableId").dataTable({
        "sPaginationType": "full_numbers",
        "bJQueryUI": true
    });
      
});
</script>

<div id="comprarJugadorDiv" title="Comprar Jugador">
	<div>
		<span>Presupuesto :</span>
		<span><c:out value="${prueba}" /></span>
	</div>
	
	
	<div>
		<div id="listadoFilters" align="left">
			<label>Posici&oacute;n</label>
			<select id="tipoJugadorSelect" name="tipoJugadorSelect" onchange="CompraJugador.traerPorTipoJugador($('#tipoJugadorSelect').val());">
				<option value="-1" selected>Seleccionar</option>
				<c:forEach items="${tipoJugador}" var="tipo">
					<option value="${tipo.id}" <c:if test="${tipo.id eq tipoJugadorId}">selected</c:if> >
						<c:out value="${tipo.descripcion}"></c:out>
					</option>
				</c:forEach>
			</select>		
		</div>		
		
		<div>
			<table cellpadding="0" cellspacing="0" border="1"
			 align="center" width="80%" id="jugadoresCompraTableId" class="display">
				<thead>
					<tr>
						<th>Nombre</th>
						<th>Apellido</th>
						<th>Velocidad</th>
						<th>Remate</th>
						<th>Habilidad</th>
						<th>F&iacute;sico</th>
						<th>Valor</th>
						<th>Opci&oacute;n</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${jugadores}" var="jugador">
						<tr>
							<td>${jugador.nombre}</td>
							<td>${jugador.apellido}</td>
							<td>${jugador.velocidad}</td>
							<td>${jugador.remate}</td>
							<td>${jugador.habilidad}</td>
							<td>${jugador.fisico}</td>
							<td>${jugador.valor}</td>
							<td>
								<a onclick="CompraJugador.comprarJugador(<c:out value="${jugador.id}" />,<c:out value="${equipoId}" />);" href="#"><img alt="image" src="static/images/plus.jpg" title="Comprar"></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>		
		</div>
	</div>
</div>		

<script type="text/javascript"
	src="/balonpie/static/js/equipo/nuevo.js"></script>	