package org.adastraeducation.liquiz.test;
import java.io.FileWriter;
import java.io.IOException;

import org.adastraeducation.liquiz.*;
public class Test {
	public static Quiz test1() {
		Quiz quiz = new Quiz();
		QuestionContainer qc = new QuestionContainer(
			new Displayable[] {
				new Text("What is a dinosaur?"),
				new MultiChoiceDropdown(1, 1,
						new Answer[]{
							new Answer("T-Rex", true),
							new Answer("Shark"),
							new Answer("mouse")
						}
				)
			}
		);
		return quiz;
	}
	/*
	 * Create a multimedia quiz (video, audio, and questions)
	 */
	public static Quiz test2() {
		Quiz quiz = new Quiz();
		QuestionContainer qc = new QuestionContainer(
			new Displayable[] {
				new Video("1.mpg"),
				new MultiChoiceDropdown()
			}
		);
		return quiz;
	}
	public static void writeFile(String filename, StringBuilder buf) throws IOException {
		FileWriter fw = new FileWriter(filename);
		fw.write("testing testing");//buf.getChars(0, buf.size(), , dstBegin);)
		buf.setLength(0);
		fw.close();
	}
	public static void main(String[] args) throws IOException {
		StringBuilder b = new StringBuilder(65536);
		Quiz quiz = test1();
		quiz.writeHTML(b);
		writeFile("test1.html", b);
	}

}
