package mx.com.gm.capaweb;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.com.gm.capadatos.domain.Persona;
import mx.com.gm.capadatos.domain.Usuario;
import mx.com.gm.capaservicio.PersonaService;
import mx.com.gm.capaservicio.UsuarioService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.actions.DispatchAction;

public class UsuarioAction extends DispatchAction {
	
	private UsuarioService usuarioService;	

	private static Log logger = LogFactory.getLog("UsuarioAction");

	public void setUsuarioService(UsuarioService usuarioService) 
	{
		this.usuarioService = usuarioService;		
	}		
	
	public ActionForward listarUsuarios(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse res) throws Exception 
	{
		logger.info("Ejecutando método listar");
		this.setListaUsuarios(req);
		return mapping.findForward("listarUsuarios");
	}

	private void setListaUsuarios(HttpServletRequest req) 
	{
		List<Usuario> usuarios = this.usuarioService.listarUsuarios();		 
		req.setAttribute("usuarios", usuarios);		
		for (Usuario usuario : usuarios) 
		{
			logger.info("Usuario:" + usuario);
		}
	}
	
	public ActionForward agregarUsuario(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse res) throws Exception 
	{
		logger.info("Ejecutando método Agregar");	
		return mapping.findForward("editarUsuario");
	}
	
	public ActionForward editarUsuario(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse res) throws Exception 
	{
		logger.info("Ejecutando método Editar");	
		String idUsuarioS = req.getParameter("idUsuario");
		if (idUsuarioS != null) 
		{
			int idUsuario = Integer.parseInt(idUsuarioS);		
			Usuario usuario = this.usuarioService.recuperarUsuario(new Usuario(
					idUsuario));						
			
			DynaActionForm usuarioForm = (DynaActionForm) form;					
			usuarioForm.set("usuario", usuario);		
			usuarioForm.set("persona", usuario.getPersona());			
			
			return mapping.findForward("editarUsuario");
		} 
		else 
		{
			return mapping.findForward("listarUsuarios");
		}
	}	

	public ActionForward accionGuardar(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse res) throws Exception 
	{
		logger.info("Ejecutando método Guardar");
		
		DynaActionForm userForm = (DynaActionForm) form;
		if (userForm != null) 
		{
			Usuario user = (Usuario) userForm.get("usuario");			
			Persona pers = (Persona) userForm.get("persona");
			user.setPersona(pers);
			
			logger.info("persona_ " + pers);											
			logger.info("usuario: " + user);
			
			if (user != null && "" != user.getUsername() && "" != user.getPassword())
			{			
				this.usuarioService.agregarUsuario(user);
			}
		}		
		this.setListaUsuarios(req);
		return mapping.findForward("listarUsuarios");
	}

	public ActionForward eliminarUsuario(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse res) throws Exception 
	{
		logger.info("Ejecutando método Eliminar");
	
		DynaActionForm userForm = (DynaActionForm) form;
		if (userForm != null) 
		{
			Usuario user = (Usuario) userForm.get("usuario");
			if (user != null && 0 != user.getIdUsuario()) 
			{
				try {
					this.usuarioService.eliminarUsuario(user);
				} 
				catch (Exception e) 
				{					
					System.out.println("Excepción al elmininar, continua el flujo...");
					System.out.println(e);
				}
			}
		}		
		this.setListaUsuarios(req);
		return mapping.findForward("listarUsuarios");
	}
	
	public ActionForward eliminarUsuarioById(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse res) throws Exception 
	{
		
		logger.info(req.getParameter("idUsuario"));
		
		Usuario user = new Usuario();
		user.setIdUsuario(Long.parseLong(req.getParameter("idUsuario")));		
		this.usuarioService.eliminarUsuario(user);
		
		this.setListaUsuarios(req);
		return mapping.findForward("listarUsuarios");		
	}
}