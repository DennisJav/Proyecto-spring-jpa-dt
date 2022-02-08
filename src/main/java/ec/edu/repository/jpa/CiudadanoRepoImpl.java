package ec.edu.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.modelo.jpa.Ciudadano;
@Repository
@Transactional
public class CiudadanoRepoImpl implements ICiudadanoRepo{

	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public void insertarCiudadano(Ciudadano ciudadano) {
		this.entityManager.persist(ciudadano);
	}

}
