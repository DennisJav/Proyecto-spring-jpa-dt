package ec.edu.interfaces.funcionales;

import java.util.ArrayList;
import java.util.List;

public class MainMetodosReferenciados {

	public static void main(String[] args) {
		
		//1. Implementar por clases
		
		IPersonaSupplier<String> persona = new PersonaSupplierImpl();
		String mensaje = persona.get();
	
		System.out.println(mensaje);
		//No se puede hacer un new de la interfaz como sucede al igual en list
		//List<Integer> lista=new ArrayList<>();
		
		//2. Lambadas
		IPersonaSupplier<String> persona1 = () -> "Se implemento por lambda";
		String mennsaje1=persona1.get();
		System.out.println(mennsaje1);
		
		//3. Metodos referenciados
		PersonaSupplierImpl personaImpl = new PersonaSupplierImpl();
		IPersonaSupplier<String> persona2 = personaImpl::get;  //Permite referencias a la personaImpl metodos referenciadas
 		String mensaje2=persona2.get();
 		System.out.println(mensaje2);
		
 		//3.1
 		PersonaSupplierSinImpl personaSinImpl = new PersonaSupplierSinImpl();
 		
		IPersonaSupplier<String> persona3 = personaSinImpl::get2;  //Permite referencias a la personaImpl metodos referenciadas
 		String mensaje3=persona3.get();
 		System.out.println(mensaje3);
 		
 		
		IPersonaSupplier<Integer> persona4 = personaSinImpl::get3;  //Permite referencias a la personaImpl metodos referenciadas
 		Integer mensaje4 = persona4.get();
 		System.out.println(mensaje4);
 		
 		
 		//3.2
 		
 		PersonaPredicateImpl personaPredi =  new  PersonaPredicateImpl();
 		IPersonaPredicate<String> personaPredi2 = personaPredi::evaluar;
 		boolean nombre = personaPredi2.evaluar("Mensaje");
 		
 		IPersonaPredicate<String> personaPredi3 = valor1 -> valor1.contains("z");
 		boolean respuesta = personaPredi3.evaluar("Arroz");
 		
 		prueba(personaPredi::evaluar);
 		
 		
 		
 		
	}
	
	
	public static boolean prueba(IPersonaPredicate<String> arg1) {
		return arg1.evaluar("Mensaje");
	}
	
}
