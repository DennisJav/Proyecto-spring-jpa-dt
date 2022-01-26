package ec.edu;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ec.edu.modelo.Paciente;
import ec.edu.modelo.Receta;
import ec.edu.modelo.jpa.Guardia;
import ec.edu.repository.jpa.GuardiaRepoImpl;
import ec.edu.service.IGestorCitaService;
import ec.edu.service.IGuardiaService;


@SpringBootApplication
public class ProyectoSpringJpaDtApplication implements CommandLineRunner {


	public static final Logger LOG = LoggerFactory.getLogger(ProyectoSpringJpaDtApplication.class);
	
//	@Autowired
//	private IPacienteService pacienteService;

	@Autowired
	private IGestorCitaService gestorCitaService;

	@Autowired
	private IGuardiaService guardiaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoSpringJpaDtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		Paciente paciente1 = new Paciente();
//		paciente1.setId(12);
//		paciente1.setNombre("Liz");
//		paciente1.setApellido("Imba");
//		paciente1.setEdad(22);
//
//		// this.pacienteService.pacienteNuevo(paciente1);
//
//		// this.pacienteService.borrarPacientePorID(1);
//
//		// this.pacienteService.actualizarPaciente(paciente1);
//		
//		//Paciente p1 = this.pacienteService.buscarPacientePorId(78);
//		//System.out.println("El paciente que esta buscando es: ");
//		//System.out.println(p1);
//		Paciente p1 =  new Paciente();
//		p1.setId(7);
//		p1.setNombre("Eri");
//		p1.setApellido("Perez");
//		p1.setEdad(40);
//		
//		Receta r1 = new Receta();
//		r1.setId(2);
//		r1.setIndicaciones("Guardar reposo");
//		r1.setMedicamentos("Paracetamol");
//		
//		this.gestorCitaService.registrarNuevaConsulta(p1, r1);

//		Guardia g1 = new Guardia();
//		g1.setNombre("Denis");
//		g1.setApellido("MVN2");
//		g1.setEdificio("JAVA2");	
//		this.guardiaService.guardarGuardia(g1);
//		Guardia g2 = new Guardia();
//		g2.setId(3);
//		g2.setNombre("Denis");
//		g2.setApellido("Ortiz");
//		g2.setEdificio("America");
//		
//		this.guardiaService.actualizarGuardia(g2);

//		Guardia g3 = this.guardiaService.buscar(3);
//		System.out.println(g3);
//		
//		this.guardiaService.borrar(2);
//		
//		Guardia g4 = this.guardiaService.buscarPorApellidoLista("Tapia");
//		System.out.println(g4);

		
		//Para typed
//		Guardia g4 = this.guardiaService.buscarPorApellidoTyped("mvn");
//		System.out.println(g4);
		
		//Para named
//		Guardia g4 = this.guardiaService.buscarPorApellidoNamed("mvn");
//		System.out.println(g4);
	
		//TALLER 22
//		Guardia g4 = this.guardiaService.buscarPorApellidoNamedNative("mvn");
//		System.out.println(g4);
		
//		Guardia g4 = this.guardiaService.buscarPorApellidoCriteriaAPI("mvn");
//		System.out.println(g4);
//		
//		Guardia g4 = this.guardiaService.buscarPorApellidoCriteriaAPIAND("MVN2","JAVA2");
//		System.out.println(g4);
		
//		Guardia g4 = this.guardiaService.buscarPorApellidoCriteriaAPIOR("MVN4","JAVA2");
//		LOG.info("ESTE ES EL GUARDIA: " + g4);
		
		List<Guardia> listaGuardia = this.guardiaService.buscarPorApellidoCriteriaAPIOR("Tapia","JAVA2");
		for(Guardia g: listaGuardia) {
			LOG.info("ESTE ES EL GUARDIA: " + g);
		
		}
		
	}

}
