package org.csu.sm.persistence.impl;

import org.csu.sm.domain.AwardRecord;
import org.csu.sm.domain.AwardRecordPK;
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
public class AwardDAOimpl implements AwardDAO{

    public void insertAward(AwardRecord awardRecord) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(awardRecord);
        transaction.commit();
        session.close();
    }

    public void updateAward(AwardRecord awardRecord) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.update(awardRecord);
        transaction.commit();
        session.close();
    }

    public long deleteAward(AwardRecord awardRecord) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        AwardRecord awardRecord1 = session.get(AwardRecord.class, new AwardRecordPK(awardRecord.getContent(), awardRecord.getDate(), awardRecord.getStudentId()));
        if (awardRecord != null) session.delete(awardRecord);
        transaction.commit();
        session.close();
        return awardRecord != null ? awardRecord.getStudentId() : -1;
    }

    public List<AwardRecord> getAwardList(long studentId) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from AwardRecord as a where studentId=" + studentId;
        List<AwardRecord> list = session.createQuery(hql).list();
        transaction.commit();
        return list;
    }
}
