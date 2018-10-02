package fr.epita.quiz.services.data;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import fr.epita.quiz.datamodel.MCQChoice;
import fr.epita.quiz.datamodel.Question;

/**
 * Le but de la classe QuestionDS est de centraliser tous les accès de haut niveau (orienté métier)
 * @author tbrou
 *
 */
@Repository
public class QuestionDS {

	@Inject
	private MCQChoiceDAO mcqDao;
	
	@Inject
	private QuestionDAO questionDAO;
	
	
	/**
	 * Méthode permettant d'ajouter une question accompagnée de ses choix.
	 * @param question
	 * @param choices
	 */
	public void createQuestionWithChoices(Question question, MCQChoice... choices) {
		
		// when
		questionDAO.create(question);
		for (MCQChoice choice : choices) {
			choice.setQuestion(question);
			mcqDao.create(choice);
		}
		
	}
	
	/**
	 * Méthode permettant d'ajouter un choix à une question
	 * @param question
	 * @param choice
	 */
	public void addChoiceToQuestion(Question question, MCQChoice choice) {
		choice.setQuestion(question);
		//TODO vérifier les doublons.
		mcqDao.create(choice);
	}

	public List<Question> search(Question question) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
