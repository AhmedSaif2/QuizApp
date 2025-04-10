package ui;

import models.Question;
import models.Quiz;
import models.User;
import utils.InputValidation;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class QuizApp {
    public static void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Quiz App!");
        System.out.print("Enter your name: ");

        String name = scanner.nextLine();
        User user = new User(name);

        System.out.println("Hello, " + name + "!");

        System.out.println(
            """
            Select the topic of the quiz:
            1. Math
            2. Science
            3. Geography
            4. Mixed
            Enter your choice (1-4):""");
        String topic;
        int choice = InputValidation.validate(1, 4);
        String[] topics = {"Math", "Science", "Geography", "Mixed"};
        topic = topics[choice - 1];

        System.out.println(
            """
            Select the size of the quiz::
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
        System.out.println("Quiz finished!");
        System.out.println("Your Quiz Score: " + ((float)quizScore/(float)questionList.size()) * 100 + "%");
        System.out.println("Do you want to play again? (y/n)");
        char playAgain = InputValidation.validateYesNo();
        if (playAgain == 'y') {
            run();
        } else {
            System.out.println("Thank you for playing!");
        }

    }
}
