package org.csu.sm.persistence.impl;

import org.csu.sm.domain.Signon;
import org.csu.sm.domain.Teacher;
import org.csu.sm.persistence.AbstractDAO;
import org.csu.sm.persistence.SignonDAO;
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
public class SignonDAOimpl extends AbstractDAO implements SignonDAO{
    public Integer studentLogin(Signon signon) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            String hql = "from Signon as signon where studentId=" + signon.getStudentId() + " and password=" + signon.getPassword();
            List<Signon> list = session.createQuery(hql).list();
            session.flush();
            transaction.commit();
            return list.size() > 0 ? 1 : 0;
        } catch (RuntimeException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public void updateStudentSignon(Signon signon) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            signon.setAuthorities("ROLE_USER");
            session.update(signon);
            session.flush();
            transaction.commit();
        } catch (RuntimeException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public Teacher teacherLogin(Teacher teacher) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            String hql = "from Teacher as t where username='" + teacher.getUsername() + "' and password='" + teacher.getPassword() + "'";
            List<Teacher> list = session.createQuery(hql).list();
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

    public void updateTeacherSignon(String username, String password) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            Teacher teacher = session.get(Teacher.class, username);
            teacher.setPassword(password);
            session.update(teacher);
            session.flush();
            transaction.commit();
        } catch (RuntimeException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public Signon getSignon(Long studentId) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            Signon signon = session.get(Signon.class, studentId);
            session.flush();
            return signon;
        } catch (RuntimeException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}
