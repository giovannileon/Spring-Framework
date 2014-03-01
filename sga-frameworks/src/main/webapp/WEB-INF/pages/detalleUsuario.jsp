<%@ include file="taglibs.jsp"%>
<title>Detalle Usuario</title>

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
<h3>Detalle del Usuario:</h3>
</div>

<html:form action="/guardarUsuario" focus="usuario.username">
<!--  onsubmit="return validateUserForm(this)"> -->
<input type="hidden" name="metodo" value="accionGuardar" />
<html:hidden property="usuario.idUsuario" />
<html:hidden property="persona.idPersona" />
<table align="center">
<tr>
<th><bean:message key="persona.nombre" />:</th>
<td><html:text property="persona.nombre" /></td>
</tr>

<tr>
<th><bean:message key="persona.apePaterno" />:</th>
<td><html:text property="persona.apePaterno" /></td>
</tr>

<tr>
<th><bean:message key="persona.apeMaterno" />:</th>
<td><html:text property="persona.apeMaterno" /></td>
</tr>

<tr>
<th><bean:message key="persona.email" />:</th>
<td><html:text property="persona.email" /></td>
</tr>

<tr>
<th><bean:message key="usuario.username" />:</th>
<td><html:text property="usuario.username" /></td>
</tr>

<tr>
<th><bean:message key="usuario.password" />:</th>
<td><html:text property="usuario.password" /></td>
</tr>

<tr>
<td colspan="2" align="right">
<html:submit styleClass="button">Guardar</html:submit>
<c:if test="${not empty param.idUsuario}">
<html:submit styleClass="button" onclick="this.form.metodo.value='eliminarUsuario'">Eliminar</html:submit>
</c:if>
</td>
</tr>
<tr><td  colspan="2" align="right"><a href="usuarios.do?metodo=listarUsuarios">Volver</a></td></tr>
</table>
</html:form>