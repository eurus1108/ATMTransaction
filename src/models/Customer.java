package models;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Customer {
    private final String accountNo;
    private String name;
    private BigDecimal balance;
    private String pin;
    private int pinAttempts;
    private boolean isCaptured;

    public Customer(String accountNo, String name, BigDecimal balance, String pin) {
        this.accountNo = accountNo;
        this.name = name;
        this.balance = balance;
        this.pin = pin;
        this.pinAttempts = 3;
        this.isCaptured = false;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance.setScale(2, RoundingMode.HALF_UP);
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public int getPinAttempts() {
        return pinAttempts;
    }

    public void setPinAttempts(int pinAttempts) {
        this.pinAttempts = pinAttempts;
    }

    public boolean isCaptured() {
        return isCaptured;
    }

    public void setCaptured(boolean captured) {
        isCaptured = captured;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "accountNo='" + accountNo + '\'' +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", pin='" + pin + '\'' +
                '}';
    }
}
