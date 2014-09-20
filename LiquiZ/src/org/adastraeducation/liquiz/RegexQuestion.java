package org.adastraeducation.liquiz;
import org.adastraeducation.liquiz.util.*;

import java.util.ArrayList;

public class RegexQuestion extends FillIn {	
	private QuizPattern pattern;
	public RegexQuestion(int id, int points, int level,
			QuizPattern pattern) {
		super(id,points,level);
		this.pattern = pattern;
	}
	
//	public RegexQuestion(int id, int points, int level,QuizPattern pattern, ArrayList<Answer> answers) {
//		super(id,points,level);
//		this.pattern = pattern;
//		this.answers=answers;
//	}
	
	public String getTagName() { return "RegexQuestion"; }
	
	public void setPattern(QuizPattern pattern){
		this.pattern = pattern;
	}
	
	public QuizPattern getPattern(){
		return pattern;
	}
	
	public boolean isCorrect(String[] asnwer){
		
		return false;
	}

}
