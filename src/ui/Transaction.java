package ui;

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
    private JLabel enterAmountLabel, enterUserLabel;
    private JTextField enterAmountField, enterUserField;
    private JButton actionButton;


    public Transaction(Menu menu, Customer customer) {
        setSize(400, 400);
        setModal(true);
        setLocationRelativeTo(menu);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        this.menu = menu;
        this.customer = customer;
    }

    public void enterAmount() {
        JLabel headerLabel = new JLabel(header);
        headerLabel.setBounds(0, 20, getWidth() - 10, 40);
        headerLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(headerLabel);

        enterAmountLabel = new JLabel("Enter amount: ");
        enterAmountLabel.setBounds(0, 50, getWidth() - 20, 20);
        enterAmountLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        enterAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(enterAmountLabel);

        enterAmountField = new JTextField();
        enterAmountField.setBounds(15, 80, getWidth() - 50, 40);
        enterAmountField.setFont(new Font("Dialog", Font.BOLD, 20));
        enterAmountField.setHorizontalAlignment(SwingConstants.RIGHT);
        add(enterAmountField);
    }

    public void addActionButton(String actionButtonType) {
        actionButton = new JButton(actionButtonType);
        actionButton.setBounds(15, 300, getWidth() - 50, 40);
        actionButton.setFont(new Font("Dialog", Font.BOLD, 20));
        actionButton.addActionListener(this);
        add(actionButton);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
