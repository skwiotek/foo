package de.bleicker.app.logger.domain.thread;

import de.bleicker.app.logger.domain.model.Duration;
import java.util.ArrayList;
import java.util.List;

public final class StopWatches extends ThreadGroup {

    private final List<Duration> durations = new ArrayList<Duration>();

    public StopWatches(String name) {
        super(name);
    }

    public List<Duration> getDurations() {
        return durations;
    }
}
