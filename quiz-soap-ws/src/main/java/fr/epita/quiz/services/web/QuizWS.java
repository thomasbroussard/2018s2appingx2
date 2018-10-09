package fr.epita.quiz.services.web;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import fr.epita.quiz.services.web.transport.QuestionMessage;

@WebService
public interface QuizWS {

	
	@WebMethod
	public void saveQuestion(QuestionMessage questionMessage);
	
	@WebMethod
	public List<QuestionMessage> listQuestions(QuestionMessage questionMessageCriteria);
	
}
