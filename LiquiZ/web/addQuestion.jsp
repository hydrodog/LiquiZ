<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ page import="org.adastraeducation.liquiz.*"%>

<jsp:useBean id="quiz" class="org.adastraeducation.liquiz.Quiz" scope="session"/>

<%
	Util.addQuestion(quiz, request);
    
%>

<%= Util.showQuiz(quiz) %>
Quiz now has: <%= quiz.getQuestionCount() %> questions in <%= quiz.getQuestionContainerCount() %> question containers.