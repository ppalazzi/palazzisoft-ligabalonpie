	<div id="message">
		<c:if test="${not empty mensaje}">
			<font color="green"> <c:out value="${mensaje}" />
			</font>
		</c:if>
	</div>
	
	<div id="error">
		<font color="red"> <form:errors path="*" /> <c:if
				test="${not empty error}">
				<c:out value="${error}"></c:out>
			</c:if>
		</font>
	</div>