package org.csu.sm.persistence.impl;

import org.csu.sm.domain.Signon;
import org.csu.sm.domain.Teacher;
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
public class SignonDAOimpl implements SignonDAO{
    public Integer studentLogin(Signon signon) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from Signon as signon where studentId=" + signon.getStudentId() + " and password=" + signon.getPassword();
        List<Signon> list = session.createQuery(hql).list();
        transaction.commit();
        return list.size() > 0 ? 1 : 0;
    }

    public void updateStudentSignon(Signon signon) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.update(signon);
        transaction.commit();
    }

    public Teacher teacherLogin(Teacher teacher) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from Teacher as t where username=" + teacher.getUsername() + " and password=" + teacher.getPassword();
        List<Teacher> list = session.createQuery(hql).list();
        transaction.commit();
        return list.size() > 0 ? list.get(0) : null;
    }

    public void updateTeacherSignon(String username, String password) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Teacher teacher = session.get(Teacher.class, username);
        teacher.setPassword(password);
        session.update(teacher);
        transaction.commit();
    }
}
