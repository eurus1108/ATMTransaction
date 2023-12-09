package models;

public class Customer {
    private String accountNo;
    private String name;
    private double balance;
    private String pin;
    private int pinAttempts;
    private boolean isCaptured;

    public Customer(String accountNo, String name, double balance, String pin) {
        this.accountNo = accountNo;
        this.name = name;
        this.balance = balance;
        this.pin = pin;
        this.pinAttempts = 0;
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

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
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
