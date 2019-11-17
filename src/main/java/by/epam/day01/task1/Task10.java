package by.epam.day01.task1;

import by.epam.day01.scanner.ArrayWithConsole;
import by.epam.day01.scanner.EnterFromConsole;

public class Task10 {

    public static void main(String[] args) {

        System.out.print("Enter n: ");
        int n= EnterFromConsole.EnterInteger();
        if(n%2!=0){
            System.out.println("Incorrect input");
            return;
        }

        int[][] array= new int[n][n];

        for(int i=0; i<array.length; ++i){
            if(i%2==0){
                int value=1;
                for(int j=0; j<array[i].length; ++j) {
                    array[i][j]=value++;
                }
            }else{
                int value=array[i].length;
                for(int j=0; j<array[i].length; ++j) {
                    array[i][j]=value--;
                }
            }
        }

        System.out.println("Result:");
        ArrayWithConsole.printArray(array);
    }
}
