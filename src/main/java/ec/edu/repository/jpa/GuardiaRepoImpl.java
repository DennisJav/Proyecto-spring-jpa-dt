package ec.edu.repository.jpa;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.modelo.jpa.Guardia;

@Repository
@Transactional
public class GuardiaRepoImpl implements IGuardiaRepo{

	
	@PersistenceContext //para la inyeccion
	private EntityManager entityManager;
	
	
	@Override
	public void insertarGuardia(Guardia guardia) {
		// TODO Auto-generated method stub
		this.entityManager.persist(guardia); //metodo persist recibe una entidad que esta puesto entity en el modelo
		
	}

	@Override
	public void actualizarGuardia(Guardia guardia) {
		// TODO Auto-generated method stub
		this.entityManager.merge(guardia);	
	}

	@Override
	public Guardia buscarguardia(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void borrarGuardia(Integer id) {
		// TODO Auto-generated method stub
		
	}
	

}
