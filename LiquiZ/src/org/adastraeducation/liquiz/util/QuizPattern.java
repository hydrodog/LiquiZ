package org.adastraeducation.liquiz.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuizPattern {
	private String regex;
	Pattern p;
	
	public QuizPattern(String regex){
		this.regex=regex;
		p=Pattern.compile(regex);
	}
	
	public boolean match(String input){
		Matcher m = p.matcher(input);
		if(m.matches())
			return true;
		else
			return false;
	}
}
