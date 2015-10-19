package de.bleicker.app.logger.domain.thread;

import de.bleicker.app.logger.domain.model.Duration;
import de.bleicker.app.logger.persistence.Default;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class Activity extends Thread {

    protected Date start;

    protected Date end;

    protected Boolean isPersisted = false;

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
        start = new Date();
        isNotPersisted();
        deactivateSiblings();
    }

    @Override
    public void interrupt() {
        pause();
        super.interrupt();
    }

    public Activity isPersisted() {
        isPersisted = true;
        return this;
    }

    public Activity isNotPersisted() {
        isPersisted = false;
        return this;
    }

    public Activity pause() {
        end = new Date();
        persist();
        return this;
    }

    protected Activity persist() {
        if(isPersisted){
           return this;
        }
        Session session = Default.getSession();
        Transaction tx = session.beginTransaction();
        Duration duration = new Duration(getName(), start, end);
        session.save(duration);
        session.flush();
        tx.commit();
        isPersisted();
        return this;
    }

    public Activity deactivateSiblings() {
        for (Activity activity : ActivityThreads.activities) {
            if (activity != this) {
                activity.pause();
            }
        }
        return this;
    }
}
