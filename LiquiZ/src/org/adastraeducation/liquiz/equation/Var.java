package org.adastraeducation.liquiz.equation;

import org.adastraeducation.liquiz.Quiz;

public class Var implements Expression{
	private double operand;
	private String name;
	private int min;
	private int step;
	private int max;
	
	public Var(String name, int min, int step, int max){
		this.name = name;
		this.min=min;
		this.step=step;
		this.max=max;
		Quiz.random(min,  max, step);
	}
	
	public Var(String name, double x){
		this.name=name;
		this.operand=x;
	}
	
	public double eval(){
		return operand;
	}
	
	public void infix(StringBuilder b){
		b.append(name);
	}
	
	public void rpn(StringBuilder b){
		b.append(name);
	}
	
	public void infixReplaceVar(StringBuilder b){
		b.append(operand);
	}
	
	public void rpnReplaceVar(StringBuilder b){
		b.append(operand);
	}
}
