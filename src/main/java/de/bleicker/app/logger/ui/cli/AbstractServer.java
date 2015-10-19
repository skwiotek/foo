package de.bleicker.app.logger.ui.cli;

import de.bleicker.app.logger.ui.CommandServerInterface;

import java.io.PrintStream;
import java.util.Scanner;

abstract class AbstractServer extends Thread implements CommandServerInterface {

    protected static Scanner input = new Scanner(System.in);

    protected static PrintStream view = System.out;

    protected String getCommand() {
        return input.nextLine();
    }

    protected String getCommand(String message) {
        view.println(message);
        return input.nextLine();
    }

}
