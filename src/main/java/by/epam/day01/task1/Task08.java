package by.epam.day01.task1;

import by.epam.day01.scanner.ArrayWithConsole;
import by.epam.day01.scanner.EnterFromConsole;

public class Task08 {

    public static void main(String[] args) {

        double[] array = ArrayWithConsole.EnterArrayFromConsoleDouble();

        ArrayWithConsole.printArray(array);

        System.out.print("Enter K: ");
        double k = EnterFromConsole.EnterDouble();

        double sum=0;
        for(int i=0; i<array.length; ++i){
            if(array[i]%2==0){
                sum+=array[i];
            }
        }

        System.out.println("Result: "+sum);
    }

}
