package org.adastraeducation.quiz;

public class Video implements Displayables {
	private String videoQuestion;
	private String width;
	private String height;
	private String type;
	private String [] ans;
	
	public Video(){
		ans = null;		
	}
	//<source src="movie.mp4" type="video/mp4">
	//<source src="movie.ogg" type="video/ogg">
	public void WriteHTML(StringBuilder b){
		b.append("<video width="+ width +" height="+ height +" controls>");
		b.append("<img src=" + videoQuestion +  "type ="+ type + ">");
		b.append("<select>");
		b.append("<input type=\"radio\"" + ans + "<br>");
		b.append("</video>");
	}
	// to do : how to represent image in JavaScript
	public void WriteJS(StringBuilder b){
		b.append("new Image(1, \"" + ans + "\")");
	}
	
	public void WriteXML(StringBuilder b) {
		b.append("<A correct=\"" + ans + "\"> </A>");
	}

}