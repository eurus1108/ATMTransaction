package ui;

import models.Customer;

import javax.swing.*;

public abstract class BaseFrame extends JFrame {
    protected Customer customer;

    protected String header = """
            <html>
            <body style='text-align:center'>
            <b>OOPBC</b><br>
            Object Oriented Programming Banking Corporation
            </body></html>
            """;

    public BaseFrame(String title) {
        initialize(title);
    }

    public BaseFrame(String title, Customer customer) {
        this.customer = customer;
        initialize(title);
    }

    public void initialize(String title) {
        setTitle(title);
        setSize(420, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        addGuiComponents();
    }

    protected abstract void addGuiComponents();
}
