package org.adastraeducation.liquiz;

/*
 * author: Yingzhu
 * This is for Fillin question
 * I decide the merge regexQuestion and NumberQuestion with Fillin instead of extending it. 
 * I will temporarily save the original class. If it is proved that they are useless, 
 * I will delete them at last.
 */
/*
 * for ApproximateNumber Question, only 1 number is allowed to appear in the question.
 * For instance, "12 fadasd" is right. However, "13 KJKAJD 24" is wrong. Only 13 may be detected and 24 may be ignored. 
 */
import java.io.FileNotFoundException;

import org.adastraeducation.liquiz.util.NumberWarningPattern;
import org.adastraeducation.liquiz.util.QuestionPattern;
import org.adastraeducation.liquiz.util.Number;
import org.adastraeducation.liquiz.util.WarningPattern;

public class FillIn extends Question {
	private Answer answer;
	
	private QuestionPattern pattern;
	private boolean hasPattern;
	private Number appro;
	private boolean isNumber;
	
	//This is a regular expression to give a warning if users' input is not suitable for our rules
	private WarningPattern warningPattern;

	public FillIn(int id, int points, int level) {
		super(id, points, level);
		warningPattern = null;
		pattern = null;
		appro = null;
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
		warningPattern = null;
		pattern = null;
		appro = null;
	}
	
	public FillIn(int id, int points, int level, Answer answer) {
		super(id, points, level);
		this.answer=answer;
		warningPattern = null;
		pattern = null;
		appro = null;
	}
	
	public FillIn(int id, int points, int level, Answer answer, WarningPattern wp, QuestionPattern qp, Number number){
		super(id,points, level);
		this.answer = answer;
		this.warningPattern=wp;
		this.pattern = qp;
		this.appro = number;
	}
	
	
	//get Tag
	public String getTagName() { return "FillIn"; }
	
	// getter and setter
	public Answer getAnswer(){
		return answer;
	}
	
	public void setAnswers(Answer answer){
		this.answer=answer;
	}

	public WarningPattern getWarningPattern() {
		return warningPattern;
	}

	public void setWarningPattern(WarningPattern warningPattern) {
		this.warningPattern = warningPattern;
	}
	
	public boolean hasPattern() {
		return hasPattern;
	}
	private void setHasPattern(boolean hasPattern) {
		this.hasPattern = hasPattern;
	}
	public boolean isNumber() {
		return isNumber;
	}
	private void setIsNumber(boolean isNumber) {
		this.isNumber = isNumber;
	}
	
	public Number getAppro() {
		return appro;
	}
	public void setAppro(Number appro) {
		this.appro = appro;
		setIsNumber(true);
	}
	public void removeAppro(){
		this.appro=null;
		setIsNumber(false);
	}
	public QuestionPattern getPattern() {
		return pattern;
	}
	public void setPattern(QuestionPattern pattern) {
		this.pattern = pattern;
		setHasPattern(true);
	}
	public void removePattern(){
		this.pattern=null;
		setHasPattern(false);
	}

	@Override
	public void writeHTML(StringBuilder b) {
		b.append("<input id='").append(getId()).append("' class='fillin' type='text' ");
		if(warningPattern!=null&&warningPattern.getTag().equals("number"))
			b.append("onblur=\"showNumberWarning(this.id,").append(((NumberWarningPattern)warningPattern).getLimit()+")\"");
		b.append(">");
		if(warningPattern!=null&&warningPattern.getTag().equals("number"))
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
	
	/*
	 * Whether students' answers are right
	 */
	@Override
	
	public boolean isCorrect(String s) {
		if(pattern==null&&appro==null){
			if(s.equals(this.answer.getAns()))
				return true;
			else
				return false;
		}
		else if(pattern==null&&appro!=null){
			String ans = this.answer.getAns();
			double target = Double.parseDouble(ans);
			if(appro.equal(target))
				return true;
			else
				return false;
		}
		else if(pattern!=null&&appro==null){
			String ans = this.answer.getAns();
			if(pattern.isMatch(ans))
				return true;
			else
				return false;
		}
		else{
			String ans = this.answer.getAns();
			if(pattern.isMatch(ans)){
				String temp = pattern.getValue(ans);
				double target = Double.parseDouble(ans);
				if(appro.equal(target))
					return true;
			}
			return false;
		}
	}

}
