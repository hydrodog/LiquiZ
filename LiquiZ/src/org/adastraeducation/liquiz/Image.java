package org.adastraeducation.liquiz;

public class Image implements Displayable {
	private String imgQuestion;
	private String width;
	private String height;
	private String [] ans;
	
	public Image(){
		ans = null;		
	}
	public void writeHTML(StringBuilder b){
		b.append("<img src='" + imgQuestion + "'style = width:"+ width + "px;height:"+ height + "px>");
		b.append("<select>");
		b.append("<input type='radio'" + ans + "<br>");
		b.append("</select>");
	}
	// to do : how to represent image in JavaScript
	public void writeJS(StringBuilder b){
		b.append("new Image(1, '" + ans + "')");
	}
	
	public void writeXML(StringBuilder b) {
		b.append("<A correct='" + ans + "'> </A>");
	}

}


/* 
 <select id="pic-changer">
  <option value="none">None selected</option>
  <option value="cat" data-picture="cat.png">cat</option>
  <option value="dog" data-picture="dog.jpg">dog</option>
</select>

*/
