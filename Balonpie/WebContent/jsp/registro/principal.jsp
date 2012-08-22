<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/balonpie/static/balonpie-style.css" rel="stylesheet" type="text/css" />
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

	$(function() {
		$( "#datepicker" ).datepicker($.datepicker.regional["es"]);
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
	<jsp:include page="/jsp/header.jsp" />

	<form:form method="post" action="/balonpie/registro.htm" id="tableId" commandName="participanteCommand" >
		<table border="1">
			<tr>
				<td><label>* Nombre : </label></td>
				<td><input type="text" name="nombre" value="nombre"></td>				
				<td><form:errors path="nombre"></form:errors></td>
			</tr>
			<tr>
				<td><label>* Apellido : </label></td>
				<td><input type="text" name="apellido" value="apellido"></td>
				<td><form:errors path="apellido"></form:errors></td>				
			</tr>
			<tr>
				<td><label>* Email : </label></td>
				<td><input type="text" name="email" value="email"></td>
				<td><form:errors path="email"></form:errors></td>				
			</tr>
			<tr>
				<td><label>* fechaNacimiento : </label></td>
				<td>
						<div id="datepicker"></div>	
				</td>
				<td><form:errors path="fechaNacimiento"></form:errors></td>								
			</tr>
			<tr>
				<td><label>calle : </label></td>
				<td><input type="text" name="calle" value="calle"></td>
				<td><form:errors path="calle"></form:errors></td>				
			</tr>
			<tr>
				<td><label>ciudad : </label></td>
				<td><input type="text" name="ciudad" value="ciudad"></td>
				<td><form:errors path="ciudad"></form:errors></td>				
			</tr>
			<tr>
				<td><label>pais : </label></td>
				<td>
					 <select id="pais" name="pais">
							 <c:forEach items="${paises}" var="pais">
							 	  <option value="<c:out value="${pais.key}" />"><c:out value="${pais.value}" /></option>
							 </c:forEach>
					 </select>
				</td>
			</tr>
			<tr>
				<td><label>password : </label></td>
				<td><input type="password" name="password" value="password"></td>
				<td><form:errors path="password"></form:errors></td>
			</tr>

		</table>
		</br><label style="color ; ##FF0000;"><c:out value="${mensajeError }" /></label>
		<input type="submit" src="Guardar">
	</form:form>

</body>
</html>