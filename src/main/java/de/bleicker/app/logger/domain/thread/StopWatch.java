package de.bleicker.app.logger.domain.thread;

import java.util.Date;

public final class StopWatch extends Thread {

    private Date startDate;
    private Date endDate;

    public StopWatch(StopWatches group, String name) {
        super(group, name);
    }

    @Override
    public void run() {
        super.run();
        while (isAlive()) {
            try {
                sleep(Long.MAX_VALUE);
            } catch (InterruptedException e) {
                // Just catching InterruptedException
            }
        }
    }

    @Override
    public synchronized void start() {
        super.start();
        this.setStartDate(new Date());
    }

    @Override
    public void interrupt() {
        this.setEndDate(new Date());
        super.interrupt();
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public StopWatch setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public StopWatch setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }
}
