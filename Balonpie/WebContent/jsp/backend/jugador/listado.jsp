<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/jsp/backend/header.jsp" />

<script type="text/javascript" src="static/js/jquery.dataTables.js"></script>

<script type="text/javascript">
$(document).ready(function() {
    $('#example').dataTable( {
        "aaSorting": [[ 4, "desc" ]]
    } );
} );
</script>

<style type="text/css" title="currentStyle">
	@import "static/css/demo_page.css";
	@import "static/css/demo_table.css";
</style>

<div width="60%">

<table cellpadding="0" cellspacing="0" border="1" class="display" id="example">
	<thead>
		<tr>
			<th>Nombre</th>
			<th>Apellido</th>
		</tr>
	</thead>
	<tbody>
		<tr class="gradeX">
			<td>Trident</td>
			<td>Internet
				 Explorer 4.0</td>
		</tr>
	</tbody>
</table>

</div>



<div>
	<c:forEach var="jugador" items="${jugadores}">
		<c:out value="${jugador.apellido}" />
	</c:forEach>
</div>


<jsp:include page="/jsp/backend/footer.jsp" />
