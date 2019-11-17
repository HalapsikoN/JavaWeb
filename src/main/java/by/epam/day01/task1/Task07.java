package by.epam.day01.task1;

import by.epam.day01.scanner.EnterFromConsole;

public class Task07 {

    public static void main(String[] args) {

        double a, b, h;
        System.out.print("Enter a: ");
        a = EnterFromConsole.EnterDouble();
        System.out.print("Enter b: ");
        b = EnterFromConsole.EnterDouble();
        System.out.print("Enter h: ");
        h = EnterFromConsole.EnterDouble();

        if (b < a) {

            double temp = a;
            a = b;
            b = temp;
        }

        if (h < 0) {

            h *= -1;
        }

        for (double x = a; x <= b; x += h) {

            double fun = Math.pow(Math.sin(x),2) - Math.cos(2*x);
            System.out.println(x + " - " + fun);
        }
    }
}
