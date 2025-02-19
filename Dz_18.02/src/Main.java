import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        task1
//        System.out.println("`Your time is limited, \nso don’t waste it \nliving someone else’s life`" + "\nSteve Jobs");


//        task2
//        Scanner sc = new Scanner(System.in);
//
//        System.out.print("Please enter a number: ");
//        int num = sc.nextInt();
//
//        System.out.print("Please enter percent in a number: ");
//        int per = sc.nextInt();
//
//        int result = (num * per) / 100;
//        System.out.println("Result: " + result);



//        task3
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Please enter first number: ");
//        int a = sc.nextInt();
//        System.out.print("Please enter second number: ");
//        int b = sc.nextInt();
//        System.out.print("Please enter third number: ");
//        int c = sc.nextInt();

//        int result = (int)(String.valueOf(a) + String.valueOf(b) + String.valueOf(c));
//        System.out.println("Result: " + result);


//        task4
//        Scanner  sc = new Scanner(System.in);
//        System.out.print("Enter a six-digit number: ");
//        String number = sc.nextLine();
//
//        if (number.length() == 6) {
//            char []numbers = number.toCharArray();
//            char temp =  numbers[0];
//            numbers[0] = numbers[5];
//            numbers[5] = temp;
//            temp = numbers[1];
//            numbers[1] = numbers[4];
//            numbers[4] = temp;
//
//            System.out.println("New number is: " + new String(numbers));
//        }
//        else {
//            System.out.println("Invalid input");
//        }


//        task5
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter the number of month: ");
//        int n = sc.nextInt();
//
//        switch (n){
//            case 12:
//            case 1:
//            case 2:
//                System.out.println("Winter");
//                break;
//            case 3:
//            case 4:
//            case 5:
//                System.out.println("Spring");
//                break;
//            case 6:
//            case 7:
//            case 8:
//                System.out.println("Summer");
//                break;
//            case 9:
//            case 10:
//            case 11:
//                System.out.println("Fall");
//                break;
//        }



//        task6
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter meters: ");
//        int meters = sc.nextInt();
//
//        System.out.print("Choose the option to convert to (1. Miles 2. Inches 3. Yards): ");
//        int choice = sc.nextInt();
//
//        if (choice == 1) {
//            System.out.println(meters + " meters = " + (meters * 0.000621371) + " miles");
//        } else if (choice == 2) {
//            System.out.println(meters + " meters = " + (meters * 39.3701) + " inches");
//        } else if (choice == 3) {
//            System.out.println(meters + " meters = " + (meters * 1.09361) + " yards");
//        } else {
//            System.out.println("Invalid choice");
//        }



//        task7
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter range start number: ");
//        int start = sc.nextInt();
//        System.out.print("Enter range finish number: ");
//        int finish = sc.nextInt();
//
//        if(start > finish){
//            int temp = start;
//            start = finish;
//            finish = temp;
//        }
//
//        for(int i = start; i <= finish; i++){
//            if(i % 2 != 0){
//                System.out.println(i);
//            }
//        }



//        task8
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter first number: ");
//        int start = sc.nextInt();
//        System.out.print("Enter last number: ");
//        int finish = sc.nextInt();
//
//        if(start > finish){
//            int temp = start;
//            start = finish;
//            finish = temp;
//        }
//
//        for(int i = start; i <= finish; i++){
//            System.out.println("Multiplication table for " + i + ":");
//            for(int j = 1; j <= 10; j++){
//                System.out.println(i + " * " + j + " = " + (i*j));
//            }
//        }



