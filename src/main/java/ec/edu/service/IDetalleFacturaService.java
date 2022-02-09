package ec.edu.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import ec.edu.modelo.jpa.DetalleFactura;

public interface IDetalleFacturaService {
	List<DetalleFactura> buscarDetallePorPrecio(BigDecimal valorMinimo, LocalDateTime fecha);
}
