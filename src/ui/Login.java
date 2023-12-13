package ui;

import controllers.account.Auth;
import models.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends BaseFrame {
    public Login() {
        super("Login");
    }

    @Override
    protected void addGuiComponents() {
        JLabel headerLabel = new JLabel(header);
        headerLabel.setBounds(0, 20, getWidth() - 10, 40);
        headerLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(headerLabel);

        JLabel accountNoLabel = new JLabel("Account: ");
        accountNoLabel.setBounds(20, 120, getWidth() - 30, 24);
        accountNoLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(accountNoLabel);

        JTextField accountNoField = new JTextField();
        accountNoField.setBounds(20, 160, getWidth() - 50, 40);
        accountNoField.setFont(new Font("Dialog", Font.PLAIN, 28));
        add(accountNoField);

        JLabel pinLabel = new JLabel("Pin: ");
        pinLabel.setBounds(20, 240, getWidth() - 50, 24);
        pinLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(pinLabel);

        JPasswordField pinField = new JPasswordField();
        pinField.setBounds(20, 280, getWidth() - 50, 40);
        pinField.setFont(new Font("Dialog", Font.PLAIN, 28));
        add(pinField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(20, 460, getWidth() - 50, 40);
        loginButton.setFont(new Font("Dialog", Font.BOLD, 20));
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String accountNo = accountNoField.getText();
                String pin = String.valueOf(pinField.getPassword());

                Customer customer = Auth.login(accountNo, pin);

                if (customer != null) {
                    Login.this.dispose();
                    new Menu(customer).setVisible(true);
                }
            }
        });
        add(loginButton);
    }
}
