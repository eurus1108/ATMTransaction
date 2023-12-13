package controllers.transaction;

import exceptions.InsufficientAmountException;
import models.Customer;

import java.math.BigDecimal;

public class WithdrawService extends TransactionService {
    public WithdrawService(Customer customer, double amount) {
        super(customer, amount);
    }

    @Override
    public void execute() {
        if (amount < 100) {
            throw new InsufficientAmountException("Error: Deposit amount should not be less than 100");
        }

        if (amount % 100 != 0) {
            throw new InsufficientAmountException("Error: Amount should be divisible by 100");
        }

        if (amount > customer.getBalance().doubleValue()) {
            throw new InsufficientAmountException("Error: Insufficient Funds");
        }

        customer.setBalance(customer.getBalance().subtract(new BigDecimal(amount)));
    }
}
