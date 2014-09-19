package org.adastraeducation.quiz;

public class Audio implements Displayables {
	private String audioQuestion;
	private String type;
	private String [] answer;
	
	public Audio(){
		answer = null;		
	}
	//<source src="horse.ogg" type="audio/ogg">
	//<source src="horse.mp3" type="audio/mpeg">
	public void WriteHTML(StringBuilder b){
		b.append("<audio controls>");
		b.append("<source src=" + audioQuestion + "type ="+ type + ">");
		b.append("<select>");
		b.append("<input type=\"radio\"" + answer + "<br>");
		b.append("</audio>");
	}
	// to do : how to represent image in JavaScript
	public void WriteJS(StringBuilder b){
		b.append("new Audio(1, \"" + answer + "\")");
	}
	
	public void WriteXML(StringBuilder b) {
		b.append("<A correct=\"" + answer + "\"> </A>");
	}

}
