import org.adastraeducation.quiz.MultiChoice;
import org.adastraeducation.quiz.Quiz;
import org.adastraeducation.quiz.StdChoice;


/**
 * Represent a set of answers to multiple choice questions that are reused
 * @author qiang
 *
 */
public class StdChoice {
	private String[] options;
	private String[] answers;
	public StdChoice(String[] options){
		options = new String[options.length/2];
		answers = new String[options.length/2];
		for (int i = 0, j = 0; i < options.length; i+=2, j++) {
			answers[j] = options[i];
			options[j] = options[i+1];
		}
	}
	public static void testHTMLAndXML(QuizApp quiz){
		
		String[] a1 = {"Strongly Disagree", "1", "Disagree", "2", "No Opinion", "3", "Agree", "4", "Strongly Agree", "5"};
		StdChoice q1 = new StdChoice(a1);
		MultiChoice m3 = new MultiChoice("poll1", "1", "I enjoy studying computational complexity.", "f", standardchoice1, "stdopinion");
		
		MultiChoice m4 = new MultiChoice("poll1", "1", "I enjoy eating Chinese food.", "f", standardchoice1, "stdopinion");
		
		String[] a2 = {"O(1)", "1", "O(log_2 n)", "logn", "O(sqrt n)", "sqrtn", "O(n)", "n", "O(n log_2 n)", "nlogn", "O(n^2)", "n^2", "O(n^3)", "n^3"};
		StdChoice standardchoice2 = new StdChoice(a2);
		MultiChoice m5 = new MultiChoice("complexity", "1", "The complexity of insertion sort is:", "f", standardchoice2, "complexity");

		quiz.addQuestion(m1);
		quiz.addQuestion(m2);
		quiz.addQuestion(m3);
		quiz.addQuestion(m4);
		quiz.addQuestion(m5);

	}
	
	public void writeHTML(StringBuilder b){
		for(int i = 0; i < answers.length; i++)
			b.append("<input type=\"radio\" name=\"stdopinion\">").append(answers[i]).append("<br>");
	}
	public void writeXML(StringBuilder b){
		for(int i = 0; i < answers.length; i++)
			b.append("<A v=\"").append(values[i]).append("\">").append(answers[i]).append("</A>");
	}
}
