package com.wentjiang.examtool;

import java.io.*;
import java.util.*;

public class AnswerChecker {

    public static void main(String[] args) {

    }

    public void checkAnswer(String rightAnswerPath, String yourAnswerPath) {
        int rightCount = 0;
        int wrongCount = 0;

        List<WrongResult> wrongResults = new ArrayList<>();

        Map<Integer,Answer> rightAnswers = readAnswerAsMap(rightAnswerPath);
        Map<Integer,Answer> yourAnswers = readAnswerAsMap(yourAnswerPath);
        for (Map.Entry<Integer,Answer> entry: yourAnswers.entrySet()){
            Integer questionNum = entry.getKey();
            Answer yourAnswer = yourAnswers.get(questionNum);
            Answer rightAnswer = rightAnswers.get(questionNum);
            if (isRight(yourAnswer.getAnswers(),rightAnswer.getAnswers())){
                rightCount++;
            }else{
                wrongCount++;
                wrongResults.add(new WrongResult(questionNum, rightAnswer.getAnswers(), yourAnswer.getAnswers()));
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
    public Map<Integer,Answer> readAnswerAsMap(String filePath) {
        Map<Integer,Answer> result = new HashMap<>();
        try (
                FileInputStream inputStream = new FileInputStream(filePath);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))
        ) {
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                if (str.trim().length() > 0) {
                    Answer answer = Answer.decodeAnswer(str);
                    result.put(answer.getQuestionNum(),answer);
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
