package by.epam.day01.scanner;

public class ArrayWithConsole {

    public static int[] EnterArrayFromConsoleInteger() {

        int numberElements = 0;
        while (numberElements <= 0) {

            System.out.print("Enter the number of elements: ");
            numberElements = EnterFromConsole.EnterInteger();
        }
        int[] array = new int[numberElements];

        for (int i = 0; i < array.length; ++i) {

            System.out.print("Enter the [" + i + "] element: ");
            array[i] = EnterFromConsole.EnterInteger();
        }
        return array;
    }

    public static double[] EnterArrayFromConsoleDouble() {

        int numberElements = 0;
        while (numberElements <= 0) {

            System.out.print("Enter the number of elements: ");
            numberElements = EnterFromConsole.EnterInteger();
        }
        double[] array = new double[numberElements];

        for (int i = 0; i < array.length; ++i) {

            System.out.print("Enter the [" + i + "] element: ");
            array[i] = EnterFromConsole.EnterDouble();
        }
        return array;
    }

    public static void printArray(int[] array) {

        System.out.print("Array: ");
        for (int i = 0; i < array.length; ++i) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void printArray(double[] array) {

        System.out.print("Array: ");
        for (int i = 0; i < array.length; ++i) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static double[][] EnterDoubleArrayFromConsoleDouble() {

        int numberLines = 0;
        while (numberLines <= 0) {

            System.out.print("Enter the number of lines: ");
            numberLines = EnterFromConsole.EnterInteger();
        }

        double[][] array = new double[numberLines][];

        for (int i = 0; i < array.length; ++i) {

            int numberElements = 0;
            while (numberElements <= 0) {

                System.out.print("Enter the number of elements in [" + i + "] line: ");
                numberElements = EnterFromConsole.EnterInteger();
            }
            array[i] = new double[numberElements];
        }

        return getDoubles(array);
    }

    public static double[][] EnterSquareArrayFromConsoleDouble() {

        int numberLines = 0;
        while (numberLines <= 0) {

            System.out.print("Enter the number of lines: ");
            numberLines = EnterFromConsole.EnterInteger();
        }

        double[][] array = new double[numberLines][numberLines];

        return getDoubles(array);
    }

    private static double[][] getDoubles(double[][] array) {
        for (int i = 0; i < array.length; ++i) {
            for (int j = 0; j < array[i].length; ++j) {

                System.out.print("Enter the the [" + i + "][" + j + "] element: ");
                array[i][j] = EnterFromConsole.EnterDouble();
            }
        }

        return array;
    }

    public static int[][] EnterDoubleArrayFromConsoleInteger() {

        int numberLines = 0;
        while (numberLines <= 0) {

            System.out.print("Enter the number of lines: ");
            numberLines = EnterFromConsole.EnterInteger();
        }

        int[][] array = new int[numberLines][];

        for (int i = 0; i < array.length; ++i) {

            int numberElements = 0;
            while (numberElements <= 0) {

                System.out.print("Enter the number of elements in [" + i + "] line: ");
                numberElements = EnterFromConsole.EnterInteger();
            }
            array[i] = new int[numberElements];
        }

        return getInts(array);
    }

    private static int[][] getInts(int[][] array) {
        for (int i = 0; i < array.length; ++i) {
            for (int j = 0; j < array[i].length; ++j) {

                System.out.print("Enter the the [" + i + "][" + j + "] element: ");
                array[i][j] = EnterFromConsole.EnterInteger();
            }
        }

        return array;
    }

    public static int[][] EnterSquareArrayFromConsoleInteger() {

        int numberLines = 0;
        while (numberLines <= 0) {

            System.out.print("Enter the number of lines: ");
            numberLines = EnterFromConsole.EnterInteger();
        }

        int[][] array = new int[numberLines][numberLines];

        return getInts(array);
    }

    public static int[][] EnterSquareArrayFromConsoleInteger(int numberLines) {

        int[][] array = new int[numberLines][numberLines];

        return getInts(array);
    }

    public static void printArray(double[][] array) {

        System.out.println("Array: ");
        for (int i = 0; i < array.length; ++i) {
            for (int j = 0; j < array[i].length; ++j) {

                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printArray(int[][] array) {

        System.out.println("Array: ");
        for (int i = 0; i < array.length; ++i) {
            for (int j = 0; j < array[i].length; ++j) {

                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
