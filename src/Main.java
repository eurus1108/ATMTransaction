import data.CustomerRepo;
import ui.Menu;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Menu(CustomerRepo.getAllCustomer().get(0)).setVisible(true);
            }
        });
    }
}