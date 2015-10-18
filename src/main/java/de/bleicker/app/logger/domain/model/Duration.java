package de.bleicker.app.logger.domain.model;

import java.util.Date;
import java.util.UUID;

public class Duration {

    protected String identity = UUID.randomUUID().toString();

    protected Date startDate = new Date();

    protected Date endDate = new Date();

    public Duration() {
    }

    public Duration(Date startDate) {
        this.startDate = startDate;
    }

    public Duration(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Duration(String identity, Date startDate, Date endDate) {
        this.identity = identity;
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

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}

