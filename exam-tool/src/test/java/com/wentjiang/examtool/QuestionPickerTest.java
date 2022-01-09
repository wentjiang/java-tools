package com.wentjiang.examtool;

import org.junit.jupiter.api.Assertions;

import java.util.List;

class QuestionPickerTest {

    private QuestionPicker questionPicker = new QuestionPicker();

    @org.junit.jupiter.api.Test
    void randomPickQuestions() {
        List<Integer> questions = questionPicker.randomPickQuestions(100, 65);
        Assertions.assertEquals(65,questions.size());
    }
}