package ec.edu.service;

import java.time.LocalDateTime;
import java.util.List;

import ec.edu.modelo.jpa.Factura;
import ec.edu.modelo.jpa.FacturaSencilla;

public interface IFacturaService {
	void guardarFactura(Factura factura);
	List<Factura> buscarFacturaJoin(LocalDateTime fecha);
	List<Factura> buscarFacturaJoinLeft(LocalDateTime fecha);
	List<Factura> buscarFacturaWhere(LocalDateTime fecha);
	List<Factura> buscarFacturaJoinFetch(LocalDateTime fecha);
	List<FacturaSencilla> buscarFacturaSencilla(LocalDateTime fecha);
}
