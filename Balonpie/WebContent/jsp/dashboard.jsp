<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
	<jsp:include page="/jsp/header.jsp" />
	
      <div class="menu_nav">
        <ul>
          <li class="active"><a href="/balonpie/">Crear Torneo</a></li>                    
          
          <li class="active"><a href="listadoTorneoView.htm">Listado de Torneos</a></li>
                    
          <c:if test="${tipoLogueo == 'administrador' }">
				<li><a href="jugadorListado.htm">Jugadores</a></li>          
          </c:if>
          <c:if test="${tipoLogueo == 'participante' }">
				<li><a href="equipoListado.htm">Mis Equipos</a></li>          
          </c:if>
                    
          <li><a href="#">Contactenos</a></li>
        </ul>
      </div>
	
</body>
</html>