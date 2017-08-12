package org.csu.sm.service;

import org.csu.sm.domain.Student;
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
}
