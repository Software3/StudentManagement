package org.csu.sm.persistence;

import org.csu.sm.domain.AwardRecord;

import javax.persistence.PersistenceException;
import java.util.List;

/**
 * Created by ltaoj on 2017/8/7.
 */
public interface AwardDAO {
    /**
     * 添加获奖情况
     * @param awardRecord
     * @throws PersistenceException
     */
    void insertAward(AwardRecord awardRecord) throws PersistenceException;

    /**
     * 更新获奖情况
     * @param awardRecord
     * @throws PersistenceException
     */
    void updateAward(AwardRecord awardRecord) throws PersistenceException;

    /**
     * 删除获奖记录
     * @param awardRecord
     * @return
     * @throws PersistenceException
     */
    long deleteAward(AwardRecord awardRecord) throws PersistenceException;

    /**
     * 获得获奖记录
     * @param studentId
     * @return
     * @throws PersistenceException
     */
    List<AwardRecord> getAwardList(long studentId) throws PersistenceException;
}
