package ec.edu.repository.jpa;

import java.util.List;

import ec.edu.modelo.Turista;

public interface ITuristaRepo {

	void insertarTurista(Turista turista);
	List<Turista> buscarTurista(String nombre);	
	
}
