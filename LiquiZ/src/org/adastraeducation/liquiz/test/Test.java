package org.adastraeducation.liquiz.test;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.adastraeducation.liquiz.*;
public class Test {
	private static String header, trailer;
	private static char[] buf;
	private static String load(String filename) throws IOException {
		FileReader fr = new FileReader(filename);
		int len = 16384;
		StringBuilder b = new StringBuilder(len);
		int charsRead;
		while ((charsRead = fr.read(buf)) > 0) {
			b.append(buf, 0, charsRead-1);
		}
		return b.toString();
	}
	static {
		buf = new char[4096];
		try {
			header = load("header.html");
			trailer = load("trailer.html");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
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
		quiz.addQuestionContainer(qc);
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
	public static void writeHTML(String filename, StringBuilder buf) throws IOException {
		FileWriter fw = new FileWriter(filename);
		fw.write(header);
		fw.write(buf.toString());
		buf.setLength(0);
		fw.write(trailer);
		fw.close();
	}
	public static void main(String[] args) throws IOException {
		StringBuilder b = new StringBuilder(65536);
		Quiz quiz = test1();
		quiz.writeHTML(b);
		writeHTML("output/test1.html", b);
	}

}
