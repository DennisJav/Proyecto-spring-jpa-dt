package ec.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.modelo.Paciente;
import ec.edu.modelo.Receta;


@Service
public class GestorCitaServiceImpl implements IGestorCitaService{

	@Autowired
	private IPacienteService pacienteServicio;
	@Autowired
	private IRecetaService recetaServicio;
	
	@Override
	public void registrarNuevaConsulta(Paciente paciente, Receta receta) {
		// TODO Auto-generated method stub
		this.pacienteServicio.pacienteNuevo(paciente);
		this.recetaServicio.guardarReceta(receta);
	}

}
