package models;

public class Question {
    private String text;
    private String[] possibleAnswers;
    private char correctAnswer;
    public Question() {
        this.text = "";
        this.possibleAnswers = new String[4];
    }
    public void setText(String text) {
        this.text = text;
    }
    public void setPossibleAnswers(String[] possibleAnswers) {
        this.possibleAnswers = possibleAnswers;
    }
    public void setCorrectAnswer(char correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
    public String getText() {
        return text;
    }
    public String[] getPossibleAnswers() {
        return possibleAnswers;
    }
    public char getCorrectAnswer() {
        return correctAnswer;
    }
    public boolean isCorrect(char answer) {
        return correctAnswer == answer;
    }
}
