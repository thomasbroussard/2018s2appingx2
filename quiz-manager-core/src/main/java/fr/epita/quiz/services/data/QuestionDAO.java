package fr.epita.quiz.services.data;

import java.util.List;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import fr.epita.quiz.datamodel.Question;

@Repository
public class QuestionDAO extends GenericDAO<Question>{

	private static final Logger LOGGER = LogManager.getLogger(QuestionDAO.class);
	
	@Inject
	private SessionFactory sf;

	

	public List<Question> search(Question criteria) {
		String searchQuery = "from Question as question where question.questionLabel like :searchString";
		Session session = getSession();
		Query<Question> query = session.createQuery(searchQuery, Question.class);
		query.setParameter("searchString", "%" + criteria.getQuestionLabel() + "%");
		return query.list();
		
	}



	@Override
	public Class<Question> getGenericClass() {
		// TODO Auto-generated method stub
		return Question.class;
	}



}
