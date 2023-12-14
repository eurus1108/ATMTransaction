package controllers.transaction;

import exceptions.InsufficientAmountException;
import exceptions.InvalidAmountException;
import models.Customer;

import java.math.BigDecimal;

public class WithdrawService extends TransactionService {
    public WithdrawService(Customer customer, double amount) {
        super(customer, amount);
    }

    @Override
    public void execute() {
        if (amount < MIN_AMOUNT) {
            throw new InsufficientAmountException("Error: Deposit amount should not be less than 100");
        }

        if (amount % MIN_AMOUNT != 0) {
            throw new InvalidAmountException("Error: Amount should be divisible by 100");
        }

        if (amount > customer.getBalance().doubleValue()) {
            throw new InsufficientAmountException("Error: Insufficient Funds");
        }

        customer.setBalance(customer.getBalance().subtract(new BigDecimal(amount)));
    }
}
