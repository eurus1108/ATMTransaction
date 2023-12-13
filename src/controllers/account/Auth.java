package controllers.account;

import data.CustomerRepo;
import exceptions.PinAttemptException;
import exceptions.PinMismatchException;
import exceptions.UserNotFoundException;
import models.Customer;

import javax.swing.JOptionPane;

public class Auth {
    public static Customer login(String accountNo, String pin) {
        try {
            Customer customer = findByAccountNo(accountNo);

            if (customer.isCaptured()) {
                throw new PinAttemptException("CAPTURED CARD.... PLEASE CALL 143-44");
            }

            if (!customer.getPin().equals(pin)) {
                customer.setPinAttempts(customer.getPinAttempts() - 1);

                if (customer.getPinAttempts() == 0) {
                    customer.setCaptured(true);
                }

                System.out.printf("Customer: %s \nRemaining Attempts: %d\n", customer.getName(), customer.getPinAttempts());
                throw new PinMismatchException("Error: Wrong Pin");
            }

            return customer;
        } catch (UserNotFoundException | PinAttemptException | PinMismatchException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Login Error", JOptionPane.ERROR_MESSAGE);
        }

        return null;
    }

    private static Customer findByAccountNo(String accountNo) {
        for (Customer customer : CustomerRepo.getAllCustomer()) {
            if (customer.getAccountNo().equals(accountNo)) {
                return customer;
            }
        }

        throw new UserNotFoundException("Account doesn't exist");
    }
}
