package ui;

import controllers.accounts.Auth;
import models.Customer;
import models.Session;

public class Login extends BaseUi {
    public void run() {
        BaseUi.printHeader();
        System.out.print("Enter your account no.: ");
        String accountNo = scanner.nextLine();

        Auth.login(accountNo);
        Customer user = Session.getUser();

        if (user == null) {
            System.out.println(RED + "Error: No account found.\n" + RESET);
            run();
            return;
        }

        while (!user.isCaptured()) {
            System.out.print("Enter you pin: ");
            String pin = scanner.nextLine();

            if (user.getPin().equals(pin)) {
                break;
            }

            user.setPinAttempts(user.getPinAttempts() - 1);

            if (user.getPinAttempts() == 0) {
                user.setCaptured(true);
            }
        }

        if (user.isCaptured()) {
            System.out.println(RED + "CAPTURED CARD.... PLEASE CALL 143-44\n" + RESET);
            Session.setUser(null);
            run();
        }
    }
}
