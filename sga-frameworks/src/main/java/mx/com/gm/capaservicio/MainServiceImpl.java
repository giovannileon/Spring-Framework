package mx.com.gm.capaservicio;

import mx.com.gm.capadatos.UsuarioDAO;
import mx.com.gm.capadatos.domain.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("mainService")
@Transactional
public class MainServiceImpl implements MainService {
	
	@Autowired
	private UsuarioDAO usuarioDAO;

	public Usuario recuperarUsuario(Usuario usuario){
		
		return usuarioDAO.getUsuarioByUsername(usuario);
	}
}