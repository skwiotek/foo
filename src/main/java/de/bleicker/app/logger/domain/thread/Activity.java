package de.bleicker.app.logger.domain.thread;

import de.bleicker.app.logger.domain.model.Duration;
import de.bleicker.app.logger.persistence.Default;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class Activity extends Thread {

    protected Date start;

    protected Boolean isActive = false;

    public Activity(String name) {
        super(name);
        ActivityThreads.activities.add(this);
    }

    @Override
    public void run() {
        super.run();
        while (isAlive()) {
            try {
                sleep(Long.MAX_VALUE);
            } catch (InterruptedException e) {

            }
        }
    }

    @Override
    public synchronized void start() {
        super.start();
        activate();
    }

    @Override
    public void interrupt() {
        persist();
        super.interrupt();
    }

    public void activate() {
        deactivateSiblings();
        if (!isActive) {
            isActive = true;
            start = new Date();
        }
    }

    public void pause() {
        if (isActive) {
            isActive = false;
            persist();
        }
    }

    protected void persist() {
        Date end = new Date();
        Session session = Default.getSession();
        Transaction tx = session.beginTransaction();
        Duration duration = new Duration(getName(), start, end);
        session.save(duration);
        session.flush();
        tx.commit();
    }

    public void deactivateSiblings() {
        for( Activity activity: ActivityThreads.activities) {
            if (activity != this) {
                activity.pause();
            }
        }
    }
}
