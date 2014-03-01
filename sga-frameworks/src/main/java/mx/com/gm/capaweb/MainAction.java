package mx.com.gm.capaweb;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mx.com.gm.capadatos.domain.Usuario;
import mx.com.gm.capaservicio.MainService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.actions.DispatchAction;

public class MainAction extends DispatchAction {
	// Atributo que será inyectado por Spring
	private MainService mainService;

	private static Log logger = LogFactory.getLog("MainAction");

	public void setMainService(MainService mainService) {
		this.mainService = mainService;
	}
	
	public ActionForward accionLogin(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse res) throws Exception {					
		
		logger.info("Ejecutando método login");
		
		DynaActionForm userForm = (DynaActionForm) form;
		Usuario usuario = (Usuario) userForm.get("usuario");
		String user = usuario.getUsername();
		String pass = usuario.getPassword();
		
		logger.info("Datos de Login: " + user + " pass: " + pass);
		usuario = mainService.recuperarUsuario(usuario);
		logger.info("user " + usuario);
		
		HttpSession session = req.getSession();
		
		if( usuario != null){			
			if(usuario.getPassword().equals(pass)){			
				session.setAttribute("user", usuario);
				req.setAttribute("msj", "Usuario Valido");
				logger.info("Usuario Valido");				
			}
			else{
				req.setAttribute("msj", "Usuario no valido, favor de ingresar sus datos correctamente");
				return mapping.findForward("login");
			}
		}
		else{
			req.setAttribute("msj", "Usuario no valido, favor de ingresar sus datos correctamente");
			return mapping.findForward("login");
		}		
		return mapping.findForward("acceso");
	}
	
	public ActionForward entrar(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		HttpSession session = req.getSession();
		logger.info("usuario sesion: " + session.getAttribute("user"));
		if(session.getAttribute("user") != null){
			return mapping.findForward("acceso");
		}		
		return mapping.findForward("login");	
	}	
	
	public ActionForward salir(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		HttpSession session = req.getSession();				
		logger.info("usuario salir: " + session.getAttribute("user"));
		session.removeAttribute("user");
		return mapping.findForward("salir");
	}	
	
	public ActionForward menu(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse res) throws Exception {		
		
		return mapping.findForward("acceso");
	}

}