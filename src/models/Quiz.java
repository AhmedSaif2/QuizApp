package models;

import java.util.List;

public class Quiz {
    private String id;
    private int numberOfQuestions;
    private List<Question> questions;
    private String topic;

    public Quiz(String id,int numberOfQuestions, String topic) {
        this.id = id;
        this.numberOfQuestions = numberOfQuestions;
        this.topic = topic;
    }
    public List<Question> generateQuestions() {
        int MAX_QUESTIONS = 30; // total number of questions in file
        List<Integer> randomIndexes = utils.RandomUtils.getRandomList(0, MAX_QUESTIONS, numberOfQuestions);
        questions = utils.QuestionsReader.readQuestions(randomIndexes,topic);
        return questions;
    }
//    public int getScore(){
//        int score = 0;
//        for (Question question : questions) {
//            if (question.isCorrect()) {
//                score++;
//            }
//        }
//        return score;
//    }
}
