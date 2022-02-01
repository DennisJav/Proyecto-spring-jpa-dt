package ec.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.modelo.jpa.Factura;
import ec.edu.repository.jpa.IFacturaRepo;

@Service
public class FacturaServiceImpl implements IFacturaService{
	
	@Autowired
	private IFacturaRepo facturaRepo;
	@Override
	public void guardarFactura(Factura factura) {
		// TODO Auto-generated method stub
		this.facturaRepo.insertarFactura(factura);
	}
	

}
