package org.adastraeducation.quiz;

public abstract class Question implements Displayables{
	
	private int id,points,level;

	private static int count; // for general unique id

	
	public Question() {}
	public Question (int id, int points, int level) {
		this.id=id;
		this.points= points;
		this.level= level;
	}	
	
	static {
		count = 0;
	}

	public Question(int points, int level) {
	}
		
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public abstract String getTagName();
	
	protected void writeAttrs(StringBuilder b) {
		writeAttr(b, "id", id);
		writeAttr(b, "level", String.valueOf(level));
		writeAttr(b, "points", String.valueOf(points));
	}

	protected static void writeAttr(StringBuilder b, String tag, String val) {
		b.append(tag).append("=\"").append(val).append("\" ");
	}

	protected static void writeAttr(StringBuilder b, String tag, int val) {
		b.append(tag).append("=\"").append(val).append("\" ");
	}

	protected static void writeOptAttr(StringBuilder b, String tag, boolean val) {
		if (val) {
			b.append(tag).append("=\"").append(val).append("\" ");
		}
	}
	

	public abstract void writeHTML(StringBuilder b);
	public abstract void writeJS(StringBuilder b);
	public abstract void writeXML(StringBuilder b);
	

}
