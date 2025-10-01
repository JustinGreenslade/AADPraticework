package PraticeWork.AvgTempCalc;

import java.util.*;

//Calculate the avarage temperature, and give how many days are above the avarage temperature
//
//1. Take an input from the user (eg. 5)
//2. Prompt the user to enter all the 5 numbers (temperature values)
//3. Calculate the avarage temperature
//4. Given the avarage temperature, how many of the numbers in the line 2 are above the avarage temperature?

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfTemps;

        System.out.print("Enter the total number of temperature values: ");
        numOfTemps = scanner.nextInt();

        double[] tempsValues = new double[numOfTemps];
        double sum = 0.0;

        for (int i = 0; i < numOfTemps; i++) {
            System.out.println("Enter the temperature value " + (i+1) + ": ");
            tempsValues[i] = scanner.nextDouble();
            sum += tempsValues[i];
        }
        System.out.println("Sum of all temperature values: " + sum);
        double average = sum / numOfTemps;
        System.out.println("The Average temperature: " + average);

        int countAboveAverage = 0;
        for (int i = 0; i< numOfTemps; i++) {
            if (tempsValues[i] > average) {
                countAboveAverage ++;
            }

        }
        System.out.println("Number of temperature values above the average: " + countAboveAverage);
    }
}
