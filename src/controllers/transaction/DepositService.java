package controllers.transaction;

import exceptions.InsufficientAmountException;
import models.Customer;

import java.math.BigDecimal;

public class DepositService extends TransactionService {
    public DepositService(Customer customer, double amount) {
        super(customer, amount);
    }

    @Override
    public void execute() {
        if (amount < 0) {
            throw new InsufficientAmountException("Error: Deposit amount should not be less than 100");
        }

        if (amount % 100 != 0) {
            throw new InsufficientAmountException("Error: amount should be divisible by 100");
        }

        customer.setBalance(customer.getBalance().add(new BigDecimal(amount)));
    }
}
