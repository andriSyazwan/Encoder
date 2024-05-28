package org.example;

import java.util.Scanner;

/**
 * Encoding App!
 *
 */
public class SpecialEncodingApp
{
    public static void main( String[] args )
    {
        Solution solutionRunner = new Solution();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("Welcome to the Special Encoding Application");

        while (!exit) {
            System.out.println("Would you like to decode or encode a text today?");
            System.out.println("Type 1 to decode or 2 to encode, or 0 to exit: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.println("Please enter the text to decode:");
                    String textToDecode = scanner.nextLine();
                    String decodedText = solutionRunner.decode(textToDecode);
                    System.out.println("Decoded text: " + decodedText);
                    break;
                case 2:
                    System.out.println("Please enter the text to encode:");
                    String textToEncode = scanner.nextLine();
                    String encodedText = solutionRunner.encode(textToEncode);
                    System.out.println("Encoded text: " + encodedText);
                    break;
                case 0:
                    exit = true;
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please type 1 to decode, 2 to encode, or 0 to exit.");
                    break;
            }
        }

        scanner.close();
    }
}
