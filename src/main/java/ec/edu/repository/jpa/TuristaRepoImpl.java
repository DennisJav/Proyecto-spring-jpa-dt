package ec.edu.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.modelo.Turista;
import ec.edu.modelo.jpa.Guardia;

@Repository
@Transactional
public class TuristaRepoImpl implements ITuristaRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertarTurista(Turista turista) {
		// TODO Auto-generated method stub
		this.entityManager.persist(turista);
		
	}

	@Override
	public List<Turista> buscarTurista(String nombre) {
		// TODO Auto-generated method stub
		
//		TypedQuery<Factura> miQuery = this.entityManager
//		.createQuery("SELECT f FROM Factura f JOIN f.detalles d WHERE f.fecha <=:fecha ", Factura.class);
//miQuery.setParameter("fecha", fecha);

		TypedQuery<Turista> miTypedQuery = (TypedQuery<Turista>) this.entityManager
				.createQuery("SELECT t FROM Turista t WHERE t.nombre <=: nombre ", Turista.class);
		miTypedQuery.setParameter("nombre", nombre);
		List<Turista> listaTuristas = miTypedQuery.getResultList();
		
		return listaTuristas;
	}

	
}
