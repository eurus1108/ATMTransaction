package ui;

import helpers.Formatter;

import java.util.Scanner;

public class BaseUi {
    protected final String RESET = "\u001B[0m";
    protected final String RED = "\u001B[31m";
    protected Scanner scanner = new Scanner(System.in);
    protected boolean isVisible;

    protected static void printHeader() {
        System.out.println(Formatter.centerText("OOPBC", 50));
        System.out.println(Formatter.centerText("Object Oriented Programming Banking Corporation", 50));
        System.out.println(Formatter.repeatChar(50, '-') + "\n");
    }
}
