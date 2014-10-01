/**
 * Quizzes are organized into courses
 */

package org.adastraeducation.liquiz;

import java.util.ArrayList;

public class Course implements Displayable {
	private String id, name, className; // classname is for user to override HTML class for style
	private ArrayList<Quiz> quizzes;

	public Course() {}

	public Course(String id, String name) {
		this.id = id;
		this.name = name;
		quizzes = new ArrayList<Quiz>();
	}

	public String getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getNoOfQzs() {
		return quizzes.size();
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addQuiz(Quiz q) {
		quizzes.add(q);
	}

	public void deleteQuiz(int i) {
		quizzes.remove(i);
	}

	public void writeHTML(StringBuilder b) {
		b.append("<div class='coursename'>" + name + "</div>");
		b.append("<div class='quizList " + className + "'>\n");
		for (Quiz q : quizzes) {
			b.append("<div class='quizName'>" + q.getName() + "</div>\n"); 
		}
		b.append("</div>");
	}

	public void writeXML(StringBuilder b) {
		b.append("<quizList id='" + id + "' courseName='" + name + "'>");
		for (Quiz q : quizzes) {
			q.writeXML(b);
		}
		b.append("</quizList>");
	}
	//TODO: writing out only some quizzes?

	public void writeJS(StringBuilder b) {
		b.append("quizlist(");
		for (Quiz q : quizzes) {
			b.append("quizref('" + q.getName() + "'");
			b.append(',').append(q.getId()).append(")");
		}
		b.append(")");
	}
	//for jquery
}