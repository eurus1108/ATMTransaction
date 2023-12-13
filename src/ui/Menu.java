package ui;

import models.Customer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends BaseFrame implements ActionListener {
    public Menu(Customer customer) {
        super("Menu", customer);
    }

    @Override
    protected void addGuiComponents() {
        JLabel headerLabel = new JLabel(header);
        headerLabel.setBounds(0, 20, getWidth() - 10, 40);
        headerLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(headerLabel);

        JButton checkBalanceButton = new JButton("Balance Inquiry");
        checkBalanceButton.setBounds(15, 140, getWidth() - 50, 50);
        checkBalanceButton.setFont(new Font("Dialog", Font.BOLD, 22));
        checkBalanceButton.addActionListener(this);
        add(checkBalanceButton);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(15, 200, getWidth() - 50, 50);
        withdrawButton.setFont(new Font("Dialog", Font.BOLD, 22));
        withdrawButton.addActionListener(this);
        add(withdrawButton);

        JButton depositButton = new JButton("Deposit");
        depositButton.setBounds(15, 260, getWidth() - 50, 50);
        depositButton.setFont(new Font("Dialog", Font.BOLD, 22));
        depositButton.addActionListener(this);
        add(depositButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(15, 320, getWidth() - 50, 50);
        cancelButton.setFont(new Font("Dialog", Font.BOLD, 22));
        cancelButton.addActionListener(this);
        add(cancelButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonPressed = e.getActionCommand();

        Transaction transaction = new Transaction(this, customer);

        if (buttonPressed.equalsIgnoreCase("Cancel")) {
            new Login().setVisible(true);
            this.dispose();
            return;
        }

        if (buttonPressed.equalsIgnoreCase("Balance Inquiry")) {
            transaction.setTitle(buttonPressed);
            transaction.getBalance();
            transaction.addActionButton("Exit");
        }

        if (buttonPressed.equalsIgnoreCase("Withdraw") || buttonPressed.equalsIgnoreCase("Deposit")) {
            transaction.setTitle(buttonPressed);

            transaction.enterAmount();
            transaction.addActionButton(buttonPressed);
        }

        transaction.setVisible(true);
    }
}
