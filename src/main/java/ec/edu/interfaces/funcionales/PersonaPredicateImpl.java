package ec.edu.interfaces.funcionales;

public class PersonaPredicateImpl implements IPersonaPredicate<String>{

	@Override
	public boolean evaluar(String arg1) {
		// TODO Auto-generated method stub
		System.out.println("Si esta en predicate");
		return false;
	}

	
}
