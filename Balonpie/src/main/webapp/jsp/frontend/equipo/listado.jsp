<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<link href="../static/style.css" rel="stylesheet" type="text/css" />
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
				<label>Descripción</label>
			</td>
		</tr>
		
		<c:forEach var="equipo" items="${equipos}">
			<tr>
				<td><a href="listadoEquipo.htm?equipoId=<c:out value='${equipo.id}' />"><c:out value="${equipo.id}" /></a></td>
				<td><c:out value="${equipo.nombre}" /></td>
				<td><c:out value="${equipo.descripcion}" /></td>
			</tr>			
		</c:forEach>		
		
	</table>				
</body>