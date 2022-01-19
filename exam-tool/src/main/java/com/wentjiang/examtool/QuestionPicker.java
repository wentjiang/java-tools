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

    public List<Integer> randomPickQuestions(int totalNum, int pickNum) {
        List<Integer> questionNums = new ArrayList<>(pickNum);
        if (pickNum > totalNum) {
            throw new IllegalStateException("Total number must greater than pick number");
        }
        for (int i = 1; i <= pickNum; i++) {
            questionNums.add(i);
        }
        for (int i = pickNum + 1; i <= totalNum; i++) {
            if (Math.random() * i >= pickNum) continue;
            questionNums.set((int) (Math.random() * pickNum), i);
        }
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


