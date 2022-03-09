package ec.edu.interfaces.funcionales;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class MainFuncional {

	public static void main(String[] args) {
	
		//SUPPLIER
		IPersonaSupplier<String> supplier = new PersonaSupplier();
		System.out.println(supplier.get());

		// Hacer esto consume mucho tiempo
		IPersonaSupplier<String> supplierChino = new PersonaSupplierChino();
		System.out.println(supplierChino.get());

		// El tiempo de hacer esto es menor es mas sencilla
		
		
		IPersonaSupplier<String> supplier1 = () -> {
			return "HOLA MUNDO LAMBDA adicional la llave";
		};
		
		System.out.println(supplier1.get());

		IPersonaSupplier<String> supplierChino1 = () -> "HOLA MUNDO LAMBDA EN CHINO";
		System.out.println(supplierChino1.get());

		ConsumoInterfacesFuncionales consumo = new ConsumoInterfacesFuncionales();
		String resultado = consumo.consumirInterfaz(() -> "HOLA MUNDO CONSUMO SUPLIER++++++");
		System.out.println(resultado);
		// JAVA tmb genera un supplier que es lo mismo que hicimos
		// Supplier<T>
		Stream<String> test = Stream.generate(() -> "HOLA MUNDO STREAM").limit(10); //forEach(x -> System.out.println(x));; ///me va a generar 100 registros tipo strieam de hola
		test.forEach(x -> System.out.println(x+"Prueba for each"));
		
		
		//Muchas funcionalidades de java reciben interfaces funcionales como el generate de la clase strea
		
		// CONSUMER
		System.out.println("CONSUMER");
		
		IPersonaConsumer<Integer> personaConsumer = number -> System.out.println(number);
		personaConsumer.accept(7);
		
		IPersonaConsumer<Integer> personaConsumer1 = number -> System.out.println(number.intValue()+1);
		personaConsumer1.accept(7);	
		
		consumo.consumirConsumer( number -> System.out.println(number + 10), 2);
		
		//Consumer JAVA
		List<Integer> listaNum = Arrays.asList(1,2,3,4,5,6);
		listaNum.forEach(number -> System.out.println(number));
		
		System.out.println("PREDICATE");
		
		//Predicate
		
		
		boolean resultado2 = consumo.consumirPredicate(cadena -> cadena.contains("D"),"Dennis");
		System.out.println(resultado2);
		
		
		//Predicate en java
		
		Stream<Integer> numerosFiltrados = listaNum.stream().filter(numero1 -> numero1 > 4 );
		numerosFiltrados.forEach(num -> System.out.println(num));
		
		
		//function
		System.out.println("FUNCTION");
		Integer nuevoValor = consumo.consumirFunction(cadena -> Integer.parseInt(cadena)-7, "2");
		System.out.println(nuevoValor);
		
		//function java
		Stream<String> listaCambiada =  listaNum.stream().map(numeroLista -> numeroLista.toString() + "N");
		listaCambiada.forEach(cadena -> System.out.println(cadena));
		
		
		
		//ListaNumero
		//listaNumeros.stream().reduce(null);
		
	}
}
