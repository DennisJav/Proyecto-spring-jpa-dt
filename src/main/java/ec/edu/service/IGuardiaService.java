package ec.edu.service;

import java.util.List;

import ec.edu.modelo.jpa.Guardia;

public interface IGuardiaService {
	void guardarGuardia(Guardia guardia);
	void actualizarGuardia(Guardia guardia);
	Guardia buscar(Integer id);
	void borrar(Integer id);
	Guardia buscarPorApellido(String apellido);
	Guardia buscarPorApellidoLista(String apellido);
	Guardia buscarPorApellidoTyped(String apellido);
	Guardia buscarPorApellidoNamed(String apellido);
	Guardia buscarPorApellidoNamedNative(String apellido);
	Guardia buscarPorApellidoCriteriaAPI(String apellido);
	Guardia buscarPorApellidoCriteriaAPIAND(String apellido, String edificio);
	List<Guardia> buscarPorApellidoCriteriaAPIOR(String apellido, String edificio);
}
