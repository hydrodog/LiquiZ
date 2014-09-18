package org.adastraeducation.quiz;
public class Text implements Displayables {
	
	private String answer;
	
	public String getTagName() { return "Text"; }
	
	@Override
	public void WriteHTML(StringBuilder b) {
		// TODO Auto-generated method stub
		b.append("<select>");
		b.append("<input type=\"radio\""+ answer + "name=\"dynosaur1\">" + "<br>");	
		b.append("</select>");
		
	}
	@Override
	public void WriteJS(StringBuilder b) {
		// TODO Auto-generated method stub
		b.append("new Text(1, \"" + answer + "\")" );

	}
	@Override
	public void WriteXML(StringBuilder b) {
		// TODO Auto-generated method stub
		b.append("<A correct= "+ answer +"</A>");

		
	}
}
