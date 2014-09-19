package org.adastraeducation.liquiz;

public class Answer implements Displayable {
	private String ans;
	private boolean correct;
	public Answer(String ans, boolean correct) {
		this.ans = ans;
		this.correct = correct;
	}
	public Answer(String ans) {
		this(ans, false);
	}
	public Answer() { this(null, false); }
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

	//TODO: Dov says add graphical answer back in here once it works
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
