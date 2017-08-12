package org.csu.sm.persistence;

import org.csu.sm.domain.Student;

import javax.persistence.PersistenceException;
import java.util.List;

/**
 * Created by ltaoj on 2017/8/7.
 */
public interface StudentDAO {

    /**
     * 添加学生基本信息
     *
     * @param student
     * @throws PersistenceException
     */
    void insertStudent(Student student) throws PersistenceException;

    /**
     * 通过学号删除学生基本信息
     *
     * @param studentId
     * @return
     * @throws PersistenceException
     */
    long deleteStudent(long studentId) throws PersistenceException;

    /**
     * 更新学生基本信息
     *
     * @param student
     * @throws PersistenceException
     */
    void updateStudent(Student student) throws PersistenceException;

    /**
     * 通过学号查找学生基本信息
     *
     * @param studentId
     * @return
     * @throws PersistenceException
     */
    Student getStudent(long studentId) throws PersistenceException;

    /**
     * 通过审核状态查找学生
     *
     * @return
     * @throws PersistenceException
     */
    List<Student> getStudentListByVerifyState(int verifyState) throws PersistenceException;

    /**
     * 通过老师查找学生列表
     *
     * @param teacherId
     * @return
     * @throws PersistenceException
     */
    List<Student> getStudentListByTeacherId(String teacherId) throws PersistenceException;

    /**
     * 通过老师和状态查找学生列表
     * @param teacherId
     * @param state
     * @return
     * @throws PersistenceException
     */
    List<Student> getStudentListByTeacherIdAndState(String teacherId, String state) throws PersistenceException;
}
