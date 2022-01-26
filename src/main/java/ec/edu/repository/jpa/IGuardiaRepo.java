package ec.edu.repository.jpa;

import java.util.List;

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
	
	Guardia buscarGuardiaPorApellidoNamedNative(String apellido);
	
	Guardia buscarGuardiaPorApellidoCriteriaAPI(String apellido);
	
	Guardia buscarGuardiaPorApellidoCriteriaAPIAND(String apellido, String edificio);
	
	List<Guardia> buscarGuardiaPorApellidoCriteriaAPIOR(String apellido, String edificio);
	
}
