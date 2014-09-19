package org.adastraeducation.quiz;


public class StdChoice extends Answer {
	private String [] answer;
	private String choices; // e.g. choices could be poll, stdopinion, complexity
	StdChoice(String [] answer, String choices){
		this.answer = answer;
		this.choices = choices;
	}
	
	public void writeHTML(StringBuilder b){
		for(int i = 0; i < answer.length; i++){
			b.append("<select>");
			b.append("<input type=\"radio\"  value = " + answer[i] + "name=\""+ choices +"\">  </option> ");
			b.append("</select>");
		}
	}
	public void WriteJS(StringBuilder b){
		b.append("");
	}
	
	public void writeXML(StringBuilder b){
		for(int i = 0; i < answer.length; i++)
			b.append("<A v=\"").append(answer[i]).append("\">").append(answer[i]).append("</A>");
	}
}
