package controllers.accounts;

import data.CustomerRepo;
import models.Customer;
import models.Session;

public class Auth {
    public static void login(String accountNo) {
        for (Customer customer : CustomerRepo.getAllCustomer()) {
            if (customer.getAccountNo().equals(accountNo)) {
                Session.setUser(customer);
            }
        }
    }

    public static boolean verifyPin(String pin) {
        return Session.getUser().getPin().equals(pin);
    }
}
