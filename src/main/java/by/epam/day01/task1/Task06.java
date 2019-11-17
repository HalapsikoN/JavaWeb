package by.epam.day01.task1;

import by.epam.day01.scanner.EnterFromConsole;

public class Task06 {
    public static void main(String[] args) {

        double[] array=new double[3];
        for (int i=0; i<array.length; ++i){
            System.out.print("Enter number:");
            array[i]= EnterFromConsole.EnterDouble();
        }

        double max=Double.MIN_VALUE;
        double min=Double.MAX_VALUE;
        for(int i=0; i<array.length; ++i){
            if(array[i]<min){
                min=array[i];
            }
            if(array[i]>max){
                max=array[i];
            }
        }

        double result=max+min;

        System.out.println("Result: " + result);
    }
}
