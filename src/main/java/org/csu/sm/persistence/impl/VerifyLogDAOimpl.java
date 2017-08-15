package org.csu.sm.persistence.impl;

import org.csu.sm.domain.VerifyLog;
import org.csu.sm.persistence.VerifyLogDAO;
import org.csu.sm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceException;
import java.util.List;

/**
 * Created by ltaoj on 2017/8/8.
 */
@Repository
public class VerifyLogDAOimpl implements VerifyLogDAO {
    public List<VerifyLog> getVerifyLogListByCounselorName(String counselorName) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from VerifyLog as v where counselorName='" + counselorName + "'";
        List<VerifyLog> list = session.createQuery(hql).list();
        session.flush();
        transaction.commit();
        return list;
    }

    public void insertVerifyLog(VerifyLog verifyLog) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(verifyLog);
        session.flush();
        transaction.commit();
        session.close();
    }

    public List<VerifyLog> getVerifyLogListByStudentId(long studentId) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from VerifyLog as v where studentId=" + studentId;
        List<VerifyLog> list = session.createQuery(hql).list();
        session.flush();
        transaction.commit();
        return list;
    }
}
