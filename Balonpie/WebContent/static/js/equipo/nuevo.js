
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

	$("#nuevoJugadorBtn").click(function() {
		var equipoId = $("#equipoDivId").html();
				
		$.ajax({
			url : '/balonpie/listadoJugadorDisponibles.adm',
			type : 'GET',
			data : {
				equipoId : equipoId
			},		
			success : function(data) {
				$("#jugadoresWindow").dialog('close');
				
				$("#jugadoresComprablesListDiv").empty().append(data).dialog({
		            width: 590,
		            height: 350,
		            show: "scale",
		            hide: "scale",
		            resizable: "false",
		            position: "center"     
				});;
			},
			error : function(data) {
				alert("error" + data);
			}
		});
	});	 
	
});