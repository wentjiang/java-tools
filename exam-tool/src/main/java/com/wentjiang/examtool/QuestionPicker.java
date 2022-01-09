package com.wentjiang.examtool;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Use question picker to pick questions
 */
public class QuestionPicker {

    public static void main(String[] args) {
        QuestionPicker questionPicker = new QuestionPicker();
        List<Integer> questions = questionPicker.randomPickQuestions(100, 65);
        questionPicker.getQuestionsAsFile(questions);
    }

    public List<Integer> randomPickQuestions(int totalNum, int pickNum) {
        List<Integer> questionNums = new ArrayList<>(pickNum);
        if (pickNum > totalNum) {
            throw new IllegalStateException("Total number must greater than pick number");
        }
        List<Integer> numberList = new ArrayList<>();
        for (int i = 1; i < totalNum + 1; i++) {
            numberList.add(i);
        }
        for (int i = pickNum; i > 0; i--) {
            Random random = new Random();
            int randomNum = random.nextInt(numberList.size());
            int questionNum = numberList.get(randomNum);
            numberList.remove(randomNum);
            questionNums.add(questionNum);
        }
        Collections.sort(questionNums);
        return questionNums;
    }

    public void getQuestionsAsFile(List<Integer> questions){
        String fileName = LocalDateTime.now() + ".txt";
        File file = new File(fileName);
        try (FileWriter writer = new FileWriter(file)) {
            questions.forEach(question -> {
                try {
                    writer.write(question + ":\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


