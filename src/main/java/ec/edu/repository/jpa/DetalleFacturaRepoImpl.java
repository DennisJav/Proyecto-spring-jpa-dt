package ec.edu.repository.jpa;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ec.edu.modelo.jpa.DetalleFactura;
import ec.edu.modelo.jpa.Factura;

@Transactional
@Repository
public class DetalleFacturaRepoImpl implements IDetalleFacturaRepo{

	public static final Logger LOG = LoggerFactory.getLogger(DetalleFacturaRepoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<DetalleFactura> buscarProductos(BigDecimal valorMinimo, LocalDateTime fecha) {
		TypedQuery<DetalleFactura> miQuery = this.entityManager
				.createQuery("SELECT d FROM DetalleFactura d, Factura f WHERE d.precio <=:valorMinimo AND f.fecha <=:fecha",DetalleFactura.class);
		miQuery.setParameter("valorMinimo", valorMinimo);
		miQuery.setParameter("fecha", fecha);

		List<DetalleFactura> listaDetalles = miQuery.getResultList();

		LOG.info("LONGITUD REPO: " + listaDetalles.size());
		for (DetalleFactura f : listaDetalles) {
			LOG.info("Factura: " + f.getFactura());
			LOG.info(f.toString());
		}

		return listaDetalles;
	}



	

}
