package de.bleicker.app.logger.cli;

import de.bleicker.app.logger.cli.hook.ShutdownHook;
import de.bleicker.app.logger.domain.thread.StopWatch;

public class App {

    private static de.bleicker.app.logger.domain.thread.StopWatches stopWatches = new de.bleicker.app.logger.domain.thread.StopWatches("StopWatch Thread Group");

    public static void main(String... argument) {
        Runtime.getRuntime().addShutdownHook(new ShutdownHook(stopWatches));

        StopWatch stopWatch = new StopWatch(stopWatches, "My Watch 1");
        stopWatch.start();
//        CommandServerInterface commandServer = new CommandServer();
//        commandServer.start();
    }
}
