package org.csu.sm.service.impl;

import org.csu.sm.domain.*;
import org.csu.sm.exception.service.InfoManageServiceException;
import org.csu.sm.exception.service.TransationException;
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

    public String modifyBasicInfoByIdPhoto(long studentId, String idPhoto) throws TransationException {
        return studentDAO.updateStudentByIdPhoto(studentId, idPhoto);
    }

    public List<Parent> getParentList(long studentId) throws InfoManageServiceException {
        return parentDAO.getParents(studentId);
    }

    public void modifyParentInfo(Parent parent) throws InfoManageServiceException {
        parentDAO.updateParent(parent);
    }

    public List<Parent> addParentInfo(Parent parent) throws InfoManageServiceException {
        parentDAO.insertParent(parent);
        return parentDAO.getParents(parent.getStudentId());
    }

    public List<Parent> deleteParentInfo(Parent parent) throws InfoManageServiceException {
        parentDAO.deleteParent(parent.getStudentId(), parent.getName());
        return parentDAO.getParents(parent.getStudentId());
    }

    public List<AwardRecord> getAwardList(long studentId) throws InfoManageServiceException {
        return awardDAO.getAwardList(studentId);
    }

    public void modifyAwardInfo(AwardRecord awardRecord) throws InfoManageServiceException {
        awardDAO.updateAward(awardRecord);
    }

    public List<AwardRecord> addAwardInfo(AwardRecord awardRecord) throws InfoManageServiceException {
        awardDAO.insertAward(awardRecord);
        return awardDAO.getAwardList(awardRecord.getStudentId());
    }

    public List<AwardRecord> deleteAwardInfo(AwardRecord awardRecord) throws InfoManageServiceException {
        awardDAO.deleteAward(awardRecord);
        return awardDAO.getAwardList(awardRecord.getStudentId());
    }

    public List<FailexamRecord> getFailexamList(long studentId) throws InfoManageServiceException {
        return failexamDAO.getFailexamList(studentId);
    }

    public void modifyFailexamInfo(FailexamRecord failexamRecord) throws InfoManageServiceException {
        failexamDAO.updateFailexam(failexamRecord);
    }

    public List<FailexamRecord> addFailexamInfo(FailexamRecord failexamRecord) throws InfoManageServiceException {
        failexamDAO.insertFailexam(failexamRecord);
        return failexamDAO.getFailexamList(failexamRecord.getStudentId());
    }

    public List<FailexamRecord> deleteFailexamInfo(FailexamRecord failexamRecord) throws InfoManageServiceException {
        failexamDAO.deleteFailexam(failexamRecord.getStudentId(), failexamRecord.getSubject());
        return failexamDAO.getFailexamList(failexamRecord.getStudentId());
    }

    public List<WithdrawInst> getWithdrawInstList(long studentId) throws InfoManageServiceException {
        return withdrawInstDAO.getWithdrawInst(studentId);
    }

    public WithdrawInst getWithdrawInst(int instId) throws InfoManageServiceException {
        return withdrawInstDAO.getWithdrawInst(instId);
    }

    public List<WithdrawInst> modifyWithdrawInstInfo(WithdrawInst withdrawInst) throws TransationException {
        try {
            withdrawInstDAO.updateWithdrawInst(withdrawInst);
        } catch (RuntimeException e) {
            throw new TransationException(withdrawInst);
        }
        return withdrawInstDAO.getWithdrawInst(withdrawInst.getStudentId());
    }

    public List<WithdrawInst> addWithdrawInstInfo(WithdrawInst withdrawInst) throws TransationException {
        try {
            withdrawInstDAO.insertWithdrawInst(withdrawInst);
        } catch (RuntimeException e) {
            throw new TransationException(withdrawInst);
        }
        return withdrawInstDAO.getWithdrawInst(withdrawInst.getStudentId());
    }

    public WithdrawInst deleteWithdrawInstInfo(WithdrawInst withdrawInst) throws InfoManageServiceException {
        return withdrawInstDAO.deleteWithdrawInst(withdrawInst.getInstId(), withdrawInst.getStudentId());
    }

    public Teacher getTeacherInfo(String username) throws InfoManageServiceException {
        return teacherDAO.getTeacher(username);
    }

    public void modifyTeacherInfo(Teacher teacher) throws InfoManageServiceException {
        teacherDAO.updateTeacher(teacher);
    }

    public void submitVerify(long studentId, int verifyState) throws InfoManageServiceException {
        studentDAO.changeStudentVerifyState(studentId, verifyState);
    }
}
