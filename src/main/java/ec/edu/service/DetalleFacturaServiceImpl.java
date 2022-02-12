package ec.edu.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.modelo.jpa.DetalleFactura;
import ec.edu.repository.jpa.IDetalleFacturaRepo;

@Service
public class DetalleFacturaServiceImpl implements IDetalleFacturaService{

	@Autowired
	private IDetalleFacturaRepo detalleRepo;

	@Override
	public List<DetalleFactura> buscarDetallePorPrecio(BigDecimal valorMinimo, LocalDateTime fecha) {
		return this.detalleRepo.buscarProductos(valorMinimo,fecha);
	}
	
	
}
