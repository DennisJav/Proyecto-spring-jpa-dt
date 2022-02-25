package ec.edu.service;

import java.math.BigDecimal;

import javax.transaction.Transactional;

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
        
        LOG.info("AA1");
        this.actualizarCuenta(cuentaOrig);
        LOG.info("DA1");
        LOG.info("AA2");
      
        
        try {
        this.actualizarCuenta2(cuentaDes);
        }catch (ArrayIndexOutOfBoundsException e) {
        	LOG.error("ERRROR");
		}
        
        LOG.info("DA2");
        
        
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
	
	
	
	
}
