package ec.edu.repository.jpa;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.modelo.jpa.CuentaBancaria;

@Transactional
@Repository
public class CuentaBancariaRepoImpl implements ICuentaBancariaRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertarCuentaBancaria(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		this.entityManager.persist(cuentaBancaria);
	}

	@Override
	public CuentaBancaria buscarCuentaBancariaNumero(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<CuentaBancaria> miQuery = this.entityManager
				.createQuery("select c from CuentaBancaria c where c.numeroCuenta = :valor",CuentaBancaria.class);
		miQuery.setParameter("valor", numero);
		
		
		return miQuery.getSingleResult();
	}

	@Override
	public void realizarTransferencia(String cuentaOrigen, String cuentaDestino, BigDecimal valorTransferir) {

	}

	@Override
	public void actualizarCuentaBancaria(CuentaBancaria cuenta) {
		this.entityManager.merge(cuenta);

	}

}