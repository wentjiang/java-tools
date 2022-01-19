package com.wentjiang.examtool.exams;

import com.wentjiang.examtool.AnswerChecker;
import com.wentjiang.examtool.QuestionListWriter;
import com.wentjiang.examtool.QuestionPicker;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

public class ExamTopic_DA_operator {

    @org.junit.jupiter.api.Test
    public void pickQuestions() {
        QuestionPicker questionPicker = new QuestionPicker();
        List<Integer> questions = questionPicker.randomPickQuestions(130, 65);
        questionPicker.getQuestionsAsFile(questions);
    }

    @Test
    public void questionList() {
        QuestionListWriter questionListWriter = new QuestionListWriter();
        String myAnswerFileName = "myAnswer-" + LocalDateTime.now() + ".txt";
        questionListWriter.writeQuestionAsFile(130, myAnswerFileName);
    }

    @Test
    public void generateReport() {
        AnswerChecker answerChecker = new AnswerChecker();
        String prefix = "examTopic/";
        String myAnswerFileName = "myAnswer-2022-01-10T22:41:11.425959.txt";

        String rightAnswerPath = prefix + "examTopicAnswer.txt";
        String myAnswerPath = prefix + "myAnswer/" + myAnswerFileName;
        String reportFile = "report-" + myAnswerFileName;
        answerChecker.checkAnswer(rightAnswerPath, myAnswerPath, reportFile);
    }
}
