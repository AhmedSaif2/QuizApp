package utils;

import java.util.Scanner;

public class InputValidation {
    public static int validate(int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        while (choice < min || choice > max) {
            System.out.println("Invalid choice. Please try again.");
            choice = scanner.nextInt();
        }
        return choice;
    }
    public static char validate(char start,char end) {
        Scanner scanner = new Scanner(System.in);
        char choice = scanner.next().charAt(0);
        while (choice < start || choice > end) {
            System.out.println("Invalid choice. Please try again.");
            choice = scanner.next().charAt(0);
        }
        return choice;
    }
    public static char validateYesNo() {
        Scanner scanner = new Scanner(System.in);
        char choice = scanner.next().charAt(0);
        while (choice != 'y' && choice != 'n') {
            System.out.println("Invalid choice. Please try again.");
            choice = scanner.next().charAt(0);
        }
        return choice;
    }

}
