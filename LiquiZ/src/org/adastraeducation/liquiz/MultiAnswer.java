package org.adastraeducation.liquiz;

public class MultiAnswer extends MultiChoiceDropdown {
	private Answer [] answers;

	public MultiAnswer() {
	}

	public MultiAnswer(int id, int level, int points, 
			Answer[] answers) {
		super(id, level, points, answers);
	}
	public MultiAnswer(int level, int points, 
			Answer[] answers) {
		super(level, points, answers);
	}
	
	public String getTagName() {
		return "MultiAnswer";
	}

	//TODO: the html is wrong here, you need values between <option> and </option>
	public void writeHTML(StringBuilder b ){		
		for (int i = 0; i < answers.length; i++){
			b.append("<select multiple>");
			b.append("<option value= '" + answers[i].getAnswer() + "'>  </option> ");
			b.append("</select>");
			b.append("</br>");
        }
	}
	public void writeJS(StringBuilder b ){
		for (int i = 0; i < answers.length; i++){
			b.append("new MultipleChoice(" +answers[i].getAnswer() +")");
		}
	}	
}
