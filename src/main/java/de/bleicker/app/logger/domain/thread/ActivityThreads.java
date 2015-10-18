package de.bleicker.app.logger.domain.thread;

import java.util.ArrayList;
import java.util.List;

public class ActivityThreads extends Thread {

    public static List<Activity> activities = new ArrayList<Activity>();

    @Override
    public void run() {
        for( Activity activity: ActivityThreads.activities ){
            activity.interrupt();
        }
        System.out.println("Good Bye with Muuuuh Power");
        super.run();
    }
}
