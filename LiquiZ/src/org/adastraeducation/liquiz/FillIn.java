package org.adastraeducation.liquiz;

/*
 * author: Yingzhu
 * This is for Fillin question
 */

import java.io.FileNotFoundException;

import org.adastraeducation.liquiz.util.NumberWarningPattern;

public class FillIn extends Question {
	private Answer answer;
	
	//This is a regular expression to give a warning if users' input is not suitable for our rules
	private NumberWarningPattern warningPattern=null;

	public FillIn(int id, int points, int level) {
		super(id, points, level);
	}
	/**
	 * Convenience Constructor: create a fillin question with a 
	 * single (correct) string answer (and convert to internal Answer)
	 * @param id
	 * @param points
	 * @param level
	 * @param answer
	 */
	public FillIn(int id, int points, int level, String answer) {
		super(id, points, level);
		this.answer = new Answer(answer, true);
	}
	
	public FillIn(int id, int points, int level, String answer) {
		super(id, points, level);
		this.answer = new Answer(answer);
	}
	
	public FillIn(int id, int points, int level, Answer answer) {
		super(id, points, level);
		this.answer=answer;
	}
	
	
	public FillIn(int id, int points, int level, NumberWarningPattern warning) {
		super(id, points, level);
		this.warningPattern=warning;
	}
	
	public FillIn(int id, int points, int level, NumberWarningPattern warning, Answer answer) {
		super(id, points, level);
		this.warningPattern=warning;
		this.answer=answer;
	}
	
	public String getTagName() { return "FillIn"; }
	
	
	public Answer getAnswer(){
		return answer;
	}
	
	public void setAnswers(Answer answer){
		this.answer=answer;
	}

	public NumberWarningPattern getWarningPattern() {
		return warningPattern;
	}

	public void setWarningPattern(NumberWarningPattern warningPattern) {
		this.warningPattern = warningPattern;
	}

	@Override
	public void writeHTML(StringBuilder b) {
		b.append("<input id='").append(getId()).append("' class='fillin' type='text' ");
		if(warningPattern!=null)
			b.append("onblur=\"showWarning(this.id,").append(warningPattern.getLimit()+")\"");
		b.append(">");
		if(warningPattern!=null)
			b.append(" <div  id=\"FW").append(this.getId()).append("\"></div>");
		b.append("\n");
		
	}

	@Override
	public void writeJS(StringBuilder b) {
		b.append("fillin()");
	}

	@Override
	public void writeXML(StringBuilder b) {
		b.append("<fillin/>");
	}

	@Override
	public boolean isCorrect(String s) {
		// TODO Auto-generated method stub
		return false;
	}


}
