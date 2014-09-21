package org.adastraeducation.liquiz;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class FillIn extends Question {
	private ArrayList<Answer> answers;

	public FillIn(int id, int points, int level) {
		super(id, points, level);
	}
	
	public FillIn(int id, int points, int level, ArrayList<Answer> answers) {
		super(id, points, level);
		this.answers=answers;
	}
	
	public String getTagName() { return "FillIn"; }
	
	
	public ArrayList<Answer> getAnswers(){
		return answers;
	}
	
	public void setAnswers(ArrayList<Answer> answers){
		this.answers=answers;
	}

	@Override
	public void writeHTML(StringBuilder b) {
		b.append("<input name='").append(getId()).append("' class='fillin' type='text'>\n");
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
