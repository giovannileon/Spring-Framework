package mx.com.gm.capadatos;

import java.util.List;
import mx.com.gm.capadatos.domain.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO {
	private SessionFactory sessionFactory;

	@Autowired
	public UsuarioDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * Se necesita de una transaccion activa por ello la prueba unitaria utiliza
	 * 
	 * @Transactional
	 */
	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void insertUsuario(Usuario Usuario) {		
		currentSession().saveOrUpdate(Usuario);
	}

	public void updateUsuario(Usuario Usuario) {
		currentSession().update(Usuario);
	}

	public void deleteUsuario(Usuario Usuario) {
		currentSession().delete(Usuario);
	}

	public Usuario findUsuarioById(long idUsuario) {
		return (Usuario) currentSession().get(Usuario.class, idUsuario);
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> findAllUsuarios() {
		return currentSession().createQuery("from Usuario").list();
	}

	public long contadorUsuarios() {
		Long contador = (Long) currentSession().createCriteria(Usuario.class)
				.setProjection(Projections.rowCount()).uniqueResult();
		return contador.longValue();
	}

	public Usuario getUsuarioByUsername(Usuario Usuario) {
		Example UsuarioEjemplo = Example.create(Usuario);
		return (Usuario) currentSession().createCriteria(Usuario.class)
				.add(UsuarioEjemplo).uniqueResult();
	}
}