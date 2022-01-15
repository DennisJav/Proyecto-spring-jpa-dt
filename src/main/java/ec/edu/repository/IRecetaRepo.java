package ec.edu.repository;

import ec.edu.modelo.Paciente;
import ec.edu.modelo.Receta;

public interface IRecetaRepo {
	
	void insertarReceta(Receta receta);
	Paciente buscarReceta(Integer id);
	void actualizarReceta(Receta receta);
	void borrarReceta(Integer id);
}
