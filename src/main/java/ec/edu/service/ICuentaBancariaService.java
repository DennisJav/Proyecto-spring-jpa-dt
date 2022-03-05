package ec.edu.service;

import java.math.BigDecimal;

import ec.edu.modelo.jpa.CuentaBancaria;

public interface ICuentaBancariaService {

	void crearCuentaBancaria(CuentaBancaria cuentaBancaria);
	CuentaBancaria buscarCuentaBancariaNumero (String numero);
	void actualizarCuenta(CuentaBancaria cuenta);
	void realizarTransferencia(String cuentaOrigen, String cuentaDestino, BigDecimal valorTransferir);
	void actualizarCuenta2(CuentaBancaria cuenta);
	void propagacionMandatory(); 
	void realizarTransferenciaExpress(String cuentaOrigen, String cuentaDestino, BigDecimal valorTransferir); 
	void realizarTransferenciaExpressInicial(String cuentaOrigen, String cuentaDestino, BigDecimal valorTransferir);
	void realizarTransferenciaExpressInicialNoT(String cuentaOrigen, String cuentaDestino, BigDecimal valorTransferir);
	
	
	void enviarEmail();
	void enviarEmailNoT();
	
}
