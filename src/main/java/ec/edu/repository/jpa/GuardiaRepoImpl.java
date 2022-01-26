package ec.edu.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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

//METODOS PARA NATIVE 
	@Override
	public Guardia buscarGuardiaPorApellidoNamed(String apellido) {

		Query miQuery = this.entityManager.createNamedQuery("Guardia.buscarPorApellido");
		miQuery.setParameter("valor", apellido);
		return (Guardia) miQuery.getSingleResult();
	}

	// el llamado para el native named es exactamente igual al llamado de un named
	// query
	@Override
	public Guardia buscarGuardiaPorApellidoNamedNative(String apellido) {
		// TODO Auto-generated method stub
		Query miQuery = this.entityManager.createNamedQuery("Guardia.buscarPorApellidoNative", Guardia.class);
		miQuery.setParameter("valor", apellido);
		return (Guardia) miQuery.getSingleResult();
	}

//PARA CITRERIA API
	// versatibilidad
	// es mas pesado
	//
	@Override
	public Guardia buscarGuardiaPorApellidoCriteriaAPI(String apellido) {

		CriteriaBuilder myCriteria = this.entityManager.getCriteriaBuilder(); // retorna un criteria builder
		// Creo el query que retorna un guardia
		CriteriaQuery<Guardia> myQuery = myCriteria.createQuery(Guardia.class);
		// Aqui se empieza a construir el sql
		// le especifico de entidad que representa la tabla, el from de guardia clas
		Root<Guardia> myTabla = myQuery.from(Guardia.class);
		// Los where en criteria API se los conoce como PREDICADO
		// select g from Guardia g where g.apellido = :valor
		// el where nos pide sentencia que comparan dos valores (equal)
		Predicate p1 = myCriteria.equal(myTabla.get("apellido"), apellido);
		// para hacer dos predicados pero se necesita mas dinamica
		// Predicate p2 = myCriteria.equal(myTabla.get("apellido"),apellido);
		// Empezamos a conformar el select
		myQuery.select(myTabla).where(p1);

		TypedQuery<Guardia> typedQuery = this.entityManager.createQuery(myQuery);

		return typedQuery.getSingleResult();
	}

	@Override
	public Guardia buscarGuardiaPorApellidoCriteriaAPIAND(String apellido, String edificio) {
		
		//select * from guardia where nombre = 'mvn' and edificio = 'Amazonas';
		//select * from guardia where nombre = 'mvn' or edificio = 'Amazonas';
		
		CriteriaBuilder myCriteria = this.entityManager.getCriteriaBuilder(); // retorna un criteria builder
		CriteriaQuery<Guardia> myQuery = myCriteria.createQuery(Guardia.class);
		Root<Guardia> myTabla = myQuery.from(Guardia.class);
	
		//CREAMOS LOS PREDICADOS
		Predicate p1 = myCriteria.equal(myTabla.get("apellido"), apellido);
		Predicate p2 = myCriteria.equal(myTabla.get("edificio"), edificio);
		//UNION DE LOS DOS PREDICADOS
		Predicate predicadofinal = myCriteria.and(p1,p2);
		//EMPEZAMOS A FORMAR EL SELECT
		//Cuando mandamos la  , por defecto es and
		//se recomienda crear un predicado espedicifo para and y or
		myQuery.select(myTabla).where(predicadofinal);

		TypedQuery<Guardia> typedQuery = this.entityManager.createQuery(myQuery);

		return typedQuery.getSingleResult();
	
	}

	@Override
	public List <Guardia> buscarGuardiaPorApellidoCriteriaAPIOR(String apellido, String edificio) {
		//select * from guardia where nombre = 'mvn' and edificio = 'Amazonas';
		//select * from guardia where nombre = 'mvn' or edificio = 'Amazonas';
		
		CriteriaBuilder myCriteria = this.entityManager.getCriteriaBuilder(); // retorna un criteria builder
		CriteriaQuery<Guardia> myQuery = myCriteria.createQuery(Guardia.class);
		Root<Guardia> myTabla = myQuery.from(Guardia.class);
	
		//CREAMOS LOS PREDICADOS
		Predicate p1 = myCriteria.equal(myTabla.get("apellido"), apellido);
		Predicate p2 = myCriteria.equal(myTabla.get("edificio"), edificio);
		//UNION DE LOS DOS PREDICADOS
		Predicate predicadofinal = myCriteria.or(p1,p2);
		//EMPEZAMOS A FORMAR EL SELECT
		//Cuando mandamos la  , por defecto es and
		//se recomienda crear un predicado espedicifo para and y or
		myQuery.select(myTabla).where(predicadofinal);

		TypedQuery<Guardia> typedQuery = this.entityManager.createQuery(myQuery);

		return typedQuery.getResultList();
	}

}
