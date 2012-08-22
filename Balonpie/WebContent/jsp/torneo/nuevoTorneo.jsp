<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liga Balonpie</title>
</head>
<body>

	<jsp:include page="/jsp/header.jsp" />

	<form method="post" action="/balonpie/registro.htm">
		<table border="1">
			<tr>
				<td><label>* <spring:message code="label.nombre.torneo" />  :  </label></td>
				<td><input type="text" name="nombre"></td>
			</tr>
		</table>
	</form>	

</body>
</html>