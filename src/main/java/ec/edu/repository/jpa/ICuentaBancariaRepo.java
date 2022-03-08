package ec.edu.repository.jpa;

import java.math.BigDecimal;

import ec.edu.modelo.jpa.CuentaBancaria;

public interface ICuentaBancariaRepo {

	void insertarCuentaBancaria(CuentaBancaria cuentaBancaria);
	
	CuentaBancaria buscarCuentaBancariaNumero(String numero);
	
	void realizarTransferencia(String cuentaOrigen, String cuentaDestino, BigDecimal valorTransferir);
	
	void actualizarCuentaBancaria(CuentaBancaria cuenta);
	void actualizarCuentaBancaria2(CuentaBancaria cuenta);
	 void enviarMail(String asunto); 
}
