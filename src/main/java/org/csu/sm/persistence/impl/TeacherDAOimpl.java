package org.csu.sm.persistence.impl;

import org.csu.sm.domain.Teacher;
import org.csu.sm.persistence.TeacherDAO;
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
public class TeacherDAOimpl implements TeacherDAO{
    public void updateTeacher(Teacher teacher) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.update(teacher);
        transaction.commit();
    }

    public Teacher getTeacher(String username) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Teacher teacher = session.get(Teacher.class, username);
        transaction.commit();
        return teacher;
    }
}
