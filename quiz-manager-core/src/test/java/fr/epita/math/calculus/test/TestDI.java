package fr.epita.math.calculus.test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/applicationContext.xml")
public class TestDI {

	@Inject
	String selectQuery;
	
	@Inject
	DataSource ds;
	
	
	
	@Test
	public void testDI() {
		// given
		// given is implicit by the presence of the selecQuery property
		
		// when
		// I launch the program
		
		// then
		Assert.assertNotNull(selectQuery);
		System.out.println("selectQuery : " + selectQuery);
		
		
	}
	@Test
	public void testDS() {
		// given
		// given is implicit by the presence of the ds property
		
		// when
		String schema = null;
		try (Connection connection = ds.getConnection();){
			schema = connection.getSchema();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		// then
		Assert.assertNotNull(schema);
		System.out.println("selectQuery : " + schema);
		
		
	}
	
}
