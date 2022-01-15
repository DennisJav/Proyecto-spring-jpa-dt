package ec.edu.service;

import ec.edu.modelo.Paciente;

public interface IPacienteService {
	void pacienteNuevo(Paciente paciente);
	void borrarPacientePorID(Integer id);
	void actualizarPaciente(Paciente paciente);
	Paciente buscarPacientePorId(Integer id);
}
