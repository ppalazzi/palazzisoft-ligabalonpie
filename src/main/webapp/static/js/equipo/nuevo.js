var CompraJugador = {
	abrirVentadaComprarJugadores : function (tipoJugadorId) {
		var data = {equipoId : $("#equipoDivId").text() , tipoJugadorId : tipoJugadorId};
		$.ajax({type : "POST",
				url : "/balonpie/listadoJugadorDisponibles.adm",
				data : data,
				success : function(data) {
					CompraJugador.completarInformacionDelEquipo(data)
				}
		});			
	},
	completarInformacionDelEquipo : function (data) {
		var dialogConfig = {
				modal : true,
				width : 800,
				height : 500,
		        close: function(event, ui) {	
		        	window.location.href = '/balonpie/nuevoEquipo.adm?id=5';
		        	$(this).dialog('close');		      
				}
			};
			
			$("#comprarJugadoresContainer").empty().append(data);
			$("#comprarJugadoresContainer").dialog(dialogConfig);		
	},
	traerPorTipoJugador : function (tipoJugadorID) {
		CompraJugador.abrirVentadaComprarJugadores(tipoJugadorID);
	},
	comprarJugador : function (jugadorId, equipoId) {
		
		var data = {equipoId : equipoId , jugadorId : jugadorId};
		$.ajax({type : "POST",
				url : "/balonpie/comprarJugador.adm",
				data : data,
				success : function(data) {
					CompraJugador.abrirVentadaComprarJugadores(0);
				}
		});	
	}
};

$(document).ready(function () {
	
	$("#comprarJugadoresButtonId").bind("click", eventHandler);
	
	function eventHandler(event){
		if (event.currentTarget.id =='comprarJugadoresButtonId') {
			CompraJugador.abrirVentadaComprarJugadores(0);
		}
	}	
});