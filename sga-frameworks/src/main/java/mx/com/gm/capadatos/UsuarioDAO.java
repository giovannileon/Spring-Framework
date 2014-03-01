package mx.com.gm.capadatos;

import java.util.List;
import mx.com.gm.capadatos.domain.Usuario;

public interface UsuarioDAO {
	
	void insertUsuario(Usuario Usuario);

	void updateUsuario(Usuario Usuario);

	void deleteUsuario(Usuario Usuario);

	Usuario findUsuarioById(long idUsuario);

	List<Usuario> findAllUsuarios();

	long contadorUsuarios();

	Usuario getUsuarioByUsername(Usuario Usuario);
}
