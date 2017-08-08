package org.csu.sm.service;

import org.csu.sm.domain.*;
import org.csu.sm.exception.service.InfoManageServiceException;

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
     * @param parentList
     * @throws InfoManageServiceException
     */
    void modifyParentsInfo(List<Parent> parentList) throws InfoManageServiceException;

    /**
     * 添加家长信息
     * @param parent
     * @return
     * @throws InfoManageServiceException
     */
    List<Parent> addParentInfo(Parent parent) throws InfoManageServiceException;

    /**
     * 查看获奖情况
     * @param studentId
     * @return
     * @throws InfoManageServiceException
     */
    List<AwardRecord> getAwardList(long studentId) throws InfoManageServiceException;

    /**
     * 修改获奖情况
     * @param awardRecordList
     * @throws InfoManageServiceException
     */
    void modifyAwardsInfo(List<AwardRecord> awardRecordList) throws InfoManageServiceException;

    /**
     * 添加奖励记录
     * @param awardRecord
     * @return
     * @throws InfoManageServiceException
     */
    List<AwardRecord> addAwardInfo(AwardRecord awardRecord) throws InfoManageServiceException;

    /**
     * 查看挂科情况
     * @param studentId
     * @return
     * @throws InfoManageServiceException
     */
    List<FailexamRecord> getFailexamList(long studentId) throws InfoManageServiceException;

    /**
     * 修改挂科情况
     * @param failexamRecordList
     * @throws InfoManageServiceException
     */
    void modifyFailexamInfo(List<FailexamRecord> failexamRecordList) throws InfoManageServiceException;

    /**
     * 添加挂科记录
     * @param failexamRecord
     * @return
     * @throws InfoManageServiceException
     */
    List<FailexamRecord> addFailexamInfo(FailexamRecord failexamRecord) throws InfoManageServiceException;

    /**
     * 查看退队说明
     * @param studentId
     * @return
     * @throws InfoManageServiceException
     */
    List<WithdrawInst> getWithdrawInstList(long studentId) throws InfoManageServiceException;

    /**
     * 修改退队说明
     * @param withdrawInst
     * @throws InfoManageServiceException
     */
    void modifyWithdrawInstInfo(WithdrawInst withdrawInst) throws InfoManageServiceException;

    /**
     * 添加退队说明
     * @param withdrawInst
     * @return
     * @throws InfoManageServiceException
     */
    List<WithdrawInst> addWithdrawInstInfo(WithdrawInst withdrawInst) throws InfoManageServiceException;

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
}