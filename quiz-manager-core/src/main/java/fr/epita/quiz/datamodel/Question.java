package fr.epita.quiz.datamodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Cette entité est associée à une table en base de données.
 * 
 * @author tbrou
 *
 */
@Entity
public class Question {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String questionLabel;
	
	public Question() {
		
	}
	
	
	

	public Question(String questionLabel) {
		this.questionLabel = questionLabel;
	}




	public String getQuestionLabel() {
		return questionLabel;
	}

	public void setQuestionLabel(String questionLabel) {
		this.questionLabel = questionLabel;
	}

}
