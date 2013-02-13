<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head></head>
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
		</tr>
		
		<c:forEach var="torneo" items="${torneos}">
			<tr>
				<td><a href="jugadorListado.htm?jugadorId=<c:out value='${torneo.id}' />"><c:out value="${torneo.id}" /></a></td>
				<td><c:out value="${torneo.descripcion}" /></td>
				<td><input type="text" value="<c:out value='${torneo.descripcion}' />" /></td>
			</tr>			
		</c:forEach>		
	</table>
</body>