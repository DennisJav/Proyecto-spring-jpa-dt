package ec.edu.repository.jpa;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ec.edu.modelo.jpa.Factura;
import ec.edu.modelo.jpa.FacturaSencilla;

@Repository
@Transactional
public class FacturaRepoImpl implements IFacturaRepo {

	public static final Logger LOG = LoggerFactory.getLogger(FacturaRepoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertarFactura(Factura factura) {
		this.entityManager.persist(factura);
	}

	@Override
	public List<Factura> buscarPorFechaJoin(LocalDateTime fecha) {
		TypedQuery<Factura> miQuery = this.entityManager
				.createQuery("SELECT f FROM Factura f JOIN f.detalles d WHERE f.fecha <=:fecha ", Factura.class);
		miQuery.setParameter("fecha", fecha);

		List<Factura> listaFactura = miQuery.getResultList();

		LOG.info("LONGITUD REPO: " + listaFactura.size());
		for (Factura f : listaFactura) {
			LOG.info(f.toString());
			LOG.info("Detalles: " + f.getDetalles());
		}

		return listaFactura;
	}

	@Override
	public List<Factura> buscarPorFechaJoinLeft(LocalDateTime fecha) {
		TypedQuery<Factura> miQuery = this.entityManager
				.createQuery("SELECT f FROM Factura f LEFT JOIN f.detalles d WHERE f.fecha <=:fecha ", Factura.class);
		miQuery.setParameter("fecha", fecha);
		return miQuery.getResultList();
	}

	
	@Override
	public List<Factura> buscarPorFechaWhere(LocalDateTime fecha) {
		// f.fact_id = d.fact_id
		// en la clave primaria se hace relacionamiento con el objeto
		TypedQuery<Factura> miQuery = this.entityManager.createQuery(
				"SELECT f FROM Factura f, DetalleFactura d WHERE f = d.factura AND f.fecha <=:fecha", Factura.class);
		miQuery.setParameter("fecha", fecha);
//		List<Factura> listaFactura = miQuery.getResultList();
//
//		LOG.info("LONGITUD REPO: " + listaFactura.size());
//		for (Factura f : listaFactura) {
//			LOG.info("Detales: " + f.getDetalles());
//			LOG.info(f.toString());
//		}
		
		return miQuery.getResultList();
	}

	
	@Override
	public List<Factura> buscarPorFechaJoinFetch(LocalDateTime fecha) {
		TypedQuery<Factura> miQuery = this.entityManager
				.createQuery("SELECT f FROM Factura f JOIN FETCH f.detalles d WHERE f.fecha <=:fecha ", Factura.class);
		miQuery.setParameter("fecha", fecha);

		List<Factura> listaFactura = miQuery.getResultList();

		LOG.info("LONGITUD REPO: " + listaFactura.size());
		for (Factura f : listaFactura) {
			LOG.info("Detales: " + f.getDetalles());
			LOG.info(f.toString());
		}

		return listaFactura;
	}

	@Override
	public List<FacturaSencilla> buscarPorFechaSensilla(LocalDateTime fecha) {
		//Constructor que recibe numero y cedula
		//NEW FacturaSencilla(f.numero, f.cedula) esto es lo nuevo
		//SE DEBE PONER COMPLETO MAS LOS PAQUETES ec.edu.modelo.jpa.
		
		TypedQuery<FacturaSencilla> miQuery = this.entityManager
				.createQuery("SELECT NEW ec.edu.modelo.jpa.FacturaSencilla(f.numero, f.cedula) FROM Factura f JOIN f.detalles d WHERE f.fecha <=:fecha", FacturaSencilla.class);
		miQuery.setParameter("fecha", fecha);
		
		List<FacturaSencilla> listaFactura = miQuery.getResultList();
		
		for (FacturaSencilla f : listaFactura) {
			LOG.info(f.toString());
		}

		return listaFactura;
	}

	
	
	
}
