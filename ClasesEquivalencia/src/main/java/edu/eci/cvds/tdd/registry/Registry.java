package edu.eci.cvds.tdd.registry;

import java.util.ArrayList;

public class Registry {
	private ArrayList<Person> registros = new ArrayList<Person>();
    public RegisterResult registerVoter(Person p) {
    	// El estado empieza en valido y con cada verificación este estado puede cambiar.
    	RegisterResult resultado=RegisterResult.VALID;
    	// Verificar si la persona esta muerta.
		if( p.isAlive()==false) resultado = RegisterResult.DEAD;
		// Verificar si la persona tiene menos de 130 años y que sea una edad valida.
		else if(p.getAge()>130 || p.getAge()<0) resultado = RegisterResult.INVALID_AGE;
		// Verificar si la persona tiene mas de 18 años.
		else if(p.getAge()<18) resultado = RegisterResult.UNDERAGE;
		// Verificar si que no exista esa misma persona en el registro o una persona con el mismo id.
		else {
			for(Person cont:registros) {
				if(p.getId()==cont.getId()) resultado = RegisterResult.DUPLICATED;
			}
		}
		
		if(resultado==RegisterResult.VALID) registros.add(p);
		
        // TODO Validate person and return real result.
        return resultado;
    }
}