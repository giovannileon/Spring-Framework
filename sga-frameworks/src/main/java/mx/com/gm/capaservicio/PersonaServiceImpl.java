package mx.com.gm.capaservicio;

import java.util.List;
import mx.com.gm.capadatos.PersonaDAO;
import mx.com.gm.capadatos.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("personaService")
@Transactional
public class PersonaServiceImpl implements PersonaService {
	@Autowired
	private PersonaDAO personaDao;

	public List<Persona> listarPersonas() {
		return personaDao.findAllPersonas();
	}

	public Persona recuperarPersona(Persona persona) {
		return personaDao.findPersonaById(persona.getIdPersona());
	}

	public void agregarPersona(Persona persona) {			
		personaDao.insertPersona(persona);
	}

	public void modificarPersona(Persona persona) {
		personaDao.updatePersona(persona);
	}

	public void eliminarPersona(Persona persona) {
		personaDao.deletePersona(persona);
	}
	
	public Persona recuperarPersonaEmail(Persona persona){
		return personaDao.getPersonaByEmail(persona);
	}
}