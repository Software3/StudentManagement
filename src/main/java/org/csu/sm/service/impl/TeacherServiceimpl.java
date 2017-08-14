package org.csu.sm.service.impl;

import org.csu.sm.domain.SearchInfo;
import org.csu.sm.domain.Student;
import org.csu.sm.domain.VerifyLog;
import org.csu.sm.exception.service.TeacherServiceException;
import org.csu.sm.persistence.StudentDAO;
import org.csu.sm.persistence.TeacherDAO;
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
    private TeacherDAO teacherDAO;

    @Autowired
    public TeacherServiceimpl(StudentDAO studentDAO, VerifyLogDAO verifyLogDAO,TeacherDAO teacherDAO) {
        this.studentDAO = studentDAO;
        this.verifyLogDAO = verifyLogDAO;
        this.teacherDAO=teacherDAO;
    }

    public List<Student> getStudentList(String teacherId) throws TeacherServiceException {
        return studentDAO.getStudentListByTeacherId(teacherId);
    }

    public List<Student> getStudentListByTeacherIdAndState(String teacherId, String state) throws TeacherServiceException {
        return studentDAO.getStudentListByTeacherIdAndState(teacherId, state);
    }

    public void auditedPass(VerifyLog verifyLog) throws TeacherServiceException {
        studentDAO.updateStudentVerifyState(verifyLog, true);
        verifyLogDAO.insertVerifyLog(verifyLog);
    }

    public void auditedFail(VerifyLog verifyLog) throws TeacherServiceException {
        studentDAO.updateStudentVerifyState(verifyLog, false);
        verifyLogDAO.insertVerifyLog(verifyLog);
    }

    public List<Student> getSearchStudents(SearchInfo searchInfo) throws TeacherServiceException {
        String hql = "from Student as s where counselorName=" + searchInfo.getCounselorName();
        if (searchInfo.getStudentId() != null) {
            hql += " and studentId=" + searchInfo.getStudentId();
        } else if (searchInfo.getName() != "") {
            hql += " and name='" + searchInfo.getName() + "'";
        } else if (searchInfo.getNativePlace() != "") {
            hql += " and nativePlace='" + searchInfo.getNativePlace() + "'";
        } else if (searchInfo.getMajor() != "") {
            hql += " and major='" + searchInfo.getMajor() + "'";
        } else if (searchInfo.getType() != "") {
            hql += " and studentType='" + searchInfo.getType() + "'";
        }
        System.out.println(hql);
        List<Student> list = teacherDAO.getSearchStudents(hql);
        return list;
    }

    public void insertStudentList(List<Student> students) throws TeacherServiceException {
        studentDAO.insertStudentList(students);
    }

    public List<Student> getStudentList() throws TeacherServiceException {
        return studentDAO.getStudentList();
    }
}
