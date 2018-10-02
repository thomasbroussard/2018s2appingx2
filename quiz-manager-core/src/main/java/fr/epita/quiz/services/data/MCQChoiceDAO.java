package fr.epita.quiz.services.data;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import fr.epita.quiz.datamodel.MCQChoice;


@Repository
public class MCQChoiceDAO extends GenericDAO<MCQChoice> {

	@Override
	public List<MCQChoice> search(MCQChoice criteria) {
		String searchQuery = "from MCQChoice where question = :question";
		Query<MCQChoice> query = getSession().createQuery(searchQuery, MCQChoice.class);
		query.setParameter("question", criteria.getQuestion());
		return query.list();
		
	}

	@Override
	public Class<MCQChoice> getGenericClass() {
		return MCQChoice.class;
	}

}
