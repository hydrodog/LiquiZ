package org.adastraeducation.quiz;

// To Do: Standard Choice

public class MultiChoiceDropdown extends Answer {
	private StdChoice stdchoice;
	private String choices;
	private String [] answer;
	private String imgName;
	private boolean imgAnswer;


	public MultiChoiceDropdown() {}

	public MultiChoiceDropdown(String choices, String imgQuestion, String answer, String imgAnswer) {
		imgQuestion.equals("t");		
	}
	public MultiChoiceDropdown(String imgQuestion, StdChoice c, String choices){
		//super
		imgQuestion.equals("t");
		this.choices = choices;
		stdchoice = c;
	}

	public String getTagName() { return "MultipleChoice Drop-down";}

	public void writeHTML(StringBuilder b ){
		if(this.choices.equals("stdopinion")||this.choices.equals("complexity")||this.choices.equals("poll"))
			this.stdchoice.writeHTML(b);
		else
			for (int i = 0; i < this.answer.length; i++) {
				if (imgAnswer){
					b.append("<select id= \"pic-data\" data-placeholder= \"Pick an Answer...\" class=\"chosen-select drop singledrop question\">");
					b.append("<option value=\""+ imgName +"\">");
					b.append(" <img src=\"" + answer +"/>");
					b.append("</option>");
				}
				else 
					b.append("ques");
					b.append("<select>");
					b.append("<input type=\"radio\""+ answer + "name=\"dynosaur1\">" + "<br>");	
					b.append("</select>");
			}
		
			b.append("<select>");
			b.append("<option value = " + answer + "\">  </option> ");
			b.append("</select>");
			
	}
	
	public void writeJS(StringBuilder b ){	
			b.append("new MultipleChoice(" +answer +")");
	}
	
	public void writeXML(StringBuilder b) {
			b.append("<A v=\"").append(answer).append("</A>");
	}
	
	public boolean isCorrect(String[] ans) {
		// TODO Auto-generated method stub
		return false;
	}
	public double gradeIt(String[] answers) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}