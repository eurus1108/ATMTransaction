package ui;

import controllers.transaction.DepositService;
import controllers.transaction.TransactionService;
import controllers.transaction.WithdrawService;
import exceptions.InsufficientAmountException;
import exceptions.InvalidAmountException;
import models.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends JDialog implements ActionListener {
    private final String header = """
            <html>
            <body style='text-align:center'>
            <b>OOPBC</b><br>
            Object Oriented Programming Banking Corporation
            </body></html>
            """;
    private Customer customer;
    private Menu menu;
    private JTextField enterAmountField;

    public Transaction(Menu menu, Customer customer) {
        setSize(400, 400);
        setModal(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(menu);
        this.menu = menu;
        this.customer = customer;
    }

    public void enterAmount() {
        JLabel headerLabel = new JLabel(header);
        headerLabel.setBounds(0, 20, getWidth() - 10, 40);
        headerLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(headerLabel);

        JLabel enterAmountLabel = new JLabel("Enter amount: ");
        enterAmountLabel.setBounds(0, 80, getWidth() - 20, 20);
        enterAmountLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        enterAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(enterAmountLabel);

        enterAmountField = new JTextField();
        enterAmountField.setBounds(15, 140, getWidth() - 50, 40);
        enterAmountField.setFont(new Font("Dialog", Font.BOLD, 20));
        enterAmountField.setHorizontalAlignment(SwingConstants.CENTER);
        add(enterAmountField);
    }

    public void getBalance() {
        JLabel headerLabel = new JLabel(header);
        headerLabel.setBounds(0, 20, getWidth() - 10, 40);
        headerLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(headerLabel);

        String balanceInfo = """
                <html>
                <body style='text-align:center'>
                <table class="tg">
                <tbody>
                  <tr>
                    <td>Account No:</td>
                    <td>%s</td>
                  </tr>
                  <tr>
                    <td>Account Name:</td>
                    <td>%s</td>
                  </tr>
                  <tr>
                    <td>Balance:</td>
                    <td>%,.2f</td>
                  </tr>
                </tbody>
                </table>
                </body></html>
                """.formatted(customer.getAccountNo(), customer.getName(), customer.getBalance());

        JLabel actualBalanceLabel = new JLabel(balanceInfo);
        actualBalanceLabel.setBounds(15, 120, getWidth() - 50, 140);
        actualBalanceLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        actualBalanceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(actualBalanceLabel);
    }

    public void addActionButton(String actionButtonType) {
        JButton actionButton = new JButton(actionButtonType);
        actionButton.setBounds(15, 300, getWidth() - 50, 40);
        actionButton.setFont(new Font("Dialog", Font.BOLD, 20));
        actionButton.addActionListener(this);
        add(actionButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonPressed = e.getActionCommand();

        if (buttonPressed.equalsIgnoreCase("Exit")) {
            this.dispose();
            return;
        }

        double amount;

        try {
            amount = Double.parseDouble(enterAmountField.getText());
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Error: You should enter a number", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (buttonPressed.equalsIgnoreCase("Deposit")) {
            TransactionService deposit = new DepositService(customer, amount);

            try {
                deposit.execute();
            } catch (InsufficientAmountException | InvalidAmountException iae) {
                JOptionPane.showMessageDialog(null, iae.getMessage(), "Deposit Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            this.dispose();
        }

        if (buttonPressed.equalsIgnoreCase("Withdraw")) {
            TransactionService withdraw = new WithdrawService(customer, amount);

            try {
                withdraw.execute();
            } catch (InsufficientAmountException | InvalidAmountException iae) {
                JOptionPane.showMessageDialog(null, iae.getMessage(), "Deposit Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            this.dispose();
        }

        System.out.println(customer.toString());
    }
}
