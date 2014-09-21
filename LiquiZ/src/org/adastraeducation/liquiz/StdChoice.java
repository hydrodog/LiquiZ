package org.adastraeducation.liquiz;

/**
 * @author dkruger
 *
 */
public class StdChoice {
	private String name;
	private Answer[] answers;

	public StdChoice(String stdChoiceName, String[] options) {

		answers = new Answer[options.length / 2];

		if (stdChoiceName.equalsIgnoreCase("Standard Question")) {

			for (int i = 0, j = 0; i < options.length; i += 2, j++) {
				answers[j] = new Answer(options[i], options[i + 1].equals("t"));
			}

		} else if (stdChoiceName.equalsIgnoreCase("Poll")) {

			for (int i = 0, j = 0; i < options.length; i += 2, j++) {
				answers[j] = new Answer(options[i],
						Integer.parseInt(options[i + 1]));
			}

		}

	}

	public void writeHTML(StringBuilder b) {
		for (int i = 0; i < answers.length; i++)
			b.append("<input type=\"radio\" name='").append(name).append("'>")
					.append(answers[i].getAnswer()).append("<br>");
	}

	public void writeXML(StringBuilder b) {
		for (int i = 0; i < answers.length; i++)
			answers[i].writeXML(b);
	}
}
