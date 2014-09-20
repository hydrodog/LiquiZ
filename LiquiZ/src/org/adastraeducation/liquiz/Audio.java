package org.adastraeducation.liquiz;

public class Audio implements Displayable {
	private String audio;
	private String type;
	
	public Audio(String audio){
		this.audio= audio;		
	}
	//<source src="horse.ogg" type="audio/ogg">
	//<source src="horse.mp3" type="audio/mpeg">
	public void writeHTML(StringBuilder b){
		b.append("<audio controls>");
		b.append("<source src=" + audio + "type ="+ type + ">");
		b.append("</audio>");
	}
	// to do : how to represent image in JavaScript
	public void writeJS(StringBuilder b){
		b.append("new Audio(1, \"" + audio + "\")");
	}
	
	public void writeXML(StringBuilder b) {
		b.append("<A correct=\"" + audio + "\"> </A>");
	}

}
