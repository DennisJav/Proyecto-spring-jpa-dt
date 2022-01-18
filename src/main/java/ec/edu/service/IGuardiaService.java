package ec.edu.service;

import ec.edu.modelo.jpa.Guardia;

public interface IGuardiaService {
	void guardarGuardia(Guardia guardia);
	void actualizarGuardia(Guardia guardia);
}
