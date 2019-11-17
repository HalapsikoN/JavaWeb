package by.epam.day01.task1;

import by.epam.day01.scanner.ArrayWithConsole;
import by.epam.day01.scanner.EnterFromConsole;

public class Task09 {

    public static void main(String[] args) {

        double[] array1 = ArrayWithConsole.EnterArrayFromConsoleDouble();
        double[] array2 = ArrayWithConsole.EnterArrayFromConsoleDouble();

        ArrayWithConsole.printArray(array1);
        ArrayWithConsole.printArray(array2);

        System.out.print("Enter K: ");
        int k= EnterFromConsole.EnterInteger();
        if(k<0||k>array1.length-1){
            System.out.println("Incorrect input");
            return;
        }

        double[] arrayResult=new double[array1.length+array2.length];


        for(int i=0; i<arrayResult.length; ++i){
            if(i<k){
                arrayResult[i]=array1[i];
                continue;
            }
            if(k==i){
                for(int j=0; j<array2.length; ++j){
                    arrayResult[i++]=array2[j];
                }
                i--;
                continue;
            }
            arrayResult[i]=array1[k++];
        }

        ArrayWithConsole.printArray(arrayResult);
    }
}
