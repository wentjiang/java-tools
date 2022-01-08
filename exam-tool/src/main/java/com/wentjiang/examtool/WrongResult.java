package com.wentjiang.examtool;

import java.util.List;

public class WrongResult {
    private int question;
    private List<String> rightAnswer;
    private List<String> yourAnswer;

    public WrongResult(int question, List<String> rightAnswer, List<String> yourAnswer) {
        this.question = question;
        this.rightAnswer = rightAnswer;
        this.yourAnswer = yourAnswer;
    }

    public int getQuestion() {
        return question;
    }

    public void setQuestion(int question) {
        this.question = question;
    }

    public List<String> getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(List<String> rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public List<String> getYourAnswer() {
        return yourAnswer;
    }

    public void setYourAnswer(List<String> yourAnswer) {
        this.yourAnswer = yourAnswer;
    }

    @Override
    public String toString() {
        return "WrongResult{" +
                "question=" + question +
                ", rightAnswer=" + rightAnswer +
                ", yourAnswer=" + yourAnswer +
                '}';
    }
}
