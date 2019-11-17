package by.epam.day01.task1;

import by.epam.day01.scanner.EnterFromConsole;

public class Task04 {

    public static void main(String[] args) {

        System.out.println("Enter x:");
        double x = EnterFromConsole.EnterDouble();
        System.out.println("Enter y:");
        double y = EnterFromConsole.EnterDouble();

        boolean result=false;

        if (((x >= -2 && x <= 2) && (y >= 0 && y <= 2)) || ((x >= -4 && x <= 4) && (y >= -3 && y <= 0)&&(x>=Math.sqrt(Math.pow(0.5, 2)-Math.pow(y-1, 2))))) {
            result = true;
        }

        System.out.println("Result: "+result);
    }
}
