import exceptions.InvalidInputException;

import java.util.Scanner;

public class CalculateFactrorial10 {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        boolean runAgain=true;
        do {
            try {
                System.out.println("Enter a number from 1 to 10: ");
                int number = scanner.nextInt();
                if (number < 1 || number > 10) {
                    throw new InvalidInputException("Invalid input: " + number);
                }
                int result = calculateFactorial(number);
                System.out.println(number + "!=" + result);

            } catch (InvalidInputException ex) {
                System.out.println(ex.getMessage());
            }
            System.out.println("Do you want to run the program again?(Y/N) ");
            String input = scanner.next();
            switch (input.toUpperCase()) {
                case "Y":
                    runAgain = true;
                    break;
                case "N":
                    runAgain = false;
                    break;
                default:
                    System.out.println("Invalid input.Program will terminate");
                    runAgain = false;
                    break;
            }
        }while(runAgain);

    }

    public static int calculateFactorial(int n){
        if(n==1||n==0){
            return 1;
        }
        return n*calculateFactorial(n-1);
    }
}
