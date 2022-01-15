package ec.edu.service;

import ec.edu.modelo.Paciente;
import ec.edu.modelo.Receta;

public interface IGestorCitaService {

	void registrarNuevaConsulta(Paciente paciente, Receta receta);
}
