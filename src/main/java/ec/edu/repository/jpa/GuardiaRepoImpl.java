package ec.edu.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import aj.org.objectweb.asm.Type;
import ec.edu.modelo.jpa.Guardia;

@Repository
@Transactional
public class GuardiaRepoImpl implements IGuardiaRepo {

	public static final Logger LOG = LoggerFactory.getLogger(GuardiaRepoImpl.class);

	@PersistenceContext // para la inyeccion
	private EntityManager entityManager;

	@Override
	public void insertarGuardia(Guardia guardia) {
		// TODO Auto-generated method stub
		this.entityManager.persist(guardia); // metodo persist recibe una entidad que esta puesto entity en el modelo

	}

	@Override
	public void actualizarGuardia(Guardia guardia) {
		// TODO Auto-generated method stub
		this.entityManager.merge(guardia);
	}

	@Override
	public Guardia buscarguardia(Integer id) {

		return this.entityManager.find(Guardia.class, id);

	}

	@Override
	public void borrarGuardia(Integer id) {
		// Creamos la entity
		Guardia guardiaABorrar = this.buscarguardia(id);
		// enviamos la Entity
		this.entityManager.remove(guardiaABorrar);

	}

	@Override
	public Guardia buscarGuardiaPorApellido(String apellido) {
		// TODO Auto-generated method stub

		// con lenguaje JPQL
		// traabaja con objetos no con la tabla
		Guardia g = null;

		try {
			Query miQuery = this.entityManager.createQuery("select g from Guardia g where g.apellido = :valor");
			miQuery.setParameter("valor", apellido);
			g = (Guardia) miQuery.getSingleResult();
		} catch (NoResultException e) {
			LOG.error("No existe el registro: " + apellido, e);
		}
		return g;
	}

	@Override
	public Guardia buscarGuardiaPorApellidoLista(String apellido) {
		// Guardia g = null;

		Query miQuery = this.entityManager.createQuery("select g from Guardia g where g.apellido = :valor");
		miQuery.setParameter("valor", apellido);
		// g = (Guardia) miQuery.getResultList();
		List<Guardia> listaDeGuardias = miQuery.getResultList();
		if (!listaDeGuardias.isEmpty()) {
			LOG.info("Tiene mas de un registro " + listaDeGuardias.size());
			return listaDeGuardias.get(0);
		} else {
			return null;
		}

	}

//METODOS SUB DE JPQL

	/**
	 * Este metodo es igual que el buscarGuardiaPorApellido nada mas que con typed
	 * query
	 */
	public Guardia buscarGuardiaPorApellidoType(String apellido) {

		TypedQuery<Guardia> miTypedQuery = (TypedQuery<Guardia>) this.entityManager
				.createQuery("select g from Guardia g where g.apellido = :valor");
		miTypedQuery.setParameter("valor", apellido);

		return miTypedQuery.getSingleResult();
	}

	@Override
	public Guardia buscarGuardiaPorApellidoNamed(String apellido) {

		Query miQuery = this.entityManager.createNamedQuery("Guardia.buscarPorApellido");
		miQuery.setParameter("valor", apellido);
		return (Guardia) miQuery.getSingleResult();
	}

	@Override
	public Guardia buscarGuardiaPorApellidoNativeQuery(String apellido) {
		// TODO Auto-generated method stub
		Query miQuery = this.entityManager.createNativeQuery("select * from guardia g where g.apellido = :valor",
				Guardia.class);
		miQuery.setParameter("valor", apellido);

		return (Guardia) miQuery.getSingleResult();
	}

}
