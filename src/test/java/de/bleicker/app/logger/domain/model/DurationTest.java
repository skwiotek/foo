package de.bleicker.app.logger.domain.model;

import org.junit.Assert;
import org.junit.Test;
import java.util.Date;

public class DurationTest {

    @Test
    public void hasIdentityTest() {
        Duration duration = new Duration();
        Assert.assertNotNull("Idenitity exists", duration.getIdentity());
    }

    @Test
    public void emptyConstructorTest() {
        Duration duration = new Duration();
        Assert.assertNotNull("Startdate exists", duration.getEndDate());
        Assert.assertNotNull("Enddate exists", duration.getStartDate());
    }

    @Test
    public void startDateGivenTest() {
        Date startDate = new Date();
        Duration duration = new Duration(startDate);
        Assert.assertSame("Startdate equals constructor startdate", startDate, duration.getStartDate());
    }

    @Test
    public void startAndEndDateGivenTest() {
        Date startDate = new Date();
        Date endDate = new Date();
        Duration duration = new Duration(startDate, endDate);
        Assert.assertSame("Startdate equals constructor startdate", startDate, duration.getStartDate());
        Assert.assertSame("Enddate equals constructor enddate", endDate, duration.getEndDate());
    }
}
