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
		b.append("<select multiple>\n");
		for (int i = 0; i < answers.length; i++){
			b.append("<option value= '").append(answers[i].getAnswer()).
				append("'>").append(answers[i].getAnswer())
				.append("</option>");
			b.append("<br/>\n");
        }
		b.append("</select>\n");
	}
	public void writeJS(StringBuilder b ){
		for (int i = 0; i < answers.length; i++){
			b.append("new MultipleChoice(" +answers[i].getAnswer() +")");
		}
	}	
}
