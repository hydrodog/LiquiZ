package org.adastraeducation.liquiz;

/**
 * @author dkruger
 *
 */
public class StdChoice {
	private String name;
	private Answer[] answers;
	public StdChoice(String[] options) {
		answers = new Answer[options.length/2];
		for (int i = 0, j = 0; i < options.length; i+=2, j++) {
			answers[j] = new Answer(options[i], options[i+1].equals("t"));
		}
	}
	
	public void writeHTML(StringBuilder b){
		for(int i = 0; i < answers.length; i++)
			b.append("<input type=\"radio\" name='")
			.append(name).append("'>").append(answers[i].getAnswer()).append("<br>");
	}
	public void writeXML(StringBuilder b) {
		for (int i = 0; i < answers.length; i++)
			answers[i].writeXML(b);
	}
}
