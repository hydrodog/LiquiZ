/* Quizzes are organized into courses */

import java.util.ArrayList;

public class Course implements Displayable {
	private String id, name;
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
		b.append("<div class='quizList'>\n");
		for (Quiz q : quizzes) {
			b.append("<div class='quizName'>" + q.getName() + "</div>\n");
			b.append("<div class='quizPol'>" + q.getPolicies() + "</div>\n");
		}
		b.append("</div>");
	}

	public void writeXML(StringBuilder b) {
		b.append("<quizList id='' courseName='" + name + "'>");
		for (Quiz q : quizzes) {
			b.append("<quizName policy='" + q.getPolicies() + "'>" + q.getName() + "</quizName>\n");
		}
		b.append("</quizList>");
	}

	public void writeJS(StringBuilder b) {
		b.append("quizList([");
		for (Quiz q : quizzes) {
			q.writeJS(b);
		}
		b.append("]");
	}
}