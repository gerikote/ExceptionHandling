import exceptions.InvalidInputException;
import exceptions.InvalidPhoneNumberException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class PhoneNumberValidator {
    private static final Logger logger = LogManager.getLogger(PhoneNumberValidator.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean runAgain = true;
        do {
            try {
                logger.info("Enter your phone number (format: xxx-xxx-xxxx):");
                String phoneNumber = scanner.nextLine();
                if (!phoneNumber.matches("\\d{3}-\\d{3}-\\d{4}")) {
                    throw new InvalidPhoneNumberException("Invalid phone number");
                }
                logger.info("Valid phone number : {} ", phoneNumber);

            } catch (InvalidPhoneNumberException ex) {
                System.out.println(ex.getMessage());
            }
            logger.info("Do you want to run the program again? (Y/N)");
            String input = scanner.nextLine();
            switch (input.toUpperCase()) {
                case "Y":
                    runAgain = true;
                    break;
                case "N":
                    runAgain = false;
                    break;
                default:
                    logger.info("Invalid input.Program will terminate");
                    runAgain = false;
                    break;
            }

        } while (runAgain);
    }
}
