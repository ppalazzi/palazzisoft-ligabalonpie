$(document).ready(function () {
	
	$("#comprarJugadoresButtonId").bind("click", eventHandler);
	
	function eventHandler(event){
		if (event.currentTarget.id =='comprarJugadoresButtonId') {
			openDialog();
		}
	}
	
	function openDialog() {
		var modalConfig = {
			modal : true,
			width : 800,
			height : 600
		};
		$("#comprarJugadorDiv").dialog(modalConfig);
	}
});