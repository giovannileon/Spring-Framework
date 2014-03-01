package mx.com.gm.capaweb;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mx.com.gm.capadatos.domain.Persona;
import mx.com.gm.capadatos.domain.Usuario;
import mx.com.gm.capaservicio.PersonaService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.actions.DispatchAction;

public class PersonaAction extends DispatchAction {
	// Atributo que será inyectado por Spring
	private PersonaService personaService;
	//private HttpSession session;

	public void setPersonaService(PersonaService personaService) {
		this.personaService = personaService;
	}

	private static Log logger = LogFactory.getLog("PersonaAction");

	private boolean checkLogin(HttpServletRequest req){
		
		HttpSession session = req.getSession();
		if(session.getAttribute("user") != null){
			return true;
		}		
		return false;
	}
	
	public ActionForward accionListar(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		if(!this.checkLogin(req)){
			logger.info("Usuario no logueado");
			return mapping.findForward("loginUsuario");
		}
		
		logger.info("Ejecutando método listar");
		this.setListaPersonas(req);
		return mapping.findForward("listarPersonas");
	}

	private void setListaPersonas(HttpServletRequest req) {		
		
		List<Persona> personas = this.personaService.listarPersonas();
		// Compartimos la lista de objetos persona con el JSP
		req.setAttribute("personas", personas);
		// Desplegamos solo para validar
		for (Persona persona : personas) {
			logger.info("Persona:" + persona);
		}
	}

	public ActionForward accionAgregar(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.info("Ejecutando método Agregar");
		// No hay parametro enviado, por que es una nueva persona
		return mapping.findForward("editarPersona");
	}

	public ActionForward accionEditar(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.info("Ejecutando método Editar");
		// Buscamos el parametro enviado
		String idPersonaS = req.getParameter("idPersona");
		if (idPersonaS != null) {
			int idPersona = Integer.parseInt(idPersonaS);
			Persona persona = this.personaService.recuperarPersona(new Persona(
					idPersona));
			// Compartimos el objeto encontrado
			DynaActionForm personaForm = (DynaActionForm) form;
			personaForm.set("persona", persona);
			logger.info(mapping);
			return mapping.findForward("editarPersona");
		} else {
			return mapping.findForward("listarPersonas");
		}
	}

	public ActionForward accionGuardar(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.info("Ejecutando método Guardar");
		// Recuperamos la persona editada
		DynaActionForm userForm = (DynaActionForm) form;
		if (userForm != null) {
			Persona persona = (Persona) userForm.get("persona");
			if (persona != null && "" != persona.getNombre()
					&& "" != persona.getApePaterno()
					&& "" != persona.getEmail()) {
				// hace insert y/o update
				this.personaService.agregarPersona(persona);
			}
		}
		// Volvemos a consultar la lista de personas
		this.setListaPersonas(req);
		return mapping.findForward("listarPersonas");
	}

	public ActionForward accionEliminar(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.info("Ejecutando método Eliminar");
		// Buscamos el parametro enviado
		DynaActionForm userForm = (DynaActionForm) form;
		if (userForm != null) {
			Persona persona = (Persona) userForm.get("persona");
			if (persona != null && 0 != persona.getIdPersona()) {
				try {
					this.personaService.eliminarPersona(persona);
				} catch (Exception e) {
					System.out.println("Excepción al elmininar, continua el flujo...");
					System.out.println(e);
				}
			}
		}
		// Volvemos a consultar la lista de personas
		this.setListaPersonas(req);
		return mapping.findForward("listarPersonas");
	}
	
	public ActionForward eliminarPersona(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse res) throws Exception 
	{
		
		logger.info(req.getParameter("idPersona"));
		
		Persona pers = new Persona();
		pers.setIdPersona(Long.parseLong(req.getParameter("idPersona")));		
		try{
			this.personaService.eliminarPersona(pers);
		}
		catch(Exception e){
			System.out.println("Excepción al elmininar, continua el flujo...");
			System.out.println(e);
			req.setAttribute("msj", "No se pudo elmininar, continua el flujo...");
		}
		
		this.setListaPersonas(req);
		return mapping.findForward("listarPersonas");		
	}

}