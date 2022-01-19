package ec.edu.repository.jpa;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.modelo.jpa.Guardia;

@Repository
@Transactional
public class GuardiaRepoImpl implements IGuardiaRepo {

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
		
		//con lenguaje JPQL
		//traabaja con objetos no con la tabla
		
		Query miQuery = this.entityManager.createQuery("select g from Guardia g where g.apellido = :valor");
		miQuery.setParameter("valor", apellido);
		Guardia miGuardia= (Guardia) miQuery.getSingleResult();
		
		return miGuardia;
	}

}
