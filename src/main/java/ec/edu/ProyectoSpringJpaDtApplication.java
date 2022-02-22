package ec.edu;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ec.edu.modelo.Paciente;
import ec.edu.modelo.Receta;
import ec.edu.modelo.Turista;
import ec.edu.modelo.jpa.Ciudadano;
import ec.edu.modelo.jpa.Cliente;
import ec.edu.modelo.jpa.CuentaBancaria;
import ec.edu.modelo.jpa.DetalleFactura;
import ec.edu.modelo.jpa.Empleado;
import ec.edu.modelo.jpa.Factura;
import ec.edu.modelo.jpa.FacturaSencilla;
import ec.edu.modelo.jpa.Guardia;
import ec.edu.service.ICiudadanoService;
import ec.edu.service.IClienteService;
import ec.edu.service.ICuentaBancariaService;
import ec.edu.service.IDetalleFacturaService;
import ec.edu.service.IFacturaService;
import ec.edu.service.IGestorCitaService;
import ec.edu.service.IGuardiaService;
import ec.edu.service.IPacienteService;
import ec.edu.service.ITuristaService;

@SpringBootApplication
public class ProyectoSpringJpaDtApplication implements CommandLineRunner {

	public static final Logger LOG = LoggerFactory.getLogger(ProyectoSpringJpaDtApplication.class);
//	@Autowired
//	private IPacienteService pacienteService;

	@Autowired
	private IGestorCitaService gestorCitaService;

	@Autowired
	private IGuardiaService guardiaService;
	@Autowired
	private IFacturaService facturaService;
	
	@Autowired
	private ICiudadanoService ciudadanoService;
	
	@Autowired
	private IDetalleFacturaService detalleFacturaService;
	
	@Autowired 
	private IClienteService clienteService;
	
	@Autowired
	private ITuristaService turistaService;
	
	@Autowired
	private ICuentaBancariaService cuentaBancariaService;

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
//		g1.setApellido("mvn");
//		g1.setEdificio("Amazonas");	
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
//		
//		//TALLER 23

		
//		Factura miFactura = new Factura();
//		miFactura.setCedula("1213213");
//		LocalDateTime miFecha = LocalDateTime.of(1989, Month.AUGUST,8,12,45);
//		// Para fecha actual LocalDateTime.now();
//		miFactura.setFecha(miFecha);
//		miFactura.setNumero("12121-23223");
		
		//Vamos a construir la lista de detalles
//		List<DetalleFactura> detalles =  new ArrayList<>();
		
		//Primer detalle
//		DetalleFactura d1 = new DetalleFactura();
//		d1.setCantidad(3);
//		d1.setPrecio(new BigDecimal(3.22));
//		d1.setFactura(miFactura);
//		
//		detalles.add(d1);
//		
//		//Primer detalle
//		DetalleFactura d2 = new DetalleFactura();
//		d2.setCantidad(10);
//		d2.setPrecio(new BigDecimal(9.99));
//		d2.setFactura(miFactura);
//		
//		detalles.add(d2);
//		
//		miFactura.setDetalles(detalles);
//		
//		this.facturaService.guardarFactura(miFactura);
		
		//Taller 24
		
//		Ciudadano ciudadano1 = new Ciudadano();
//		ciudadano1.setNombre("Dennis");
//		ciudadano1.setApellido("Tapia");
//		
//		
//		Empleado empleado = new Empleado();
//		empleado.setIess("123245aaa");
//		empleado.setSalario(new BigDecimal(252.36));
//	
//		empleado.setCiudadano(ciudadano1);
//		
//		ciudadano1.setEmpleado(empleado);
//		
//		this.ciudadanoService.guardarCiudadano(ciudadano1);
		
		//Taller 25
		

		
//		LocalDateTime miFecha = LocalDateTime.of(1989, Month.AUGUST,8,2,5);
//		List<Factura> listaFactura = this.facturaService.buscarFacturaJoin(miFecha);
//		LOG.info("longitud"+listaFactura.size());
//		for(Factura f: listaFactura) {
//			LOG.info("Factura Encontrada"+f);
//			//LOG.info(f.toString());
//		}
		
		
//		List<Factura> listaFactura1 = this.facturaService.buscarFacturaJoinLeft(miFecha);
//		for(Factura f1: listaFactura1) {
//			LOG.info("Factura Encontrada"+f1);
//		}
		
//		
//		LocalDateTime miFecha = LocalDateTime.of(1989, Month.AUGUST,8,2,2);
//		List<Factura> listaFactura = this.facturaService.buscarFacturaWhere(miFecha);
//	//	LOG.info("longitud"+listaFactura.size());
//		for(Factura f: listaFactura) {
//			//LOG.info("Factura Encontrada"+f);
//			LOG.info(f.toString());
//		}
//		
		
		//TALLER 26
//		
//		
//		 //FETCH
//		System.out.println("SELECT CON FETCH");
//		LocalDateTime miFecha = LocalDateTime.of(1989, Month.AUGUST,8,2,5);
//		List<Factura> listaFactura = this.facturaService.buscarFacturaJoinFetch(miFecha);
//
//		List<DetalleFactura> listaDetalleFacturas = this.detalleFacturaService.buscarDetallePorPrecio(new BigDecimal(7) , miFecha);
//
//		//COLECTION
//		System.out.println("COLECCION");
//		Cliente cliente=new Cliente();
//		cliente.setNombre("Javier");
//		List<String> tel = new ArrayList<>();
//		tel.add("0963321015");
//		tel.add("222565651");
//		
//		cliente.setTelefonos(tel);
//		
//		this.clienteService.guardarCliente(cliente);
//		
//		
//		//FACTURATO
//		System.out.println("FACTURA SENCILLA");
//		List<FacturaSencilla> listaFacSencilla = this.facturaService.buscarFacturaSencilla(miFecha);
		
		
		//Taller 27
		
//		Turista tur1=new Turista();
//		tur1.setNombre("Denis");
//		//tur1.setSaldo(new BigDecimal(121));
//		tur1.setAbono(new BigDecimal(12));
//		tur1.setValor(new BigDecimal(110));
//				
//		
//		this.turistaService.guardarTurista(tur1);
//		List<Turista> listaTurista = this.turistaService.obtenerTodosTuristas("Denis");
//        for(Turista t : listaTurista) {
//            LOG.info("El turista buscado es: " + t);
//            
//        }
//		//this.turistaService.obtenerTodosTuristas();
		
		
		//Taller 32

		
		CuentaBancaria c1 = new CuentaBancaria();
		
		c1.setClienteCedula("12313");
		c1.setNumeroCuenta("121221");
		c1.setSaldo(new BigDecimal(1000));
		c1.setTipo("Ahorros");
		
		this.cuentaBancariaService.crearCuentaBancaria(c1);
		
		CuentaBancaria c2 = new CuentaBancaria();
		
		c2.setClienteCedula("1721334555");
		c2.setNumeroCuenta("41002120");
		c2.setSaldo(new BigDecimal(100));
		c2.setTipo("Corriente");
		
		this.cuentaBancariaService.crearCuentaBancaria(c2);
	}

}
