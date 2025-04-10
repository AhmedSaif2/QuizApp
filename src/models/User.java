package models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<Quiz> quizzes;

    public User(String name) {
        this.name = name;
        quizzes = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public void addQuiz(Quiz quiz) {
        quizzes.add(quiz);
    }
    public List<Quiz> getQuizzes() {
        return quizzes;
    }
    public double getScore(){
        double totalScore = 0;
        for (Quiz quiz : quizzes) {
            totalScore+=quiz.getScore();
        }
        totalScore/=(double)quizzes.size();
        return totalScore;
    }
}
