package com.h2;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        int[] numbers = new int[5];
        numbers[0] = 11;
        numbers[1] = 14;
        numbers[2] = 15;
        numbers[3] = 18;
        numbers[4] = 100;

        System.out.println(add(numbers));
    }

    public static int doubleTheNumber(int number) {
        return 2*number;
    }

    private static int add(int[] numbers) {

        int sum = 0;

        for (int number: numbers) {
           sum = sum+number;
        }

        return sum;
    }



}
