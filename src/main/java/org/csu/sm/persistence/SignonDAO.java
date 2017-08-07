package org.csu.sm.persistence;

import org.csu.sm.domain.Signon;
import org.csu.sm.domain.Teacher;

import javax.persistence.PersistenceException;

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
     * 登录成功返回老师信息，失败返回null
     * @param teacher
     * @return
     * @throws PersistenceException
     */
    Integer teacherLogin(Teacher teacher) throws PersistenceException;
}
