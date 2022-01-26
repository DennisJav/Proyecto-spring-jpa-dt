package ec.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.modelo.jpa.Guardia;
import ec.edu.repository.jpa.IGuardiaRepo;

@Service
public class GuardiaServiceImpl implements IGuardiaService {

	@Autowired
	private IGuardiaRepo guardiaRepo;

	@Override
	public void guardarGuardia(Guardia guardia) {
		// TODO Auto-generated method stub
		this.guardiaRepo.insertarGuardia(guardia);
	}

	@Override
	public void actualizarGuardia(Guardia guardia) {
		// TODO Auto-generated method stub
		this.guardiaRepo.actualizarGuardia(guardia);
	}

	@Override
	public Guardia buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.guardiaRepo.buscarguardia(id);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.guardiaRepo.borrarGuardia(id);
	}

	@Override
	public Guardia buscarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		
		return this.guardiaRepo.buscarGuardiaPorApellido(apellido);
	}

	@Override
	public Guardia buscarPorApellidoLista(String apellido) {
		// TODO Auto-generated method stub
		return this.guardiaRepo.buscarGuardiaPorApellidoLista(apellido);
	}


	@Override
	public Guardia buscarPorApellidoTyped(String apellido) {
		// TODO Auto-generated method stub
		return this.guardiaRepo.buscarGuardiaPorApellidoType(apellido);
	}

	@Override
	public Guardia buscarPorApellidoNamed(String apellido) {
		// TODO Auto-generated method stub
		return this.guardiaRepo.buscarGuardiaPorApellidoNamed(apellido);
	}

	@Override
	public Guardia buscarPorApellidoNamedNative(String apellido) {
		// TODO Auto-generated method stub
		return this.guardiaRepo.buscarGuardiaPorApellidoNamedNative(apellido);
	}

	@Override
	public Guardia buscarPorApellidoCriteriaAPI(String apellido) {
		// TODO Auto-generated method stub
		return this.guardiaRepo.buscarGuardiaPorApellidoCriteriaAPI(apellido);
	}

	@Override
	public Guardia buscarPorApellidoCriteriaAPIAND(String apellido, String edificio) {
		// TODO Auto-generated method stub
		return this.guardiaRepo.buscarGuardiaPorApellidoCriteriaAPIAND(apellido, edificio);
	}

	@Override
	public List<Guardia> buscarPorApellidoCriteriaAPIOR(String apellido, String edificio) {
		// TODO Auto-generated method stub
		return this.guardiaRepo.buscarGuardiaPorApellidoCriteriaAPIOR(apellido, edificio);
	}


}
