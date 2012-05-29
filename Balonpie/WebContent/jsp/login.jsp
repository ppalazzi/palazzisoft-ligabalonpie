<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="../static/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<jsp:include page="/jsp/header.jsp" />
	<form action="/balonpie/login.htm" method="post"
		onsubmit="return validarDatos(this);">
		<ol>
			<li><label for="name">Nombre de Usuario</label> <input id="name"
				name="user" /></li>
			<li><label for="email">Contraseņa</label> <input id="email"
				name="password" type="password" /></li>
			<li><label>Administrador</label> <input type="checkbox"
				name="esAdmin" value="true" /></li>
			<li><input type="image" name="imageField" id="imageField"
				src="../static/images/submit.gif" class="send" /></li>
			<li><a href="/balonpie/registro.htm">Registrate</a></li>
		</ol>
	</form>
</body>
</html>