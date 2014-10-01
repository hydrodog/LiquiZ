package org.adastraeducation.liquiz;
import org.adastraeducation.liquiz.util.*;

/*
 * author: Yingzhu
 * This is to create RegexQuestion
 */

import java.util.ArrayList;

public class RegexQuestion extends FillIn {	
	
	private QuizPattern pattern; //The regex pattern that will be used
	
	//constructors
	public RegexQuestion(int id, int points, int level, QuizPattern pattern) {
		super(id,points,level);
		this.pattern = pattern;
	}
	
	public RegexQuestion(int id, int points, int level, NumberWarningPattern warningPattern, QuizPattern pattern) {
		super(id,points,level, warningPattern);
		this.pattern = pattern;
	}
	

	
	public String getTagName() { return "RegexQuestion"; }
	
	public void setPattern(QuizPattern pattern){
		this.pattern = pattern;
	}
	
	public QuizPattern getPattern(){
		return pattern;
	}
	

}
