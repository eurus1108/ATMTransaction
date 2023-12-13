package ui;

import data.CustomerRepo;
import models.Customer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class Admin extends JFrame {
    private final JTable customerTable;

    public Admin() {
        setTitle("Admin Panel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        JButton viewAllCustomersButton = new JButton("View All Customers");
        JButton addCustomerButton = new JButton("Add New Customer");
        JButton editCustomerButton = new JButton("Edit Customer Information");
        JButton changePinButton = new JButton("Change Customer Pin");
        JButton exitButton = new JButton("Exit");

        setLayout(new GridLayout(5, 1));
        add(viewAllCustomersButton);
        add(addCustomerButton);
        add(editCustomerButton);
        add(changePinButton);
        add(exitButton);

        viewAllCustomersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAllCustomers();
            }
        });

        addCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAddCustomerDialog();
            }
        });

        editCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showEditCustomerDialog();
            }
        });

        changePinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showChangePinDialog();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Login().setVisible(true);
            }
        });

        customerTable = new JTable();
    }

    private void showAllCustomers() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Account No");
        model.addColumn("Name");
        model.addColumn("Balance");
        model.addColumn("PIN");

        for (Customer customer : CustomerRepo.getAllCustomer()) {
            Object[] rowData = {customer.getAccountNo(), customer.getName(), customer.getBalance(), customer.getPin()};
            model.addRow(rowData);
        }

        customerTable.setModel(model);

        JScrollPane scrollPane = new JScrollPane(customerTable);
        JOptionPane.showMessageDialog(this, scrollPane, "All Customers", JOptionPane.PLAIN_MESSAGE);
    }

    private void showAddCustomerDialog() {
        JTextField accountNoField = new JTextField(10);
        JTextField nameField = new JTextField(10);
        JTextField balanceField = new JTextField(10);
        JTextField pinField = new JTextField(10);

        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(new JLabel("Account No:"));
        panel.add(accountNoField);
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Balance:"));
        panel.add(balanceField);
        panel.add(new JLabel("PIN:"));
        panel.add(pinField);

        int result = JOptionPane.showConfirmDialog(this, panel, "Add New Customer", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String accountNo = accountNoField.getText();
            String name = nameField.getText();
            BigDecimal balance = new BigDecimal(balanceField.getText());
            String pin = pinField.getText();

            Customer newCustomer = new Customer(accountNo, name, balance, pin);
            CustomerRepo.addCustomer(newCustomer);

            JOptionPane.showMessageDialog(this, "Customer added successfully!");
        }
    }

    private void showEditCustomerDialog() {
        JTextField accountNoField = new JTextField(10);

        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.add(new JLabel("Account No:"));
        panel.add(accountNoField);

        int result = JOptionPane.showConfirmDialog(this, panel, "Edit Customer Information", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String accountNoToEdit = accountNoField.getText();
            Customer selectedCustomer = findCustomerByAccountNo(accountNoToEdit);

            if (selectedCustomer != null) {
                JTextField nameField = new JTextField(10);
                panel = new JPanel(new GridLayout(1, 2));
                panel.add(new JLabel("New Name:"));
                panel.add(nameField);

                result = JOptionPane.showConfirmDialog(this, panel, "Edit Customer Name", JOptionPane.OK_CANCEL_OPTION);

                if (result == JOptionPane.OK_OPTION) {
                    String newName = nameField.getText();
                    selectedCustomer.setName(newName);
                    JOptionPane.showMessageDialog(this, "Customer information updated successfully!");
                } else {
                    JOptionPane.showMessageDialog(this, "Editing canceled!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Customer with Account No " + accountNoToEdit + " not found!");
            }
        }
    }

    private void showChangePinDialog() {
        JTextField pinField = new JTextField(10);

        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.add(new JLabel("Account No:"));
        panel.add(pinField);

        int result = JOptionPane.showConfirmDialog(this, panel, "Edit Customer Information", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String accountNoToEdit = pinField.getText();
            Customer selectedCustomer = findCustomerByAccountNo(accountNoToEdit);

            if (selectedCustomer != null) {
                JTextField nameField = new JTextField(10);
                panel = new JPanel(new GridLayout(1, 2));
                panel.add(new JLabel("New Pin:"));
                panel.add(nameField);

                result = JOptionPane.showConfirmDialog(this, panel, "Edit Customer Name", JOptionPane.OK_CANCEL_OPTION);

                if (result == JOptionPane.OK_OPTION) {
                    String newName = nameField.getText();
                    selectedCustomer.setPin(newName);
                    JOptionPane.showMessageDialog(this, "Customer information updated successfully!");
                } else {
                    JOptionPane.showMessageDialog(this, "Editing canceled!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Customer with Account No " + accountNoToEdit + " not found!");
            }
        }
    }


    private Customer getSelectedCustomer() {
        int selectedRow = customerTable.getSelectedRow();

        if (selectedRow != -1) { // Check if any row is selected
            // Assuming the order of columns in the table is the same as the order in the Customer class
            String accountNo = customerTable.getValueAt(selectedRow, 0).toString();
            // Assuming the accountNo is unique in your data
            return findCustomerByAccountNo(accountNo);
        } else {
            JOptionPane.showMessageDialog(this, "No customer selected!");
            return null;
        }
    }

    private Customer findCustomerByAccountNo(String accountNo) {
        for (Customer customer : CustomerRepo.getAllCustomer()) {
            if (customer.getAccountNo().equals(accountNo)) {
                return customer;
            }
        }
        return null;
    }
}
