import exceptions.InvalidAgeException;
import exceptions.InvalidInputException;

import java.util.Scanner;

public class AgeValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean runAgain = true;
        do {
            try {
                System.out.println("Enter your age: ");
                int age = scanner.nextInt();
                if (age > 18 || age < 65) {
                    throw new InvalidAgeException("Age must be between 18 and 65");
                }
                System.out.println("Valid age: " + age);
            } catch (InvalidAgeException ex) {
                System.out.println(ex.getMessage());
            }
            System.out.println("Do you want to run the code again? (Y/N) ");
            String input = scanner.next();
            switch (input.toUpperCase()) {
                case "Y":
                    runAgain = true;
                    break;
                case "N":
                    runAgain = false;
                    break;
                default:
                    System.out.println("Invalid input.Program will be terminated.");
                    runAgain = false;
                    break;
            }

        } while (runAgain);
    }
}