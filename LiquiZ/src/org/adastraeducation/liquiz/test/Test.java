package org.adastraeducation.liquiz.test;
import org.adastraeducation.liquiz.equation.*;
import java.io.*;
import java.util.Scanner;
import java.beans.XMLEncoder;
import java.beans.XMLDecoder;

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
		quiz.setId(1);
		quiz.setName("Animals");
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

		Equation eq = new Equation
		(
			new Plus
			(
				new Var("x", 0, 99, 1),	
				new Var("y", 0, 99, 1)	
			)
		);
		qc = new QuestionContainer(
			new Displayable[] {
				new Text("What is "),
				eq,
				new Text("?"),
				new FillIn(3, 1, 1)
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
	public static void writeXML(String filename, Quiz quiz) throws IOException {
		XMLEncoder enc = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filename)));
		enc.writeObject(quiz);
		enc.close();
	}

	public static Quiz readXML(String filename) throws IOException {
		XMLDecoder dec = new XMLDecoder(new BufferedInputStream(new FileInputStream(filename)));
		Quiz q = (Quiz)dec.readObject();
		dec.close();
		return q;
	}

	public static void main(String[] args) throws IOException {
		StringBuilder b = new StringBuilder(65536);
		Quiz quiz = test1();
		quiz.writeHTML(b);
		writeHTML("output/test1.html", b);
		writeXML("output/test1.xml", quiz);
	}

}
