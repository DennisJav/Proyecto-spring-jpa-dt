package ec.edu.interfaces.funcionales;
@FunctionalInterface
public interface IPersonaPredicate<T>{
	//recibe un argumento lo procesa y devuelve un bolleano
	
	boolean evaluar(T arg1);
}
