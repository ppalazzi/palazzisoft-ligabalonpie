$(document).ready(function () {
	
	$("#comprarJugadoresButtonId").bind("click", eventHandler);
	
	function eventHandler(event){
		if (event.currentTarget.id =='comprarJugadoresButtonId') {
			openDialog();
		}
	}
	
	function openDialog() {
		$("#comprarJugadorDiv").dialog();
	}
});