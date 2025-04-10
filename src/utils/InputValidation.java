package utils;

import java.util.Scanner;

public class InputValidation {
    private static String message = "Invalid input. Please try again.";
    private static Scanner scanner = new Scanner(System.in);
    public static int validate(int min, int max) {
        int choice = scanner.nextInt();
        while (choice < min || choice > max) {
            System.out.println(message);
            choice = scanner.nextInt();
        }
        return choice;
    }
    public static char validate(char start,char end) {
        char choice = scanner.next().charAt(0);
        while (choice < start || choice > end) {
            System.out.println(message);
            choice = scanner.next().charAt(0);
        }
        return choice;
    }
    public static char validateYesNo() {
        char choice = scanner.next().charAt(0);
        while (choice != 'y' && choice != 'n') {
            System.out.println(message);
            choice = scanner.next().charAt(0);
        }
        return choice;
    }

}
