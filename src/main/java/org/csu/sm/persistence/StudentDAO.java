package org.csu.sm.persistence;

import org.csu.sm.domain.Student;

import javax.persistence.PersistenceException;

/**
 * Created by ltaoj on 2017/8/7.
 */
public interface StudentDAO {

    /**
     * 添加学生基本信息
     * @param student
     * @throws PersistenceException
     */
    void insertStudent(Student student) throws PersistenceException;

    /**
     * 通过学号删除学生基本信息
     * @param studentId
     * @return
     * @throws PersistenceException
     */
    long deleteStudent(long studentId) throws PersistenceException;

    /**
     * 更新学生基本信息
     * @param student
     * @throws PersistenceException
     */
    void updateStudent(Student student) throws PersistenceException;

    /**
     * 通过学号查找学生基本信息
     * @param studentId
     * @return
     * @throws PersistenceException
     */
    Student getStudent(long studentId) throws PersistenceException;
}
