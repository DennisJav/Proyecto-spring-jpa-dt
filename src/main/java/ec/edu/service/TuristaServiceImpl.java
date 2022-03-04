package ec.edu.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.modelo.Turista;
import ec.edu.repository.jpa.ITuristaRepo;

@Service
public class TuristaServiceImpl implements ITuristaService{

	@Autowired
	private ITuristaRepo turistaRepo;
	
	@Override
	public List<Turista> obtenerTodosTuristas(String nombre) {
		// TODO Auto-generated method stub
		List<Turista> lista =  this.turistaRepo.buscarTurista(nombre); //que se obtiene del repository
		List<Turista> listaCalculada = this.calcularSaldo(lista);
		return listaCalculada;
	}

	private List<Turista> calcularSaldo(List<Turista> listaTuristas){
		for(Turista turista: listaTuristas) {
			BigDecimal saldo = turista.getValor().subtract(turista.getAbono());
			turista.setSaldo(saldo);
		}
		return listaTuristas;
	}

	@Override
	public void guardarTurista(Turista turista) {
		this.turistaRepo.insertarTurista(turista);
		
	}
	
}
