package com.wentjiang.examtool;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class AnswerChecker {

    public static void main(String[] args) {

    }

    public void checkAnswer(String rightAnswerPath, String yourAnswerPath) {
        int rightCount = 0;
        int wrongCount = 0;

        List<WrongResult> wrongResults = new ArrayList<>();

        List<List<String>> rightAnswers = readAnswerAsList(rightAnswerPath);
        List<List<String>> yourAnswers = readAnswerAsList(yourAnswerPath);
        for (int i = 1; i < yourAnswers.size() + 1; i++) {
            if (isRight(rightAnswers.get(i), yourAnswers.get(i))) {
                rightCount++;
            } else {
                wrongCount++;
                wrongResults.add(new WrongResult(i, rightAnswers.get(i), yourAnswers.get(i)));
            }
        }

        showResultInConsole(rightCount,wrongCount,wrongResults);
    }

    private void showResultInConsole(int rightCount, int wrongCount, List<WrongResult> wrongResults) {
        int total = rightCount + wrongCount;
        double rightRate = (double)rightCount*100 / total;
        System.out.println("Summary---------------------");
        System.out.println("Total answer: " + total + ", right number: " + rightCount + ", wrong number: " + wrongCount + ", right rate: " + rightRate + "%");

        System.out.println("Detail wrong info-------------");
        wrongResults.stream().forEach(result ->{
            System.out.println(result.toString());
        });
    }

    private boolean isRight(List<String> rightAnswer, List<String> yourAnswer) {
        if (rightAnswer.size() != yourAnswer.size()) {
            return false;
        }
        return rightAnswer.containsAll(yourAnswer) && yourAnswer.containsAll(rightAnswer);
    }

    /**
     * support multiple choice answer, read as a char list
     */
    public List<List<String>> readAnswerAsList(String filePath) {
        List<List<String>> result = new ArrayList<>();
        try (
                FileInputStream inputStream = new FileInputStream(filePath);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))
        ) {
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                if (str.trim().length() > 0) {
                    List<String> answer = Arrays
                            .stream(str.trim().toUpperCase().split(""))
                            .sorted()
                            .collect(Collectors.toList());
                    result.add(answer);
                } else {
                    throw new IllegalStateException("check your file: " + filePath);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
