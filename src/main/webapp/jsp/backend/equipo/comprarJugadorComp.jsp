<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript"
	src="/balonpie/static/js/equipo/comprarJugadorComp.js"></script>


<div id="comprarJugadorDiv">
	<div>
		<span>Presupuesto :</span>
		<span><c:out value="${prueba}" /></span>
	</div>
	
	
	<div>
		<div id="listadoFilters" align="left">
			<label>Posición</label>
			<select id="tipoJugadorSelect" name="tipoJugadorSelect">
				<option value="-1" selected>Seleccionar</option>
				<c:forEach items="${tipoJugador}" var="tipo">
					<option value="${tipo.id}" <c:if test="${tipo.id eq tipoJugadorId}">selected</c:if> >
						<c:out value="${tipo.descripcion}"></c:out>
					</option>
				</c:forEach>
			</select>		
		</div>		
		
		<div>
			<c:forEach items="${jugadores}" var="jugador">
				<div class="Table">
				    <div class="Title">
				        <p>Jugadores</p>
				    </div>
				    <div class="Heading">
				        <div class="Cell">
				            <p>Nombre</p>
				        </div>
				        <div class="Cell">
				            <p>Apellido</p>
				        </div>
				        <div class="Cell">
				            <p>Velocidad</p>
				        </div>
				        <div class="Cell">
				        	<p>Remate</p>
				        </div>
				        <div class="Cell">
				        	<p>Habilidad</p>
				        </div>
				        <div class="Cell">
				        	<p>F&iacute;sico</p>
				        </div>
				        <div class="Cell">
				        	<p>Valor</p>
				        </div>
				        <div class="Cell">
				        	<p>Opci&oacute;n</p>
				        </div>						        				    				        				        				        
				    </div>
				    <div class="Row">
				        <div class="Cell">
				            <p>${jugador.nombre}</p>
				        </div>
				        <div class="Cell">
				            <p>${jugador.apellido}</p>
				        </div>
				        <div class="Cell">
				            <p>${jugador.velocidad}</p>
				        </div>
				        <div class="Cell">
				            <p>${jugador.remate}</p>
				        </div>
				        <div class="Cell">
				            <p>${jugador.habilidad}</p>
				        </div>	
				        <div class="Cell">
				            <p>${jugador.fisico}</p>
				        </div>
				        <div class="Cell">
				            <p>${jugador.valor}</p>
				        </div>		
				        <div class="Cell">
				        	<a onclick="comprarJugador(<c:out value="${jugador.id}" />);" href="#"><img alt="image" src="static/images/plus.jpg" title="Comprar"></a>
				        </div>			        					        				        				        
				    </div>

				</div>	
			</c:forEach>
		</div>
	</div>
</div>		
	