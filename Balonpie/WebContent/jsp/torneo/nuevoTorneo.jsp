<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liga Balonpie</title>
</head>
<body>

	<jsp:include page="/jsp/header.jsp" />

	<form:form method="post" action="/balonpie/nuevoTorneo.htm" commandName="torneoCommand">
		<input type="hidden" name="participanteId" value="<c:out value='${participanteId}' />" />
		<table border="1">
			<tr>
				<td><label>* Descripción  :  </label></td>
				<td><input type="text" name="descripcion" value="<c:out value="${torneo.descripcion}" />"></td>
			</tr>
		</table>
		</br><label style="color ; ##FF0000;"><c:out value="${mensajeError}" /></label>
		<input type="submit" src="Guardar">		
	</form:form>	

</body>
</html>