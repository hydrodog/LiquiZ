package org.adastraeducation.liquiz;
import org.adastraeducation.liquiz.util.*;

import java.util.ArrayList;

public class RegexQuestion extends FillIn {	
	
	private QuizPattern pattern; //The regex pattern that will be used
	
	//constructors
	public RegexQuestion(int id, int points, int level, String answer, QuizPattern pattern) {
		super(id,points,level, answer);
		this.pattern = pattern;
	}
	
	public RegexQuestion(int id, int points, int level, Answer answer, QuizPattern pattern) {
		super(id,points,level, answer);
		this.pattern = pattern;
	}
	
	public RegexQuestion(int id, int points, int level,
			Answer answer, NumberWarningPattern warningPattern, QuizPattern pattern) {
		super(id,points,level, warningPattern, answer);
		this.pattern = pattern;
	}
	

	
	public String getTagName() { return "RegexQuestion"; }
	
	public void setPattern(QuizPattern pattern){
		this.pattern = pattern;
	}
	
	public QuizPattern getPattern(){
		return pattern;
	}
	
	/*
	 * For regexQuestion, the answer will only store the value. It is necessary for it to store the pattern
	 */
	public boolean isCorrect(String s) {
		String temp = this.getAnswer().getAns();
		String ans = pattern.getValue(s);
		if(ans==null)
			return false;
		else{
			if(temp.equals(ans))
				return true;
			else
				return false;
		}
	}
	

}
