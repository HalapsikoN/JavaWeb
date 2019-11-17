package by.epam.day01.scanner;

import java.util.Scanner;

public class EnterFromConsole {

    public static int EnterInteger() {

        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            scanner.nextLine();
        }

        int result = scanner.nextInt();
        return result;
    }

    public static double EnterDouble() {

        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextDouble()) {
            scanner.nextLine();
        }

        double result = scanner.nextDouble();
        return result;
    }
}
