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
import fr.epita.quiz.services.data.MCQChoiceDAO;
import fr.epita.quiz.services.data.QuestionDAO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class TestJPA {

	private static final Logger LOGGER = LogManager.getLogger(TestJPA.class);

	@Inject
	@Named("sessionFactory")
	SessionFactory sf;
	
	@Inject
	QuestionDAO questDAO;
	
	@Inject
	MCQChoiceDAO mcqDAO;
	
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
		questDAO.create(question);

		// then*
		Question criteria = new Question();
		criteria.setQuestionLabel("JPA");
		List<Question> list = questDAO.search(criteria);
		LOGGER.info(list);
		Assert.assertNotEquals(0, list.size());

	}

}
