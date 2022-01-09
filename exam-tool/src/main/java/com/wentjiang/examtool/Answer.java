package com.wentjiang.examtool;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Answer {
    private int questionNum;
    private List<String> answers;

    public Answer(int questionNum, List<String> answers) {
        this.questionNum = questionNum;
        this.answers = answers;
    }

    public int getQuestionNum() {
        return questionNum;
    }

    public void setQuestionNum(int questionNum) {
        this.questionNum = questionNum;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public static Answer decodeAnswer(String strAnswer) {
        if (strAnswer == null || strAnswer.trim().length() == 0) {
            throw new IllegalStateException(strAnswer + " not a valid answer");
        }
        String[] strs = strAnswer.split(":");
        assert strs.length == 2;
        List<String> answers = Arrays
                .stream(strs[1].trim().toUpperCase().split(""))
                .sorted()
                .collect(Collectors.toList());
        return new Answer(Integer.parseInt(strs[0].trim()), answers);
    }
}
