INSERT INTO Users (FirstName, LastName, Username, Password, Email)
VALUES ("Yijin", "Kang", "yijkan", "password", "yijinkang@gmail.com");

INSERT INTO Courses (Name, Privacy)
VALUES ("Intro Java", "a");

INSERT INTO Policies (PolID, Name, Timed, ShowAns, Scored, Grade, ShuffleQues, ShuffleAns)
VALUES (1, "Homework", "N", "Y", "N", "10", "N", "N");

INSERT INTO Quizzes (Name, Policy, Privacy)
VALUES ("ThisIsAQuiz", 1, "a");

--Elements to go into first qc
INSERT INTO DispElSeq
VALUES (1, "What is the color of the sky?", 1, "text");
INSERT INTO DispElSeq
VALUES (1, "Example of longer text", 2, "text");

INSERT INTO Questions
VALUES (1, 3, 1, "Fill");
INSERT INTO Answers(AnsID, Element);
VALUES (1, "Blue");
INSERT INTO Answers(AnsID, Element);
VALUES (2, "Light Blue");

--Connect questions to answers
INSERT INTO QuesAnsSeq (Ques, Ans, Sequence, Correct);
VALUES (1, 1, 1, "Y");
INSERT INTO QuesAnsSeq (Ques, Ans, Sequence, Correct);
VALUES (1, 2, 2, "Y");

--Add DispEls and Questions to qc
INSERT INTO QuesConElements (QuesCon, Sequence, Element)
VALUES (1, 1, 1)
INSERT INTO QuesConElements (QuesCon, Sequence, Ques)
VALUES (1, 2, 1)

--Elements to go into second qc
INSERT INTO DispElSeq
VALUES (2, "image.jpg", 1, "img");
INSERT INTO DispElSeq
VALUES (3, "Which animal is shown in the picture?", 1, "text");

INSERT INTO Questions
VALUES (2, 5, 2, "Mult");
INSERT INTO Answers(AnsID, Element);
VALUES (3, "Dog");
INSERT INTO Answers(AnsID, Element);
VALUES (4, "Cat");
INSERT INTO Answers(AnsID, Element);
VALUES (5, "Fox");

INSERT INTO QuesAnsSeq (Ques, Ans, Sequence, Correct);
VALUES (2, 3, 1, "N");
INSERT INTO QuesAnsSeq (Ques, Ans, Sequence, Correct);
VALUES (2, 4, 2, "Y");
INSERT INTO QuesAnsSeq (Ques, Ans, Sequence, Correct);
VALUES (2, 5, 3, "N");

INSERT INTO QuesConElements (QuesCon, Sequence, Element)
VALUES (2, 1, 2);
INSERT INTO QuesConElements (QuesCon, Sequence, Element)
VALUES (2, 2, 3);
INSERT INTO QuesConElements (QuesCon, Sequence, Ques)
VALUES (2, 3, 2);

--Connect QuesCons to Quiz
INSERT INTO QuizzesQuesCons
VALUES (1, 1, 1);
INSERT INTO QuizzesQuesCons
VALUES (1, 2, 2);

--Yijin Kang has admin permissions over Quiz 1
INSERT INTO UserPermissions
VALUES (1, 1, "Quiz", 1);