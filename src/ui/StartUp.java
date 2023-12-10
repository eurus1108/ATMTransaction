package ui;

import helpers.Formatter;

public class StartUp extends BaseUi{
    public void run() {
        while (true) {
            BaseUi.printHeader();
            System.out.println(Formatter.leftPad("S -> Start Transaction", 15));
            System.out.println(Formatter.leftPad("Q -> Quit", 15) + "\n");
            System.out.print(Formatter.leftPad("Enter your choice: ", 15));
            String choice = scanner.nextLine();
            System.out.println();

            if (choice.length() > 1) {
                System.out.println(RED + "Error: Enter S or Q only\n" + RESET);
                continue;
            }

            if (choice.equalsIgnoreCase("S")) {
                new Login().run();
            } else if (choice.equalsIgnoreCase("Q")) {
                // quit program
                break;
            } else {
                System.out.println(RED + "Error: Enter S or Q only\n" + RESET);
            }
        }
    }
}
