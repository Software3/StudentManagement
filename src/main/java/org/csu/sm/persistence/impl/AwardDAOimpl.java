package org.csu.sm.persistence.impl;

import org.csu.sm.domain.AwardRecord;
import org.csu.sm.domain.AwardRecordPK;
import org.csu.sm.persistence.AbstractDAO;
import org.csu.sm.persistence.AwardDAO;
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
public class AwardDAOimpl extends AbstractDAO implements AwardDAO{

    public void insertAward(AwardRecord awardRecord) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            session.save(awardRecord);
            session.flush();
            transaction.commit();
        } catch (RuntimeException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public void updateAward(AwardRecord awardRecord) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            session.update(awardRecord);
            session.flush();
            transaction.commit();
        } catch (RuntimeException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public long deleteAward(AwardRecord awardRecord) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            AwardRecord awardRecord1 = session.get(AwardRecord.class, new AwardRecordPK(awardRecord.getContent(), awardRecord.getDate(), awardRecord.getStudentId()));
            if (awardRecord1 != null) session.delete(awardRecord1);
            session.flush();
            transaction.commit();
            return awardRecord != null ? awardRecord.getStudentId() : -1;
        } catch (RuntimeException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public List<AwardRecord> getAwardList(long studentId) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            String hql = "from AwardRecord as a where studentId=" + studentId;
            List<AwardRecord> list = session.createQuery(hql).list();
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
