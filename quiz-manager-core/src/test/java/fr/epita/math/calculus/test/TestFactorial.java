package fr.epita.math.calculus.test;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import fr.epita.math.calculus.Factorial;

public class TestFactorial {

	private static final Logger LOGGER = LogManager.getLogger(TestFactorial.class);
			
			
	@Test
	public void testDefault() {
		// Given 
		int n = 3;
		
		// When
		int result = Factorial.calculate(n);
		
		// Then
		Assert.assertEquals(6,result);
		
		LOGGER.info("got this result : " + result);
	}
	
	
}
