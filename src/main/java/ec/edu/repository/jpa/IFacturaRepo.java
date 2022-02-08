package ec.edu.repository.jpa;

import java.time.LocalDateTime;
import java.util.List;

import ec.edu.modelo.jpa.Factura;

public interface IFacturaRepo {
	void insertarFactura(Factura factura);
	List<Factura> buscarPorFechaJoin(LocalDateTime fecha);
	List<Factura> buscarPorFechaJoinLeft(LocalDateTime fecha);
}
