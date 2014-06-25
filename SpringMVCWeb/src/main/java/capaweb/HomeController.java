package capaweb;

import model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import capaservicio.LoginService;

@Controller
public class HomeController {

	@Autowired
	LoginService loginService;
	
	@RequestMapping(value = "/")
	public String home() {
		System.out.println("HomeController: Passing through...");
		return "home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(){
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody Usuario checkLogin(@ModelAttribute Usuario usuario, Model modelo) {

		System.out.println(usuario);
		
		boolean result = loginService.verificaLogin(usuario.getUsername(), usuario.getPassword());
		String msj = "";
		
		if(result){
			msj  = "El usuario " + usuario.getUsername() + " se ha logueado exitosamente";
		}
		
		modelo.addAttribute("mensaje", msj);
		
		return usuario;
	}
}
