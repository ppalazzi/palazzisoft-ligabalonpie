<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="../static/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/cufon-yui.js"></script>
<script type="text/javascript" src="js/arial.js"></script>
<script type="text/javascript" src="js/cuf_run.js"></script>
<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="js/radius.js"></script>
<title>Liga Balonpie - Listado de Jugadores</title>
</head>
<body>
	<jsp:include page="/jsp/header.jsp" />

	<table border="1" width="30%" height="30%">
		<tr>
			<td>
				<label>Id</label>
			</td>
			<td>
				<label>Nombre</label>
			</td>			
			<td>
				<label>Apellido</label>
			</td>
		</tr>
		<c:forEach var="jugador" items="${jugadores}">
			<tr>
				<td><a href="/liga/altaJugador.pal?idJugador=1"><c:out value="${jugador.id}" /></a></td>
				<td><c:out value="${jugador.nombre}" /></td>
				<td><c:out value="${jugador.apellido}" /></td>
			</tr>			
		</c:forEach>
	
	</table>
</body>
</html>