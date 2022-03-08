package ec.edu.interfaces.funcionales;

@FunctionalInterface
public interface IPersonaFunction <T,R>{
	//recibe un argumento y retorna un tipo diferente
	R apply(T arg1);
	//provee mayor flexibilidad
}
