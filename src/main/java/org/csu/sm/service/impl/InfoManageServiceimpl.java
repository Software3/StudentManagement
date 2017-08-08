package org.csu.sm.service.impl;

import org.csu.sm.domain.*;
import org.csu.sm.exception.service.InfoManageServiceException;
import org.csu.sm.persistence.*;
import org.csu.sm.service.InfoManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ltaoj on 2017/8/8.
 */
@Service
public class InfoManageServiceimpl implements InfoManageService{

    private StudentDAO studentDAO;
    private ParentDAO parentDAO;
    private AwardDAO awardDAO;
    private FailexamDAO failexamDAO;
    private WithdrawInstDAO withdrawInstDAO;
    private TeacherDAO teacherDAO;

    @Autowired
    public InfoManageServiceimpl(StudentDAO studentDAO, ParentDAO parentDAO, AwardDAO awardDAO, FailexamDAO failexamDAO, WithdrawInstDAO withdrawInstDAO, TeacherDAO teacherDAO) {
        this.studentDAO = studentDAO;
        this.parentDAO = parentDAO;
        this.awardDAO = awardDAO;
        this.failexamDAO = failexamDAO;
        this.withdrawInstDAO = withdrawInstDAO;
        this.teacherDAO = teacherDAO;
    }

    public Student getBasicInfo(long studentId) throws InfoManageServiceException {
        return studentDAO.getStudent(studentId);
    }

    public void modifyBasicInfo(Student student) throws InfoManageServiceException {
        studentDAO.updateStudent(student);
    }

    public List<Parent> getParentList(long studentId) throws InfoManageServiceException {
        return parentDAO.getParents(studentId);
    }

    public void modifyParentsInfo(List<Parent> parentList) throws InfoManageServiceException {
        for (int i = 0;i < parentList.size();i++) {
            parentDAO.updateParent(parentList.get(i));
        }
    }

    public List<Parent> addParentInfo(Parent parent) throws InfoManageServiceException {
        parentDAO.insertParent(parent);
        return parentDAO.getParents(parent.getStudentId());
    }

    public List<AwardRecord> getAwardList(long studentId) throws InfoManageServiceException {
        return awardDAO.getAwardList(studentId);
    }

    public void modifyAwardsInfo(List<AwardRecord> awardRecordList) throws InfoManageServiceException {
        for (int i = 0;i < awardRecordList.size();i++) {
            awardDAO.updateAward(awardRecordList.get(i));
        }
    }

    public List<AwardRecord> addAwardInfo(AwardRecord awardRecord) throws InfoManageServiceException {
        awardDAO.insertAward(awardRecord);
        return awardDAO.getAwardList(awardRecord.getStudentId());
    }

    public List<FailexamRecord> getFailexamList(long studentId) throws InfoManageServiceException {
        return failexamDAO.getFailexamList(studentId);
    }

    public void modifyFailexamInfo(List<FailexamRecord> failexamRecordList) throws InfoManageServiceException {
        for (int i = 0;i < failexamRecordList.size();i++) {
            failexamDAO.insertFailexam(failexamRecordList.get(i));
        }
    }

    public List<FailexamRecord> addFailexamInfo(FailexamRecord failexamRecord) throws InfoManageServiceException {
        failexamDAO.insertFailexam(failexamRecord);
        return failexamDAO.getFailexamList(failexamRecord.getStudentId());
    }

    public List<WithdrawInst> getWithdrawInstList(long studentId) throws InfoManageServiceException {
        return withdrawInstDAO.getWithdrawInst(studentId);
    }

    public void modifyWithdrawInstInfo(WithdrawInst withdrawInst) throws InfoManageServiceException {
        withdrawInstDAO.updateWithdrawInst(withdrawInst);
    }

    public List<WithdrawInst> addWithdrawInstInfo(WithdrawInst withdrawInst) throws InfoManageServiceException {
        withdrawInstDAO.insertWithdrawInst(withdrawInst);
        return withdrawInstDAO.getWithdrawInst(withdrawInst.getStudentId());
    }

    public Teacher getTeacherInfo(String username) throws InfoManageServiceException {
        return teacherDAO.getTeacher(username);
    }

    public void modifyTeacherInfo(Teacher teacher) throws InfoManageServiceException {
        teacherDAO.updateTeacher(teacher);
    }
}
