package com.wentjiang.examtool;

import java.util.*;

public class QuestionPicker {

    public static void main(String[] args) {
        QuestionPicker questionPicker = new QuestionPicker();
        questionPicker.randomPickQuestions(100,65);
    }

    public List<Integer> randomPickQuestions(int totalNum, int pickNum) {
        List<Integer> questionNums = new ArrayList<>(pickNum);
        if (pickNum > totalNum) {
            throw new IllegalStateException("Total number must greater than pick number");
        }
        Set<Integer> numberSet = new HashSet<>();
        for (int i = 1; i < totalNum + 1; i++) {
            numberSet.add(i);
        }
        for (int i = pickNum; i > 0; i--) {
            Random random = new Random();
            int num = random.nextInt(numberSet.size());
            questionNums.add(num);
        }
        return questionNums;
    }
}


