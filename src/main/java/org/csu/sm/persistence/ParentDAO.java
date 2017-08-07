package org.csu.sm.persistence;

import org.csu.sm.domain.Parent;

import javax.persistence.PersistenceException;
import java.util.List;

/**
 * Created by ltaoj on 2017/8/7.
 */
public interface ParentDAO {
    /**
     * 添加学生家长信息
     * @param parent
     * @throws PersistenceException
     */
    void insertParent(Parent parent) throws PersistenceException;

    /**
     * 更新家长信息
     * @param parent
     * @throws PersistenceException
     */
    void updateParent(Parent parent) throws PersistenceException;

    /**
     * 删除家长信息
     * @param studentId
     * @param name
     * @return
     * @throws PersistenceException
     */
    long deleteParent(long studentId, String name) throws PersistenceException;

    /**
     * 得到家长信息集合
     * @param studentId
     * @return
     * @throws PersistenceException
     */
    List<Parent> getParents(long studentId) throws PersistenceException;
}
