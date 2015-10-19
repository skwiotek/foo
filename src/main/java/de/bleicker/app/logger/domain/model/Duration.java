package de.bleicker.app.logger.domain.model;

import java.util.Date;
import java.util.UUID;

public class Duration {

    protected String identity = UUID.randomUUID().toString();

    protected String title;

    protected Date startDate = new Date();

    protected Date endDate = new Date();

    public Duration(String title, Date startDate, Date endDate) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getIdentity() {
        return identity;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getTitle() {
        return title;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

