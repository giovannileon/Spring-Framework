package test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import mx.com.gm.capadatos.PersonaDAO;
import mx.com.gm.capadatos.UsuarioDAO;
import mx.com.gm.capadatos.domain.Persona;
import mx.com.gm.capadatos.domain.Usuario;
import mx.com.gm.capaservicio.UsuarioService;

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
public class TestUsuarioServiceImpl {
	private static Log logger = LogFactory.getLog("TestUsuarioServiceImpl");
	@Autowired
	private UsuarioService UsuarioService;
	@Autowired
	private UsuarioDAO UsuarioDAO;
	@Autowired
	private PersonaDAO personaDAO;
	
	@Test
	@Transactional
	@Ignore
	public void deberiaMostrarUsuarios() {
		try {
			System.out.println();
			logger.info("Inicio del test deberiaMostrarUsuarios");
			int contadorUsuarios = this.desplegarUsuarios();
			// Segun el numero de Usuarios recuperadas,
			// deberia ser el mismo de la tabla
			assertEquals(contadorUsuarios, UsuarioDAO.contadorUsuarios());
			logger.info("Fin del test deberiaMostrarUsuarios");
			System.out.println();
		} catch (Exception e) {
			logger.error("Error Servicio", e);
		}
	}

	private int desplegarUsuarios() {
		List<Usuario> Usuarios = UsuarioService.listarUsuarios();
		int contadorUsuarios = 0;
		for (Usuario Usuario : Usuarios) {
			logger.info("Usuario: " + Usuario);
			contadorUsuarios++;
		}
		return contadorUsuarios;
	}

	@Test
	@Transactional
	@Ignore
	public void testOperaciones() {
		try {
			System.out.println();
			logger.info("Inicio del test testOperaciones");
			Usuario Usuario1 = new Usuario();
			Persona persona = personaDAO.findPersonaById(5);
			
			Usuario1.setUsername("user5");
			Usuario1.setPassword("123");
			Usuario1.setPersona(persona);						

			UsuarioService.agregarUsuario(Usuario1);
			assertEquals(5, UsuarioDAO.contadorUsuarios());
						
			Usuario Usuario2 = UsuarioService.recuperarUsuario(new Usuario(1));
			Usuario2.setUsername("Administrador");
			UsuarioService.modificarUsuario(Usuario2);
			this.desplegarUsuarios();
			logger.info("Fin del test testOperaciones");
			System.out.println();
		} catch (Exception e) {
			logger.error("Error Servicio", e);
		}
	}

	@Test
	@Transactional
	public void testCompruebaOperaciones() {
		try {
			System.out.println();
			logger.info("Fin del test testCompruebaOperaciones");			
			assertEquals(4, UsuarioDAO.contadorUsuarios());
			this.desplegarUsuarios();
			logger.info("Fin del test testCompruebaOperaciones");
			System.out.println();
		} catch (Exception e) {
			logger.error("Error Servicio", e);
		}
	}
	
}