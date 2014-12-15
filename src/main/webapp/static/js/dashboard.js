$(document).ready(function () {

	$("#misTorneos").click(function() {
		$("#listadoTorneoDiv").toggle("fast");
	});
});

function traerEquiposPorTorneo(torneoId, participanteId) {
	var data = {torneoId : torneoId, participanteId : participanteId};
	$.ajax({type : "POST",
			url : "/balonpie/traerEquipoDelTorneo.htm",
			data : data,
			success : completarInformacionDelEquipo});	
}

function completarInformacionDelEquipo(response) {
	$("#equipoResumenDiv").attr("style", "");		
	$("#equipoDataDiv").html(response);	
}
