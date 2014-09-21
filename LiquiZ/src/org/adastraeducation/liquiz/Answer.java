package org.adastraeducation.liquiz;

public class Answer implements Displayable {
	private String ans;
	private boolean correct;
	private String width; // for graphical answer
	private String height;// for graphical answer
	private int value; //poll values
	
	
	public Answer(String ans, boolean correct) {
		this.ans = ans;
		this.correct = correct;
	}
	public Answer(String ans) {
		this(ans, false);
	}
	public Answer() { this(null, false); }
	
	
    public Answer(String ans, int value) {
    	this.ans = ans;
    	this.value = value;
	}
    
	public void setAnswer(String answer){
		ans = answer;
	}
	public String getAnswer(){
		return ans;
	}
	public void setCorrect(boolean correct){
		this.correct = correct;
	}
	public  boolean getCorrect(){
		return correct;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	//TODO: Dov says add graphical answer back in here once it works
	// working on this
	public String graphanswer(){
		return "<input type=\"radio\" value = " + ans + "\" alt=\"" + ans + "\" width=\""+ width+"\" height=\""+height+"\"><br>";
	}

	public void writeHTML(StringBuilder b) {
		b.append("<input type='radio' name='")
				.append(ans).append("'>").append("<br>");
		
	}
	public void writeJS(StringBuilder b) {
		b.append('\'').append(ans).append('\'');
	}
	public void writeXML(StringBuilder b) {
		if (correct) {
			b.append("<A correct = 't'>");
		} else {
			b.append("<A>");
		}
		b.append(ans).append("</A>");
	}
}
