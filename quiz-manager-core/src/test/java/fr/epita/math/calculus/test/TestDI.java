package fr.epita.math.calculus.test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class TestDI {

	private static final Logger LOGGER = LogManager.getLogger(TestDI.class);
	@Inject
	String selectQuery;

	@Inject
	DataSource ds;

	@BeforeClass
	public static void beforeAll() {
		// executed before any test
	}

	@Before
	public void before() {
		// method that will be executed before each test
	}

	@Test
	public void testDI() {
		// given
		// given is implicit by the presence of the selecQuery property

		// when
		// I launch the program

		// then
		Assert.assertNotNull(selectQuery);
		LOGGER.info("selectQuery : " + selectQuery);

	}

	@Test
	public void testDS() {
		// given
		// given is implicit by the presence of the ds property

		// when
		String schema = null;
		try (Connection connection = ds.getConnection();) {
			schema = connection.getSchema();
		} catch (SQLException e) {
			LOGGER.error(e);
		}

		// then
		Assert.assertNotNull(schema);
		LOGGER.info("selectQuery : " + schema);

	}

}
