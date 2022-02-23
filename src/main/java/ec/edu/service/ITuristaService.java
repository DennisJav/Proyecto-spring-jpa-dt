package ec.edu.service;

import java.util.List;

import ec.edu.modelo.Turista;

public interface ITuristaService {

	void guardarTurista(Turista turista);
	
	List<Turista> obtenerTodosTuristas(String nombre);
	
}
