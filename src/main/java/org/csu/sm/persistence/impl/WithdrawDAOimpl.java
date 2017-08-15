package org.csu.sm.persistence.impl;

import org.csu.sm.domain.WithdrawInst;
import org.csu.sm.exception.service.TransationException;
import org.csu.sm.persistence.AbstractDAO;
import org.csu.sm.persistence.WithdrawInstDAO;
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
public class WithdrawDAOimpl extends AbstractDAO implements WithdrawInstDAO{
    public void insertWithdrawInst(WithdrawInst withdrawInst) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            session.save(withdrawInst);
            session.flush();
            transaction.commit();
        } catch (RuntimeException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public void updateWithdrawInst(WithdrawInst withdrawInst) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            WithdrawInst withdrawInst1 = null;
            if (withdrawInst.getDescription() == null || withdrawInst.getDescription().equals("")) {
                withdrawInst1 = session.get(WithdrawInst.class, withdrawInst.getInstId());
                withdrawInst1.setComment(withdrawInst.getComment());
                session.update(withdrawInst1);
            } else {
                session.update(withdrawInst);
            }
            session.flush();
            transaction.commit();
        } catch (RuntimeException e) {
            transaction.rollback();;
            throw e;
        } finally {
            session.close();
        }
    }

    public List<WithdrawInst> getWithdrawInst(long studentId) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            String hql = "from WithdrawInst as w where studentId=" + studentId;
            List<WithdrawInst> list = session.createQuery(hql).list();
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

    public WithdrawInst getWithdrawInst(int instId) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            WithdrawInst withdrawInst = session.get(WithdrawInst.class, instId);
            session.flush();
            transaction.commit();
            return withdrawInst;
        } catch (RuntimeException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public WithdrawInst deleteWithdrawInst(int instId, long studentId) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            String hql = "from WithdrawInst as w where instId=" + instId + " and studentId=" + studentId;
            List<WithdrawInst> list = session.createQuery(hql).list();
            if (list.size() > 0) session.delete(list.get(0));
            session.flush();
            transaction.commit();
            return list.size() > 0 ? list.get(0) : null;
        } catch (RuntimeException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}
