package org.adastraeducation.liquiz;

import java.util.ArrayList;
import java.util.Random;

public class Quiz implements Displayable {
	public static Random r;
	
	static {
		/*
		 *  if there are any random numbers to be gotten,
		 *  everyone should get them out of the quiz like:
		 *  Quiz.r.nextInteger()
		 */
		r = new Random();
	}
	public static int random(int a, int b) {
		return a + r.nextInt(b-a);
	}
	public static double random(double a, double b) {
		return a + r.nextDouble() * (b-a);
	}
	// TODO: make this escape strings in single quotes
	public static String escapeJS(String s) {
		return s;
	}
	// TODO: make this escape strings in single quotes
	public static String escapeXML(String s) {
		return s;
	}
	private ArrayList<QuestionContainer> qContainers;
	private Policies Plc ; 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private int id; // unique id for db and XML
	private String name; // display name, possibly per Course?
	
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
		b.append("</div>\n");
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
