package ec.edu.interfaces.funcionales;

@FunctionalInterface
//Esta con error porque intenta representar que la funcion de 
//la interfaz recibe y retorna el mismo tipo de dato
public interface IPersonaFunctionUnaryOperator<T, R> {
	// recibe un argumento y retorna un tipo diferente
	R apply(T arg1);
	// provee mayor flexibilidad
}
