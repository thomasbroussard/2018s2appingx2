package fr.epita.quiz.services.web;

import java.util.List;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.epita.quiz.services.data.QuestionDS;
import fr.epita.quiz.services.web.transport.QuestionMessage;

public class QuizWSImpl implements QuizWS{

	private static final Logger LOGGER = LogManager.getLogger(QuizWSImpl.class);
	
	@Inject
	private QuestionDS ds;
	
	@Override
	public void saveQuestion(QuestionMessage questionMessage) {
		LOGGER.info("questionMessage {}", questionMessage);
	//	ds.createQuestionWithChoices(questionMessage, questionMessage.getMcqChoiceLabel());
	}

	@Override
	public List<QuestionMessage> listQuestions(QuestionMessage questionMessageCriteria) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
