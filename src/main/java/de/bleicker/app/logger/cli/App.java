package de.bleicker.app.logger.cli;

import de.bleicker.app.logger.domain.thread.ActivityThreads;
import de.bleicker.app.logger.ui.CommandServerInterface;
import de.bleicker.app.logger.ui.cli.CommandServer;

public class App {

    public static void main(String... argument) {
        Runtime.getRuntime().addShutdownHook(new ActivityThreads());
        CommandServerInterface commandServer = new CommandServer();
        commandServer.start();
    }
}
