package by.epam.day01.task1;

import by.epam.day01.scanner.EnterFromConsole;

public class Task03 {

    public static void main(String[] args) {

        System.out.print("Enter a:");
        double a= EnterFromConsole.EnterDouble();
        System.out.print("Enter b:");
        double b= EnterFromConsole.EnterDouble();

        if(a<=0 || b<=0){
            System.out.println("Incorrect input");
            return;
        }

        double perimetr=a+b+Math.sqrt(Math.pow(a,2)+Math.pow(b,2));
        double square=a*b/2;

        System.out.println("Perimetr: "+perimetr);
        System.out.println("Square: "+square);
    }
}
