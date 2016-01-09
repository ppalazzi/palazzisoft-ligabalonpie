var Torneos = {
	mostrarDetalles : function(torneoId) {
		var data = {torneoId : torneoId};
		$.ajax({type : "GET",
			url : "/balonpie/torneosDetalles.htm",
			data : data,
			success : function(data) {
				$("#misEquiposDiv").empty().append(data);
			}
	});			
	}	
}