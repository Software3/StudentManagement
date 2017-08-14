package org.csu.sm.service;

import org.csu.sm.domain.Student;
import org.csu.sm.domain.VerifyLog;
import org.csu.sm.exception.service.TeacherServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 51157 on 2017/8/12.
 */
public interface TeacherService {
    /**
     * 获得指定老师的学生列表
     *
     * @param teacherId
     * @return
     * @throws TeacherServiceException
     */
    List<Student> getStudentList(String teacherId) throws TeacherServiceException;

    /**
     * 获得指定学生列表通过老师ID和状态
     *
     * @param teacherId
     * @param state
     * @return
     * @throws TeacherServiceException
     */
    List<Student> getStudentListByTeacherIdAndState(String teacherId, String state) throws TeacherServiceException;

    /**
     * 指定学生通过审核
     * 1.改变学生审核状态由1改为2
     * 2.向审核日志中添加审核通过信息
     *
     * @param verifyLog
     * @throws TeacherServiceException
     */
    void auditedPass(VerifyLog verifyLog) throws TeacherServiceException;

    /**
     * 指定学生不通过审核
     * 1.改变学生审核状态由1改为3
     * 2.向审核日志中添加审核不通过信息
     *
     * @param verifyLog
     * @throws TeacherServiceException
     */
    void auditedFail(VerifyLog verifyLog) throws TeacherServiceException;


    void insertStudentList(List<Student> students) throws TeacherServiceException;
}

