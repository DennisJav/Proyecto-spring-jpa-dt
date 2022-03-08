package ec.edu.interfaces.funcionales;

@FunctionalInterface
public interface IPersonaConsumer<T> {
	//recibe argumentos pero no retornos
	public void accept(T arg1);
	
	//el nombre se adquiere por el numero de argumentos en todas las interfaces funcionales
	//bi tri tetra y mas
	
}
