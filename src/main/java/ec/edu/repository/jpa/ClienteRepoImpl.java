package ec.edu.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.modelo.jpa.Cliente;

@Repository
@Transactional
public class ClienteRepoImpl implements IClienteRepo{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertarCliente(Cliente cliente) {
		this.entityManager.persist(cliente);
		
	}
	
	
}
