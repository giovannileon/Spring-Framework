package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import mx.com.gm.capadatos.PersonaDAO;
import mx.com.gm.capadatos.UsuarioDAO;
import mx.com.gm.capadatos.domain.Persona;
import mx.com.gm.capadatos.domain.Usuario;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:datasource-test.xml",
		"classpath:applicationContext.xml" })
public class TestUsuarioDAOImpl {
	private static Log logger = LogFactory.getLog("TestUsuarioDAOImpl");
	@Autowired
	private UsuarioDAO usuarioDAO;
	@Autowired
	private PersonaDAO personaDAO;

	@Test
	@Transactional
	@Ignore
	public void deberiaMostrarUsuarios() {
		try {
			System.out.println();
			logger.info("Inicio del test deberiaMostrarUsuarios");
			List<Usuario> Usuarios = usuarioDAO.findAllUsuarios();
			int contadorUsuarios = 0;
			for (Usuario Usuario : Usuarios) {
				logger.info("Usuario: " + Usuario);
				contadorUsuarios++;
			}
			// Segun el numero de Usuarios recuperadas, deberia ser el mismo de
			// la tabla
			assertEquals(contadorUsuarios, usuarioDAO.contadorUsuarios());
			logger.info("Fin del test deberiaMostrarUsuarios");
		} catch (Exception e) {
			logger.error("Error JBDC", e);
		}
	}

	@Test
	@Transactional
	@Ignore
	public void deberiaEncontrarUsuarioPorId() {
		try {
			System.out.println();
			logger.info("Inicio  del  test deberiaEncontrarUsuarioPorId");
			int idUsuario = 1;
			Usuario usuario = usuarioDAO.findUsuarioById(idUsuario);
			// Segun la Usuario recuperada, deberia ser la misma que el registro
			// 1
			assertEquals("user1", usuario.getUsername());
			// Imprimimos todo el objeto
			logger.info("Usuario recuperada (id=" + idUsuario + "): " + usuario);
			logger.info("Fin  del  test deberiaEncontrarUsuarioPorId");
		} catch (Exception e) {
			logger.error("Error JBDC", e);
		}
	}

	@Test
	@Transactional
	@Ignore
	public void deberiaInsertarUsuario() {
		try {
			System.out.println();
			logger.info("Inicio del test deberiaInsertarUsuario");
			// El script de datos tiene 3 registros
			assertEquals(4, usuarioDAO.contadorUsuarios());
			Persona persona = personaDAO.findPersonaById(5);

			Usuario usuario = new Usuario();
			usuario.setUsername("user5");
			usuario.setPassword("123");
			usuario.setPersona(persona);
			usuarioDAO.insertUsuario(usuario);
			// Recuperamos a la Usuario recien insertada por su email
			usuario = usuarioDAO.getUsuarioByUsername(usuario);

			logger.info("Usuario insertada: " + usuario);
			// Deberia haber ya cuatro Usuarios
			assertEquals(5, usuarioDAO.contadorUsuarios());
			logger.info("Fin del test deberiaInsertarUsuario");
		} catch (Exception e) {
			logger.error("Error JBDC", e);
		}
	}

	@Test
	@Transactional
	@Ignore
	public void deberiaActualizarPersona() {
		try {
			System.out.println();
			logger.info("Inicio del test deberiaActualizarUsuario");
			int idUsuario = 1;
			Usuario usuario = usuarioDAO.findUsuarioById(idUsuario);
			logger.info("Persona a modificar (id=" + idUsuario + "): "
					+ usuario);
			usuario.setUsername("user10");
			usuarioDAO.updateUsuario(usuario);
			// Volvemos a leer el usuario
			usuario = usuarioDAO.findUsuarioById(idUsuario);
			// Segun la persona recuperada, deberia ser la misma que el registro
			// 1
			assertEquals("user10", usuario.getUsername());
			// Imprimimos todo el objeto
			logger.info("Usuario  modificada  (id=" + idUsuario + "):  "
					+ usuario);
			logger.info("Fin del test deberiaActualizarUsuario");
		} catch (Exception e) {
			logger.error("Error JBDC", e);
		}
	}

	@Test
	@Transactional
	//@Ignore
	public void deberiaEliminarPersona() {
		try {
			System.out.println();
			logger.info("Inicio del test deberiaEliminarUsuario");
			// Buscamos eliminar la persona con id = 2
			int idUsuario = 2;
			Usuario usuario = usuarioDAO.findUsuarioById(idUsuario);
			logger.info("Persona a eliminar (id=" + idUsuario + "): " + usuario);
			// Eliminamos la persona recuperada
			usuarioDAO.deleteUsuario(usuario);
			usuario = usuarioDAO.findUsuarioById(idUsuario);
			// Deberia de regresar nulo al buscar la persona 2
			assertNull(usuario);
			// Imprimimos todo el objeto
			logger.info("Nuevo listado de personas:");
			List<Usuario> usuarios = usuarioDAO.findAllUsuarios();
			int contadorUsuarios = 0;
			for (Usuario usuario2 : usuarios) {
				logger.info("Usuario: " + usuario2);
				contadorUsuarios++;
			}
			// Segun el numero de personas recuperadas, deberia ser el mismo de
			// la tabla
			assertEquals(contadorUsuarios, usuarioDAO.contadorUsuarios());
			logger.info("Fin del test deberiaEliminarUsuario");
			System.out.println();
		} catch (Exception e) {
			logger.error("Error JBDC", e);
		}
	}
}