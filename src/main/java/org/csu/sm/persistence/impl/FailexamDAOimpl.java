package org.csu.sm.persistence.impl;

import org.csu.sm.domain.FailexamRecord;
import org.csu.sm.domain.FailexamRecordPK;
import org.csu.sm.persistence.AbstractDAO;
import org.csu.sm.persistence.FailexamDAO;
import org.csu.sm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceException;
import java.util.List;

/**
 * Created by ltaoj on 2017/8/7.
 */
@Repository
public class FailexamDAOimpl extends AbstractDAO implements FailexamDAO{
    public void insertFailexam(FailexamRecord failexamRecord) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            session.save(failexamRecord);
            session.flush();
            transaction.commit();
        } catch (RuntimeException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public void updateFailexam(FailexamRecord failexamRecord) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            session.update(failexamRecord);
            session.flush();
            transaction.commit();
        } catch (RuntimeException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public long deleteFailexam(long studentId, String subject) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            FailexamRecord failexamRecord = session.get(FailexamRecord.class, new FailexamRecordPK(subject, studentId));
            if (failexamRecord != null) session.delete(failexamRecord);
            session.flush();
            transaction.commit();
            session.close();
            return failexamRecord != null ? studentId : -1;
        } catch (RuntimeException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public List<FailexamRecord> getFailexamList(long studentId) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            String hql = "from FailexamRecord as f where studentId=" + studentId;
            List<FailexamRecord> list = session.createQuery(hql).list();
            session.flush();
            transaction.commit();
            return list;
        } catch (RuntimeException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}
