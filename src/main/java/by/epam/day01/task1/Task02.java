package by.epam.day01.task1;

import by.epam.day01.scanner.EnterFromConsole;

public class Task02 {

    public static void main(String[] args) {

        System.out.print("Enter a:");
        double a= EnterFromConsole.EnterDouble();
        System.out.print("Enter b:");
        double b= EnterFromConsole.EnterDouble();
        System.out.print("Enter c:");
        double c= EnterFromConsole.EnterDouble();


        if(a==0 || b*b+4*c*a<0){
            System.out.println("Incorrect input");
            return;
        }

        double result=((b+Math.sqrt(Math.pow(b, 2)+4*a*c))/2*a)-Math.pow(a, 3)*c+Math.pow(b, -2);

        System.out.println("Result: "+result);
    }
}
