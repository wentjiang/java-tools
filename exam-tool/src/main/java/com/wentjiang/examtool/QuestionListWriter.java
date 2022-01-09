package com.wentjiang.examtool;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class QuestionListWriter {

    public static void main(String[] args) {
        QuestionListWriter questionListWriter = new QuestionListWriter();
        questionListWriter.writeQuestionAsFile(136, "examTopic/examTopicAnswer.txt");
    }

    public void writeQuestionAsFile(int number, String fileName) {
        File file = new File(fileName);
        try (FileWriter fileWriter = new FileWriter(file)) {
            for (int i = 1; i < number + 1; i++) {
                fileWriter.write(i + ":\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
