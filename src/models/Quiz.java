package models;

import java.util.List;

public class Quiz {
    private String id;
    private int numberOfQuestions;
    private List<Question> questions;
    private String topic;
    private User user;
    private double score;

    public Quiz(String id,int numberOfQuestions, String topic) {
        this.id = id;
        this.numberOfQuestions = numberOfQuestions;
        this.topic = topic;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public void setScore(double score) {
        this.score = score;
    }
    public double getScore(){
        return score/numberOfQuestions;
    }
    public String getId() {
        return id;
    }
    public String getTopic() {
        return topic;
    }
    public List<Question> generateQuestions() {
        int MAX_QUESTIONS = 30; // total number of questions in file
        List<Integer> randomIndexes = utils.RandomUtils.getRandomList(0, MAX_QUESTIONS-1, numberOfQuestions);
        questions = utils.QuestionsReader.readQuestions(randomIndexes,topic);
        return questions;
    }
}
