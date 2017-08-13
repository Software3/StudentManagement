package org.csu.sm.persistence;

import org.csu.sm.domain.WithdrawInst;

import javax.persistence.PersistenceException;
import java.util.List;

/**
 * Created by ltaoj on 2017/8/7.
 */
public interface WithdrawInstDAO {
    /**
     * 添加退队入队说明
     * @param withdrawInst
     * @throws PersistenceException
     */
    void insertWithdrawInst(WithdrawInst withdrawInst) throws PersistenceException;

    /**
     * 更新退队入队说明
     * @param withdrawInst
     * @throws PersistenceException
     */
    void updateWithdrawInst(WithdrawInst withdrawInst) throws PersistenceException;

    /**
     * 获取运动员退队入队说明列表
     * @param studentId
     * @return
     * @throws PersistenceException
     */
    List<WithdrawInst> getWithdrawInst(long studentId) throws PersistenceException;

    /**
     * 获取某条退队说明
     * @param instId
     * @return
     * @throws PersistenceException
     */
    WithdrawInst getWithdrawInst(int instId) throws PersistenceException;

     /**
     * 删除退队说明
     * @param instId
     * @param studentId
     * @return
     * @throws PersistenceException
     */
    WithdrawInst deleteWithdrawInst(int instId, long studentId) throws PersistenceException;
}
