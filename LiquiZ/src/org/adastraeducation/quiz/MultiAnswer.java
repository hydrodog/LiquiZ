package org.adastraeducation.quiz;

public class MultiAnswer extends Answer{

	private String[] answer;

	public MultiAnswer() {
	}

	public MultiAnswer(String [] answer) {
	//
	}
	
	public String getTagName() {
		return "MultipleChoice Answer";
	}

	public void writeHTML(StringBuilder b ){
		
		for (int i = 0; i < answer.length; i++){
			b.append("<select multiple>");
			b.append("<option> value= " + answer[i] + "\">  </option> ");
			b.append("</select>");
			b.append("</br>");
        }
	}
	public void writeJS(StringBuilder b ){
		for (int i = 0; i < answer.length; i++){
			b.append("new MultipleChoice(" +answer[i] +")");
		}
	}
	public void writeXML(StringBuilder b) {
		for (int i = 0; i < answer.length; i++)
			b.append("<A v=\"").append(answer[i]).append("</A>");
	}
	
	
}
