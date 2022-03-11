package ec.edu.service;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;


@Service
public class CuentaFachadaServiceImpl {

	public static final Logger LOG = LoggerFactory.getLogger(CuentaFachadaServiceImpl.class);

	
	@Autowired
	private ICuentaBancariaService cuentaBancariaService;
	
	public void realizarTransferenciaExpressInicialNoT(String cuentaOrigen, String cuentaDestino, BigDecimal valorTransferir) {
		LOG.info("Prueba1: "+ TransactionSynchronizationManager.isActualTransactionActive());
		this.cuentaBancariaService.realizarTransferenciaExpress(cuentaOrigen, cuentaDestino, valorTransferir);
	}
	
	
}
