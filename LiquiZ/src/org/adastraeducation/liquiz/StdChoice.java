package org.adastraeducation.liquiz;


import java.util.HashMap;


public class StdChoice {
	private String name;
	private Answer[] answers;
	private HashMap<String, Answer[]> opinion = new HashMap<String, Answer[]>();
	

	public StdChoice(String name ) {
		this.name = name;
		hashMapStdChoice();
		this.answers =  opinion.get(name);
	}

	
	private void hashMapStdChoice() {
		opinion = new HashMap<String, Answer[]>();

		opinion.put("Poll", new Answer[] {new Answer("Strongly Agree"),
			    new Answer("Agree"), new Answer("No Opinion"),
			    new Answer("Disagree"),new Answer("Strongly Disagree")
			  });
	}
	
	public void writeHTML(StringBuilder b) {
		for (int i = 0; i < answers.length; i++)
			b.append("<input type=\"radio\" name='").append(name).append("'>")
					.append(answers[i].getAnswer()).append("<br>");
	}

	public void writeXML(StringBuilder b) {
		for (int i = 0; i < answers.length; i++)
			answers[i].writeXML(b);
	}
