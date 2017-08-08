package org.csu.sm.persistence;

import org.csu.sm.domain.Teacher;

import javax.persistence.PersistenceException;

/**
 * Created by ltaoj on 2017/8/7.
 */
public interface TeacherDAO {
    /**
     * 更新老师信息
     * @param teacher
     * @throws PersistenceException
     */
    void updateTeacher(Teacher teacher) throws PersistenceException;

    /**
     * 查看教师信息
     * @param username
     * @return
     * @throws PersistenceException
     */
    Teacher getTeacher(String username) throws PersistenceException;
}
