<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="/balonpie/static/js/jquery-1.3.2.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liga Balonpie</title>

<script>
	$(document).ready(function() {
		
		$('p:first').toggle(function() {
			$(this).animate({'height' : '+=150px'},2000,'linear');}, function() {
				$(this).animate({'height' : '-=150px'},2000,'swing');	
		});		
		
		$('#bio > div').hide();
		$('#bio > div:first').show();
		
		$('#bio h3').click(function() {
			$(this).next().animate({'height':'toggle'}, 'fast', 'swing' );	
		});
	});

	function getCurrentCalendarText() {
		return $("#datepicker").datepicker("option", "currentText");
	};
	
	function toggleFade() {
		$('#tableId').fadeOut();;
	}
			
</script>
</head>

<body>
	<section id="bio">
		<h2>Quién te la chupó mejor?</h2>
		
		<h3>Sol</h3>
		<div>
			<p>Alto pete en el inodoro del tío Hector</p>
		</div>
		
		<h3>Adriana</h3>
		<div>
			<p>Se re copó en la casa del Conde</p>
		</div>

		<h3>Ce</h3>
		<div>
			<p>Inolvidables petes</p>
		</div>
		
	</section>
</body>