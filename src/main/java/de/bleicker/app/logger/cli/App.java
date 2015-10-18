package de.bleicker.app.logger.cli;

import de.bleicker.app.logger.domain.thread.Activity;
import de.bleicker.app.logger.domain.thread.ActivityThreads;

public class App {

    public static void main(String... argument) {

        // register Message as shutdown hook
        Runtime.getRuntime().addShutdownHook(new ActivityThreads());

        Activity activity1 = new Activity("First activity");
        Activity activity2 = new Activity("Second activity");
        activity1.start();
        activity2.start();

//        List<Duration> list = session.createQuery("from Duration").list();
//
//        for (Duration item : list) {
//            System.out.println("Id: " + item.getIdentity() + " | Start:" + item.getStartDate().toString() + " | End:" + item.getEndDate().toString());
//        }
    }
}
