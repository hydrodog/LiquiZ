package org.adastraeducation.liquiz;

public class Image implements Displayable {
	private String width;
	private String height;
	private String [] name;
	
	public Image(){
		ans = null;		
	}
	//TODO: Add Image constructor here!!
	
	
	public void writeHTML(StringBuilder b){
		b.append("<img src='" + name + "' style = width:"+ width + "px;height:"+ height + "px>");
	}
	// to do : how to represent image in JavaScript
	//TODO: image id should not be hardcoded to 1!!!
	public void writeJS(StringBuilder b){
		b.append("image(1, '" + ans + "')");
	}
	
	public void writeXML(StringBuilder b) {
		b.append("<image name='").append( nameA correct='" + ans + "'> </A>");
	}

}


/* 
 <select id="pic-changer">
  <option value="none">None selected</option>
  <option value="cat" data-picture="cat.png">cat</option>
  <option value="dog" data-picture="dog.jpg">dog</option>
</select>

*/
