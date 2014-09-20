package org.adastraeducation.liquiz;

import java.util.ArrayList;

public class Quiz implements Displayable {
	private ArrayList<QuestionContainer> qContainers;
	private Policies Plc ;  
	
	public Quiz() {
		qContainers = new ArrayList<QuestionContainer>();
		Plc = new Policies();
	}
	
	public Quiz(Policies plc) {
		this.qContainers = new ArrayList<QuestionContainer>();
		this.Plc = plc;
	}
	
	public Policies getPolicies(){
		return this.Plc;
	}
	
	public void setPolicies(int num,boolean timed, int duration, 
			boolean showAns,boolean scored,int grade, boolean shuffle, String accessCode){
		this.Plc.setAttemptNum(num);
		this.Plc.setTimed(timed);
		this.Plc.setDuration(duration);
		this.Plc.setShowAns(showAns);
		this.Plc.setScored(scored);
		this.Plc.setGrade(grade);
		this.Plc.setShuffle(shuffle);
		this.Plc.setAccessCode(accessCode);
	}
	
	public ArrayList<QuestionContainer> getQuestionContainers() {
		return this.qContainers;
	}
	
	public void addQuestionContainer(QuestionContainer qc) {
		qContainers.add(qc);
	}
	
	public void deleteQuestionContainer(int Index) {
		qContainers.remove(Index);
	}
	
	public void QuizSetUp() {
		
	}
	
	public void writeHTML (StringBuilder b)	{
		b.append("<div class='quiz'>\n");
		for(QuestionContainer qc : this.qContainers) {
			qc.writeHTML(b);
		}
		b.append("</div>");
	}
	
	public void writeXML (StringBuilder b) {
		b.append("<quiz id='' title=''>");
		for(QuestionContainer qc: this.qContainers) {
			qc.writeXML(b);
		}
		b.append("</quiz>");
	}
	
	public void writeJS (StringBuilder b) {
		b.append("{ title: '', ... [");
		for(QuestionContainer qc: this.qContainers) {
			qc.writeJS(b);
		}
		b.append("]");
	}
}
