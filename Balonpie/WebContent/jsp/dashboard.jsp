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
</head>
<body>
	<jsp:include page="/jsp/header.jsp" />
	
      <div class="menu_nav">
        <ul>
          <li class="active"><a href="/balonpie/">Crear Torneo</a></li>
          
          <c:if test="${session.tipoLogueo == 'administrador'}">
          		ES LOGUEO
          </c:if>
          
          <li><a href="jugadorListado.htm">Jugadores</a></li>
          <li><a href="#">Contactenos</a></li>
        </ul>
      </div>
	
</body>
</html>