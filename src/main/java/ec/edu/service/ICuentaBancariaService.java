package ec.edu.service;

import java.math.BigDecimal;

import ec.edu.modelo.jpa.CuentaBancaria;

public interface ICuentaBancariaService {

	void crearCuentaBancaria(CuentaBancaria cuentaBancaria);
	CuentaBancaria buscarCuentaBancariaNumero (String numero);
	void actualizarCuenta(CuentaBancaria cuenta);
	void realizarTransferencia(String cuentaOrigen, String cuentaDestino, BigDecimal valorTransferir);


}
