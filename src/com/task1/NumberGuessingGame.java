package com.task1;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

	public static void main(String[] args) {
		Random random = new Random();
        int score=0;
        int targetNumber = random.nextInt(100)+1; 
        int maxattempts = 0;
     // Create Scanner for user input
     	Scanner scanner = new Scanner(System.in);
        
        // Display introductory message
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a number between 1 and 100.");
        System.out.println("Your task is to guess the number.");
        System.out.println("I will give you hints if your guess is too high or too low.");
 

        System.out.print("Enter your guess number: ");

        while (true) {
            System.out.print("Enter your guess number: ");

            // Check if the user entered a valid integer before reading it
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); 
                continue; 
            }

          
            int Guessuser = scanner.nextInt();
            maxattempts++;

            if (Guessuser == targetNumber) {
                System.out.println("Congratulations! You guessed the number " + targetNumber + " in " + maxattempts + " attempts.");
                score++;  
                break;  
            } 
            else if (Guessuser < targetNumber) {
                System.out.println("This number is too low! Try again.");
            } 
            else {
                System.out.println("This number is too high! Try again.");
            }
        }

       
        scanner.close();
    }
}

