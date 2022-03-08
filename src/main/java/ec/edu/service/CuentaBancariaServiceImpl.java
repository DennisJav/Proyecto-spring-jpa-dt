package ec.edu.service;

import java.math.BigDecimal;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.modelo.jpa.CuentaBancaria;
import ec.edu.repository.jpa.CuentaBancariaRepoImpl;
import ec.edu.repository.jpa.ICuentaBancariaRepo;

@Service
public class CuentaBancariaServiceImpl implements ICuentaBancariaService{

	public static final Logger LOG = LoggerFactory.getLogger(CuentaBancariaServiceImpl.class);

	@Autowired
	private ICuentaBancariaRepo cuentaBancariaRepo;

	@Override
	public void crearCuentaBancaria(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		this.cuentaBancariaRepo.insertarCuentaBancaria(cuentaBancaria);
		
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public CuentaBancaria buscarCuentaBancariaNumero(String numero) {
		// TODO Auto-generated method stub
		return this.cuentaBancariaRepo.buscarCuentaBancariaNumero(numero);
	}

	@Override
	
	@Transactional
	public void realizarTransferencia(String cuentaOrigen, String cuentaDestino, BigDecimal valorTransferir) {
		// TODO Auto-generated method stub
		
		
		CuentaBancaria cuentaOrig = this.buscarCuentaBancariaNumero(cuentaOrigen);
        CuentaBancaria cuentaDes = this.buscarCuentaBancariaNumero(cuentaDestino);

        BigDecimal nuevoSaldoOrigen = cuentaOrig.getSaldo().subtract(valorTransferir);
        cuentaOrig.setSaldo(nuevoSaldoOrigen);

        BigDecimal nuevoSaldoDestino = cuentaDes.getSaldo().add(valorTransferir);
        cuentaDes.setSaldo(nuevoSaldoDestino);
      //  cuentaDes.setTipo(null);  //ERROR PROVOCADO
        
        this.actualizarCuenta(cuentaDes);
        this.actualizarCuenta2(cuentaDes);

        
        
        //SE CONTROLA PERO SI SE PROPAGA LA TRANSACCION HASTA EL FINAL

	}

	@Override
	public void actualizarCuenta(CuentaBancaria cuenta) {
		
		this.cuentaBancariaRepo.actualizarCuentaBancaria(cuenta);
		
	}

	@Override
	public void actualizarCuenta2(CuentaBancaria cuenta) {
		// TODO Auto-generated method stub
		this.cuentaBancariaRepo.actualizarCuentaBancaria2(cuenta);

	
	}
	
	
	
	@Transactional(value = TxType.SUPPORTS)
	public void propagacionSuport() {
		
		
		
		
	}
	
	
	@Transactional(value = TxType.MANDATORY)
	public void propagacionMandatory() {
		LOG.info("Ejecucion mandatory");
		
		
	}
	
	@Transactional	
	public void realizarTransferenciaExpressInicial(String cuentaOrigen, String cuentaDestino, BigDecimal valorTransferir) {
		this.realizarTransferenciaExpress(cuentaOrigen, cuentaDestino, valorTransferir);
	}
	

	
	
	/**
	 * NO es transaccion porque le vamos a retirar para ejecutar el error o saber que sucede
	 * @param cuentaOrigen
	 * @param cuentaDestino
	 * @param valorTransferir
	 */
	//SEGUNDO ESCENARIO
	//@Transactional(value = TxType.REQUIRES_NEW)	
	public void realizarTransferenciaExpressInicialNoT(String cuentaOrigen, String cuentaDestino, BigDecimal valorTransferir) {
		this.realizarTransferenciaExpress(cuentaOrigen, cuentaDestino, valorTransferir);
	}
	
	
	
	
	//@Transactional(value = TxType.SUPPORTS)
	
	@Transactional(value = TxType.REQUIRES_NEW)
	
	public void realizarTransferenciaExpress(String cuentaOrigen, String cuentaDestino, BigDecimal valorTransferir) {
		// TODO Auto-generated method stub
		LOG.info("EJECUCION SUPPORT");
		
		CuentaBancaria cuentaOrig = this.buscarCuentaBancariaNumero(cuentaOrigen);
        CuentaBancaria cuentaDes = this.buscarCuentaBancariaNumero(cuentaDestino);

        BigDecimal nuevoSaldoOrigen = cuentaOrig.getSaldo().subtract(valorTransferir);
        cuentaOrig.setSaldo(nuevoSaldoOrigen);

        BigDecimal nuevoSaldoDestino = cuentaDes.getSaldo().add(valorTransferir);
        cuentaDes.setSaldo(nuevoSaldoDestino);

        LOG.info("EJECUCION SUPPORT ANTES");
        this.actualizarCuenta(cuentaOrig);
        this.actualizarCuenta2(cuentaDes);
        LOG.info("DESPUES DEL SUPPROT");

	}
	
	@Transactional
	public void enviarEmail() {
		this.cuentaBancariaRepo.enviarMail("Correo de clase  TRANSACCION");
	}
	
	
	public void enviarEmailNoT() {
		this.cuentaBancariaRepo.enviarMail("Correo de clase  NO TRANSACCION");

	}
	
	
}
