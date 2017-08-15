package org.csu.sm.persistence;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by ltaoj on 2017/8/15.
 */
public abstract class AbstractDAO {
    public Transaction getTransation(Session session) {
        if (session.getTransaction().isActive())
            return session.getTransaction();
        return session.beginTransaction();
    }
}
