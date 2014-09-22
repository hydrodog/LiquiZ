package org.adastraeducation.liquiz.test;
import org.adastraeducation.liquiz.equation.*;

import java.io.*;
import java.util.HashMap;
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
		// for multiChoiceDropDown
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
		
		//for Equation
		Var x = new Var("x", 0, 99, 1);
		Var y = new Var("y", 0, 99, 1);
		HashMap<String,Var> map = new HashMap<String,Var>();
		map.put("x",x);
		map.put("y", y);
		Equation eq = new Equation(	"x+y",map);
		
		qc = new QuestionContainer(
			new Displayable[] {
				new Text("What is "),
				eq,
				new Text("?"),
				new FillIn(3, 1, 1)
			}
			);
		quiz.addQuestionContainer(qc);

		qc = new QuestionContainer(
				new Displayable[] {
					new Video("1.mpg"),
					new Text("Describe the main character in the video in 200 words or less"),
					new Essay()
				}
			);
		quiz.addQuestionContainer(qc);
		
		qc = new QuestionContainer(
				new Displayable[] {
					new Text("Listen to the audio clip and write down the words"),
					new Audio("1.mp3"),
					new FillIn(5,1,1)
				}
			);
		quiz.addQuestionContainer(qc);

		// create two random 3x3 matrices filled with integers [-3..3]
		Matrix m1 = new Matrix(3,3,-3,3);
		Matrix m2 = new Matrix(3,3,-3,3);
		// create a 3x3 matrix worth 1 point, level 1
		MatrixQuestion m3 = new MatrixQuestion(1, 1, 3, 3);
		quiz.addQuestionContainer(qc = new QuestionContainer(
			new Displayable[] {
				new Text("Solve the matrix addition"),
				m1,
				new Text("+"),
				m2,
				m3
			}
		));

		return quiz;
	}
	/*
	 * Create a multimedia quiz (video, audio, and questions)
	 */
	public static Quiz test2() {
		Quiz quiz = new Quiz();
		Response qc = new Response(
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
		String s = buf.toString();
		fw.write(s);
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
