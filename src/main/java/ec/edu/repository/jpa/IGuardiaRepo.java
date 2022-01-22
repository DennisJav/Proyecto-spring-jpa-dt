package ec.edu.repository.jpa;

import ec.edu.modelo.jpa.Guardia;

public interface IGuardiaRepo {
	void insertarGuardia(Guardia guardia);

	void actualizarGuardia(Guardia guardia);

	Guardia buscarguardia(Integer id);

	void borrarGuardia(Integer id);

	Guardia buscarGuardiaPorApellido(String apellido);
	
	Guardia buscarGuardiaPorApellidoLista(String apellido);
	
	Guardia buscarGuardiaPorApellidoType(String apellido);
	
	Guardia buscarGuardiaPorApellidoNamed(String apellido);
	
}
