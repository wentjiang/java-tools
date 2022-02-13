package com.wentjiang.examtool;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class QuestionListWriter {

    public void writeQuestionAsFile(int from, int size, String fileName) {
        File file = new File(fileName);
        try (FileWriter fileWriter = new FileWriter(file)) {
            for (int i = from; i < from + size; i++) {
                fileWriter.write(i + ":\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
