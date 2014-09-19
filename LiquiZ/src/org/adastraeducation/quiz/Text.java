package org.adastraeducation.quiz;
public class Text implements Displayable {
	
	private String text;
	
	public String getTagName() { return "Text"; }
	
	@Override
	public void writeHTML(StringBuilder b) {
		// TODO Auto-generated method stub
		b.append("<select>");
		b.append("<input type=\"radio\""+ text + "name=\"dynosaur1\">" + "<br>");	
		b.append("</select>");
		
	}
	@Override
	public void writeJS(StringBuilder b) {
		// TODO Auto-generated method stub
		b.append("new Text(1, \"" + text + "\")" );

	}
	@Override
	public void writeXML(StringBuilder b) {
		// TODO Auto-generated method stub
		b.append("<A correct= "+ text +"</A>");

		
	}
}
