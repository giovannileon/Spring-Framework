package mx.com.gm.capaservicio;

import java.util.List;

import mx.com.gm.capadatos.PersonaDAO;
import mx.com.gm.capadatos.UsuarioDAO;
import mx.com.gm.capadatos.domain.Persona;
import mx.com.gm.capadatos.domain.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("usuarioService")
@Transactional
public class UsuarioServiceImpl implements UsuarioService {
	@Autowired
	private UsuarioDAO usuarioDAO;	
	
	@Autowired
	private PersonaDAO personaDAO;

	public List<Usuario> listarUsuarios() {
		return usuarioDAO.findAllUsuarios();
	}

	public Usuario recuperarUsuario(Usuario usuario) {
		return usuarioDAO.findUsuarioById(usuario.getIdUsuario());
	}

	public void agregarUsuario(Usuario usuario) {
		
		Persona pers = usuario.getPersona();
		System.out.println("dao: " + pers);
		
		personaDAO.insertPersona(pers);
		pers = personaDAO.getPersonaByEmail(pers);
		System.out.println("dao2: " + pers);
		
		usuario.setPersona(pers);
		System.out.println(usuario);
		usuarioDAO.insertUsuario(usuario);
	}

	public void modificarUsuario(Usuario usuario) {
		usuarioDAO.updateUsuario(usuario);
	}

	public void eliminarUsuario(Usuario usuario) {
		usuarioDAO.deleteUsuario(usuario);
	}
}