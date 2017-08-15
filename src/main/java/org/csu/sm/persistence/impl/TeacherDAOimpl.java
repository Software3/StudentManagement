package org.csu.sm.persistence.impl;

import org.csu.sm.domain.SearchInfo;
import org.csu.sm.domain.Student;
import org.csu.sm.domain.Teacher;
import org.csu.sm.persistence.TeacherDAO;
import org.csu.sm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceException;
import java.util.ArrayList;
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
        session.flush();
        transaction.commit();
        session.close();
    }

    public Teacher getTeacher(String username) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Teacher teacher = session.get(Teacher.class, username);
        session.flush();
        transaction.commit();
        return teacher;
    }

    public List<Student> getSearchStudents(String hql) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        List<Student> list = session.createQuery(hql).list();
        session.flush();
        transaction.commit();
        return list;
    }
}
