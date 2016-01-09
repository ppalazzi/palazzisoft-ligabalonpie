function executeUrl(url,type,callback) {
	$.ajax({
		type: type,
		url: url,
		success: function(data) {
			$("#homeContainer").html(data);
			
			if (callback != null) {
				callback();
			}
		}
	});
}

function setCalendarProperties() {
	$("#datepicker").datepicker({
		showWeek: true,
		firstDay: 1
	});
}