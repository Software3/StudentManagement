package org.csu.sm.persistence;

import org.csu.sm.domain.FailexamRecord;
import org.csu.sm.exception.PersistenceException;

import java.util.List;

/**
 * Created by lenovo on 2017/8/7.
 */
public interface FailexamDAO {
    /**
     * 添加挂科记录
     * @param failexamRecord
     * @throws PersistenceException
     */
    void insertFailexam(FailexamRecord failexamRecord) throws PersistenceException;

    /**
     * 更新挂科记录
     * @param failexamRecord
     * @throws PersistenceException
     */
    void updateFailexam(FailexamRecord failexamRecord) throws PersistenceException;

    /**
     * 删除挂科记录
     * @param studentId
     * @param subject
     * @return
     * @throws PersistenceException
     */
    long deleteFailexam(long studentId, String subject) throws PersistenceException;

    /**
     * 通过学号获取所有挂科记录
     * @param studentId
     * @return
     * @throws PersistenceException
     */
    List<FailexamRecord> getFailexamList(long studentId) throws PersistenceException;
}
