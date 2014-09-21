package org.adastraeducation.liquiz;


public class MultiChoiceRadio extends MultiChoiceDropdown {
	public MultiChoiceRadio() {
	}

	public MultiChoiceRadio(int id, int level, int points,
				Answer[] answers) {
		super(id, level, points, answers);
	}
	public MultiChoiceRadio(int level, int points,
			Answer[] answers) {
	super(level, points, answers);
}

	public String getTagName() {
		return "MultiChoiceRadio";
	}

	public void writeHTML(StringBuilder b ){
		b.append("<select>");
		for (int i = 0; i < answers.length; i++){
			b.append("<option> <input type='radio' value= '" + answers[i].getAnswer() + "'> "+ answers[i].getAnswer() +" </option> ");
		}
		b.append("</select>");
		b.append("</br>");
	}

	public void writeJS(StringBuilder b ) {
		for (int i = 0; i < answers.length; i++) {
			b.append("multichoice(").append(answers[i].getAnswer()).append(')');
		}
	}
	
	
}
