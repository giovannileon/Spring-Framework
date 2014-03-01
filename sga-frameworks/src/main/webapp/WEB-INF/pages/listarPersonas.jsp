<%@ include file="taglibs.jsp"%>
<title>Listado de Personas</title>

<style>
	.msj{
		color: red;
	}
	.center{
		text-align: center;
	}
</style>

<div class="center">
<h2>Sistema de Gestion de Alumnos SGA con Hibernate, Spring y Struts</h2>
<h3>Listado de Personas:</h3>
</div>

<div class="center">
<a href="detallePersona.do?metodo=accionAgregar">Agregar Persona</a>
|
<a href="login.do?metodo=menu">Menu Principal</a>
<br>
<span class="msj">${msj}</span>
</div>
<br/>

<table border="1" align="center">
<thead>
<tr>
<th><bean:message key="persona.idPersona" /></th>
<th><bean:message key="persona.nombre" /></th>
<th><bean:message key="persona.apePaterno" /></th>
<th><bean:message key="persona.apeMaterno" /></th>
<th><bean:message key="persona.email" /></th>
<th>Acciones </th>
</tr>
</thead>
<tbody>
<c:forEach var="persona" items="${personas}">
<tr>
<td><a
href="detallePersona.do?metodo=accionEditar&idPersona=${persona.idPersona}">${persona.idPersona}</a></td>
<td>${persona.nombre}</td>
<td>${persona.apePaterno}</td>
<td>${persona.apeMaterno}</td>
<td>${persona.email}</td>
<td><a
href="detallePersona.do?metodo=eliminarPersona&idPersona=${persona.idPersona}">Eliminar</a></td>
</tr>
</c:forEach>
</tbody>
</table>