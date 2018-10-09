package fr.epita.quiz.services.web.transport;

import java.util.List;

public class QuestionMessage {
	
	private String questionLabel;
	
	private List<MCQChoiceMessage> mcqChoiceLabel;

	public String getQuestionLabel() {
		return questionLabel;
	}

	public void setQuestionLabel(String questionLabel) {
		this.questionLabel = questionLabel;
	}

	public List<MCQChoiceMessage> getMcqChoiceLabel() {
		return mcqChoiceLabel;
	}

	public void setMcqChoiceLabel(List<MCQChoiceMessage> mcqChoiceLabel) {
		this.mcqChoiceLabel = mcqChoiceLabel;
	}

	
	
}
