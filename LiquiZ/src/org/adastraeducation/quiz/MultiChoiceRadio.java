package org.adastraeducation.quiz;

public class MultiChoiceRadio extends MultiChoiceDropdown {
	private StdChoice stdchoice;
	private String choices;
	private String [] answer;
	private String imgName;
	private boolean imgAnswer;

	public MultiChoiceRadio() {
	}

	public MultiChoiceRadio(String[] choices, String answer) {
	//
	}
	
	public String getTagName() {
		return "MultipleChoice Radio-Button";
	}

	public void writeHTML(StringBuilder b ){
		if(this.choices.equals("stdopinion")||this.choices.equals("complexity")||this.choices.equals("poll"))
			this.stdchoice.writeHTML(b);
		else
			for (int i = 0; i < this.answer.length; i++) {
				if (imgAnswer){
					b.append("<select id= \"pic-data\" data-placeholder= \"Pick an Answer...\" class=\"chosen-select drop singledrop question\">");
					b.append("<option value=\""+ imgName +"\">");
					b.append(" <img src=\"" + answer +"/>"); // answer here is the image.jpg
					b.append("</option>");
				}
				else 
					b.append("ques");
					b.append("<select>");
					b.append("<input type=\"radio\""+ answer + "name=\"dynosaur1\">" + "<br>");	
					b.append("</select>");
			}
		
		
		b.append("<select>");
		b.append("<option> <input type=\"radio\" value= " + answer + "\">  </option> ");
		b.append("</select>");
		b.append("</br>");
   
	}
	public void writeJS(StringBuilder b ){
		b.append("new MultipleChoice(" +answer +")");
	}
	public void writeXML(StringBuilder b) {
		b.append("<A v=\"").append(answer).append("</A>");
	}
	
	
}
