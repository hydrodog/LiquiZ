package org.adastraeducation.liquiz;

public class LiquiZUser extends User {

	public static final int CREATE = 4; // & edit and delete
	public static final int EDIT = 8; // only
	public static final int DELETE = 16; // delete only???
	public static final int COPY = 32;
	public static final int GRADE = 64;
	public static final int READ = 128;
}