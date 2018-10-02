package fr.epita.quiz.resources;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.services.data.QuestionDS;
import fr.epita.quiz.transport.QuestionMessage;

@Path("/questions")
public class QuestionResource {


	@Inject
	QuestionDS ds;
	
	@GET
	@Path("/")
	@Produces(value = { MediaType.APPLICATION_JSON })
	public List<QuestionMessage> findAllQuestions() {
		final List<Question> questions = ds.search(new Question());
		final List<QuestionMessage> messages = new ArrayList<>();
		for (final Question question : questions) {
			final QuestionMessage message = new QuestionMessage();
			message.setTitle(question.getQuestionLabel());
		}
		return messages;
	}