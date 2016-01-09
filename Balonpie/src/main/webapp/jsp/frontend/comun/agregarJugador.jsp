<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">

<script type="text/javascript"
	src="/balonpie/static/js/jquery.dataTables.js"></script>

<script type="text/javascript">
$(document).ready(function () {
    $("#jugadoresCompraTableId").dataTable({
        "sPaginationType": "full_numbers",
        "bJQueryUI": true
    });
});

function asignarJugador(id, nombre, apellido, velocidad, remate, habilidad, fisico, valor) {	    		
	var posicion = $("#posicion").val();
	Dashboard.asignarJugadorAPantalla(id, nombre, apellido, posicion, velocidad, remate, habilidad, fisico, valor);	
}

</script>

<div id="comprarJugadorDiv" title="Comprar Jugador">
	
	<input type="hidden" id="tipoJugadorId" value="${tipoJugadorId}">
	<input type="text" id="posicion" value="${posicion}">
	
	<div>			
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
							<td id="nombre">${jugador.nombre}</td>
							<td id="apellido">${jugador.apellido}</td>
							<td id="velocidad">${jugador.velocidad}</td>
							<td id="remate">${jugador.remate}</td>
							<td id="habilidad">${jugador.habilidad}</td>
							<td id="fisico">${jugador.fisico}</td>
							<td id="valor">${jugador.valor}</td>
							<td>
								<a id="comprarJugadorA" onclick="asignarJugador('<c:out value="${jugador.id}" />','<c:out value="${jugador.nombre}" />','<c:out value="${jugador.apellido}" />',
								'<c:out value="${jugador.velocidad}" />','<c:out value="${jugador.remate}" />',
								'<c:out value="${jugador.habilidad}" />','<c:out value="${jugador.fisico}" />','<c:out value="${jugador.valor}" />');" href="#"><img alt="image" src="static/images/plus.jpg" title="Comprar"></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>		
		</div>
	</div>
</div>		

<script type="text/javascript"
	src="/balonpie/static/js/equipo/nuevo.js"></script>	