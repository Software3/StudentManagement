package org.csu.sm.persistence.impl;

import org.csu.sm.domain.Student;
import org.csu.sm.persistence.StudentDAO;
import org.csu.sm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceException;

/**
 * Created by ltaoj on 2017/8/7.
 */
@Repository
public class StudentDAOimpl implements StudentDAO{
    public void insertStudent(Student student) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(student);
        transaction.commit();
    }

    public long deleteStudent(long studentId) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class, studentId);
        if (student != null) session.delete(student);
        transaction.commit();
        return student != null ? studentId : -1;
    }

    public void updateStudent(Student student) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.update(student);
        transaction.commit();
    }

    public Student getStudent(long studentId) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class, studentId);
        transaction.commit();
        return student;
    }
}
