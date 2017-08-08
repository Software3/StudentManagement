package org.csu.sm.service;

import org.csu.sm.domain.Student;
import org.csu.sm.domain.VerifyLog;
import org.csu.sm.exception.service.VerifyServiceException;

import java.util.List;

/**
 * Created by ltaoj on 2017/8/8.
 */
public interface VerifyService {
    /**
     * 教师查看个人审批日志
     * @param counselorName
     * @return
     * @throws VerifyServiceException
     */
    List<VerifyLog> getVerifyLogListForTeacher(String counselorName) throws VerifyServiceException;

    /**
     * 学生查看个人被审批日志
     * @param studentId
     * @return
     * @throws VerifyServiceException
     */
    List<VerifyLog> getVerifyLogListForStudent(long studentId) throws VerifyServiceException;

    /**
     * 查看资料已提交还未被审批的学生
     * @return
     * @throws VerifyServiceException
     */
    List<Student> getStudentInfosUnverified() throws VerifyServiceException;

    /**
     * 查看资料还没提交过的学生
     * @return
     * @throws VerifyServiceException
     */
    List<Student> getStudentListUncommited() throws VerifyServiceException;

    /**
     * 查看已审核成功的学生
     * @return
     * @throws VerifyServiceException
     */
    List<Student> getStudentListVerified() throws VerifyServiceException;
}
