package fr.epita.math.calculus.test;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.quiz.datamodel.MCQChoice;
import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.services.data.MCQChoiceDAO;
import fr.epita.quiz.services.data.QuestionDAO;
import fr.epita.quiz.services.data.QuestionDS;


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
	
	@Inject
	QuestionDS questionDS;
	
	private static boolean isInit = false;

	@Before
	public void before() {
		if (!isInit) {
			// initialization code here

			isInit = true;
		}
	}

	@Test
	public void testQuestionDAOCreateSearch() {

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
	
	@Test
	public void testQuestionDAOAndMCQChoiceDAOCreateSearch() {
		
		// given
		Question question = new Question();
		question.setQuestionLabel("What is JPA ?");
		MCQChoice choice1 = new MCQChoice("it is a specification to normalize ORM feature in Java", true, question);
			
		// when
		questDAO.create(question);
		mcqDAO.create(choice1);
		
		// then
		Question criteria = new Question();
		criteria.setQuestionLabel("JPA");
		List<Question> list = questDAO.search(criteria);
		LOGGER.info(list);
		Assert.assertNotEquals(0, list.size());
		MCQChoice criteriaChoice = new MCQChoice();
		criteriaChoice.setQuestion(list.get(0));
		List<MCQChoice> mcqChoices = mcqDAO.search(criteriaChoice);
		LOGGER.info(mcqChoices);
		Assert.assertNotEquals(0, mcqChoices.size());
		
		
	}
	
	@Test
	public void testQuestionDS() {
		
		// given
		Question question = new Question("What is JPA?");
		MCQChoice choice1 = new MCQChoice("it is a specification to normalize ORM feature in Java", true, question);
	
		
		// when
		questionDS.createQuestionWithChoices(question, choice1);
		
		// then
		Question criteria = new Question();
		criteria.setQuestionLabel("JPA");
		List<Question> list = questDAO.search(criteria);
		LOGGER.info(list);
		Assert.assertNotEquals(0, list.size());
		MCQChoice criteriaChoice = new MCQChoice();
		criteriaChoice.setQuestion(list.get(0));
		List<MCQChoice> mcqChoices = mcqDAO.search(criteriaChoice);
		LOGGER.info(mcqChoices);
		Assert.assertNotEquals(0, mcqChoices.size());
		
		
	}

}
