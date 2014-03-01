<%@ include file="taglibs.jsp"%>
<title>Listado de Usuarios</title>

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
<h3>Listado de Usuarios</h3>
</div>

<div class="center">
<a href="detalleUsuario.do?metodo=agregarUsuario">Agregar Usuario</a>
|
<a href="login.do?metodo=menu">Menu Principal</a>

</div>
<br/>
<table border="1" align="center">
<thead>
<tr>
<th><bean:message key="usuario.idUsuario" /></th>
<th><bean:message key="usuario.username" /></th>
<th><bean:message key="persona.email" /></th>
<th><bean:message key="usuario.persona" /></th>
<th>Acciones</th>
</tr>
</thead>
<tbody>
<c:forEach var="usuario" items="${usuarios}">
<tr>
<td><a
href="detalleUsuario.do?metodo=editarUsuario&idUsuario=${usuario.idUsuario}">${usuario.idUsuario}</a></td>
<td>${usuario.username}</td>
<td>${usuario.persona.email}</td>
<td>${usuario.persona.nombre} ${usuario.persona.apePaterno}</td>
<td><a
href="detalleUsuario.do?metodo=eliminarUsuarioById&idUsuario=${usuario.idUsuario}">Eliminar</a></td>
</tr>
</c:forEach>
</tbody>
</table>