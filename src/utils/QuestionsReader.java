package utils;

import models.Question;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuestionsReader {
    static int LINES_PER_QUESTION = 7;
    public static List<Question> readQuestions(List<Integer> randomIndexes,String topic) {
        List<Question> questions = new ArrayList<>();
        String filePath = "src/data/" + topic + ".txt";
        for (int i:randomIndexes){
            int lineOffset = i * LINES_PER_QUESTION;
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                // Skip the first N lines
                for (int j = 0; j < lineOffset; j++) {
                    if (reader.readLine() == null) {
                        // Reached EOF before offset
                        System.out.println("File has fewer than " + lineOffset + " lines.");
                        break;
                    }
                }

                // read from the offset onward
                String line = reader.readLine();
                Question question = new Question();
                question.setText(line);
                String[] possibleAnswers = new String[4];
                for (int k = 0; k < 4; k++) {
                    line = reader.readLine();
                    if (line == null) {
                        // Reached EOF before reading all possible answers
                        System.out.println("File has fewer than " + (lineOffset + LINES_PER_QUESTION) + " lines.");
                        break;
                    }
                    possibleAnswers[k] = line;
                }
                question.setPossibleAnswers(possibleAnswers);
                line = reader.readLine();
                question.setCorrectAnswer(line.charAt(0));
                questions.add(question);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return questions;
    }
}
