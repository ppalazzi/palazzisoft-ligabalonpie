var Dashboard = {	
	actualizarPerfil : function() {
		var data = {
			id : $("#id").val(),
			nombre : $("#nombre").val(),
			estado : $("#estado").val(),
			apellido : $("#apellido").val(),
			email : $("#email").val(),
			fechaNacimiento : $('[name="fechaNacimiento"]').val(),
			ciudad : $("#ciudad").val(),
			calle : $("#calle").val(),
			numero : $("#numero").val(),
			pais : $("#pais").val(),
			password : $("#password").val()
		};
		
		$.ajax({
			type : "POST",
			url : "/balonpie/modificarPerfil.htm",
			data : data,
			success : function(data) {
				$("#container").empty().append(data);
			}
		});
	},
	verMiPerfil : function (participanteId) {
		var data = {participanteId : participanteId};
		
		$.ajax({type : "GET",
			url : "/balonpie/participantePorId.htm",
			data : data,
			success : function(data) {
				$("#container").empty().append(data);
			}
		});
	},	
	cargarAnimacion : function (participanteId) {
        $("#misTorneos").click(function() {
            $("#listadoTorneoDiv").toggle("fast");
        });		
        
        $("#miPerfil").click(function() {
        	Dashboard.verMiPerfil(participanteId);
        });      
	},	
	traerTorneosPorParticipante : function (participanteId) {
		var data = {participanteId : participanteId};
		$.ajax({type : "GET",
				url : "/balonpie/torneosDeParticipante.htm",
				data : data,
				success : function(data) {
					$("#listadoTorneoDiv").append(data);
				}
		});			
	},
	completarInformacionDelEquipo : function() {
		$("#equipoResumenDiv").attr("style", "");		
		$("#equipoDataDiv").html(response);			
	},
	comprarJugadorPorPosicion : function(tipoJugador, posicion) {
		$.ajax({
			data : {tipoJugador : tipoJugador, posicion : posicion},
			type : 'GET',
			url : '/balonpie/listadoJugador.htm',
			success : function(data) {
				var dialogConfig = {
						modal : true,
						width : 800,
						height : 500
				};	
				
				$("#comprarJugadoresContainer").empty().append(data);
				$("#comprarJugadoresContainer").dialog(dialogConfig);				
			}
		});
	},
	asignarJugadorAPantalla : function(id, nombre, apellido, posicion, velocidad, remate, habilidad, fisico, valor) {
		var response = Dashboard.validarPosicionExistente(id); 
				
		if (response) {
			$("#idPos" + posicion).val(id);
			$("#nomPos" + posicion).text(nombre);
			$("#apePos" + posicion).text(apellido);
			$("#velPos" + posicion).text(velocidad);
			$("#remPos" + posicion).text(remate);
			$("#habPos" + posicion).text(habilidad);
			$("#fisPos" + posicion).text(fisico);
			$("#valPos" + posicion).text(valor);
			$("#comprarJugadoresContainer").dialog('close');			
		}	
	},
	validarPosicionExistente : function(id) {
		var response = true;
		$("[id*=idPos]").each(function () {			
			if ($(this).val() == id) {
				Dashboard.mostrarMensaje("El jugador ya se encuentra en la Plantilla");
				response = false;
			}
		});		
		
		return response;
	},
	crearNuevoTorneo : function() {
		var nombreTorneo = $("#nombreTorneo").val();
		var nombreEquipo = $("#nombreEquipo").val();
		var descripcionEquipo = $("#descripcionEquipo").val();
		
		if (nombreTorneo == null || nombreTorneo == '') {
			Dashboard.mostrarMensaje("Debe completar el Nombre del Torneo");			
			return;
		}
		if (nombreEquipo == null || nombreEquipo == '') {
			Dashboard.mostrarMensaje("Debe completar el Nombre de Equipo");			
			return;
		}
		if (descripcionEquipo == null || descripcionEquipo == '') {
			Dashboard.mostrarMensaje("Debe completar La Descripci\u00f3n del Equipo");			
			return;
		}

		$("#nuevoTorneoform").submit();
	},
	mostrarMensaje : function(mensaje) {
		$("#dialogMessage").text(mensaje);		
		$("#dialog").dialog();		
	}
}

$(document).ready(function () {	
	var participanteId = $("#participanteId").val();
		
	if (participanteId != null) {
		Dashboard.cargarAnimacion(participanteId);
		Dashboard.traerTorneosPorParticipante(participanteId);		
	}	
});

