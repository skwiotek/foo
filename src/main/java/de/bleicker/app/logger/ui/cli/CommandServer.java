package de.bleicker.app.logger.ui.cli;

import de.bleicker.app.logger.domain.thread.Activity;

public class CommandServer extends AbstractServer {

    @Override
    public void run() {
        super.run();
        executeCommand(getCommand("Waiting for command:"));
    }

    protected void executeCommand(String command) {
        switch (command) {
            case "1":
                createActivity();
                break;
            default:
                help();
                break;
        }
        executeCommand(getCommand("Waiting for command:"));
    }

    protected void createActivity() {
        Activity activity = new Activity(fetchName());
        activity.start();
    }

    protected String fetchName() {
        view.println("Activity Name:");
        return input.nextLine();
    }

    protected void help() {
        view.println("Unknown activity");
    }
}
