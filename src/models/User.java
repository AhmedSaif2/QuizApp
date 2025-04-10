package models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<Quiz> quizzes;
    private int score;
    public User(String name) {
        this.name = name;
        quizzes = new ArrayList<>();
        score = 0;
    }

    public void addQuiz(Quiz quiz) {
        quizzes.add(quiz);
    }

}
