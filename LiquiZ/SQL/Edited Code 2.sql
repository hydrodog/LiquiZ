-- MySQL Script generated by MySQL Workbench
-- Fri Sep 26 13:04:49 2014
-- Model: New Model    Version: 1.0
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Policies`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Policies` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Policies` (
  `PolID` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(255) NOT NULL,
  `Attempts` INT NOT NULL,
  `Timed` VARCHAR(1) NOT NULL,
  `TimeLimit` INT NULL,
  `ShowAns` VARCHAR(1) NOT NULL,
  `Scored` VARCHAR(1) NOT NULL,
  `Grade` INT NOT NULL,
  `ShuffleQues` VARCHAR(1) NOT NULL,
  `ShuffleAns` VARCHAR(1) NOT NULL,
  `AccessCode` VARCHAR(255) NULL,
  PRIMARY KEY (`PolID`),
  UNIQUE INDEX `PolID_UNIQUE` (`PolID` ASC))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mydb`.`Quizzes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Quizzes` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Quizzes` (
  `QuizID` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(255) NULL,
  `Desc` INT NULL,
  `Policy` INT NOT NULL,
  `Privacy` CHAR(1) NOT NULL,
  PRIMARY KEY (`QuizID`),
  UNIQUE INDEX `QID_UNIQUE` (`QuizID` ASC),
)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Questions`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Questions` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Questions` (
  `QuesID` INT NOT NULL AUTO_INCREMENT,
  `Points` INT NOT NULL,
  `Level` INT NULL,
  `Type` CHAR(4) NOT NULL,
  PRIMARY KEY (`QuesID`),
  UNIQUE INDEX `QuesID_UNIQUE` (`QuesID` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Courses`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Courses` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Courses` (
  `CourseID` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(255) NOT NULL,
  `Privacy` CHAR(1) NOT NULL,
  PRIMARY KEY (`CourseID`),
  UNIQUE INDEX `CID_UNIQUE` (`CourseID` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`CoursesQuizzes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`CoursesQuizzes` ;

CREATE TABLE IF NOT EXISTS `mydb`.`CoursesQuizzes` (
  `Course` INT NULL,
  `Quiz` INT NULL,
  `Order` INT NULL,
)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mydb`.`QuizzesQuesCons`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`QuizzesQuesCons` ;

CREATE TABLE IF NOT EXISTS `mydb`.`QuizzesQuesCons` (
  `Quiz` INT NOT NULL,
  `QuesCon` INT NOT NULL,
  `Order` INT NOT NULL,
)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`QuesConElements`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`QuesConElements` ;

CREATE TABLE IF NOT EXISTS `mydb`.`QuesConElements` (
  `QuesCon` INT NOT NULL,
  `Order` INT NOT NULL,
  `Element` INT NULL,
  `Ques` INT NULL,
  `Type` CHAR(4) NOT NULL,
)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mydb`.`Answers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Answers` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Answers` (
  `AnsSet` INT NOT NULL,
  `Order` INT NOT NULL,
  `Correct` VARCHAR(1) NOT NULL DEFAULT 'Y',
  `Response` INT NULL,
  `Element` INT NULL COMMENT 'What represents the answer',
  `LowBound` INT NULL COMMENT 'to accept a range of numbers (lower bound)',
  `HighBound` INT NULL COMMENT 'to accept a range of numbers (upper bound)',
)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`DispElSeq`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`DispElSeq` ;

CREATE TABLE IF NOT EXISTS `mydb`.`DispElSeq` (
  `DispEl` INT NOT NULL,
  `Element` VARCHAR(255) NOT NULL,
  `Order` INT NOT NULL,
  `Type` CHAR(4) NOT NULL,
)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mydb`.`StdChoiceSeq`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`StdChoiceSeq` ;

CREATE TABLE IF NOT EXISTS `mydb`.`StdChoiceSeq` (
  `StdChoice` INT NOT NULL,
  `Element` INT NOT NULL,
  `Order` INT NOT NULL,
)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`QuesAns`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`QuesAns` ;

CREATE TABLE IF NOT EXISTS `mydb`.`QuesAns` (
  `Ques` INT NOT NULL,
  `AnsSet` INT NULL,
  `StdChoice` INT NULL,
)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Users` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Users` (
  `UserID` INT NOT NULL AUTO_INCREMENT,
  `FirstName` VARCHAR(255) NOT NULL,
  `LastName` VARCHAR(255) NOT NULL,
  `Username` VARCHAR(255) NOT NULL,
  `Password` VARCHAR(255) NOT NULL,
  `Email` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`UserID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`UsersCourses`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`UsersCourses` ;

CREATE TABLE IF NOT EXISTS `mydb`.`UsersCourses` (
  `User` INT NOT NULL,
  `Course` INT NOT NULL,
  `Role` CHAR(4) NOT NULL,
)
ENGINE = InnoDB;

USE `mydb` ;

-- I created views in order to see how the tables would fit together

-- -----------------------------------------------------
-- Placeholder table for view `mydb`.`ViewQuiz`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ViewQuiz` (`QuesCon` INT, `QuesID` INT, `Element` INT);

-- -----------------------------------------------------
-- Placeholder table for view `mydb`.`ViewQuizWAns`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ViewQuizWAns` (`QuesCon` INT, `Element` INT, `QuesID` INT, `Points` INT);

-- -----------------------------------------------------
-- View `mydb`.`ViewQuiz`
-- -----------------------------------------------------
DROP VIEW IF EXISTS `mydb`.`ViewQuiz` ;
DROP TABLE IF EXISTS `mydb`.`ViewQuiz`;
USE `mydb`;
CREATE  OR REPLACE VIEW `ViewQuiz` AS
SELECT QuizzesQuesCons.QuesCon, DispElSeq.Element, Questions.QuesID
FROM QuizzesQuesCons
LEFT JOIN QuesConElements ON QuizzesQuesCons.QuesCon = QuesConElements.QuesCon
LEFT JOIN Questions ON QuesConElements.Ques = Questions.QuesID
LEFT JOIN DispElSeq ON QuesConElements.Element = DispElSeq.DispEl
AND QuizzesQuesCons.Quiz="1" -- just an example quiz
ORDER BY QuizzesQuesCons.Order, QuesConElements.Order, DispElSeq.Order ASC;

-- -----------------------------------------------------
-- View `mydb`.`ViewQuizWAns`
-- -----------------------------------------------------
DROP VIEW IF EXISTS `mydb`.`ViewQuizWAns` ;
DROP TABLE IF EXISTS `mydb`.`ViewQuizWAns`;
USE `mydb`;
CREATE  OR REPLACE VIEW `ViewQuizWAns` AS
SELECT QuizzesQuesCons.QuesCon, DispElSeq.Element, Questions.QuesID, Questions.Points 
FROM QuizzesQuesCons
LEFT JOIN QuesConElements ON QuizzesQuesCons.QuesCon = QuesConElements.QuesCon
LEFT JOIN Questions ON QuesConElements.Ques = Questions.QuesID
LEFT JOIN QuesAns ON Questions.QuesID = QuesAns.Ques
LEFT JOIN Answers ON QuesAns.AnsSet = Answers.AnsSet AND Answers.Correct="Y"
LEFT JOIN DispElSeq ON QuesConElements.DispEl = DispElSeq.DispEl AND Answers.Element = DispElSeq.DispEl
WHERE QuizzesQuesCons.Quiz="1" -- just an example quiz
ORDER BY QuizzesQuesCons.Order, QuesConElements.Order, DispElSeq.Order ASC;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
