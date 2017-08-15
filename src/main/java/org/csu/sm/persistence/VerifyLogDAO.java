package org.csu.sm.persistence;

import org.csu.sm.domain.VerifyLog;
import org.csu.sm.exception.PersistenceException;

import java.util.List;

/**
 * Created by ltaoj on 2017/8/8.
 */
public interface VerifyLogDAO {
    /**
     * 老师查看审核日志
     *
     * @param counselorName
     * @return
     * @throws PersistenceException
     */
    List<VerifyLog> getVerifyLogListByCounselorName(String counselorName) throws PersistenceException;

    /**
     * 添加审核日志
     *
     * @param verifyLog
     * @throws PersistenceException
     */
    void insertVerifyLog(VerifyLog verifyLog) throws PersistenceException;

    /**
     * 学生查看审核日志
     *
     * @param studentId
     * @return
     * @throws PersistenceException
     */
    List<VerifyLog> getVerifyLogListByStudentId(long studentId) throws PersistenceException;

}
