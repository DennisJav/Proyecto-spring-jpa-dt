package ec.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.modelo.Receta;
import ec.edu.repository.IRecetaRepo;

@Service
public class RecetaServiceImpl implements IRecetaService{
	
	@Autowired
	private IRecetaRepo recetaRepo;

	@Override
	public void guardarReceta(Receta receta) {
		// TODO Auto-generated method stub
		this.recetaRepo.insertarReceta(receta);
	}
	
}
