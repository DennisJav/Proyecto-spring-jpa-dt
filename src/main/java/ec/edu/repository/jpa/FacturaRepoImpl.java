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
	       TypedQuery<Factura> miQuery = this.entityManager.createQuery("SELECT f FROM Factura f JOIN f.detalles d WHERE f.fecha <=:fecha ",Factura.class);
	        miQuery.setParameter("fecha", fecha);
	        
	        List<Factura> listaFactura = miQuery.getResultList();
	        
	        LOG.info("LONGITUD REPO: "+listaFactura.size());
	    	for(Factura f: listaFactura) {
				LOG.info("Detales: "+f.getDetalles());
				LOG.info(f.toString());
			}
	        
	        return listaFactura;
	}
	@Override
	public List<Factura> buscarPorFechaJoinLeft(LocalDateTime fecha) {
        TypedQuery<Factura> miQuery = this.entityManager.createQuery("SELECT f FROM Factura f LEFT JOIN f.detalles d WHERE f.fecha <=:fecha ",Factura.class);
        miQuery.setParameter("fecha", fecha);
        return miQuery.getResultList();
	}
	
}
