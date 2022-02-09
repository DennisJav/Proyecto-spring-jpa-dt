package ec.edu.repository.jpa;

import java.time.LocalDateTime;
import java.util.List;

import ec.edu.modelo.jpa.Factura;
import ec.edu.modelo.jpa.FacturaSencilla;

public interface IFacturaRepo {
	void insertarFactura(Factura factura);
	List<Factura> buscarPorFechaJoin(LocalDateTime fecha);
	List<Factura> buscarPorFechaJoinLeft(LocalDateTime fecha);
	List<Factura> buscarPorFechaWhere(LocalDateTime fecha);
	List<Factura> buscarPorFechaJoinFetch(LocalDateTime fecha);
	
	List<FacturaSencilla> buscarPorFechaSensilla(LocalDateTime fecha);
	
}
