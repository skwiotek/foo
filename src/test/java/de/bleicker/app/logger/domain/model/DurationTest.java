package de.bleicker.app.logger.domain.model;

import org.junit.Assert;
import org.junit.Test;
import java.util.Date;

public class DurationTest {

    @Test
    public void constructTest() {
        Date startDate = new Date();
        Date endDate = new Date();
        String title = "foo";
        Duration duration = new Duration(title, startDate, endDate);
        Assert.assertSame("Startdate equals constructor startdate", startDate, duration.getStartDate());
        Assert.assertSame("Enddate equals constructor enddate", endDate, duration.getEndDate());
        Assert.assertSame("Title equals constructor title", title, duration.getTitle());
    }

}
