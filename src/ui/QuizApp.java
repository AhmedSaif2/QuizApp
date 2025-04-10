package ui;

import models.Question;
import models.Quiz;
import models.User;
import utils.InputValidation;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class QuizApp {
    private static Scanner scanner;
    public QuizApp(){
        scanner = new Scanner(System.in);
    }
    public static void run() {
        System.out.println("Welcome to the Quiz App!");
        System.out.print("Enter your name: ");

        String name = scanner.nextLine();
        User user = new User(name);
        System.out.println("Hello, " + user.getName() + "!");
        int choice = 0;
        while (choice !=3){
            System.out.println("""
            Please select an option
            1. Start Quiz
            2. View Scores
            3. Exit"""
            );
            choice = InputValidation.validate(1, 3);
            if (choice == 1) {
                System.out.println("Starting the quiz...");
                startQuiz(user);
            } else if (choice == 2) {
                ShowScores(user);
            }
        }
        System.out.println("Thank you for playing!");
    }
    public static void startQuiz(User user) {
        String[] topics = {"Math", "Science", "Geography", "Mixed"};
        System.out.println("Select the topic of the quiz:");
        for (int i=1;i<=4;i++){
            System.out.println(i+". "+topics[i-1]);
        }
        System.out.println("Enter your choice (1-"+topics.length+"):");
        String topic;
        int choice = InputValidation.validate(1, 4);
        topic = topics[choice - 1];

        System.out.println(
            """
            Select the size of the quiz:
            1. 5 questions
            2. 10 questions
            3. 15 questions
            Enter your choice (1-3):""");
        choice = InputValidation.validate(1,3);
        int quizSize = choice * 5;

        System.out.println("Starting the quiz...");

        Quiz quiz = new Quiz(UUID.randomUUID().toString(), quizSize,topic);
        user.addQuiz(quiz);
        List<Question> questionList = quiz.generateQuestions();
        int quizScore=0;
        for (int i=0; i < questionList.size(); i++) {
            Question question = questionList.get(i);
            System.out.println("Q"+ (i+1) +":"+question.getText());
            String[] possibleAnswers = question.getPossibleAnswers();
            for (String answer:possibleAnswers){
                System.out.println(answer);
            }
            System.out.print("Enter your answer (a-d): ");
            char answer = InputValidation.validate('a', 'd');
            if (question.isCorrect(answer)) {
                quizScore++;
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect. The correct answer is: " + question.getCorrectAnswer());
            }
        }
        quiz.setScore(quizScore);
        System.out.println("Quiz finished!");
        System.out.println("Quiz Score: " + ((float)quizScore/(float)questionList.size()) * 100 + "%");
        System.out.println("Overall Score: " + user.getScore() * 100 + "%");

        System.out.println("Do you want to play again? (y/n)");
        char playAgain = InputValidation.validateYesNo();
        if (playAgain == 'y') {
            startQuiz(user);
        } else {
            System.out.println("Thank you for playing!");
        }
    }
    public static void ShowScores(User user) {
        if (user.getQuizzes().isEmpty()) {
            System.out.println("No quizzes taken yet.");
            return;
        }
        System.out.println("Your Scores:");
        for (Quiz quiz : user.getQuizzes()) {
            System.out.println("Quiz ID: " + quiz.getId());
            System.out.println("Topic: " + quiz.getTopic());
            System.out.println("Score: " + quiz.getScore() * 100 + "%");
        }
        System.out.println("Overall Score: " + user.getScore() * 100 + "%");
    }
}
