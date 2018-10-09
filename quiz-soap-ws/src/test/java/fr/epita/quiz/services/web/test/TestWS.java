package fr.epita.quiz.services.web.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.quiz.services.web.QuizWS;
import fr.epita.quiz.services.web.transport.QuestionMessage;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class TestWS {

	@Inject
	QuizWS client;

	@Test
	public void testClient() {
		client.saveQuestion(new QuestionMessage());


	}
	

}
