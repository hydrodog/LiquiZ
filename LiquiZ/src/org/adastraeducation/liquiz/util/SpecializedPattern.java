package org.adastraeducation.liquiz.util;

/*
 * author: Yingzhu
 * I create some patterns that users can directly use.
 */

public class SpecializedPattern {
	public static QuizPattern MASS = new QuizPattern("([0-9|.]+)(kg|kilogram)");
	public static QuizPattern LENGTH = new QuizPattern("([0-9|.]+)(m|meter)");
	public static QuizPattern TIME = new QuizPattern("([0-9|.]+)(s|second)");
	public static QuizPattern VELOCITY = new QuizPattern("([0-9|.]+)(m\\/s|meter\\/second)");
}
