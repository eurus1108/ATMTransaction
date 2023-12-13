package controllers.transaction;

import models.Customer;

public abstract class TransactionService {
    protected final Customer customer;
    protected final double amount;
    protected final int MIN_AMOUNT = 100;

    public TransactionService(Customer customer, double amount) {
        this.customer = customer;
        this.amount = amount;
    }

    public abstract void execute();
}
