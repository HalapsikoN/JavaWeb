package by.epam.day01.task1;

import by.epam.day01.scanner.EnterFromConsole;

public class Task01 {

    public static void main(String[] args) {

        System.out.println("Enter number:");
        int number= EnterFromConsole.EnterInteger();

        if(number>9999 || number<1000){
            System.out.println("Not correct number");
            return;
        }

        int firstPart=number/100;
        int secondPart=number%100;

        if (firstPart/10+firstPart%10==secondPart/10+secondPart%10){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }

}