//        task9
//        Random rand = new Random();
//        int []arr = new int[10];
//        for(int i = 0; i < 10; i++)
//            arr[i] = rand.nextInt(201) - 100;
//
//        int min =  arr[0];
//        int max =  arr[0];
//        int positiveCount = 0;
//        int negativeCount = 0;
//        int zeroCount = 0;
//        for(int i = 0; i < 10; i++){
//            if(arr[i] < min)
//                min = arr[i];
//
//            if(arr[i] > max)
//                max = arr[i];
//
//            if(arr[i] > 0)
//                positiveCount++;
//
//            if(arr[i] < 0)
//                negativeCount++;
//
//            if(arr[i] == 0)
//                zeroCount++;
//        }
//        for(int i = 0; i < 10; i++)
//            System.out.print(arr[i] + " ");
//
//        System.out.println();
//        System.out.println("Minimum: " + min);
//        System.out.println("Maximum: " + max);
//        System.out.println("Positive Count: " + positiveCount);
//        System.out.println("Negative Count: " + negativeCount);
//        System.out.println("Zero Count: " + zeroCount);



//        task10
//        Random rand = new Random();
//        int length = 10;
//        int []arr = new int[length];
//        for(int i = 0; i < length; i++)
//            arr[i] = rand.nextInt(201) - 100;
//
//        int []oddArr = new int[length];
//        int []evenArr = new int[length];
//        int []positiveArr = new int[length];
//        int []negativeArr = new int[length];
//
//        int evenIndex = 0, oddIndex = 0, negativeIndex = 0, positiveIndex = 0;
//
//        for (int i = 0; i < length; i++) {
//            if (i % 2 != 0)
//                oddArr[oddIndex++] = arr[i];
//
//            if(i % 2 == 0)
//                evenArr[evenIndex++] = arr[i];
//
//            if(arr[i] > 0)
//                positiveArr[positiveIndex++] = arr[i];
//
//            if(arr[i] < 0)
//                negativeArr[negativeIndex++] = arr[i];
//
//        }
//
//        for(int i = 0; i < length; i++)
//            System.out.print(arr[i] + " ");
//        System.out.println();
//
//        for(int i = 0; i < evenIndex; i++)
//            System.out.print(evenArr[i] + " ");
//        System.out.println();
//
//        for(int i = 0; i < oddIndex; i++)
//            System.out.print(oddArr[i] + " ");
//        System.out.println();
//
//        for(int i = 0; i < positiveIndex; i++)
//            System.out.print(positiveArr[i] + " ");
//        System.out.println();
//
//        for(int i = 0; i < negativeIndex; i++)
//            System.out.print(negativeArr[i] + " ");
//        System.out.println();



//        task11
//        int length = 10;
//        String direction = "v";
//        char symbol = '*';
//
//        printLine(length, direction, symbol);



//        task12
        Random rand = new Random();
        int []arr = new int[10];
        for(int i = 0; i < 10; i++)
            arr[i] = rand.nextInt(201) - 100;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter sort method (ascending or descending): ");
        String sortMethod =  sc.nextLine();

        System.out.println("Original array: ");
        for(int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");

        sortArray(arr, sortMethod);
        System.out.println();

        System.out.println("Sorted array: ");
        for(int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    public static void sortArray(int[] arr, String sortMethod){
        if (sortMethod.equalsIgnoreCase("ascending") || sortMethod.equalsIgnoreCase("asc")) {
            Arrays.sort(arr);
        } else if (sortMethod.equalsIgnoreCase("descending") || sortMethod.equalsIgnoreCase("desc")) {
            Arrays.sort(arr);
            for (int i = 0; i < arr.length / 2; i++) {
                int temp = arr[i];
                arr[i] = arr[arr.length - 1 - i];
                arr[arr.length - 1 - i] = temp;
            }
        } else {
            System.out.println("Invalid sort method");
        }
    }

    public static void printLine(int length, String direction, char symbol) {
        if (direction.equals("horizontal") || direction.equalsIgnoreCase("h")) {
            for (int i = 1; i <= length; i++) {
                System.out.print(symbol);
            }
        } else if (direction.equalsIgnoreCase("vertical") || direction.equalsIgnoreCase("v")) {
            for (int i = 1; i <= length; i++) {
                System.out.println(symbol);
            }
        } else {
            System.out.println("Invalid direction");
        }

        System.out.println();
    }
}