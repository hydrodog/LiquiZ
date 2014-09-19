package org.adastraeducation.quiz;
 

public class Image implements Displayable {
	private String image;
	private String width;
	private String height;
	
	public Image(String image){
		this.image= image;
	}
	
	public Image(String image, String width, String height){
		this.image= image;
		this.height= height;
		this.width= width;
	}
	public void writeHTML(StringBuilder b){
		b.append("<img src=" + image + "style = width:"+ width + "px;height:"+ height + "px>");
	}
	// to do : how to represent image in JavaScript
	public void writeJS(StringBuilder b){
		b.append("new Image(1, \"" + image + "\")");
	}
	
	public void writeXML(StringBuilder b) {
		b.append("<A correct=\"" + image + "\"> </A>");
	}

}
