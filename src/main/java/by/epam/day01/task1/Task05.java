package by.epam.day01.task1;

import by.epam.day01.scanner.EnterFromConsole;

public class Task05 {

    public static void main(String[] args) {

        double[] array=new double[3];
        for (int i=0; i<array.length; ++i){
            System.out.print("Enter number:");
            array[i]= EnterFromConsole.EnterDouble();
        }

        for(int i=0; i<array.length; ++i){
            if(array[i]>=0){
                array[i]=Math.pow(array[i], 2);
            }else {
                array[i]=Math.pow(array[i], 4);
            }
        }

        System.out.println("Result:");
        for(int i=0; i<array.length; ++i){
            System.out.print(array[i]+" ");
        }
    }
}
