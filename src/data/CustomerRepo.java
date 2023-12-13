package data;

import models.Customer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepo {
    private static List<Customer> customers = new ArrayList<>();

    static {
        customers.add(new Customer("0123-4567-8901", "Roel Richard", new BigDecimal(5_000), "1111"));
        customers.add(new Customer("2345-6789-0123", "Dorie Marie", new BigDecimal(0), "2222"));
        customers.add(new Customer("3456-7890-1234", "Railee Darrel", new BigDecimal(10_000), "3333"));
        customers.add(new Customer("4567-8901-2345", "Railynne Dessirei", new BigDecimal(2_500), "4444"));
        customers.add(new Customer("5678-9012-3456", "Raine Dessirei", new BigDecimal(10_000), "5555"));
    }

    public static List<Customer> getAllCustomer() {
        return customers;
    }

    public static void addCustomer(Customer customer) {
        customers.add(customer);
    }
}
