package org.csu.sm.service;

import org.csu.sm.domain.*;
import org.csu.sm.exception.service.InfoManageServiceException;
import org.csu.sm.exception.service.TransationException;

import java.util.List;

/**
 * Created by ltaoj on 2017/8/8.
 */

public interface InfoManageService {
    /**
     * 查看学生基本信息
     * @param studentId
     * @return
     * @throws InfoManageServiceException
     */
    Student getBasicInfo(long studentId) throws InfoManageServiceException;

    /**
     * 修改学生基本信息
     * @param student
     * @throws InfoManageServiceException
     */
    void modifyBasicInfo(Student student) throws InfoManageServiceException;

    /**
     * 查看家长信息
     * @param studentId
     * @return
     * @throws InfoManageServiceException
     */
    List<Parent> getParentList(long studentId) throws InfoManageServiceException;

    /**
     * 修改家长信息
     * @param parent
     * @throws InfoManageServiceException
     */
    void modifyParentInfo(Parent parent) throws InfoManageServiceException;

    /**
     * 添加家长信息
     * @param parent
     * @return
     * @throws InfoManageServiceException
     */
    List<Parent> addParentInfo(Parent parent) throws InfoManageServiceException;

    /**
     * 删除家长信息
     * @param parent
     * @return
     * @throws InfoManageServiceException
     */
    List<Parent> deleteParentInfo(Parent parent) throws InfoManageServiceException;

    /**
     * 查看获奖情况
     * @param studentId
     * @return
     * @throws InfoManageServiceException
     */
    List<AwardRecord> getAwardList(long studentId) throws InfoManageServiceException;

    /**
     * 修改获奖情况
     * @param awardRecord
     * @throws InfoManageServiceException
     */
    void modifyAwardInfo(AwardRecord awardRecord) throws InfoManageServiceException;

    /**
     * 添加奖励记录
     * @param awardRecord
     * @return
     * @throws InfoManageServiceException
     */
    List<AwardRecord> addAwardInfo(AwardRecord awardRecord) throws InfoManageServiceException;

    /**
     * 删除奖励记录
     * @param awardRecord
     * @return
     * @throws InfoManageServiceException
     */
    List<AwardRecord> deleteAwardInfo(AwardRecord awardRecord) throws InfoManageServiceException;

    /**
     * 查看挂科情况
     * @param studentId
     * @return
     * @throws InfoManageServiceException
     */
    List<FailexamRecord> getFailexamList(long studentId) throws InfoManageServiceException;

    /**
     * 修改挂科情况
     * @param failexamRecord
     * @throws InfoManageServiceException
     */
    void modifyFailexamInfo(FailexamRecord failexamRecord) throws InfoManageServiceException;

    /**
     * 添加挂科记录
     * @param failexamRecord
     * @return
     * @throws InfoManageServiceException
     */
    List<FailexamRecord> addFailexamInfo(FailexamRecord failexamRecord) throws InfoManageServiceException;

    /**
     * 删除挂科记录
     * @param failexamRecord
     * @return
     * @throws InfoManageServiceException
     */
    List<FailexamRecord> deleteFailexamInfo(FailexamRecord failexamRecord) throws InfoManageServiceException;

    /**
     * 查看退队说明
     * @param studentId
     * @return
     * @throws InfoManageServiceException
     */
    List<WithdrawInst> getWithdrawInstList(long studentId) throws InfoManageServiceException;

    /**
     * 通过
     * @param instId
     * @return
     * @throws InfoManageServiceException
     */
    WithdrawInst getWithdrawInst(int instId) throws InfoManageServiceException;
    /**
     * 修改退队说明
     * @param withdrawInst
     * @throws InfoManageServiceException
     */
    List<WithdrawInst> modifyWithdrawInstInfo(WithdrawInst withdrawInst) throws TransationException;

    /**
     * 添加退队说明
     * @param withdrawInst
     * @return
     * @throws InfoManageServiceException
     */
    List<WithdrawInst> addWithdrawInstInfo(WithdrawInst withdrawInst) throws TransationException;

    /**
     * 删除退队说明
     * @param withdrawInst
     * @return
     * @throws InfoManageServiceException
     */
    WithdrawInst deleteWithdrawInstInfo(WithdrawInst withdrawInst) throws InfoManageServiceException;

    /**
     * 查看教师信息
     * @param username
     * @return
     * @throws InfoManageServiceException
     */
    Teacher getTeacherInfo(String username) throws InfoManageServiceException;

    /**
     * 修改教师信息
     * @param teacher
     * @throws InfoManageServiceException
     */
    void modifyTeacherInfo(Teacher teacher) throws InfoManageServiceException;

    /**
     * 学生提交审核
     * @param studentId
     * @param verifyState
     * @throws InfoManageServiceException
     */
    void submitVerify(long studentId, int verifyState) throws InfoManageServiceException;
}
