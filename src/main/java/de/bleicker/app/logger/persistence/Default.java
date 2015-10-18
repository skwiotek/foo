package de.bleicker.app.logger.persistence;

import de.bleicker.app.logger.domain.model.Duration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Default {

    public static Session getSession() {
        SessionFactory factory = new Configuration().configure().addClass(Duration.class).buildSessionFactory();
        return factory.openSession();
    }

}
