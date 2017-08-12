package org.csu.sm.service.impl;

import org.csu.sm.domain.Student;
import org.csu.sm.domain.VerifyLog;
import org.csu.sm.exception.service.TeacherServiceException;
import org.csu.sm.persistence.StudentDAO;
import org.csu.sm.persistence.VerifyLogDAO;
import org.csu.sm.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 51157 on 2017/8/12.
 */
@Service
public class TeacherServiceimpl implements TeacherService {
    private StudentDAO studentDAO;
    private VerifyLogDAO verifyLogDAO;

    @Autowired
    public TeacherServiceimpl(StudentDAO studentDAO, VerifyLogDAO verifyLogDAO) {
        this.studentDAO = studentDAO;
        this.verifyLogDAO = verifyLogDAO;
    }

    public List<Student> getStudentList(String teacherId) throws TeacherServiceException {
        return studentDAO.getStudentListByTeacherId(teacherId);
    }

    public List<Student> getStudentListByTeacherIdAndState(String teacherId, String state) throws TeacherServiceException {
        return studentDAO.getStudentListByTeacherIdAndState(teacherId, state);
    }

}
