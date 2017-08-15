package org.csu.sm.persistence;

import org.csu.sm.domain.Signon;
import org.csu.sm.domain.Teacher;
import org.csu.sm.exception.PersistenceException;


/**
 * Created by ltaoj on 2017/8/7.
 */
public interface SignonDAO {
    /**
     * 学生登陆成功返回1，失败返回0
     * @param signon
     * @return
     * @throws PersistenceException
     */
    Integer studentLogin(Signon signon) throws PersistenceException;

    /**
     * 学生修改登录密码
     * @param signon
     * @throws PersistenceException
     */
    void updateStudentSignon(Signon signon) throws PersistenceException;

    /**
     * 登录成功返回老师信息，失败返回null
     * @param teacher
     * @return
     * @throws PersistenceException
     */
    Teacher teacherLogin(Teacher teacher) throws PersistenceException;

    /**
     * 教师修改登录密码
     * @param username
     * @param password
     * @throws PersistenceException
     */
    void updateTeacherSignon(String username, String password) throws PersistenceException;

    /**
     * 根据学号获取登录信息
     * @param studentId
     * @return
     * @throws PersistenceException
     */
    Signon getSignon(Long studentId) throws PersistenceException;
}
