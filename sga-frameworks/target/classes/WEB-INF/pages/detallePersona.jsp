<%@ include file="taglibs.jsp"%>
<title>Detalle Persona</title>

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
<h3>Detalle de la Persona:</h3>
</div>

<html:form action="/guardarPersona" focus="persona.nombre">
<!--  onsubmit="return validateUserForm(this)"> -->
<input type="hidden" name="metodo" value="accionGuardar" />
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
<td colspan="2" align="right">
<html:submit styleClass="button">Guardar</html:submit>
<c:if test="${not empty param.idPersona}">
<html:submit styleClass="button" onclick="this.form.metodo.value='accionEliminar'">Eliminar</html:submit>
</c:if>
</td>
</tr>
<tr><td  colspan="2" align="right"><a href="personas.do?metodo=accionListar">Volver</a></td></tr>
</table>
</html:form>