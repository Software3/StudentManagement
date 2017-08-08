package org.csu.sm.service.impl;

import org.csu.sm.domain.Student;
import org.csu.sm.domain.VerifyLog;
import org.csu.sm.exception.service.VerifyServiceException;
import org.csu.sm.persistence.StudentDAO;
import org.csu.sm.persistence.VerifyLogDAO;
import org.csu.sm.service.VerifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ltaoj on 2017/8/8.
 */
@Service
public class VerifyServiceimpl implements VerifyService{

    private static final int UNCOMMITED = 0;
    private static final int UNVERIFIED = 1;
    private static final int VERIFIED = 2;

    private VerifyLogDAO verifyLogDAO;
    private StudentDAO studentDAO;

    @Autowired
    public VerifyServiceimpl(VerifyLogDAO verifyLogDAO, StudentDAO studentDAO) {
        this.verifyLogDAO = verifyLogDAO;
        this.studentDAO = studentDAO;
    }

    public List<VerifyLog> getVerifyLogListForTeacher(String counselorName) throws VerifyServiceException {
        return verifyLogDAO.getVerifyLogListByCounselorName(counselorName);
    }

    public List<VerifyLog> getVerifyLogListForStudent(long studentId) throws VerifyServiceException {
        return verifyLogDAO.getVerifyLogListByStudentId(studentId);
    }

    public List<Student> getStudentInfosUnverified() throws VerifyServiceException {
        return studentDAO.getStudentListByVerifyState(UNVERIFIED);
    }

    public List<Student> getStudentListUncommited() throws VerifyServiceException {
        return studentDAO.getStudentListByVerifyState(UNCOMMITED);
    }

    public List<Student> getStudentListVerified() throws VerifyServiceException {
        return studentDAO.getStudentListByVerifyState(VERIFIED);
    }
}
