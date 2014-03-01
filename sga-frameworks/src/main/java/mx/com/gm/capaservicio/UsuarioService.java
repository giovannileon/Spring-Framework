package mx.com.gm.capaservicio;

import java.util.List;
import mx.com.gm.capadatos.domain.Usuario;

public interface UsuarioService {
	
	public List<Usuario> listarUsuarios();

	public Usuario recuperarUsuario(Usuario Usuario);

	public void agregarUsuario(Usuario Usuario);

	public void modificarUsuario(Usuario Usuario);

	public void eliminarUsuario(Usuario Usuario);
}
