package org.adastraeducation.liquiz;
import java.util.ArrayList;
import java.util.Arrays;

public class QuestionContainer implements Displayable {
	private ArrayList<Displayable> displayables;

	public QuestionContainer() {
		displayables = new ArrayList<Displayable>();
	}
	public QuestionContainer(Displayable[] list) {
		displayables = new ArrayList<Displayable>(Arrays.asList(list));
	}

	public ArrayList<Displayable> getDisplayables() {
		return this.displayables;
	}

	public void add(Displayable d){
		displayables.add(d);
	}

	public void delete(Displayable d){
		displayables.remove(d);
	}

	public void writeHTML (StringBuilder b) {
		b.append("<div class='question'>\n");
		for (Displayable d : displayables) {
			d.writeHTML(b);
		}
		b.append("</div>\n");
	}

	public void writeXML (StringBuilder b) {
		b.append("<Q>");
		for (Displayable d : displayables) {
			d.writeXML(b);
		}
		b.append("</Q>");
	}

	public void writeJS (StringBuilder b) {
		b.append("{title:... [");
		if (displayables.size() > 0) {
			displayables.get(0).writeJS(b);
			if (displayables.size() > 1) {
				for (int i = 1; i < displayables.size(); i++) {
					b.append(',');
					displayables.get(i);
				}
			}
		}
		b.append("] };");
	}
}
