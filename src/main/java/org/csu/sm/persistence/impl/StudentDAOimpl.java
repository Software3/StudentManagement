package org.csu.sm.persistence.impl;

import org.csu.sm.domain.Student;
import org.csu.sm.domain.VerifyLog;
import org.csu.sm.persistence.StudentDAO;
import org.csu.sm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceException;
import java.util.List;

/**
 * Created by ltaoj on 2017/8/7.
 */
@Repository
public class StudentDAOimpl implements StudentDAO {

    public void insertStudent(Student student) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(student);
        session.flush();
        transaction.commit();
        session.close();
    }

    public long deleteStudent(long studentId) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class, studentId);
        if (student != null) session.delete(student);
        session.flush();
        transaction.commit();
        session.close();
        return student != null ? studentId : -1;
    }

    public void updateStudent(Student student) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.update(student);
        transaction.commit();
        session.close();
    }

    public Student getStudent(long studentId) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class, studentId);
        session.flush();
        transaction.commit();
        return student;
    }

    public List<Student> getStudentListByVerifyState(int verifyState) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from Student as s where verifyState=" + verifyState;
        List<Student> list = session.createQuery(hql).list();
        session.flush();
        transaction.commit();
        return list;
    }

    public List<Student> getStudentListByTeacherId(String teacherId) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from Student as s where counselorName='" + teacherId + "'";
        List<Student> list = session.createQuery(hql).list();
        session.flush();
        transaction.commit();
        return list;
    }

    public List<Student> getStudentListByTeacherIdAndState(String teacherId, String state) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from Student as s where counselorName='" + teacherId + "' and verifyState=" + state;
        List<Student> list = session.createQuery(hql).list();
        session.flush();
        transaction.commit();
        return list;
    }

    public void updateStudentVerifyState(VerifyLog verifyLog, boolean isVerify) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.load(Student.class, verifyLog.getStudentId());
        student.setVerifyState(isVerify == true ? 2 : 3);
        session.update(student);
        session.flush();
        transaction.commit();
    }

    public void insertStudentList(List<Student> students) throws PersistenceException {
        try {
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            for (int i = 0; i < students.size(); i++) {
                session.save(students.get(i));
            }
            session.flush();
            transaction.commit();
            session.close();
        } catch (RuntimeException e) {
            throw new PersistenceException(e);
        }
    }

    public List<Student> getStudentList() throws PersistenceException {
        try {
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("from Student");
            List<Student> students = query.list();
            session.flush();
            transaction.commit();
            session.close();
            return students;
        } catch (RuntimeException e) {
            throw new PersistenceException(e);
        }
    }


}
