package org.adastraeducation.liquiz;

import java.util.ArrayList;

public class MultiChoiceDropdown extends Question {
	protected Answer[] answers;
	private StdChoice stdchoice;

	public MultiChoiceDropdown() {
	}

	public MultiChoiceDropdown(int id, int level, int points, Answer[] answers) {
		super(id, level, points);
		this.answers = answers.clone();
	}

	public MultiChoiceDropdown(int level, int points, Answer[] answers) {
		super(level, points);
		this.answers = answers.clone();
	}

	/*
	 * TODO: Here you have to look up a standard choice, put it in here and not
	 * use the answers.
	 */
     // I have changed it the code complies now
	public MultiChoiceDropdown(int level, int points, String stdChoiceName, String[] options) {
		super(level, points);
		stdchoice = new StdChoice(stdChoiceName, options);
			
	}

	public String getTagName() {
		return "MultiChoice";
	}

	public void writeHTML(StringBuilder b) {
		// Standard Choice options
		if (stdchoice != null) {

			stdchoice.writeHTML(b);

		} else {

			// Regular options
			b.append("<select>");
			for (int i = 0; i < answers.length; i++) {
				b.append("<option value='" + answers[i].getAnswer() + "'> "
						+ answers[i].getAnswer() + " </option> ");
			}
			b.append("</select>");
			b.append("</br>");
		}

	}

	public void writeJS(StringBuilder b) {
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
