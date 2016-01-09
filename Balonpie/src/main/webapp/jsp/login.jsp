<jsp:include page="/jsp/header.jsp" />
	<form action="/balonpie/login.htm" method="post"
		onsubmit="return validarDatos(this);">
		<ol>
			<li><label for="name">Nombre de Usuario</label> <input id="name"
				name="user" /></li>
			<li><label for="email">Contraseña</label> <input id="email"
				name="password" type="password" /></li>
			<li><label>Administrador</label> <input type="checkbox"
				name="esAdmin" value="true" /></li>
			<li><input type="image" name="imageField" id="imageField"
				src="../static/images/submit.gif" class="send" /></li>
			<li><a href="/balonpie/registro.htm">Registrate</a></li>			
		</ol>
	</form>
<jsp:include page="/jsp/footer.jsp" />