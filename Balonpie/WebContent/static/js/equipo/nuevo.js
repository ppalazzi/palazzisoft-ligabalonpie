
$(document).ready(function(){
	$("#jugadoresWindow").hide();
	
	$("#jugadoresDialog").click(function() {
	    $("#jugadoresWindow").dialog({
	            width: 590,
	            height: 350,
	            show: "scale",
	            hide: "scale",
	            resizable: "false",
	            position: "center"     
	     });
	 });
	 
	 $("#nuevoJugadorBtn").click(function() {
	 	$("#jugadoresWindow").dialog('close');
	 	
	 	$("#nuevosJugadoresWindows").dialog({
	            width: 590,
	            height: 350,
	            show: "scale",
	            hide: "scale",
	            resizable: "false",
	            position: "center"  	 	
	 	});
	 });

//	$("#nuevoJugadorBtn").click(function() {				
//		traerJugadoresDisponiblesPorEquipos(0);
//	});	 
	
});

function traerJugadoresDisponiblesPorEquipos(tipoJugadorId) {
	var equipoId = $("#equipoDivId").html();
	
	$.ajax({
		url : '/balonpie/listadoJugadorDisponibles.adm',
		type : 'GET',
		data : {
			equipoId : equipoId,
			tipoJugadorId : tipoJugadorId
		},		
		success : function(data) {
			$("#jugadoresWindow").dialog('close');
			
			$("#jugadoresComprablesListDiv").empty().append(data).dialog({
	            width: 890,
	            height: 650,
	            show: "scale",
	            hide: "scale",
	            resizable: "false",
	            position: "center"     
			});
		},
		error : function(data) {
			alert("error" + data);
		}
	});
}