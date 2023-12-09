import data.CustomerRepo;
import models.Customer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your account number: ");
        String accountNo = scanner.nextLine();

        Customer currentCustomer = null;

        for (Customer customer : CustomerRepo.getAllCustomer()) {
            if (customer.getAccountNo().equals(accountNo)) {
                currentCustomer = customer;
                break;
            }
        }

        if (currentCustomer == null) {
            System.exit(0);
        }

        while (currentCustomer.getPinAttempts() < 3) {
            if (currentCustomer.getPinAttempts() + 1 == 3) {
                currentCustomer.setCaptured(true);
            }

            System.out.print("Enter you pin: ");
            String pin = scanner.nextLine();

            if (currentCustomer.getPin().equals(pin)) {
                break;
            }

            System.out.println("Count: " + currentCustomer.getPinAttempts());
            currentCustomer.setPinAttempts(currentCustomer.getPinAttempts() + 1);
        }

        System.out.println("Is captured?: " + currentCustomer.isCaptured());
    }
}