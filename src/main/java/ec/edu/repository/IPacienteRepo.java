package ec.edu.repository;

import ec.edu.modelo.Paciente;

public interface IPacienteRepo {
	void insertarPaciente(Paciente paciente);
	Paciente buscarPaciente(Integer id);
	void actualizarPaciente(Paciente paciente);
	void borrarPaciente(Integer id);
}
