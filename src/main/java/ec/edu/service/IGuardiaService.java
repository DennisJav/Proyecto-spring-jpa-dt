package ec.edu.service;

import ec.edu.modelo.jpa.Guardia;

public interface IGuardiaService {
	void guardarGuardia(Guardia guardia);
	void actualizarGuardia(Guardia guardia);
	Guardia buscar(Integer id);
	void borrar(Integer id);
	Guardia buscarPorApellido(String apellido);
}
