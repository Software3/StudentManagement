package org.csu.sm.service;

import org.csu.sm.domain.Signon;
import org.csu.sm.domain.Student;
import org.csu.sm.domain.Teacher;
import org.csu.sm.exception.service.AccountServiceException;

/**
 * Created by ltaoj on 2017/8/7.
 */
public interface AccountService {

    /**
     * 学生登录
     * @param signon
     * @return
     * @throws AccountServiceException
     */
    Student studentLogin(Signon signon) throws AccountServiceException;

    /**
     * 修改学生密码
     * @param studentId
     * @param newPassword 新密码
     * @param oldPassword 旧密码
     * @throws AccountServiceException
     */
    void changeStudPassword(long studentId, String newPassword, String oldPassword) throws AccountServiceException;

    /**
     * 老师登录
     * @param teacher
     * @return
     * @throws AccountServiceException
     */
    Teacher teacherLogin(Teacher teacher) throws AccountServiceException;

    /**
     * 修改教师密码
     * @param username
     * @param newPassword
     * @param oldPassword
     * @throws AccountServiceException
     */
    void changeTeacPassword(String username, String newPassword, String oldPassword) throws AccountServiceException;
}
