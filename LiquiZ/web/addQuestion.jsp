<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ page import="org.adastraeducation.liquiz.*"%>

<jsp:useBean id="quiz" class="org.adastraeducation.liquiz.Quiz" scope="session"/>

<%
	QuestionContainer qc = new QuestionContainer();
	String title = request.getParameter("title");
	qc.add(new Text(title));
    String questionText = request.getParameter("question_text");
    qc.add(new Text(questionText));
	
   	int points = 1;
   	try {
   		points = Integer.parseInt(request.getParameter("points"));
   	} catch(Exception e) {
   	}

	int level = 1;
	try {   
   		level = Integer.parseInt(request.getParameter("level"));
   	} catch(Exception e) {
   		//TODO: do nothing and level will default to 1 if error?
   	}

    Question q = null;
	String questType = request.getParameter("question_type");
	if (questType.equals("FillIn")) {
	    String answerText = request.getParameter("answer");
	    String warningPattern = request.getParameter("warningPattern");
	    boolean hasWarning = warningPattern != null;
	    System.out.println(hasWarning); // TODO: CHECK!
	  	Answer answer = new Answer(answerText, true);
       	q = new FillIn(points, level, answer, null, null, null);
	} else if (questType.equals("MultiChoice")) {
		int numChoices = Integer.parseInt(request.getParameter("multichoice_number"));
		Answer[] answers = new Answer[numChoices];
		for (int i = 0; i < numChoices; i++) {
		  String choice = request.getParameter("choices" + (i+1));
		  answers[i] = new Answer(choice, false);
		}
		q = new MultiChoiceDropdown(level, points, answers);
		  
	}

    qc.add(q);
    quiz.addQuestionContainer(qc);
    StringBuilder b = new StringBuilder(65536);
    quiz.writeHTML(b);
%>

<%= b %>
Quiz now has: <%= quiz.getQuestionCount() %> questions in <%= quiz.getQuestionContainerCount() %> question containers.