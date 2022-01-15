package ec.edu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ec.edu.modelo.Paciente;
import ec.edu.modelo.Receta;
import ec.edu.service.IGestorCitaService;
import ec.edu.service.IPacienteService;

@SpringBootApplication
public class ProyectoSpringJpaDtApplication implements CommandLineRunner {

//	@Autowired
//	private IPacienteService pacienteService;

	@Autowired
	private IGestorCitaService gestorCitaService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoSpringJpaDtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Paciente paciente1 = new Paciente();
		paciente1.setId(12);
		paciente1.setNombre("Liz");
		paciente1.setApellido("Imba");
		paciente1.setEdad(22);

		// this.pacienteService.pacienteNuevo(paciente1);

		// this.pacienteService.borrarPacientePorID(1);

		// this.pacienteService.actualizarPaciente(paciente1);
		
		//Paciente p1 = this.pacienteService.buscarPacientePorId(78);
		//System.out.println("El paciente que esta buscando es: ");
		//System.out.println(p1);
		Paciente p1 =  new Paciente();
		p1.setId(7);
		p1.setNombre("Eri");
		p1.setApellido("Perez");
		p1.setEdad(40);
		
		Receta r1 = new Receta();
		r1.setId(2);
		r1.setIndicaciones("Guardar reposo");
		r1.setMedicamentos("Paracetamol");
		
		this.gestorCitaService.registrarNuevaConsulta(p1, r1);
	}

}
