package org.adastraeducation.liquiz;
import java.util.ArrayList;

public class MultiChoiceDropdown extends Question {
	protected Answer[] answers;
	
	public MultiChoiceDropdown() {
	}

	public MultiChoiceDropdown(int id, int level, int points,
		Answer[] answers) {
		super(id, level,points);
		this.answers = answers.clone();
	}

	public MultiChoiceDropdown(int level, int points,
			Answer[] answers) {
		super(level,points);
		this.answers = answers.clone();
	}
	/*
	 * TODO: Here you have to look up a standard choice, put it in here
	 * and not use the answers.
	 */
	public MultiChoiceDropdown(int level, int points,
			String stdChoiceName) {
			super(level,points);
			//TODO: FIX THIS! look up stdChoice!
			this.answers = answers.clone();
	}
	
	public String getTagName() { return "MultiChoice";}

	public void writeHTML(StringBuilder b ){
		b.append("<select class='dropdown'>\n");
		for (int i = 0; i < answers.length; i++){
			b.append("<option value='").append(answers[i].getAnswer())
			.append("'>").append(answers[i].getAnswer()).append("</option>\n");
			b.append("</br>");
        }
		b.append("</select>\n");
	}
	public void writeJS(StringBuilder b ){
		b.append("multichoice([");
		for (int i = 0; i < answers.length; i++) {
			answers[i].writeJS(b);
		}
	}
	public void writeXML(StringBuilder b) {
		for (int i = 0; i < answers.length; i++)
			answers[i].writeXML(b);
	}
}
