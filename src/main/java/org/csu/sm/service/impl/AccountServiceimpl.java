package org.csu.sm.service.impl;

import org.csu.sm.domain.Signon;
import org.csu.sm.domain.Student;
import org.csu.sm.domain.Teacher;
import org.csu.sm.exception.service.AccountServiceException;
import org.csu.sm.persistence.SignonDAO;
import org.csu.sm.persistence.StudentDAO;
import org.csu.sm.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ltaoj on 2017/8/7.
 */
@Service
public class AccountServiceimpl implements AccountService{

    private SignonDAO signonDAO;
    private StudentDAO studentDAO;

    @Autowired
    public AccountServiceimpl(SignonDAO signonDAO, StudentDAO studentDAO) {
        this.signonDAO = signonDAO;
        this.studentDAO = studentDAO;
    }

    public Student studentLogin(Signon signon) throws AccountServiceException {
        Integer isLoginSuccess = signonDAO.studentLogin(signon);
        return isLoginSuccess == 1 ? studentDAO.getStudent(signon.getStudentId()) : null;
    }

    public void changeStudPassword(long studentId, String newPassword) throws AccountServiceException {
      signonDAO.updateStudentSignon(new Signon(studentId, newPassword));
    }

    public Teacher teacherLogin(Teacher teacher) throws AccountServiceException {
        return signonDAO.teacherLogin(teacher);
    }

    public void changeTeacPassword(String username, String newPassword, String oldPassword) throws AccountServiceException {
        Teacher teacher = signonDAO.teacherLogin(new Teacher(username, oldPassword));
        if (teacher  != null) signonDAO.updateTeacherSignon(username, newPassword);
    }
}
