package org.csu.sm.persistence.impl;

import org.csu.sm.domain.Parent;
import org.csu.sm.domain.ParentPK;
import org.csu.sm.persistence.ParentDAO;
import org.csu.sm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.PersistenceException;
import java.util.List;

/**
 * Created by ltaoj on 2017/8/7.
 */
public class ParentDAOimpl implements ParentDAO{
    public void insertParent(Parent parent) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(parent);
        transaction.commit();
    }

    public void updateParent(Parent parent) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.update(parent);
        transaction.commit();
    }

    public long deleteParent(long studentId, String name) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Parent parent = session.get(Parent.class, new ParentPK(studentId, name));
        if (parent != null) session.delete(parent);
        transaction.commit();
        return parent != null ? studentId : -1;
    }

    public List<Parent> getParents(long studentId) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from Parent as p where studentId=" + studentId;
        List<Parent> list = session.createQuery(hql).list();
        transaction.commit();
        return list;
    }
}
