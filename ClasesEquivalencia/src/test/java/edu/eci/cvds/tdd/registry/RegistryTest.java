package edu.eci.cvds.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {

    private Registry registry = new Registry();
    
    @Test
    public void validateDEAD() {
    	Person person = new Person("Pepito", 1, 19, Gender.MALE, false);
    	
    	RegisterResult result = registry.registerVoter(person);
    	
    	Assert.assertEquals(RegisterResult.DEAD, result);
    }
    
    @Test
    public void validateUNDERAGE() {
    	Person person = new Person("Pepito", 1, 16, Gender.MALE, true);
    	
    	RegisterResult result = registry.registerVoter(person);
    	
    	Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }
    
    @Test
    public void validateINVALID_AGE_negativo() {
    	Person person = new Person("Pepito", 1, -2, Gender.MALE, true);
    	
    	RegisterResult result = registry.registerVoter(person);
    	
    	Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }
    
    @Test
    public void validateINVALID_AGE_mayor() {
    	Person person = new Person("Pepito", 1, 200, Gender.MALE, true);
    	
    	RegisterResult result = registry.registerVoter(person);
    	
    	Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }
    
    @Test
    public void validateDUPLICATED() {
    	Person person = new Person("Pepito", 1, 20, Gender.MALE, true);
    	
    	Person personDuplicated = new Person("Juanita", 1, 100, Gender.FEMALE, true);
    	
    	RegisterResult result = registry.registerVoter(person);
    	result = registry.registerVoter(personDuplicated);
    	
    	Assert.assertEquals(RegisterResult.DUPLICATED, result);
    }

}