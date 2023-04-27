import exceptions.InsufficientFundsException;
import exceptions.NegativeAmountException;
import exceptions.NegativeAmountException;

import java.util.Scanner;
import java.util.logging.Logger;

public class BankAccount {
    private double balance;
    private static final Logger logger = Logger.getLogger(BankAccount.class.getName());

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void withdrawal(double amount) throws InsufficientFundsException, NegativeAmountException {
        if (amount < 0) {
            throw new NegativeAmountException("You can only enter positive amounts");
        } else if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds in account");
        }
        balance -= amount;
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);
        Scanner scanner = new Scanner(System.in);
        boolean runAgain = true;


        do {
            try {
                logger.info("Enter the amount you want to withdraw : ");
                double withdrawalAmount = scanner.nextDouble();
                account.withdrawal(withdrawalAmount);
                logger.info("Withdrawal successful.Current balance is : " + account.balance);
            } catch (InsufficientFundsException ex) {
                logger.info("An error occurred: " + ex.getMessage());
            } catch (NegativeAmountException ex) {
                logger.info("An error occurred : " + ex.getMessage());
            }
            logger.info("Do you want to make another withdrawal? (Y/N) ");
            String input = scanner.next();
            switch (input.toUpperCase()) {
                case "Y":
                    runAgain = true;
                    break;
                case "N":
                    runAgain = false;
                    break;
                default:
                    logger.info("Invalid input.Program will be terminated");
                    runAgain = false;
                    break;
            }

        } while (runAgain);
    }
}
