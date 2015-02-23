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
	}
}

$(document).ready(function () {	
	var participanteId = $("#participanteId").val();
	
	Dashboard.cargarAnimacion(participanteId);
	Dashboard.traerTorneosPorParticipante(participanteId);
});

