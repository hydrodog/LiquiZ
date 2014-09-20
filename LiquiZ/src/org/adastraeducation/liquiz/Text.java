package org.adastraeducation.liquiz;

public class Text implements Displayable {
	private String text;
	
	public String getTagName() { return "Text"; }
	
	@Override
	public void writeHTML(StringBuilder b) {
		b.append("<select>");
		b.append("<input type=\"radio\""+ text + "name=\"dynosaur1\">" + "<br>");	
		b.append("</select>");
		
	}
	@Override
	public void writeJS(StringBuilder b) {
		b.append(text);
	}
	@Override
	public void writeXML(StringBuilder b) {
		b.append("<text>").append(text).append("</text>");
	}
}
