package org.adastraeducation.liquiz;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.adastraeducation.liquiz.util.NumberWarningPattern;

public class FillIn extends Question {
	private ArrayList<Answer> answers;
	
	private NumberWarningPattern warningPattern=null;

	public FillIn(int id, int points, int level) {
		super(id, points, level);
	}
	
	public FillIn(int id, int points, int level, ArrayList<Answer> answers) {
		super(id, points, level);
		this.answers=answers;
	}
	
	
	public FillIn(int id, int points, int level, NumberWarningPattern warning) {
		super(id, points, level);
		this.warningPattern=warning;
	}
	
	public FillIn(int id, int points, int level, NumberWarningPattern warning, ArrayList<Answer> answers) {
		super(id, points, level);
		this.warningPattern=warning;
		this.answers=answers;
	}
	
	public String getTagName() { return "FillIn"; }
	
	
	public ArrayList<Answer> getAnswers(){
		return answers;
	}
	
	public void setAnswers(ArrayList<Answer> answers){
		this.answers=answers;
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


}
