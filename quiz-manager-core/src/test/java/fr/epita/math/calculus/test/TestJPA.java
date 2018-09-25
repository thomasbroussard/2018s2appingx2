package fr.epita.math.calculus.test;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.quiz.datamodel.Question;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class TestJPA {

	private static final Logger LOGGER = LogManager.getLogger(TestJPA.class);

	@Inject
	@Named("sessionFactory")
	SessionFactory sf;
	private static boolean isInit = false;

	@Before
	public void before() {
		if (!isInit) {
			// initialization code here

			isInit = true;
		}
	}

	@Test
	public void testSessionFactory() {

		// given
		Question question = new Question();
		question.setQuestionLabel("What is JPA ?");

		// when
		Session session = this.sf.openSession();

		Transaction tx = session.beginTransaction();
		session.save(question);
		tx.commit();
		session.close();

		// then
		Session sessionCheck = this.sf.openSession();

		Query<Question> searchQuery = sessionCheck.createQuery("from Question", Question.class);
		List<Question> list = searchQuery.list();
		LOGGER.info(list);
		Assert.assertNotEquals(0, list.size());
		
		sessionCheck.close();

	}

}
