package org.adastraeducation.liquiz.util;

/*
 * author: Yingzhu
 * This is QuizPattern to create the rules for limiting users' input
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuizPattern {
	private String regex;
	Pattern p;
	
	public QuizPattern(String regex){
		this.regex=regex;
		p=Pattern.compile(regex);
	}
	
	//match the input whether they are right
	public boolean match(String input){
		Matcher m = p.matcher(input);
		if(m.matches())
			return true;
		else
			return false;
	}
}
