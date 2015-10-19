package de.bleicker.app.logger.cli.hook;

import de.bleicker.app.logger.domain.thread.StopWatches;

public final class ShutdownHook extends Thread {

    private final StopWatches stopWatches;

    public ShutdownHook(StopWatches stopWatches) {
        super();
        this.stopWatches = stopWatches;
    }

    @Override
    public void run() {
        synchronized (stopWatches) {
            stopWatches.interrupt();
            System.out.println("Good Bye with Muuuuh Power");
            super.run();
        }
    }

}
