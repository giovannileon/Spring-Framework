<%@ include file="taglibs.jsp"%>
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
<p>Inicio de Sesion, Favor de introducir sus datos para entrar.</p>
</div>


<html:form action="/login" focus="usuario.username">

<input type="hidden" name="metodo" value="accionLogin" />
<div class="center">
<table align="center">
<tr>
<th><bean:message key="usuario.username" />:</th>
<td><html:text property="usuario.username" /></td>
</tr>

<tr>
<th><bean:message key="usuario.password" />:</th>
<td><html:text property="usuario.password" /></td>
</tr>

<tr>
<td>&nbsp;</td>
<td>
<html:submit styleClass="button">Entrar</html:submit>
</td>
</tr>
<tr>
<td class="msj" colspan="2">${msj}</td>
</tr>
</table></div>
</html:form>
