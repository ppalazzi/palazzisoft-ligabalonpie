<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="/jsp/header.jsp" />

<link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">

<script type="text/javascript"
	src="/balonpie/static/js/dashboard.js"></script>

	<c:url value="/nuevoTorneo.htm" var="url">
		<c:param name="participanteId" value="${participanteId}"/>
	</c:url>
	
	<div>
		<ul>
			<li><a href="nuevoTorneo.htm?participanteId=<c:out value="${participanteId}" />">Nuevo Torneo</a></li>

			<li id="misTorneos"><label>Mis Torneos</label>
				<div id="listadoTorneoDiv"></div>
			</li>			
			<li id="miPerfil">
				<label>Mi Perfil</label>
			</li>
		</ul>
	</div>
	
	<div id="container" style="position: relative; top: 10px; left: 290px;" >
		<form:form id="nuevoTorneoform" commandName="nuevoTorneoCommand" action="nuevoTorneo.htm" method="POST">
			<input type="hidden" value="<c:out value='${participanteId}' />" name="participanteId">

			<ul>			
				<li><label>Nombre del Torneo</label>
					
					<spring:bind path="nombreTorneo">
									<input type="text" id="nombreTorneo" name="nombreTorneo" maxlength="50"
										value='<c:out value="${nuevoTorneo.nombreTorneo}" />'>
								</spring:bind>
					<font color="red">
						<form:errors path="nombreTorneo" />
					</font>																			
				<li>
				<li><label>Nombre del Equipo</label> 
					<spring:bind path="nombreEquipo">
									<input type="text" id="nombreEquipo" name="nombreEquipo" maxlength="50"
										value='<c:out value="${nuevoTorneo.nombreEquipo}" />'>
								</spring:bind>			
					<font color="red">
						<form:errors path="nombreEquipo" />
					</font>						
				</li>
				<li>
					<label>Descripción del Equipo</label> 
					<form:input id="descripcionEquipo" path="descripcionEquipo" maxlength="50" /> 
					<font
						color="red"> <form:errors path="descripcionEquipo" />
					</font>

					<font
						color="red"> <form:errors path="cantidadJugadores" />
					</font>										
			</li>					
			</ul>
				
			<div id="jugadores">
				<ul>
					<li>Arquero</li>
					<li>					
						<div id="navcontainer">
							<ul id="navlist">
							<spring:bind path="idPos0">
								<input type="hidden" name="idPos0" id="idPos0"
									value='<c:out value="${nuevoTorneo.idPos0}" />'>
							</spring:bind>
							<li id="nomPos0"></li>
								<li id="apePos0"></li>
								<li id="velPos0"></li>
								<li id="remPos0"></li>
								<li id="habPos0"></li>
								<li id="fisPos0"></li>
								<li id="valPos0"></li>
								<li>
									<a onclick="Dashboard.comprarJugadorPorPosicion(0,0);"><img alt="" src="/balonpie/static/images/plus.jpg"></a>
									<a href=""><img alt="" src="/balonpie/static/images/less.png"></a>
								</li>
								<li>
									<font color="red">
										<form:errors path="idPos0" />
									</font>
								</li>
							</ul>
						</div>
					</li>
				</ul>
				<ul>
					<li>Defensa</li>
					<li>
						<div id="navcontainer">
							<ul id="navlist">
							<spring:bind path="idPos1">
								<input type="hidden" name="idPos1" id="idPos1"
									value='<c:out value="${nuevoTorneo.idPos1}" />'>
							</spring:bind>
								<li id="nomPos1"></li>
								<li id="apePos1"></li>
								<li id="velPos1"></li>
								<li id="remPos1"></li>
								<li id="habPos1"></li>
								<li id="fisPos1"></li>
								<li id="valPos1"></li>
								<li>
									<a onclick="Dashboard.comprarJugadorPorPosicion(1,1);"><img alt="" src="/balonpie/static/images/plus.jpg"></a>
									<a href=""><img alt="" src="/balonpie/static/images/less.png"></a>
								</li>
								<li>
									<font color="red">
										<form:errors path="idPos1" />
									</font>
								</li>								
							</ul>
						</div>					
					</li>
					<li>
						<div id="navcontainer">
							<ul id="navlist">
							<spring:bind path="idPos2">
								<input type="hidden" name="idPos2" id="idPos2"
									value='<c:out value="${nuevoTorneo.idPos2}" />'>
							</spring:bind>
								<li id="nomPos2"></li>
								<li id="apePos2"></li>
								<li id="velPos2"></li>
								<li id="remPos2"></li>
								<li id="habPos2"></li>
								<li id="fisPos2"></li>
								<li id="valPos2"></li>
								<li>
									<a onclick="Dashboard.comprarJugadorPorPosicion(1,2);"><img alt="" src="/balonpie/static/images/plus.jpg"></a>
									<a href=""><img alt="" src="/balonpie/static/images/less.png"></a>
								</li>
								<li>
									<font color="red">
										<form:errors path="idPos2" />
									</font>
								</li>								
							</ul>
						</div>					
					</li>
					<li>
						<div id="navcontainer">
							<ul id="navlist">
							<spring:bind path="idPos3">
								<input type="hidden" name="idPos3" id="idPos3"
									value='<c:out value="${nuevoTorneo.idPos3}" />'>
							</spring:bind>							
								<li id="nomPos3"></li>
								<li id="apePos3"></li>
								<li id="velPos3"></li>
								<li id="remPos3"></li>
								<li id="habPos3"></li>
								<li id="fisPos3"></li>
								<li id="valPos3"></li>
								<li>
									<a onclick="Dashboard.comprarJugadorPorPosicion(1,3);"><img alt="" src="/balonpie/static/images/plus.jpg"></a>
									<a href=""><img alt="" src="/balonpie/static/images/less.png"></a>
								</li>
								<li>
									<font color="red">
										<form:errors path="idPos3" />
									</font>
								</li>								
							</ul>
						</div>						
					</li>
					<li>
						<div id="navcontainer">
							<ul id="navlist">
							<spring:bind path="idPos4">
								<input type="hidden" name="idPos4" id="idPos4"
									value='<c:out value="${nuevoTorneo.idPos4}" />'>
							</spring:bind>							
								<li id="nomPos4"></li>
								<li id="apePos4"></li>
								<li id="velPos4"></li>
								<li id="remPos4"></li>
								<li id="habPos4"></li>
								<li id="fisPos4"></li>
								<li id="valPos4"></li>
								<li>
									<a onclick="Dashboard.comprarJugadorPorPosicion(1,4);"><img alt="" src="/balonpie/static/images/plus.jpg"></a>
									<a href=""><img alt="" src="/balonpie/static/images/less.png"></a>
								</li>
								<li>
									<font color="red">
										<form:errors path="idPos4" />
									</font>
								</li>								
							</ul>
						</div>						
					</li>
				</ul>
				<ul>
					<li>Mediocampo</li>
					<li>
						<div id="navcontainer">
							<ul id="navlist">
							<spring:bind path="idPos5">
								<input type="hidden" name="idPos5" id="idPos5"
									value='<c:out value="${nuevoTorneo.idPos5}" />'>
							</spring:bind>							
								<li id="nomPos5"></li>
								<li id="apePos5"></li>
								<li id="velPos5"></li>
								<li id="remPos5"></li>
								<li id="habPos5"></li>
								<li id="fisPos5"></li>
								<li id="valPos5"></li>
								<li>
									<a onclick="Dashboard.comprarJugadorPorPosicion(2,5);"><img alt="" src="/balonpie/static/images/plus.jpg"></a>
									<a href=""><img alt="" src="/balonpie/static/images/less.png"></a>
								</li>
								<li>
									<font color="red">
										<form:errors path="idPos5" />
									</font>
								</li>								
							</ul>
						</div>						
					</li>
					<li>
						<div id="navcontainer">
							<ul id="navlist">
							<spring:bind path="idPos6">
								<input type="hidden" name="idPos6" id="idPos6"
									value='<c:out value="${nuevoTorneo.idPos6}" />'>
							</spring:bind>							
								<li id="nomPos6"></li>
								<li id="apePos6"></li>
								<li id="velPos6"></li>
								<li id="remPos6"></li>
								<li id="habPos6"></li>
								<li id="fisPos6"></li>
								<li id="valPos6"></li>
								<li>
									<a onclick="Dashboard.comprarJugadorPorPosicion(2,6);"><img alt="" src="/balonpie/static/images/plus.jpg"></a>
									<a href=""><img alt="" src="/balonpie/static/images/less.png"></a>
								</li>
								<li>
									<font color="red">
										<form:errors path="idPos6" />
									</font>
								</li>								
							</ul>
						</div>						
					</li>
					<li>
						<div id="navcontainer">
							<ul id="navlist">
							<spring:bind path="idPos7">
								<input type="hidden" name="idPos7" id="idPos7"
									value='<c:out value="${nuevoTorneo.idPos7}" />'>
							</spring:bind>							
								<li id="nomPos7"></li>
								<li id="apePos7"></li>
								<li id="velPos7"></li>
								<li id="remPos7"></li>
								<li id="habPos7"></li>
								<li id="fisPos7"></li>
								<li id="valPos7"></li>
								<li>
									<a onclick="Dashboard.comprarJugadorPorPosicion(2,7);"><img alt="" src="/balonpie/static/images/plus.jpg"></a>
									<a href=""><img alt="" src="/balonpie/static/images/less.png"></a>
								</li>
								<li>
									<font color="red">
										<form:errors path="idPos7" />
									</font>
								</li>								
							</ul>
						</div>						
					</li>					
				</ul>
				<ul>
					<li>Ataque</li>
					<li>
						<div id="navcontainer">
							<ul id="navlist">
							<spring:bind path="idPos8">
								<input type="hidden" name="idPos8" id="idPos8"
									value='<c:out value="${nuevoTorneo.idPos8}" />'>
							</spring:bind>							
								<li id="nomPos8"></li>
								<li id="apePos8"></li>
								<li id="velPos8"></li>
								<li id="remPos8"></li>
								<li id="habPos8"></li>
								<li id="fisPos8"></li>
								<li id="valPos8"></li>
								<li>
									<a onclick="Dashboard.comprarJugadorPorPosicion(3,8);"><img alt="" src="/balonpie/static/images/plus.jpg"></a>
									<a href=""><img alt="" src="/balonpie/static/images/less.png"></a>
								</li>
								<li>
									<font color="red">
										<form:errors path="idPos8" />
									</font>
								</li>								
							</ul>
						</div>						
					</li>
					<li>
						<div id="navcontainer">
							<ul id="navlist">
							<spring:bind path="idPos0">
								<input type="hidden" name="idPos9" id="idPos9"
									value='<c:out value="${nuevoTorneo.idPos9}" />'>
							</spring:bind>							
								<li id="nomPos9"></li>
								<li id="apePos9"></li>
								<li id="velPos9"></li>
								<li id="remPos9"></li>
								<li id="habPos9"></li>
								<li id="fisPos9"></li>
								<li id="valPos9"></li>
								<li>
									<a onclick="Dashboard.comprarJugadorPorPosicion(3,9);"><img alt="" src="/balonpie/static/images/plus.jpg"></a>
									<a href=""><img alt="" src="/balonpie/static/images/less.png"></a>
								</li>
								<li>
									<font color="red">
										<form:errors path="idPos9" />
									</font>
								</li>								
							</ul>
						</div>						
					</li>
					<li>
						<div id="navcontainer">
							<ul id="navlist">
							<spring:bind path="idPos10">
								<input type="hidden" name="idPos10" id="idPos10"
									value='<c:out value="${nuevoTorneo.idPos10}" />'>
							</spring:bind>							
								<li id="nomPos10"></li>
								<li id="apePos10"></li>
								<li id="velPos10"></li>
								<li id="remPos10"></li>
								<li id="habPos10"></li>
								<li id="fisPos10"></li>
								<li id="valPos10"></li>
								<li>
									<a onclick="Dashboard.comprarJugadorPorPosicion(3,10);"><img alt="" src="/balonpie/static/images/plus.jpg"></a>
									<a href=""><img alt="" src="/balonpie/static/images/less.png"></a>
								</li>
								<li>
									<font color="red">
										<form:errors path="idPos10" />
									</font>
								</li>								
							</ul>
						</div>						
					</li>
				</ul>
				
				<input type="button" value="Guardar" onclick="Dashboard.crearNuevoTorneo();">		
			</div>
		<div id="comprarJugadoresContainer" title="Comprar Jugadores">
			
		</div>

		<div class="hidden" id="dialog" title="Liga Balonpie"><span id="dialogMessage"></span></div>

	</form:form>
	</div>
<jsp:include page="/jsp/footer.jsp" />	