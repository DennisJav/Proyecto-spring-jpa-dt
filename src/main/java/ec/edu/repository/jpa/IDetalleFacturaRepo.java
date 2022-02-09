package ec.edu.repository.jpa;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import ec.edu.modelo.jpa.DetalleFactura;

public interface IDetalleFacturaRepo {
	
	List<DetalleFactura> buscarProductos(BigDecimal valorMinimo , LocalDateTime fecha);
}
